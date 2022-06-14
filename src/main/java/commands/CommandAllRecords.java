package commands;

import dao.impl.RecordDAOImpl;
import dao.impl.ServiceDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Record;
import entity.Service;
import entity.User;
import services.RecordService;
import services.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CommandAllRecords extends CommandBase{
    RecordService record = new RecordService();
    ServiceService service = new ServiceService();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Record> records = record.findRecords();
        List<Service> services = service.findServices();
        session.setAttribute("records", records);
        session.setAttribute("services", services);
        return ALL_RECORDS_PAGE;
    }
}
