package servlet;

import commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ControllerHelper {
    private static ControllerHelper instance = null;
    HashMap<String, CommandBase> coms = new HashMap<>();
    private ControllerHelper(){
        coms.put("main", new CommandMain());
        coms.put("login", new CommandLogin());
        coms.put("signup", new CommandSignUp());
        coms.put("allUsers", new CommandAllUsers());
        coms.put("records", new CommandAllRecords());
        coms.put("services", new CommandAllServices());
        coms.put("createService", new CommandCreateService());
        coms.put("createRecord", new CommandCreateRecord());
        coms.put("myRecords", new CommandMyRecords());
        coms.put("updateRecord", new CommandUpdateRecord());
    };

    public CommandBase getCommand(HttpServletRequest req){
        System.out.println(req.getParameter("action"));
        CommandBase command = coms.get(req.getParameter("action"));
        if (command == null){
            command = new CommandMain();
        }
        return command;
    }
    public static ControllerHelper getInstance(){
        if(instance == null){
            instance = new ControllerHelper();
        }
        return instance;
    }
}
