package com.fayda.demo.resident;

import jakarta.annotation.Nullable;

import java.util.Date;

public class ResidentDTO {
    private String fullName;
    private String phoneNumber;
    private String zone;
    private String email;
    private String wereda;
    private String nationality;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWereda() {
        return wereda;
    }

    public void setWereda(String wereda) {
        this.wereda = wereda;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}