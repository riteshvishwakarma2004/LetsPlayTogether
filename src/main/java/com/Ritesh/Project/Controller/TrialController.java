package com.Ritesh.Project.Controller;

import com.Ritesh.Project.Model.PlayerDetail;
import com.Ritesh.Project.Model.PlayerDto;
import com.Ritesh.Project.Services.TrialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialController {

    private TrialService trialService;

    public TrialController(TrialService trial){
        this.trialService = trial;
    }

    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("home", HttpStatus.OK);
    }
    @GetMapping("/secured")
    public String SecuredPage(){
        return "working";
    }

    @PostMapping("/register")
    public ResponseEntity<PlayerDetail> register(@RequestBody PlayerDetail player){
        System.out.println("register");
        PlayerDetail dto = trialService.register(player);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
