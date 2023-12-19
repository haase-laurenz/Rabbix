package com.example.RegisterLogin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiningController {
    
    @GetMapping(path = "/mining")
    public String showMining(){
        return "mining";
    }
}
