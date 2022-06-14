package commands;

import connection.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

public class CommandBase implements ICommand{
    protected String MAIN_PAGE = "/mainView.jsp";
    protected String LOGIN_PAGE = "/loginView.jsp";
    protected String SIGNUP_PAGE = "/signupView.jsp";
    protected String ERROR_PAGE = "/errorView.jsp";
    protected String ALL_USERS_PAGE = "/allUsersView.jsp";
    protected String ALL_RECORDS_PAGE = "/allRecordsView.jsp";
    protected String ALL_SERVICES_PAGE = "/allServicesView.jsp";
    protected String CREATE_SERVICE_PAGE = "/createServiceView.jsp";
    protected String CREATE_RECORD_PAGE = "/createRecordView.jsp";
    protected String MY_RECORDS_PAGE = "/myRecordsView.jsp";
    protected String UPDATE_RECORD_PAGE = "/updateRecordView.jsp";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return LOGIN_PAGE;
    }

}
