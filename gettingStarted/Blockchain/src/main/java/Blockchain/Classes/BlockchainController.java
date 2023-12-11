package Blockchain.Classes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller 
public class BlockchainController {
    
    @GetMapping(path = "/")
    public String index(Model model){

        model.addAttribute("message", "Hello from Thymeleaf!");
        return "index";
    }

    @GetMapping(path = "/overview")
    public String overview(Model model){

        model.addAttribute("message", "Hello from Thymeleaf!");
        return "overview";
    }

    

}
