package commands;

import dao.impl.CurrentRecordDAOImpl;
import dao.impl.RecordDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.Service;
import services.CRecordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandUpdateRecord extends CommandBase{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = null;
        String id = req.getParameter("recordId");
        CRecordService crec = new CRecordService();
        if(crec.updateCRecordStatus(Integer.parseInt(id),true)){
            page = UPDATE_RECORD_PAGE;
        }
        else{
            req.getSession().setAttribute("error", "No such record!");
            page = ERROR_PAGE;
        }
        return page;
    }
}
