package commands;

import dao.impl.ServiceDAOImpl;
import entity.Service;
import services.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CommandAllServices extends CommandBase{
    ServiceService service = new ServiceService();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Service> services = service.findServices();
        session.setAttribute("services", services);
        return ALL_SERVICES_PAGE;
    }
}
