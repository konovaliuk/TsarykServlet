package services;

import dao.impl.RecordDAOImpl;
import dao.impl.UserDAOImpl;
import entity.User;

import java.sql.Connection;
import java.util.List;

public class UserService {
    UserDAOImpl userDAO = new UserDAOImpl();
    public List<User> findUsers(){
        return userDAO.findUsers();
    }
    public User findUserById( int id){
        return userDAO.findUserById(id);
    }
    public User isUser( String username, String password){
        return userDAO.isUser(username, password);
    }
    public boolean createUser( User user){
        return userDAO.createUser(user);
    }
}
