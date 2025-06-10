package com.Ritesh.Project.Model;

public class PlayerDetail {
    private String playerId;
    private String name;
    private String phone;
    private String sport;
    private String area;
    private String groupId;
    private String description;
    private String pin;

    public PlayerDetail(String playerId, String name, String phone, String sport, String area, String groupId, String description, String pin) {
        this.playerId = playerId;
        this.name = name;
        this.phone = phone;
        this.sport = sport;
        this.area = area;
        this.groupId = groupId;
        this.description = description;
        this.pin = pin;
    }

    public PlayerDetail() {
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
