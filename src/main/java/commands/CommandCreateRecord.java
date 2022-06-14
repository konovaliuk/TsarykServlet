package commands;

import connection.ConnectionPool;
import dao.impl.CurrentRecordDAOImpl;
import dao.impl.ServiceDAOImpl;
import dao.impl.UserDAOImpl;
import entity.CurrentRecord;
import services.CRecordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

public class CommandCreateRecord extends CommandBase{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = null;
        Object id = req.getSession().getAttribute("userId");
        UserDAOImpl user = new UserDAOImpl();
        String rec = req.getParameter("recordId");
        CRecordService crecord = new CRecordService();
        CommandCreateRecord com = new CommandCreateRecord();

        if(crecord.createCRecord(user.findUserById(((Number)id).intValue()), Integer.parseInt(rec))){
            page = CREATE_RECORD_PAGE;
        }
        else{
            req.getSession().setAttribute("error", "The record is closed");
            page = ERROR_PAGE;
        }
        return page;
    }
}
