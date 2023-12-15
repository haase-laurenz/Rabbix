package Blockchain.Settings;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SettingsController {
    
    @GetMapping(path = "/settings")
    public String overview(Model model){

        return "settings";
    }
}
