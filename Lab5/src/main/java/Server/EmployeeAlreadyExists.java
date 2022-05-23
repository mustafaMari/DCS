package Server;

import jakarta.xml.ws.WebFault;

@WebFault
public class EmployeeAlreadyExists extends Exception{
    public EmployeeAlreadyExists() {
        super("This employee already exits");
    }
    public EmployeeAlreadyExists(String s){
        super(s);
    }
}
