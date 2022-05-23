package Server;

import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "EmployeeService", endpointInterface = "Server.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepoImple employeeRepoImple  = new EmployeeRepoImple();
    @Override
    public Employee getEmployee(int id) throws EmployeeNotFound {
        return employeeRepoImple.getEmployee(id);
    }

    @Override
    public Employee updateEmployee(int id, String name) throws  EmployeeNotFound {
        return employeeRepoImple.updateEmployee(id, name);
    }

    @Override
    public boolean deleteEmployee(int id) throws EmployeeNotFound {
        return employeeRepoImple.deleteEmployee(id);
    }

    @Override
    public Employee addEmployee(int id, String name) throws EmployeeAlreadyExists {
        return employeeRepoImple.addEmployee(id, name);
    }

    @Override
    public int countEmployees() {
        return employeeRepoImple.count();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepoImple.getAllEmployees();
    }
}
