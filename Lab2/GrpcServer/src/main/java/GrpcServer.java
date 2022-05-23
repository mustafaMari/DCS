import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class GrpcServer {

    public static void main(String[] args) {
        int port = 5001;
        System.out.println("Starting server: ");
        Server server = ServerBuilder
                .forPort(port)
                .addService(new GrpcServiceImpl())
                .build();
        try {
            server.start();
            System.out.println("...server started");
            server.awaitTermination();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
    static class GrpcServiceImpl extends GrpcServiceGrpc.GrpcServiceImplBase{
        public Map<Integer, Vector<String>> database = new HashMap<>(){};
        public void grpcStoreData(GrpcRequest request, StreamObserver<GrpcResponse> responseStreamObserver){
            String message;
            System.out.println("...Called Procedure");
            Vector<String> values = new Vector<>();
            message = "Data added successfully";
            values.add("Id: " +request.getId());
            values.add("Name: " +request.getName());
            values.add("Sex: " +request.getSex());
            values.add("Height: " +request.getHeight());
            database.putIfAbsent(request.getId(), values);
           GrpcResponse response = GrpcResponse.newBuilder()
                   .setMessage(message)
                   .build();
           responseStreamObserver.onNext(response);
           responseStreamObserver.onCompleted();
        }
        public void grpcReadInfo(ReadInfoRequest request, StreamObserver<ReadInfoResponse> response){
            System.out.println("Database: " + database);
            Vector<String> values = database.get(request.getId());
            for (String value : values) {
                ReadInfoResponse response2 = ReadInfoResponse.newBuilder()
                        .setMessage(value)
                        .build();
                response.onNext(response2);
            }
            response.onCompleted();
        }
        public void grpcFibo(GrpcRequestFibo requestFibo, StreamObserver<GrpcResponseFibo> responseFiboStreamObserver){
            int n1=0,n2=1,n3,i,count=requestFibo.getN();
            boolean first = true;
            for(i=2;i<count;++i)
            {
                if (first){
                    GrpcResponseFibo result = GrpcResponseFibo.newBuilder()
                            .setResult(n1)
                            .build();
                    responseFiboStreamObserver.onNext(result);
                    result = GrpcResponseFibo.newBuilder()
                            .setResult(n2)
                            .build();
                    responseFiboStreamObserver.onNext(result);
                    first = false;
                }
                n3=n1+n2;
                GrpcResponseFibo result = GrpcResponseFibo.newBuilder()
                        .setResult(n3)
                        .build();
                responseFiboStreamObserver.onNext(result);
                n1=n2;
                n2=n3;
            }
            responseFiboStreamObserver.onCompleted();
        }
        public void downloadFile(DownloadFileRequest request, StreamObserver<DataChunk> responseObserver) {
            try {
                String fileName = request.getFileName();

                // read the file and convert to a byte array
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                byte[] bytes = inputStream.readAllBytes();
                BufferedInputStream imageStream = new BufferedInputStream(new ByteArrayInputStream(bytes));

                int bufferSize = 1 * 1024;// 1K
                byte[] buffer = new byte[bufferSize];
                int length;
                while ((length = imageStream.read(buffer, 0, bufferSize)) != -1) {
                    responseObserver.onNext(DataChunk.newBuilder()
                            .setData(ByteString.copyFrom(buffer, 0, length))
                            .setSize(bufferSize)
                            .build());
                }
                imageStream.close();
                responseObserver.onCompleted();
            } catch (Throwable e) {
                responseObserver.onError(Status.ABORTED
                        .withDescription("Unable to acquire the image " + request.getFileName())
                        .withCause(e)
                        .asException());
            }
        }

        @Override
        public StreamObserver<SumRequest> grpcSum(StreamObserver<SumResponse> responseObserver) {
            return new StreamObserver<SumRequest>() {
                int sumResult = 0;
                @Override
                public void onNext(SumRequest sumRequest) {
                    sumResult+=sumRequest.getNo();


                }

                @Override
                public void onError(Throwable throwable) {
                    throwable.printStackTrace();

                }

                @Override
                public void onCompleted() {
                    responseObserver.onNext(
                            SumResponse
                                    .newBuilder()
                                    .setResult(sumResult)
                                    .build());
                    responseObserver.onCompleted();

                }
            };
        }
    }

}
