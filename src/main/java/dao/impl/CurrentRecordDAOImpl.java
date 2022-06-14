package dao.impl;

import connection.ConnectionPool;
import dao.interfaces.ICurrentRecordDAO;
import entity.CurrentRecord;
import entity.Record;
import entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrentRecordDAOImpl implements ICurrentRecordDAO {
    private final String SELECT = "SELECT * FROM current_record";
    private final String INSERT = "INSERT INTO current_record VALUES(";
    private final int COLUMN_ID = 1;
    private final int COLUMN_CLIENT = 2;
    private final int COLUMN_IS_CLOSED = 3;
    CurrentRecord extractCRecord(ResultSet resultSet) throws SQLException {
        CurrentRecord crecord = new CurrentRecord();
        crecord.setId(resultSet.getLong(COLUMN_ID));
        crecord.setId_client(resultSet.getLong(COLUMN_CLIENT));
        crecord.setIs_closed(resultSet.getBoolean(COLUMN_IS_CLOSED));
        return crecord;
    }
    public List<CurrentRecord> findCRecords(){
        List<CurrentRecord> crecords = new ArrayList<>();
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT);
            while(resultSet.next()){

                CurrentRecord crecord = extractCRecord(resultSet);
                crecords.add(crecord);
                System.out.println(crecord.getId()+"\t" + crecord.getId_client()+"\t"+crecord.getIs_closed());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return crecords;
    }

    public CurrentRecord findCRecordById( int id){
        CurrentRecord crecord =null;
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT+" WHERE id = " + id);
            while(resultSet.next()){

                crecord = extractCRecord(resultSet);

            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return crecord;
    }
    public boolean createCRecord( User user, int id){
        boolean res = true;
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            RecordDAOImpl record = new RecordDAOImpl();
            Record r = record.findRecordById(id);
            System.out.println(r.getIs_open());
            if (r.getIs_open()){
                Statement stmtObj = connObj.createStatement();
                stmtObj.execute(INSERT + id +", "+ user.getId() + ", '0')");
                stmtObj.execute("UPDATE record SET is_open = '0' WHERE id=" + id);
                stmtObj.close();
            }
            else {
                System.out.println("The record is closed!");
                res = false;
            }
        } catch(Exception exception){
            exception.printStackTrace();
            res = false;
        }
        return res;
    }
    public boolean updateCRecordStatus(int id, boolean is_closed){
        boolean res = true;
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            int myInt = is_closed ? 1 : 0;
            stmtObj.execute("UPDATE current_record SET is_closed = '"+myInt+ "' WHERE id=" + id);
            deleteCRecord(id);
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
            res = false;
        }
        return res;
    }
    public void deleteCRecord(int id){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute("DELETE FROM current_record WHERE id=" + id);

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
