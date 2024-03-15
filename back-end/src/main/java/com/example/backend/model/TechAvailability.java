package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class TechAvailability {

    @Id
    @GeneratedValue
    private Integer availabilityId;
    private Integer technicianId;
    private String date;
    private String time;
    private String availability;
    private String hospitalFee;
    private String technicianFee;


    public Integer getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Integer availabilityId) {
        this.availabilityId = availabilityId;
    }

    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getHospitalFee() {
        return hospitalFee;
    }

    public void setHospitalFee(String hospitalFee) {
        this.hospitalFee = hospitalFee;
    }

    public String getTechnicianFee() {
        return technicianFee;
    }

    public void setTechnicianFee(String technicianFee) {
        this.technicianFee = technicianFee;
    }
}
