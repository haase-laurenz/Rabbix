package com.example.RegisterLogin.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.RegisterLogin.Entity.Account;
import com.example.RegisterLogin.Entity.Block;
import com.example.RegisterLogin.Repo.BlockRepo;
import com.example.RegisterLogin.Service.AccountService;
import com.example.RegisterLogin.Service.BlockchainService;

@Controller
public class MiningController {
    
    @Autowired
    private AccountService accountService;

    @Autowired
    private BlockchainService blockchainService;

    public MiningController(AccountService accountService, BlockchainService blockchainService) {
        this.accountService = accountService;
        this.blockchainService = blockchainService;
    }

    @GetMapping(path = "/mining")
    public String showMining(Model model,Principal principal){

        Account account = accountService.findByName(principal.getName());

        model.addAttribute("account", account);

        return "mining";
    }

    @GetMapping(path = "/mining/doMining")
    public String doMining(Model model,Principal principal){

        System.out.println("Mining started");  
        blockchainService.mine();
        System.out.println("redirect");
        return "redirect:/mining";
    }

}
