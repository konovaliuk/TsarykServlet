package servlet;

import commands.CommandBase;
import commands.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String page = null;
        try {
            CommandBase command = controllerHelper.getCommand(req);
            System.out.println(command);
            page = command.execute(req, res);
        } catch (ServletException se){
            se.printStackTrace();
            //req.setAttribute("messageError", Message.getInstance().getProperty(Message.SERVLET_EXCEPTION));
        } catch (IOException ioe){
            ioe.printStackTrace();
            //req.setAttribute("messageError", Message.getInstance().getProperty(Message.IO_EXCEPTION));
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }
}
