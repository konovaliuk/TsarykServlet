package services;

import dao.impl.RecordDAOImpl;
import entity.Record;
import entity.User;

import java.util.List;

public class RecordService {
    RecordDAOImpl recordDAO = new RecordDAOImpl();

    public List<Record> findRecords(){
        return recordDAO.findRecords();
    }
    public List<Record> findRecordsByClient(User user){
        return recordDAO.findRecordsByClient(user);
    }
    public List<Record> findRecordsByMaster(User user){
        return recordDAO.findRecordsByMaster(user);
    }
}
