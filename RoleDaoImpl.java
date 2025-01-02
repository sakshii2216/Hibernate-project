package Hibernate.EmployeeManagement.daoIMPL;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDAO {
    private List<Role> roleList = new ArrayList<>();

    @Override
    public void addRole(Role role) {
        try {
            if (RoleValidator.validateRole(role)) {
                roleList.add(role);
                System.out.println("Role added successfully.");
            } else {
                System.out.println("Failed to add role: Validation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error adding role: " + e.getMessage());
        }
    }

    @Override
    public void updateRole(Role role) {
        try {
            if (RoleValidator.validateRole(role)) {
                boolean found = false;
                for (Role r : roleList) {
                    if (r.getRoleId() == role.getRoleId()) {
                        r.setRoleName(role.getRoleName());
                        found = true;
                        System.out.println("Role updated successfully.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Role not found.");
                }
            } else {
                System.out.println("Failed to update role: Validation failed.");
            }
        } catch (Exception e) {
            System.out.println("Error updating role: " + e.getMessage());
        }
    }

    @Override
    public void deleteRole(int role_id) {
        try {
            boolean removed = roleList.removeIf(r -> r.getRoleId() == roleId);
            if (removed) {
                System.out.println("Role deleted successfully.");
            } else {
                System.out.println("Role not found.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting role: " + e.getMessage());
        }
    }

    @Override
    public Role getRole(int role_id) {
        try {
            for (Role r : roleList) {
                if (r.getRoleId() == role_id) {
                    return r;
                }
            }
            System.out.println("Role not found.");
            return null;
        } catch (Exception e) {
            System.out.println("Error retrieving role: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Role> getAllRoles() {
        try {
            return roleList;
        } catch (Exception e) {
            System.out.println("Error retrieving all roles: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
