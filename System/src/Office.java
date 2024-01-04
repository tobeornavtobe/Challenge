import java.util.List;
import java.util.ArrayList;

public class Office {
    private String officeName;
    private int officeNumber;
    private static int officeCounter = 100000; // ensure 6 digit
    private List<Employee> employees;

    // Constructor
    public Office(String officeName) {
        this.officeName = officeName;
        this.officeNumber = generateOfficeNumber();
        this.employees = new ArrayList<>();

    }

    private int generateOfficeNumber() {
        return ++officeCounter;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public String getOfficeName() {
        return officeName;
    }

    // Adds an employee only if the employee does not already exist
    public boolean addEmployee(String employeeName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(employeeName)) {
                return false;
            }

        }
        return employees.add(new Employee(employeeName));

    }

    // Iterates through the list and removes an employee only if the employee
    // already exists
    public boolean removeEmployee(String employeeName) {
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(employeeName)) {
                employeeToRemove = employee;
                break;
            }
        }
        return employeeToRemove != null && employees.remove(employeeToRemove);
    }

    // Returns an unmodifiable list
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public String toString() {
        return "Office " + officeNumber + ": " + officeName;
    }

}