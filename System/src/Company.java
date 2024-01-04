import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Company {
    private Map<Integer, Office> offices;

    public Company() {
        this.offices = new HashMap<>();
    }

    // Creates a new office object and adds it to the HashMap
    public boolean openOffice(String officeName) {
        Office newOffice = new Office(officeName);
        offices.put(newOffice.getOfficeNumber(), newOffice);
        return true;
    }

    // This returns a specific Office object based on its unique officeNumber
    public Office getOffice(int officeNumber) {
        return offices.get(officeNumber);
    }

    // This returns the entire offices map. I.e the officeNumbers and Office values.
    public Map<Integer, Office> getOffices() {
        return offices;
    }

    // Adds an employee to the specified office
    public boolean addEmployee(String employeeName, int officeNumber) {
        Office office = offices.get(officeNumber);
        return office != null && office.addEmployee(employeeName);
    }

    // Removes an employee from the specified office
    public boolean removeEmployee(String employeeName, int officeNumber) {
        Office office = offices.get(officeNumber);
        return office != null && office.removeEmployee(employeeName);
    }

    // Moves an employee from one office to another, only if the offices already
    // exist
    // Method also checks if the employee exists in the old office and does not
    // already exist in the new office
    public boolean transferEmployee(String employeeName, int oldOfficeNumber, int newOfficeNumber) {
        Office oldOffice = offices.get(oldOfficeNumber);
        Office newOffice = offices.get(newOfficeNumber);

        if (oldOffice != null && newOffice != null) {
            if (oldOffice.removeEmployee(employeeName)) {
                return newOffice.addEmployee(employeeName);
            }
        }

        return false;
    }

    // Returns a list of employees for the specified office
    public List<Employee> getEmployees(int officeNumber) {
        Office office = offices.get(officeNumber);
        return (office != null) ? office.getEmployees() : null;
    }
}