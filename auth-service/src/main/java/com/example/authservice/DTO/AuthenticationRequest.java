package com.example.authservice.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private  String password;
    private String accounttype;

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public AuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
