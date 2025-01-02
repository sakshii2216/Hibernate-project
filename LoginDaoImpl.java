package Hibernate.EmployeeManagement.daoIMPL;

import java.util.ArrayList;
import java.util.List;

import Hibernate.EmployeeManagement.dao.LoginDAO;

public class LoginDaoImpl implements LoginDAO {
    private List<Login> loginList = new ArrayList<>();

    @Override
    public void addLogin(Login login) {
        try {
            if (LoginValidator.validateLogin(login)) {
                loginList.add(login);
                System.out.println("Login added successfully.");
            } else {
                System.out.println("Failed to add login: Validation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error adding login: " + e.getMessage());
        }
    }

    @Override
    public void updateLogin(Login login) {
        try {
            if (LoginValidator.validateLogin(login)) {
                boolean found = false;
                for (Login l : loginList) {
                    if (l.getLoginId() == login.getLoginId()) {
                        l.setUsername(login.getUsername());
                        l.setPassword(login.getPassword());
                        l.setEmpId(login.getEmpId());
                        found = true;
                        System.out.println("Login updated successfully.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Login not found.");
                }
            } else {
                System.out.println("Failed to update login: Validation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error updating login: " + e.getMessage());
        }
    }

    @Override
    public void deleteLogin(int login_id) {
        try {
            boolean removed = loginList.removeIf(l -> l.getLoginId() == loginId);
            if (removed) {
                System.out.println("Login deleted successfully.");
            } else {
                System.out.println("Login not found.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting login: " + e.getMessage());
        }
    }

    @Override
    public Login getLogin(int login_id) {
        try {
            for (Login l : loginList) {
                if (l.getLoginId() == loginId) {
                    return l;
                }
            }
            System.out.println("Login not found.");
            return null;
        } catch (Exception e) {
            System.out.println("Error retrieving login: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Login> getAllLogins() {
        try {
            return loginList;
        } catch (Exception e) {
            System.out.println("Error retrieving all logins: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
