package com.example.RegisterLogin.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping(path = "/")
    public String showNav(){
        return "redirect:/home";
    }

    @GetMapping(path = "/home")
    public String home(){
        return "home";
    }

}
