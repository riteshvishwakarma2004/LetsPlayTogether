package com.Ritesh.Project.Configuration;


import com.Ritesh.Project.Entity.Players;
import com.Ritesh.Project.Repositories.PlayersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private PlayersRepo repo;

    public MyUserDetailsService(PlayersRepo repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Players player = repo.findByplayerId(id);
        System.out.println("1"+" "+ player.getPlayerId());
        if(player == null){
            throw new UsernameNotFoundException("player not found");
        }
        AppUser user = new AppUser();
        user.setPlayerId(player.getPlayerId());
        System.out.println("2");
        user.setPassword(player.getPin());
        System.out.println("3 "+player.getPin());
        return new CustomUserDetails(user);
    }
}
