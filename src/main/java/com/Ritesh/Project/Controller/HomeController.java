package com.Ritesh.Project.Controller;

import com.Ritesh.Project.Entity.PlayersGroups;
import com.Ritesh.Project.Model.HomeDetailsDto;
import com.Ritesh.Project.Model.PlayerDetail;
import com.Ritesh.Project.Model.PlayerDto;
import com.Ritesh.Project.Services.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    private HomeService homeService;

    public HomeController(HomeService service){
        this.homeService = service;
    }

    @GetMapping("/")
    public String homePage(){
        return "home.html";
    }

    @GetMapping("/registerPage")
    public String registerPage(){
        return "registerPage";
    }

    @GetMapping("/checkId")
    public String checkId(@RequestParam("playerId") String id, Model model){
        boolean isAvailable = homeService.checkForPlayerId(id);
        if(isAvailable){
            model.addAttribute("id", id);
            model.addAttribute("message", "This Id is now your, go ahead");
            return "registerPage";
        }
        model.addAttribute("id", id);
        model.addAttribute("message", "This Id is not available, try another");
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(@RequestParam("playerId") String playerId,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone,
                           @RequestParam("sport") String sport,
                           @RequestParam("area") String area,
                           @RequestParam("description") String description,
                           @RequestParam("pin") String pin,
                           Model model){
        PlayerDetail detail = new PlayerDetail(playerId,name,phone,sport,area,null,description,pin);
        boolean registered = homeService.register(detail);
        if(registered){
            model.addAttribute("details",detail);
            return "registered";
        }
        return "playerIdTaken";
    }

    @GetMapping("/playerProfile")
    public String playerProfile(Model model){
        String playerId = SecurityContextHolder.getContext().getAuthentication().getName();

        HomeDetailsDto home = homeService.getAllDetails(playerId);
        model.addAttribute("home", home);
        if(home.getGroup() == null) {
            return "playerProfile";
        }

        return "playerProfile2";

    }

    @GetMapping("/searchPlayerFromHome")
    public String searchPlayerFromHome(@RequestParam("playerId") String playerId, Model model){
        PlayerDto player = homeService.searchPlayer(playerId);
        if(player == null){
            return "wrongId";
        }
        model.addAttribute("player", player);
        return "playerPageToHome";
    }

    @GetMapping("/searchPlayer")
    public String searchPlayer(@RequestParam("playerId") String playerId, Model model){
        PlayerDto player = homeService.searchPlayer(playerId);
        if(player == null){
            return "wrongId";
        }
        model.addAttribute("player", player);
        return "playerPageToProfile";
    }

    @GetMapping("/groupRegistration")
    public String groupRegistration(Model model){
        String playerId = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("id",playerId);
        return "groupRegistration";
    }

    @PostMapping("/createGroup")
    public void createGroup(@RequestParam("groupId") String groupId,
                              @RequestParam("adminId") String adminId,
                              @RequestParam("name") String name,
                              @RequestParam("sport") String sport,
                              @RequestParam("moto") String moto,
                              @RequestParam("area") String area,
                            Model model
                              )
    {
        PlayersGroups group = new PlayersGroups(groupId,name,adminId,area,sport,moto,null);
        homeService.createGroup(group);
        playerProfile(model);
    }
}
