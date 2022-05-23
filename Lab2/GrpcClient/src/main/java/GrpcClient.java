import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class GrpcClient {
    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Handler
        logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
//        String address = "localhost";
//        int port = 5001;
//        System.out.println("Running grpc client...");
//        ManagedChannel channel = ManagedChannelBuilder
//                .forAddress(address, port)
//                .usePlaintext()
//                .build();
//        GrpcServiceGrpc.GrpcServiceBlockingStub stub =
//                GrpcServiceGrpc.newBlockingStub(channel);
//        GrpcServiceGrpc.GrpcServiceFutureStub futureStub = GrpcServiceGrpc.newFutureStub(channel);
//        GrpcRequest request = GrpcRequest.newBuilder()
//                .setId(12)
//                .setName("Mustafa")
//                .setSex("Male")
//                .setHeight(184.3)
//                .build();
//        GrpcResponse response = stub.grpcStoreData(request);
//        System.out.println("response: " + response);
//        ReadInfoRequest request2 = ReadInfoRequest.newBuilder()
//                .setId(12)
//                .build();
//        Iterator<ReadInfoResponse>  infoResponseIterator;
//        try{
//            infoResponseIterator = stub.grpcReadInfo(request2);
//            while (infoResponseIterator.hasNext()) {
//                ReadInfoResponse readInfoResponse = infoResponseIterator.next();
//                System.out.println(readInfoResponse);
//            }
//        }catch (StatusRuntimeException e){
//            e.fillInStackTrace();
//        }
//        GrpcRequestFibo requestFibo = GrpcRequestFibo.newBuilder()
//                .setN(8)
//                .build();
//        Iterator<GrpcResponseFibo> responseFiboIterator;
//        try{
//            responseFiboIterator = stub.grpcFibo(requestFibo);
//            for (int i = 1; responseFiboIterator.hasNext() ; i++) {
//                GrpcResponseFibo responseFibo = responseFiboIterator.next();
//                System.out.println(responseFibo);
//            }
//        }catch (StatusRuntimeException e){
//            e.fillInStackTrace();
//        }
        List<SumRequest> sumRequests = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
              sumRequests.add(SumRequest.newBuilder().setNo(i).build());
        }
        sum(sumRequests);


    }
    public static void sum(List<SumRequest> sumRequests){
        String address = "localhost";
        int port = 5001;
        int res = 0;
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(address, port)
                .usePlaintext()
                .build();
        GrpcServiceGrpc.GrpcServiceBlockingStub stub =
                GrpcServiceGrpc.newBlockingStub(channel);
        GrpcServiceGrpc.GrpcServiceStub futureStub = GrpcServiceGrpc.newStub(channel);
        StreamObserver<SumResponse> responseStreamObserver = new StreamObserver<SumResponse>() {
            @Override
            public void onNext(SumResponse sumResponse) {
                info("onNext: " + sumResponse.getResult());

            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();

            }

            @Override
            public void onCompleted() {
                info("finished");

            }
        };
        StreamObserver<SumRequest> requestStreamObserver = futureStub.grpcSum(responseStreamObserver);
        try{
            for(SumRequest sumRequest : sumRequests){
                requestStreamObserver.onNext(sumRequest);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        requestStreamObserver.onCompleted();
        channel.shutdown();
    }
    private static void info(String msg, Object... params) {
        logger.log(Level.INFO, msg, params);
    }

    private static void warning(String msg, Object... params) {
        logger.log(Level.WARNING, msg, params);
    }

}
