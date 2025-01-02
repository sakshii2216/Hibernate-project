package Hibernate.EmployeeManagement.daoIMPL;

	import java.util.ArrayList;
	import java.util.List;

	import java.util.ArrayList;
	import java.util.List;

	public class DepartmentDaoImpl implements IDepartmentDAO {
	    private List<Department> departmentList = new ArrayList<>();

	    @Override
	    public void addDepartment(Department department) {
	        try {
	            if (DepartmentValidator.validateDepartment(department)) {
	                departmentList.add(department);
	                System.out.println("Department added successfully.");
	            } else {
	                System.out.println("Failed to add department: Validation failed.");
	            }
	        } catch (Exception e) {
	            System.out.println("Error adding department: " + e.getMessage());
	        }
	    }

	    @Override
	    public void updateDepartment(Department department) {
	        try {
	            if (DepartmentValidator.validateDepartment(department)) {
	                boolean found = false;
	                for (Department dept : departmentList) {
	                    if (dept.getDeptId() == department.getDeptId()) {
	                        dept.setDeptName(department.getDeptName());
	                        dept.setBudget(department.getBudget());
	                        dept.setManagerId(department.getManagerId());
	                        found = true;
	                        System.out.println("Department updated successfully.");
	                        break;
	                    }
	                }
	                if (!found) {
	                    System.out.println("Department not found.");
	                }
	            } else {
	                System.out.println("Failed to update department: Validation failed.");
	            }
	        } catch (Exception e) {
	            System.out.println("Error updating department: " + e.getMessage());
	        }
	    }

	    @Override
	    public void deleteDepartment(int dept_id) {
	        try {
	            boolean removed = departmentList.removeIf(dept -> dept.getDeptId() == deptId);
	            if (removed) {
	                System.out.println("Department deleted successfully.");
	            } else {
	                System.out.println("Department not found.");
	            }
	        } catch (Exception e) {
	            System.out.println("Error deleting department: " + e.getMessage());
	        }
	    }

	    @Override
	    public Department getDepartment(int deptd) {
	        try {
	            for (Department dept : departmentList) {
	                if (dept.getDeptId() == deptId) {
	                    return dept;
	                }
	            }
	            System.out.println("Department not found.");
	            return null;
	        } catch (Exception e) {
	            System.out.println("Error retrieving department: " + e.getMessage());
	            return null;
	        }
	    }

	    @Override
	    public List<Department> getAllDepartments() {
	        try {
	            return departmentList;
	        } catch (Exception e) {
	            System.out.println("Error retrieving all departments: " + e.getMessage());
	            return new ArrayList<>();
	        }
	    }
	}
