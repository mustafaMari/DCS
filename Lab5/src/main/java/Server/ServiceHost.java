package Server;

import jakarta.xml.ws.Endpoint;

import java.io.IOException;

import static java.lang.System.exit;

public class ServiceHost {
    public static void main(String[] args) {
        System.out.println("Server running....");
        System.out.println("press ENTER to exit");
        EmployeeServiceImpl employeeRepoImple = new EmployeeServiceImpl();
        Endpoint.publish("http://localhost:8001/employee-service", employeeRepoImple);
        try{
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();

        }
        exit(0);

    }
}
