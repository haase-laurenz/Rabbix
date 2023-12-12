package Blockchain.Home;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    
    @GetMapping(path = "/home")
    public String overview(Model model){

        return "home";
    }
}

