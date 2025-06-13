package com.Ritesh.Project.Model;

public class GroupMembers {
    private String playerId;
    private String name;

    public GroupMembers(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public GroupMembers() {
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
}
