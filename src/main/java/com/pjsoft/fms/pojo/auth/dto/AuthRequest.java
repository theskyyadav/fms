package com.pjsoft.fms.pojo.auth.dto;

public
class AuthRequest {
    private String  username;

    public
    String getPassword() {
        return password;
    }

    public
    void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public
    String getUsername() {
        return username;
    }

    public
    void setUsername(String username) {
        this.username = username;
    }
}
