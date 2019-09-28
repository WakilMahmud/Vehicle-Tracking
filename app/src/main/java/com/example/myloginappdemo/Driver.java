package com.example.myloginappdemo;

public class Driver {
    String name;
    String phone;
    String vehicle;

    public Driver(String name, String phone, String vehicle) {
        this.name = name;
        this.phone = phone;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
