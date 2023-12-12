package Blockchain.Mining;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MiningController {
    
    @GetMapping(path = "/mining")
    public String overview(Model model){

        return "mining";
    }
}
