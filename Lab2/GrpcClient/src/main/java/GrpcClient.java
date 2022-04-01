import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args) {
        String address = "localhost";
        int port = 5001;
        System.out.println("Running grpc client...");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(address, port)
                .usePlaintext()
                .build();
        GrpcServiceGrpc.GrpcServiceBlockingStub stub =
                GrpcServiceGrpc.newBlockingStub(channel);
        GrpcRequest request = GrpcRequest.newBuilder()
                .setId(12)
                .setName("Mustafa")
                .setSex("Male")
                .setHeight(184.3)
                .build();
        GrpcResponse response = stub.grpcProcedure(request);
        System.out.println("response: " + response);
        GrpcRequestFibo requestFibo = GrpcRequestFibo.newBuilder()
                .setN(8)
                .build();
        Iterator<GrpcResponseFibo> responseFiboIterator;
        try{
            responseFiboIterator = stub.grpcFibo(requestFibo);
            for (int i = 1; responseFiboIterator.hasNext() ; i++) {
                GrpcResponseFibo responseFibo = responseFiboIterator.next();
                System.out.println(responseFibo);
            }
        }catch (StatusRuntimeException e){
            e.fillInStackTrace();
        }
        channel.shutdown();
    }
}
