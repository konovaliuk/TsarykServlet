package commands;

import dao.impl.UserDAOImpl;
import entity.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CommandAllUsers extends CommandBase{
    UserService user = new UserService();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(req.getSession().getAttribute("role"));
        if ((long) req.getSession().getAttribute("role")==2l){
            List<User> users = user.findUsers();
            session.setAttribute("users", users);
            return ALL_USERS_PAGE;
        }
        else {
            req.getSession().setAttribute("error", "No access!");
            return ERROR_PAGE;
        }
    }
}
