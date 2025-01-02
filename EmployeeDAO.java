package Hibernate.EmployeeManagement.dao;


import java.util.List;

import Hibernate.EmployeeManagement.entity.Employee;
import Hibernate.EmployeeManagement.util.HibernateUtil;


	public interface EmployeeDAO {
	    void addEmployee(Employee employee);
	    Employee getEmployee(int emp_id);
	    List<Employee> getAllEmployees();
	    void updateEmployee(Employee employee);
	    void deleteEmployee(int emp_id);
	}
