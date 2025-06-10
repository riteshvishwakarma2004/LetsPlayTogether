package com.Ritesh.Project.Services;

import com.Ritesh.Project.Entity.Players;
import com.Ritesh.Project.Repositories.PlayersRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService {

    private PlayersRepo playersRepo;

    public HomeService(PlayersRepo repo){
        this.playersRepo = repo;
    }

    public boolean checkForPlayerId(String id){
        System.out.println("entered check for player id");
        Players player = playersRepo.findByplayerId(id);
        System.out.println("checked "+player);
        if(player == null){
            System.out.println("true");
            return true;
        }

        return false;
    }
}
