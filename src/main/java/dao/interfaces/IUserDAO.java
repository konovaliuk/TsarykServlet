package dao.interfaces;
import entity.User;

import java.sql.Connection;
import java.util.List;
public interface IUserDAO {
    List<User> findUsers();
    User findUserById(int id);
    boolean createUser(User user);
    void deleteUser(int id);
    User isUser(String username, String password);
}
