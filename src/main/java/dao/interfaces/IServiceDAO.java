package dao.interfaces;
import entity.Service;

import java.sql.Connection;
import java.util.List;
public interface IServiceDAO {
    List<Service> findServices();
    List<Service> findServicesByName(String name);
    boolean createService(Service service);
    void updateServiceCost(String name, int cost);
    void deleteService(int id);
}
