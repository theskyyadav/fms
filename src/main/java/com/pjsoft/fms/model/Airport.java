package com.pjsoft.fms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
//    @NotBlank(message = "Airport code cannot be blank")
//    @Size(min = 3, max = 5, message = "Airport code must be between 3 and 5 characters")
    private String code;

    @Column(nullable = false)
//    @NotBlank(message = "Airport name cannot be blank")
//    @Size(max = 100, message = "Airport name must not exceed 100 characters")
    private String name;

    @Column(nullable = false)
//    @NotBlank(message = "City cannot be blank")
//    @Size(max = 50, message = "City name must not exceed 50 characters")
    private String city;

    @Column(nullable = false)
//    @NotBlank(message = "Country cannot be blank")
//    @Size(max = 50, message = "Country name must not exceed 50 characters")
    private String country;

    @Column(nullable = false)
    @NotNull(message = "Latitude cannot be null")
    @DecimalMin(value = "-90.0", message = "Latitude must be greater than or equal to -90.0")
    @DecimalMax(value = "90.0", message = "Latitude must be less than or equal to 90.0")
    private double latitude;

    @Column(nullable = false)
    @NotNull(message = "Longitude cannot be null")
    @DecimalMin(value = "-180.0", message = "Longitude must be greater than or equal to -180.0")
    @DecimalMax(value = "180.0", message = "Longitude must be less than or equal to 180.0")
    private double longitude;

    public
    Airport(String code, String name, String city, String country, double latitude, double longitude) {

        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public
    Airport() {
    }

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

