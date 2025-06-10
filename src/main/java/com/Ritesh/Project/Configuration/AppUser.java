package com.Ritesh.Project.Configuration;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class AppUser {

    private String playerId;
    private String pin;

    public AppUser(String playerId, String pin) {
        this.playerId = playerId;
        this.pin = pin;
    }

    public AppUser() {
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPassword() {
        return pin;
    }

    public void setPassword(String password) {
        this.pin = password;
    }

}
