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

public class CommandLogin extends CommandBase{
        @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = null;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService user = new UserService();
        User log_user = user.isUser(username, password);
        System.out.println(log_user);
        if(log_user != null){
            req.getSession().setAttribute("userId", log_user.getId());
            req.getSession().setAttribute("user", username);
            req.getSession().setAttribute("role", log_user.getId_role());
            page = MAIN_PAGE;
        }
        else{
            req.getSession().setAttribute("error", "Login error!");
            page = ERROR_PAGE;
        }
        return page;
    }
}
