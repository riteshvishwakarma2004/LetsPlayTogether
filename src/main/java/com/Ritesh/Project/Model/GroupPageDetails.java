package com.Ritesh.Project.Model;

import java.util.ArrayList;

public class GroupPageDetails {
    private GroupDetails groupDetails;
    private ArrayList<GroupMembers>  members;

    public GroupPageDetails(GroupDetails groupDetails, ArrayList<GroupMembers> members) {
        this.groupDetails = groupDetails;
        this.members = members;
    }

    public GroupPageDetails() {
    }

    public GroupDetails getGroupDetails() {
        return groupDetails;
    }

    public void setGroupDetails(GroupDetails groupDetails) {
        this.groupDetails = groupDetails;
    }

    public ArrayList<GroupMembers> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<GroupMembers> members) {
        this.members = members;
    }
}
