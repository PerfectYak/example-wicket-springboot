package com.example.wicket.vo;

import java.io.Serializable;

public class AddressVO implements Serializable {
    private String zip;
    private String city;
    private String address;

    public String getCity() {
        return city;
    }

    public AddressVO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddressVO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public AddressVO setZip(String zip) {
        this.zip = zip;
        return this;
    }
}
