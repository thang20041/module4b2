package com.example.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String email;
    private String address;
    private String phone;
    private Clazz clazz;

    public Student(int id, String name, String dob, String email, String address, String phone, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.clazz = clazz;
    }

    public Student(String name, String dob, String email, String address, String phone, Clazz clazz) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
