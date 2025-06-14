package com.Ritesh.Project.Services;

import com.Ritesh.Project.Entity.JoiningRequest;
import com.Ritesh.Project.Entity.Members;
import com.Ritesh.Project.Entity.Players;
import com.Ritesh.Project.Entity.PlayersGroups;
import com.Ritesh.Project.Model.*;
import com.Ritesh.Project.Repositories.GroupsRepo;
import com.Ritesh.Project.Repositories.JoiningRequestRepo;
import com.Ritesh.Project.Repositories.MembersRepo;
import com.Ritesh.Project.Repositories.PlayersRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    private PlayersRepo playersRepo;
    private PasswordEncoder encoder;
    private GroupsRepo groupRepo;
    private MembersRepo membersRepo;
    private JoiningRequestRepo requestRepo;

    public HomeService(PlayersRepo repo, PasswordEncoder encoder, GroupsRepo groupRepo, MembersRepo membersRepo, JoiningRequestRepo requestRepo){
        this.playersRepo = repo;
        this.encoder = encoder;
        this.groupRepo = groupRepo;
        this.membersRepo = membersRepo;
        this.requestRepo = requestRepo;
    }

    public boolean checkForPlayerId(String id){
        System.out.println("entered check for player id");
        Players player = playersRepo.findByplayerId(id.toLowerCase());
        System.out.println("checked "+player);
        if(player == null){
            System.out.println("true");
            return true;
        }

        return false;
    }

    public boolean register(PlayerDetail detail) {
       boolean isAvailable =  checkForPlayerId(detail.getPlayerId());
       if(isAvailable){
           Players player = new Players();
           player.setPlayerId(detail.getPlayerId().toLowerCase());
           player.setName(detail.getName());
           player.setPhone(detail.getPhone());
           player.setSport(detail.getSport().toLowerCase());
           player.setArea(detail.getArea());
           player.setGroupId(detail.getGroupId());
           player.setPin(encoder.encode(detail.getPin()));
           player.setDescription(detail.getDescription());

          Players savedPlayer =  playersRepo.save(player);
           return true;
       }
       return false;
    }


    public HomeDetailsDto getAllDetails(String playerId) {

        HomeDetailsDto home = new HomeDetailsDto();

        Players player = playersRepo.findByplayerId(playerId);
        PlayerDto dto = new PlayerDto(player.getPlayerId(),player.getName(),player.getPhone(),player.getSport(),player.getArea(),player.getDescription());
        home.setPlayer(dto);


        String myGroupId = player.getGroupId();
        if(myGroupId != null){
            String name = groupRepo.getName(myGroupId);
            YourGroup group = new YourGroup(myGroupId,name);
            home.setGroup(group);
        }

        List<String> groupIds = membersRepo.findAllGroupIds(playerId);
        if(groupIds == null){
            return home;
        }
        List<PlayersGroups> allGroups = groupRepo.findAllById(groupIds);
        ArrayList<YouAreInThem> groups = new ArrayList<>();
        for(PlayersGroups group : allGroups){
            groups.add(new YouAreInThem(group.getGroupId(),group.getName()));
        }
        home.setGroups(groups);

        List<String> requests = requestRepo.getAllRequests(playerId);
        home.setRequests(requests);
        return home;

    }

    public PlayerDto searchPlayer(String playerId) {
        PlayerDto player = playersRepo.searchPlayer(playerId);
        return player;
    }

    public void createGroup(PlayersGroups group) {
        groupRepo.save(group);
        Players player = playersRepo.findByplayerId(group.getAdminId());
        player.setGroupId(group.getGroupId());
        playersRepo.save(player);
    }

    public GroupPageDetails getGroupDetails(String groupId) {
        Optional<PlayersGroups> temp = groupRepo.findById(groupId);

        PlayersGroups detail = temp.get();
        GroupDetails gd = new GroupDetails(detail.getGroupId(),detail.getName(),
                                                 detail.getSport(),detail.getArea(),
                                                detail.getMoto(),detail.getNotice(),
                                                    detail.getAdminId());
        GroupPageDetails details = new GroupPageDetails();
        details.setGroupDetails(gd);
        List<String> playerIds = membersRepo.getAllPlayersId(groupId);
        List<GroupMembers> membersList = playersRepo.getMembersDetails(playerIds);
        details.setMembers((ArrayList<GroupMembers>) membersList);

        return details;
     }

    public GroupPageDetails updateNotice(String groupId, String notice) {
       Optional<PlayersGroups> ogroup =  groupRepo.findById(groupId);
       PlayersGroups detail = ogroup.get();
       detail.setNotice(notice);
       groupRepo.save(detail);

        GroupDetails gd = new GroupDetails(detail.getGroupId(),detail.getName(),
                detail.getSport(),detail.getArea(),
                detail.getMoto(),detail.getNotice(),
                detail.getAdminId());
        GroupPageDetails details = new GroupPageDetails();
        details.setGroupDetails(gd);
        List<String> playerIds = membersRepo.getAllPlayersId(groupId);
        List<GroupMembers> membersList = playersRepo.getMembersDetails(playerIds);
        details.setMembers((ArrayList<GroupMembers>) membersList);

        return details;


    }

    public List<GroupDetails> getAllGroupsBySport(String playerId, String sport) {
        List<String> playerIsInThem = membersRepo.findAllGroupIds(playerId);
        playerIsInThem.add(playerId);
        List<GroupDetails> groups = groupRepo.findAllRemainingGroups(playerIsInThem,sport);
        return groups;
    }

    public void requestGroup(String groupId, String playerId) {
        requestRepo.save(new JoiningRequest(playerId,groupId));
    }

    public HomeDetailsDto acceptRequest(String myGroupId,String requestingPlayerId, String playerId) {
        Members member = new Members(myGroupId,requestingPlayerId);
        membersRepo.save(member);
        requestRepo.removeRequest(myGroupId,requestingPlayerId);

        HomeDetailsDto home = new HomeDetailsDto();

        Players player = playersRepo.findByplayerId(playerId);
        PlayerDto dto = new PlayerDto(player.getPlayerId(),player.getName(),player.getPhone(),player.getSport(),player.getArea(),player.getDescription());
        home.setPlayer(dto);


        String MyGroupId = player.getGroupId();
        if(MyGroupId != null){
            String name = groupRepo.getName(MyGroupId);
            YourGroup group = new YourGroup(MyGroupId,name);
            home.setGroup(group);
        }

        List<String> groupIds = membersRepo.findAllGroupIds(playerId);
        if(groupIds == null){
            return home;
        }
        List<PlayersGroups> allGroups = groupRepo.findAllById(groupIds);
        ArrayList<YouAreInThem> groups = new ArrayList<>();
        for(PlayersGroups group : allGroups){
            groups.add(new YouAreInThem(group.getGroupId(),group.getName()));
        }
        home.setGroups(groups);

        List<String> requests = requestRepo.getAllRequests(playerId);
        home.setRequests(requests);
        return home;
    }
}
