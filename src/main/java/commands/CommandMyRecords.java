package commands;

import dao.impl.CurrentRecordDAOImpl;
import dao.impl.RecordDAOImpl;
import dao.impl.UserDAOImpl;
import entity.CurrentRecord;
import entity.Record;
import entity.User;
import services.RecordService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CommandMyRecords extends CommandBase{
    UserService user = new UserService();
    RecordService rec = new RecordService();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object id = req.getSession().getAttribute("userId");
        if ((long) req.getSession().getAttribute("role")==1l){
            List<Record> records = rec.findRecordsByClient(user.findUserById(((Number)id).intValue()));
            if(records.isEmpty()) {
                req.getSession().setAttribute("error", "No records!");
                return ERROR_PAGE;
            }
            session.setAttribute("records", records);
            return MY_RECORDS_PAGE;
        }
        if ((long) req.getSession().getAttribute("role")==3l){
            List<Record> records = rec.findRecordsByMaster(user.findUserById( ((Number)id).intValue()));
            if(records.isEmpty()) {
                req.getSession().setAttribute("error", "No records!");
                return ERROR_PAGE;
            }
            session.setAttribute("records", records);
            return MY_RECORDS_PAGE;
        }
        else {
            req.getSession().setAttribute("error", "No records!");
            return ERROR_PAGE;
        }
    }
}
