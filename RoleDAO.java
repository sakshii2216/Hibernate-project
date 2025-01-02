package Hibernate.EmployeeManagement.dao;



import java.util.List;

import Hibernate.EmployeeManagement.entity.Role;
import Hibernate.EmployeeManagement.util.HibernateUtil;


public interface RoleDAO {
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(int role_id);
    Role getRole(int role_id);
    List<Role> getAllRoles();
}
