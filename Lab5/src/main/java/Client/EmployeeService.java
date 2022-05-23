
package Client;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.2
 * Generated source version: 3.0
 * 
 */
@WebService(name = "EmployeeService", targetNamespace = "http://Server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeService {


    /**
     * 
     * @param arg0
     * @return
     *     returns Client.Employee
     * @throws EmployeeNotFound_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEmployee", targetNamespace = "http://Server/", className = "Client.GetEmployee")
    @ResponseWrapper(localName = "getEmployeeResponse", targetNamespace = "http://Server/", className = "Client.GetEmployeeResponse")
    public Employee getEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws EmployeeNotFound_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<Client.Employee>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllEmployees", targetNamespace = "http://Server/", className = "Client.GetAllEmployees")
    @ResponseWrapper(localName = "getAllEmployeesResponse", targetNamespace = "http://Server/", className = "Client.GetAllEmployeesResponse")
    public List<Employee> getAllEmployees();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     * @throws EmployeeNotFound_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteEmployee", targetNamespace = "http://Server/", className = "Client.DeleteEmployee")
    @ResponseWrapper(localName = "deleteEmployeeResponse", targetNamespace = "http://Server/", className = "Client.DeleteEmployeeResponse")
    public boolean deleteEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws EmployeeNotFound_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns Client.Employee
     * @throws EmployeeNotFound_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateEmployee", targetNamespace = "http://Server/", className = "Client.UpdateEmployee")
    @ResponseWrapper(localName = "updateEmployeeResponse", targetNamespace = "http://Server/", className = "Client.UpdateEmployeeResponse")
    public Employee updateEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws EmployeeNotFound_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns Client.Employee
     * @throws EmployeeAlreadyExists_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addEmployee", targetNamespace = "http://Server/", className = "Client.AddEmployee")
    @ResponseWrapper(localName = "addEmployeeResponse", targetNamespace = "http://Server/", className = "Client.AddEmployeeResponse")
    public Employee addEmployee(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws EmployeeAlreadyExists_Exception
    ;

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "countEmployees", targetNamespace = "http://Server/", className = "Client.CountEmployees")
    @ResponseWrapper(localName = "countEmployeesResponse", targetNamespace = "http://Server/", className = "Client.CountEmployeesResponse")
    public int countEmployees();

}