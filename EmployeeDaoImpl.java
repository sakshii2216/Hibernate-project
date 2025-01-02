package Hibernate.EmployeeManagement.daoIMPL;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        try {
            if (EmployeeValidator.validateEmployee(employee)) {
                employeeList.add(employee);
                System.out.println("Employee added successfully.");
            } else {
                System.out.println("Failed to add employee: Validation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            if (EmployeeValidator.validateEmployee(employee)) {
                boolean found = false;
                for (Employee emp : employeeList) {
                    if (emp.getId() == employee.getId()) {
                        emp.setFirstName(employee.getFirstName());
                        emp.setLastName(employee.getLastName());
                        emp.setEmail(employee.getEmail());
                        emp.setPhone(employee.getPhone());
                        found = true;
                        System.out.println("Employee updated successfully.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Employee not found.");
                }
            } else {
                System.out.println("Failed to update employee: Validation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int emp_id) {
        try {
            boolean removed = employeeList.removeIf(emp -> emp.getId() == employeeId);
            if (removed) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    @Override
    public Employee getEmployee(int emp_id) {
        try {
            for (Employee emp : employeeList) {
                if (emp.getId() == employeeId) {
                    return emp;
                }
            }
            System.out.println("Employee not found.");
            return null;
        } catch (Exception e) {
            System.out.println("Error retrieving employee: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try {
            return employeeList;
        } catch (Exception e) {
            System.out.println("Error retrieving all employees: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
