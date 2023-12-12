package Blockchain.Account;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {
    
    @GetMapping(path = "/account")
    public String overview(Model model){

        return "account";
    }
}
