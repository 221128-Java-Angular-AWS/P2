package com.revature.Squawk.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "logs")
public class Log {
    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time")
    private Timestamp dateTime;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference( value = "log_user")
    @JoinColumn(name =  "user_id")
    private Integer userId;
    */


    @Column(name = "user_id")
    private Integer userId;

    @Column
    private String event;

    public Log () {}

    public Log (Timestamp dateTime, Integer userId, String event){
        this.dateTime = dateTime;
        this.userId = userId;
        this.event = event;
    }

    public Log(Integer id,  Timestamp dateTime, Integer userId, String event) {
        this.id = id;
        this.dateTime = dateTime;
        this.userId = userId;
        this.event = event;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUser(Integer userId) {
        this.userId = userId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id) && Objects.equals(dateTime, log.dateTime) && Objects.equals(userId, log.userId) && Objects.equals(event, log.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, userId, event);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", userId=" + userId +
                ", event='" + event + '\'' +
                '}';
    }
}
