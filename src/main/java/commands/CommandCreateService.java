package commands;

import connection.ConnectionPool;
import dao.impl.ServiceDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Service;
import entity.User;
import services.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

public class CommandCreateService extends CommandBase{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = null;
        String name = req.getParameter("name");
        String cost = req.getParameter("cost");
        Service new_service = new Service(0l, name, Long.parseLong(cost));
        ServiceService service = new ServiceService();
        if(service.createService(new_service)){
            page = CREATE_SERVICE_PAGE;
        }
        else{
            req.getSession().setAttribute("error", "Wrong input data!");
            page = ERROR_PAGE;
        }
        return page;
    }
}
