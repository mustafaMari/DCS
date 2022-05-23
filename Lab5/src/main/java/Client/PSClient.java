package Client;

import java.net.MalformedURLException;
import java.net.URL;

public class PSClient {
    public static void main(String[] args) throws MalformedURLException, EmployeeNotFound_Exception {
        int num = -1;
        URL url = new URL("http://localhost:8001/employee-service?wsdl");
        EmployeeService_Service employeeService_service = new EmployeeService_Service();
        EmployeeService employeeService = employeeService_service.getEmployeeServiceImplPort();
        num = employeeService.countEmployees();
        System.out.println("Number of employees" + num);
        Employee employee = employeeService.getEmployee(1);
        System.out.println("Employee " + employee.firstName + ", id="+employee.id );

        try
        {
            employeeService.addEmployee(4, "newName");
        } catch (EmployeeAlreadyExists_Exception e)
        {
            System.out.println("...already added");
        }

        employee = employeeService.getEmployee(4);
        System.out.println("Employee " + employee.firstName + ", id="+employee.id );


    /*

        |---|   |------ |\    | |   |-----
        |   |   |       | \   | |   |
        |---|   |------ |  \  | |   |----|
        |       |       |   \ | |        |
        |       |------ |    \| |   -----|

         */
    }
}
