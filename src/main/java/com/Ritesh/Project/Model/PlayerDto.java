package com.Ritesh.Project.Model;

public class PlayerDto {
    private String playerId;
    private String name;
    private String phone;
    private String sport;
    private String area;
    private String description;

    public PlayerDto(String playerId, String name, String phone, String sport, String area, String description) {
        this.playerId = playerId;
        this.name = name;
        this.phone = phone;
        this.sport = sport;
        this.area = area;
        this.description = description;
    }

    public PlayerDto() {
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
