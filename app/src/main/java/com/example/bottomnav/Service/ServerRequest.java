package com.example.bottomnav.Service;

import com.example.bottomnav.POJO.User;

public class ServerRequest {
    private String operation;
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
