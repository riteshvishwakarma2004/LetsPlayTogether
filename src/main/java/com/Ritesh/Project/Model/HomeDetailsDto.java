package com.Ritesh.Project.Model;

import java.util.ArrayList;
import java.util.List;

public class HomeDetailsDto {
    private PlayerDto player;
    private ArrayList<YouAreInThem> groups;
    private YourGroup group;
    private List<String> requests;

    public HomeDetailsDto(PlayerDto player, ArrayList<YouAreInThem> groups, YourGroup group) {
        this.player = player;
        this.groups = groups;
        this.group = group;
    }

    public HomeDetailsDto() {
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDto player) {
        this.player = player;
    }

    public ArrayList<YouAreInThem> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<YouAreInThem> groups) {
        this.groups = groups;
    }

    public YourGroup getGroup() {
        return group;
    }

    public void setGroup(YourGroup group) {
        this.group = group;
    }

    public List<String> getRequests() {
        return requests;
    }

    public void setRequests(List<String> requests) {
        this.requests = requests;
    }
}
