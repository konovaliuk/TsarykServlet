package dao.interfaces;
import entity.CurrentRecord;

import entity.User;

import java.sql.Connection;
import java.util.List;
public interface ICurrentRecordDAO {
    List<CurrentRecord> findCRecords();
    boolean createCRecord( User user, int id);
    boolean updateCRecordStatus( int id, boolean is_closed);
}
