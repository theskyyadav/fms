package com.pjsoft.fms.pojo.auth.dto;

public
class AuthResponse {
    private String username;
    private String token;

    public
    AuthResponse(String username, String token) {
        this.username=username;
        this.token=token;
    }

    public
    String getUsername() {
        return username;
    }

    public
    void setUsername(String username) {
        this.username = username;
    }

    public
    String getToken() {
        return token;
    }

    public
    void setToken(String token) {
        this.token = token;
    }
}
