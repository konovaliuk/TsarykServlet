package dao.impl;

import connection.ConnectionPool;
import dao.interfaces.IUserDAO;
import entity.User;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAOImpl implements IUserDAO {
    private final String SELECT = "SELECT * FROM user u";
    private final String INSERT = "INSERT INTO user(firstname, lastname, username, password, email, phone, id_role) VALUES('";
    private final String COLUMN_ID = "id";
    private final String COLUMN_FIRSTNAME = "firstname";
    private final String COLUMN_LASTNAME = "lastname";
    private final String COLUMN_USERNAME = "username";
    private final String COLUMN_PASS = "password";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_PHONE = "phone";
    private final String COLUMN_ROLE = "id_role";
    User extractUser(ResultSet resultSet) throws SQLException{
        User user = new User();
        user.setId(resultSet.getLong(COLUMN_ID));
        user.setUsername(resultSet.getString(COLUMN_USERNAME));
        user.setPassword(resultSet.getString(COLUMN_PASS));
        user.setId_role(resultSet.getLong(COLUMN_ROLE));
        return user;
    }
    public List<User> findUsers(){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        List<User> users = new ArrayList<>();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT);
            while(resultSet.next()){

                User user = extractUser(resultSet);
                users.add(user);
                System.out.println(user.getId()+"\t" + user.getFirstname()+"\t"+ user.getLastname()+"\t"+user.getId_role());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return users;
    }
    public User findUserById( int id){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        User user = null;
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT + " WHERE u.id=" + id);
            while(resultSet.next()){
                user = extractUser(resultSet);
                System.out.println(user.getId()+"\t" + user.getFirstname()+"\t"+ user.getLastname() +"\t"+user.getId_role());
            }

            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return user;
    }
    public User isUser( String username, String password){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        User user = null;
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            System.out.println(SELECT + " WHERE u.username=" + '"'+ username + '"');
            ResultSet resultSet = stmtObj.executeQuery(SELECT + " WHERE u.username=" + '"'+username +'"');
            while(resultSet.next()){
                user = extractUser(resultSet);
                System.out.println(user.getId()+"\t" + user.getUsername()+"\t"+ user.getPassword());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
            user = null;
        }
        if(user==null){return null;}
        if (!(Objects.equals(user.getPassword(),password))) {
            user = null;
            return user;
        }
        System.out.println(user);
        return user;
    }
    public boolean createUser( User user){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        boolean res = true;
        System.out.println(INSERT + user.getFirstname() + "', '"+ user.getLastname() + "', '"+
                user.getUsername()+"', '"+user.getPassword()+"', '"+user.getEmail()+"', '"+user.getPhone()+
                "', "+user.getId_role()+")");
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute(INSERT + user.getFirstname() + "', '"+ user.getLastname() + "', '"+
                    user.getUsername()+"', '"+user.getPassword()+"', '"+user.getEmail()+"', '"+user.getPhone()+
                    "', "+user.getId_role()+")");

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
            res = false;
        }
        return res;
    }
    public void deleteUser( int id){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute("DELETE FROM user WHERE id=" + id);

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
