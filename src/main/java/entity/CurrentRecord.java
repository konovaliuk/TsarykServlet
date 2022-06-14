package entity;

import java.util.Objects;

public class CurrentRecord {
    private Long id;
    private Long id_client;
    private Boolean is_closed;
    public CurrentRecord(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Boolean getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(Boolean is_closed) {
        this.is_closed = is_closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentRecord that = (CurrentRecord) o;
        return Objects.equals(id, that.id) && Objects.equals(id_client, that.id_client) && Objects.equals(is_closed, that.is_closed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_client, is_closed);
    }

    @Override
    public String toString() {
        return "Current_record{" +
                "id=" + id +
                ", id_client=" + id_client +
                ", is_closed=" + is_closed +
                '}';
    }
}
