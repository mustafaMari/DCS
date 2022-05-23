package Server;

import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceProvider;

import java.util.ArrayList;
import java.util.List;



public class EmployeeRepoImple implements EmployeeRepository {
    private final List<Employee> employeeList;

    public EmployeeRepoImple() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Mustafa"));
        employeeList.add(new Employee(2, "Mari"));
        employeeList.add(new Employee(3, "Hassan"));
        employeeList.add(new Employee(4, "Alhamoud"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployee(int id) throws EmployeeNotFound {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFound();


    }

    @Override
    public Employee updateEmployee(int id, String firstName) throws EmployeeNotFound {
        try{
            Employee e = getEmployee(id);
            e.setId(id);
            e.setFirstName(firstName);
            return e;
        }catch (EmployeeNotFound e){
            throw new EmployeeNotFound();
        }
    }

    @Override
    public boolean deleteEmployee(int id) throws EmployeeNotFound {
        try{
            employeeList.remove(getEmployee(id));
            return true;
        }catch (EmployeeNotFound e){
            throw new EmployeeNotFound();
        }

    }

    @Override
    public Employee addEmployee(int id, String name) throws EmployeeAlreadyExists {
        for (Employee e : employeeList){
            if (e.getId() == id){
                throw new EmployeeAlreadyExists();
            }
        }

        Employee e = new Employee(id, name);
        employeeList.add(e);
        return e;
    }

    @Override
    public int count() {
        return employeeList.size();
    }
}
