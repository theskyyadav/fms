package com.pjsoft.fms.pojo.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AirportDTO {
    private Long id;

	private String code;

    private String name;

    private String city;

    private String country;

    private double latitude;

    private double longitude;

    public
    Long getId() {
        return id;
    }

    public
    void setId(Long id) {
        this.id = id;
    }

    public
    String getCode() {
        return code;
    }

    public
    void setCode(String code) {
        this.code = code;
    }

    public
    String getName() {
        return name;
    }

    public
    void setName(String name) {
        this.name = name;
    }

    public
    String getCity() {
        return city;
    }

    public
    void setCity(String city) {
        this.city = city;
    }

    public
    String getCountry() {
        return country;
    }

    public
    void setCountry(String country) {
        this.country = country;
    }

    public
    double getLatitude() {
        return latitude;
    }

    public
    void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public
    double getLongitude() {
        return longitude;
    }

    public
    void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}


