package dao.impl;

import connection.ConnectionPool;
import dao.interfaces.IServiceDAO;
import entity.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements IServiceDAO {
    private final String SELECT = "SELECT * FROM service";
    private final String INSERT = "INSERT INTO service(name, cost) VALUES('";
    Service extractService(ResultSet resultSet) throws SQLException {
        Service service = new Service();
        service.setId(resultSet.getLong(1));
        service.setName(resultSet.getString(2));
        service.setCost(resultSet.getLong(3));
        return service;
    }
    public List<Service> findServices(){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        List<Service> services = new ArrayList<>();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT);
            while(resultSet.next()){

                Service service = extractService(resultSet);
                services.add(service);
                System.out.println(service.getId()+"\t" + service.getName()+"\t"+ service.getCost());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return services;
    }
    public List<Service> findServicesByName(String name){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        List<Service> services = new ArrayList<>();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT +" WHERE name LIKE '%"+name +"%'");
            while(resultSet.next()){

                Service service = extractService(resultSet);
                services.add(service);
                System.out.println(service.getId()+"\t" + service.getName()+"\t"+ service.getCost());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return services;
    }
    public boolean createService(Service service){
        boolean res = true;
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute(INSERT + service.getName() + "', "+ service.getCost() +")");

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
            res = false;
        }
        return res;
    }
    public void updateServiceCost(String name, int cost){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute("UPDATE service SET cost = "+cost+" WHERE name='" + name+"'");

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public void deleteService(int id){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute("DELETE FROM service WHERE id=" + id);

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}

