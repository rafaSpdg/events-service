package com.dolphinevents.eventservice.event;

import java.lang.Override;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;


@Entity(name= "event_details")
public class Event {

    public Event() {

    }

    public Event(Integer id, String name, String location, Timestamp date, double price, String eventType) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.price = price;
        this.eventType = eventType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    private String name;

    
    private String location;

    
    private Timestamp date;

    private double price;

    
    @JsonProperty("event_type")
    private String eventType;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date ) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", location=" + location + ", date=" + date + ", price=" + price
                + ", eventType=" + eventType + "]";
    }
}
