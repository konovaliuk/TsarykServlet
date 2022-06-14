package dao.impl;

import dao.interfaces.IRoleDAO;
import entity.Role;
import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements IRoleDAO {
    private final String SELECT = "SELECT r.id, r.name FROM role r";
    Role extractRole(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getLong(1));
        role.setName(resultSet.getString(2));
        return role;
    }
    public List<Role> findRoles(Connection connObj){
        List<Role> roles = new ArrayList<>();
        try{
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT);
            while(resultSet.next()){

                Role role = extractRole(resultSet);
                roles.add(role);
                System.out.println(role.getId()+"\t" + role.getName());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return roles;
    }
    public Role findRoleById(Connection connObj, int id){
        Role role = null;
        try{
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT+ " WHERE r.id=" + id);
            while(resultSet.next()){
                role = extractRole(resultSet);
                System.out.println(role.getId()+"\t" + role.getName());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return role;
    }
    public void updateRoleName(Connection connObj, int id, String name){
        try{
            Statement stmtObj = connObj.createStatement();
            stmtObj.execute("UPDATE role SET name = '"+name+ "' WHERE id=" + id);
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public void deleteRole(Connection connObj, int id){
        try{
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute("DELETE FROM role WHERE id=" + id);

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
