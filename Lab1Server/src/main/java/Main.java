import org.apache.xmlrpc.WebServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("XML-RPC Server... ");
            int port = 8889;
            WebServer server = new WebServer(port);
            server.addHandler("FirstService", new FirstService());
            server.start();
            System.out.println("Server started Successfully");
            System.out.println("Listening on port: " + port);
            System.out.println("Press <ENTER> to stop the server.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader.readLine();
            server.shutdown();
        }catch (Exception exception){
            System.err.println("XML-RPX Server: " + exception);
        }
    }
}
