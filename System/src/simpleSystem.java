import java.util.ArrayList;
import java.util.List;

public class simpleSystem {
    public static void main(String[] args) {
        Company msrCompany = new Company();

        // Opening offices
        msrCompany.openOffice("Office1");
        msrCompany.openOffice("Office2");

        // Adding employees to offices
        msrCompany.addEmployee("John Doe", 100001);
        msrCompany.addEmployee("Jane Doe", 100001);
        msrCompany.addEmployee("Bob Smith", 100002);

        // Getting employees in an office
        List<Employee> employeesInOffice1 = msrCompany.getEmployees(100001);
        if (employeesInOffice1 != null) {
            System.out.println("Employees in Office1: " + employeesInOffice1);
        }

        // Iterate through all offices and print their employees
        for (Office office : msrCompany.getOffices().values()) {
            int officeNumber = office.getOfficeNumber();
            List<Employee> employeesInOffice = msrCompany.getEmployees(officeNumber);

            if (employeesInOffice != null) {
                System.out.println("Employees in Office " + officeNumber + ": " + employeesInOffice);
            } else {
                System.out.println("No employees in Office " + officeNumber);
            }
        }

        // Removing an employee from an office
        msrCompany.removeEmployee("Jane Doe", 100001);

        // Get all offices
        List<String> allOffices = new ArrayList<>();
        for (Office office : msrCompany.getOffices().values()) {
            allOffices.add(office.toString());
        }
        System.out.println("All offices: " + allOffices);
    }
}
