package services;

import dao.impl.ServiceDAOImpl;
import entity.Service;

import java.sql.Connection;
import java.util.List;

public class ServiceService {
    private static final ServiceDAOImpl serviceDAO = new ServiceDAOImpl();
    public List<Service> findServices(){
        return serviceDAO.findServices();
    }
    public boolean createService(Service service){
        return serviceDAO.createService(service);
    }
}
