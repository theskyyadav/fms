package com.pjsoft.fms.pojo.auth.dto;

public
class UserResponse {
    private Long id;
    private String name;
    private String username;

    public
    UserResponse(Long id, String name, String username) {
        this.id=id;
        this.name=name;
        this.username=username;

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
    String getName() {
        return name;
    }

    public
    void setName(String name) {
        this.name = name;
    }

    public
    String getUsername() {
        return username;
    }

    public
    void setUsername(String username) {
        this.username = username;
    }
}
