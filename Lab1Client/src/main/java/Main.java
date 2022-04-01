import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
       try{
           XmlRpcClient service = new XmlRpcClient("http://localhost:8889");
           AC ac = new AC();
           Vector<Integer> params2 = new Vector<>();
           params2.addElement(1000);
           service.executeAsync("FirstService.asyProc", params2, ac);
           System.out.println("Called Asynchronously");

           Vector<Integer> params = new Vector<>();
           params.addElement(12);
           params.addElement(21);
           Object result = service.execute("FirstService.compute", params);
           System.out.println("Result: "  + result);

       }catch (Exception exception){
           System.err.println("XML-REC Client: " + exception);
       }
    }
}
