package Server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface EmployeeService {
    @WebMethod
    Employee getEmployee(int id) throws EmployeeNotFound;
    @WebMethod
    Employee updateEmployee(int id, String name) throws EmployeeNotFound;
    @WebMethod
    boolean deleteEmployee(int id)  throws EmployeeNotFound;
    @WebMethod
    Employee addEmployee(int id, String name) throws EmployeeAlreadyExists;
    @WebMethod
    int countEmployees();
    @WebMethod
    List<Employee> getAllEmployees();
}
