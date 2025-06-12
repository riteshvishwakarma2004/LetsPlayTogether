package com.Ritesh.Project.Model;

public class YourGroup {
    private String groupId;
    private String name;

    public YourGroup(String groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    public YourGroup() {
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
}
