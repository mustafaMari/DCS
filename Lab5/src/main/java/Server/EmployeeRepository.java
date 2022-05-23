package Server;

import java.util.List;


public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id) throws EmployeeNotFound;
    Employee updateEmployee(int id, String firstName) throws EmployeeNotFound;
    boolean deleteEmployee(int id) throws EmployeeNotFound;
    Employee addEmployee(int id, String name) throws EmployeeAlreadyExists;
    int count();

}
