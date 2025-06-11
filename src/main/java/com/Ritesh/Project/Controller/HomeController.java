package com.Ritesh.Project.Controller;

import com.Ritesh.Project.Model.PlayerDetail;
import com.Ritesh.Project.Services.HomeService;
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
        PlayerDetail detail = new PlayerDetail(playerId,name,phone,sport,area,"NA",description,pin);
        boolean registered = homeService.register(detail);
        if(registered){
            model.addAttribute("details",detail);
            return "registered";
        }
        return "playerIdTaken";
    }
}
