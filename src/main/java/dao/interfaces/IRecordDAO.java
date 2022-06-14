package dao.interfaces;
import entity.Record;
import entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
public interface IRecordDAO {
    List<Record> findRecords();
    List<Record> findRecordsByDate(Date date);
    List<Record> findRecordsByService(String serv_name);
    void createRecord( Record record);
    boolean updateRecordStatus( int id, boolean is_open);
    void deleteRecord( int id);
    List<Record> findRecordsByMaster( User user);
    List<Record> findRecordsByClient( User user);
}
