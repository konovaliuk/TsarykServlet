package entity;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Record {
    private Long id;
    private Date date;
    private Time time;
    private Long id_master;
    private Long id_service;
    private Boolean is_open;
    public Record() {
    }

    public Record(Long id, Date date, Time time, Long id_master, Long id_service, Boolean is_open) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.id_master = id_master;
        this.id_service = id_service;
        this.is_open = is_open;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Long getId_master() {
        return id_master;
    }

    public void setId_master(Long id_master) {
        this.id_master = id_master;
    }

    public Long getId_service() {
        return id_service;
    }

    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

    public Boolean getIs_open() {
        return is_open;
    }

    public void setIs_open(Boolean is_open) {
        this.is_open = is_open;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) && Objects.equals(date, record.date) && Objects.equals(time, record.time) && Objects.equals(id_master, record.id_master) && Objects.equals(id_service, record.id_service) && Objects.equals(is_open, record.is_open);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, id_master, id_service, is_open);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", id_master=" + id_master +
                ", id_service=" + id_service +
                ", is_open=" + is_open +
                '}';
    }
}

