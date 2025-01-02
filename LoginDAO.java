package Hibernate.EmployeeManagement.dao;



import java.util.List;

import Hibernate.EmployeeManagement.entity.Login;

public interface LoginDAO {
    void addLogin(Login login);
    void updateLogin(Login login);
    void deleteLogin(int login_id);
    Login getLogin(int login_id);
    List<Login> getAllLogins();
}
