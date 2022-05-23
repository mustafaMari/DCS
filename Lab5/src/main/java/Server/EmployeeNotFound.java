package Server;

import jakarta.xml.ws.WebFault;

@WebFault
public class EmployeeNotFound extends Exception{
    public EmployeeNotFound(){
        super("The requested employee does not exists");
    }
    public EmployeeNotFound(String s){
        super(s);
    }
}
