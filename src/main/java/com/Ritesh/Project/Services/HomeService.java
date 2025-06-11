package com.Ritesh.Project.Services;

import com.Ritesh.Project.Entity.Players;
import com.Ritesh.Project.Model.PlayerDetail;
import com.Ritesh.Project.Repositories.PlayersRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService {

    private PlayersRepo playersRepo;
    private PasswordEncoder encoder;
    public HomeService(PlayersRepo repo, PasswordEncoder encoder){
        this.playersRepo = repo;
        this.encoder = encoder;
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
           player.setGroupId(detail.getGroupId().toLowerCase());
           player.setPin(encoder.encode(detail.getPin()));
           player.setDescription(detail.getDescription());

          Players savedPlayer =  playersRepo.save(player);
           return true;
       }
       return false;
    }







}
