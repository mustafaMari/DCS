import org.apache.xmlrpc.AsyncCallback;

import java.net.URL;

public class AC implements AsyncCallback {
    @Override
    public void handleResult(Object o, URL url, String s) {
        System.out.println("the following result was returned:\n"+ o + "\nwhen the method:\n"+ s +"\nwith the following endpoint:\n" + url + "\nwas called");
    }

    @Override
    public void handleError(Exception e, URL url, String s) {
        System.err.println("the following Exception message was returned:\n"+ e.getMessage() + "\nwhen the method:\n"+ s +"\nith the following endpoint:\n" + url + "\nwas called");
    }
}
