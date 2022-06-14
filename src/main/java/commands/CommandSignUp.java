package commands;

import connection.ConnectionPool;
import dao.impl.UserDAOImpl;
import entity.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

public class CommandSignUp extends CommandBase{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = null;
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        User new_user = new User(0l, firstname, lastname, username, password, email, phone,1l);
        UserService user = new UserService();
        if(user.createUser(new_user)){
            req.getSession().setAttribute("user", username);
            req.getSession().setAttribute("userId", new_user.getId());
            req.getSession().setAttribute("role", new_user.getId_role());
            page = MAIN_PAGE;
        }
        else{
            req.getSession().setAttribute("error", "Email or phone already exists!");
            page = ERROR_PAGE;
        }
        return page;
    }
}
