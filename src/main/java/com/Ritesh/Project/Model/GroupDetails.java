package com.Ritesh.Project.Model;

public class GroupDetails {
    private String GroupId;
    private String name;
    private String adminId;
    private String sport;
    private String area;
    private String moto;
    private String notice;

    public GroupDetails(String groupId, String name, String sport, String area, String moto, String notice,String adminId) {
        GroupId = groupId;
        this.name = name;
        this.sport = sport;
        this.area = area;
        this.moto = moto;
        this.notice = notice;
        this.adminId  = adminId;
    }

    public GroupDetails() {
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
