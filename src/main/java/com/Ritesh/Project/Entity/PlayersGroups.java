package com.Ritesh.Project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PlayersGroups {
    @Id
    private String groupId;
    private String name;
    private String adminId;
    private String area;
    private String sport;
    private String moto;
    private String notice;

    public PlayersGroups(String groupId, String name, String adminId, String area, String sport, String moto, String notice) {
        this.groupId = groupId;
        this.name = name;
        this.adminId = adminId;
        this.area = area;
        this.sport = sport;
        this.moto = moto;
        this.notice = notice;
    }

    public PlayersGroups() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }


}
