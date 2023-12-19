package com.example.RegisterLogin.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.RegisterLogin.Entity.Account;
import com.example.RegisterLogin.Service.AccountService;

@Controller
public class MiningController {
    
    @Autowired
    private AccountService accountService;

    public MiningController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/mining")
    public String showMining(Model model,Principal principal){

        Account account = accountService.findByName(principal.getName());

        model.addAttribute("account", account);

        return "mining";
    }
}
