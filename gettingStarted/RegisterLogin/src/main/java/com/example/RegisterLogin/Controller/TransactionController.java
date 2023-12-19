package com.example.RegisterLogin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {
    
    @GetMapping(path = "/transaction")
    public String showTransaction(){
        return "transaction";
    }

}
