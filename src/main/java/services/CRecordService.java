package services;

import dao.impl.CurrentRecordDAOImpl;
import entity.CurrentRecord;
import entity.User;

import java.util.List;

public class CRecordService {
    CurrentRecordDAOImpl crecordDAO = new CurrentRecordDAOImpl();
    public List<CurrentRecord> findCRecords(){
        return crecordDAO.findCRecords();
    }
    public boolean createCRecord(User user, int id){
        return crecordDAO.createCRecord(user, id);
    }
    public boolean updateCRecordStatus(int id, boolean is_closed){
        return crecordDAO.updateCRecordStatus(id, is_closed);
    }
}
