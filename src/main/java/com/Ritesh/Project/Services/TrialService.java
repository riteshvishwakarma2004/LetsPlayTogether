package com.Ritesh.Project.Services;

import com.Ritesh.Project.Entity.Players;
import com.Ritesh.Project.Model.PlayerDetail;
import com.Ritesh.Project.Model.PlayerDto;
import com.Ritesh.Project.Repositories.PlayersRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TrialService {

    private final PasswordEncoder passwordEncoder;
    private final PlayersRepo playerRepo;

    public TrialService(PasswordEncoder encoder, PlayersRepo repo) {
        this.playerRepo = repo;
        this.passwordEncoder = encoder;
    }


    public PlayerDetail register(PlayerDetail player){
        Players players = new Players(player.getPlayerId(),player.getName(),player.getPhone(),player.getSport(),player.getArea(),"NA",player.getDescription(),player.getPin());
        players.setPin(passwordEncoder.encode(players.getPin()));
        players.setGroupId("N/A");
       Players  savedPlayer =  playerRepo.save(players);
       return player;
    }
}
