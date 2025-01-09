package com.pjsoft.fms.pojo.response;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;


public class AirportResponseDTO {

    @Column(nullable = false, unique = true)

//    @Pattern(regexp = "^[A-Z]{3,4}$", message = "Airport code must be 3 or 4 uppercase letters")

    private String code;

    @Column(nullable = false)

    @NotNull(message = "Airport name is required")

    @Size(min = 3, message = "Airport name must be at least 3 characters")

    private String name;



    public String getCode() {

        return code;

    }

    public void setCode(String code) {

        this.code = code;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }


}

