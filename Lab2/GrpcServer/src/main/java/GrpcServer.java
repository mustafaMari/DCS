import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

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
        public void grpcProcedure(GrpcRequest request, StreamObserver<GrpcResponse> responseStreamObserver){
            String message;
            System.out.println("...Called Procedure");
            message = request.getSex().equals("Male") ? "Mr. " : "Mrs. ";
            message += request.getName() + "  Your height is: " + request.getHeight();
            message += " Your Id is: " + request.getId();
           GrpcResponse response = GrpcResponse.newBuilder()
                   .setMessage("Hello: " + message)
                   .build();
           responseStreamObserver.onNext(response);
           responseStreamObserver.onCompleted();
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

    }
}
