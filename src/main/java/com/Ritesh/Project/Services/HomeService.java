package com.Ritesh.Project.Services;

import com.Ritesh.Project.Entity.Players;
import com.Ritesh.Project.Entity.PlayersGroups;
import com.Ritesh.Project.Model.*;
import com.Ritesh.Project.Repositories.GroupsRepo;
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
    public HomeService(PlayersRepo repo, PasswordEncoder encoder, GroupsRepo groupRepo, MembersRepo membersRepo){
        this.playersRepo = repo;
        this.encoder = encoder;
        this.groupRepo = groupRepo;
        this.membersRepo = membersRepo;
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
        System.out.println("player detail addded");

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

        return home;

    }
}
