package dao.impl;

import connection.ConnectionPool;
import dao.interfaces.IRecordDAO;
import entity.Record;
import entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDAOImpl implements IRecordDAO {
    private final String SELECT = "SELECT * FROM record";
    private final String INSERT = "INSERT INTO record(date, time, id_master, id_service, is_open ) VALUES('";
    private final int COLUMN_ID = 1;
    private final int COLUMN_DATE = 2;
    private final int COLUMN_TIME = 3;
    private final int COLUMN_MASTER = 4;
    private final int COLUMN_SERVICE = 5;
    private final int COLUMN_IS_OPEN = 6;
    Record extractRecord(ResultSet resultSet) throws SQLException {
        Record record = new Record();
        record.setId(resultSet.getLong(COLUMN_ID));
        record.setDate(resultSet.getDate(COLUMN_DATE));
        record.setTime(resultSet.getTime(COLUMN_TIME));
        record.setId_master(resultSet.getLong(COLUMN_MASTER));
        record.setId_service(resultSet.getLong(COLUMN_SERVICE));
        record.setIs_open(resultSet.getBoolean(COLUMN_IS_OPEN));
        return record;
    }
    public List<Record> findRecords(){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        List<Record> records = new ArrayList<>();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT);
            while(resultSet.next()){

                Record record = extractRecord(resultSet);
                records.add(record);
                System.out.println(record.getId()+"\t" + record.getDate()+"\t"+ record.getTime()+"\t"+record.getId_master()
                        +"\t"+record.getId_service()+"\t"+record.getIs_open());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return records;
    }
    public List<Record> findRecordsByDate(Date date){
        List<Record> records = new ArrayList<>();
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT+" WHERE date = '" + date+ "'");
            while(resultSet.next()){

                Record record = extractRecord(resultSet);
                records.add(record);
                System.out.println(record.getId()+"\t" + record.getDate()+"\t"+ record.getTime()+"\t"+record.getId_master()
                        +"\t"+record.getId_service()+"\t"+record.getIs_open());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return records;
    }
    public Record findRecordById(int id){
        Record record =null;
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT+" WHERE id = " + id);
            while(resultSet.next()){

                record = extractRecord(resultSet);

            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return record;
    }
    public List<Record> findRecordsByService( String serv_name){
        List<Record> records = new ArrayList<>();
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT+" WHERE id_service = (SELECT id FROM service WHERE name = '"+serv_name+"') u");
            while(resultSet.next()){

                Record record = extractRecord(resultSet);
                records.add(record);
                System.out.println(record.getId()+"\t" + record.getDate()+"\t"+ record.getTime()+"\t"+record.getId_master()
                        +"\t"+record.getId_service()+"\t"+record.getIs_open());
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return records;

    }
    public List<Record> findRecordsByClient(User user){
        List<Record> records = new ArrayList<>();
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT+" WHERE id IN (SELECT id FROM current_record WHERE id_client ="+user.getId()+")");
            while(resultSet.next()){

                Record record = extractRecord(resultSet);
                records.add(record);
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return records;

    }
    public List<Record> findRecordsByMaster(User user){
        List<Record> records = new ArrayList<>();
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            ResultSet resultSet = stmtObj.executeQuery(SELECT+" WHERE id IN (SELECT id FROM current_record WHERE id IN (SELECT id FROM record WHERE id_master="+user.getId()+"))");
            while(resultSet.next()){

                Record record = extractRecord(resultSet);
                records.add(record);
            }
            resultSet.close();
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
        return records;

    }
    public void createRecord(Record record){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            int myInt = record.getIs_open() ? 1 : 0;
            stmtObj.execute(INSERT + record.getDate() + "', '"+ record.getTime() + "', "+
                    record.getId_master()+", "+record.getId_service()+", '"+myInt+"')");

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public boolean updateRecordStatus( int id, boolean is_open){
        boolean res = true;
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();
            int myInt = is_open ? 1 : 0;
            stmtObj.execute("UPDATE record SET is_open = '"+myInt+ "' WHERE id=" + id);
            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
            res = false;
        }
        return res;
    }
    public void deleteRecord( int id){
        Connection connObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
        try{
            DataSource dataSource = jdbcObj.setUpPool();
            connObj = dataSource.getConnection();
            Statement stmtObj = connObj.createStatement();

            stmtObj.execute("DELETE FROM record WHERE id=" + id);

            stmtObj.close();
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
