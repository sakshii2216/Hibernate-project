package Hibernate.EmployeeManagement.dao;


import java.util.List;

import Hibernate.EmployeeManagement.entity.Department;
import Hibernate.EmployeeManagement.util.HibernateUtil;

public interface DepartmentDAO {
    void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int dept_id);
    Department getDepartment(int dept_id);
    List<Department> getAllDepartments();
}
