package com.example.RegisterLogin.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.RegisterLogin.Entity.Account;
import com.example.RegisterLogin.Service.AccountService;
import com.example.RegisterLogin.Service.BlockchainService;

@Controller
public class MiningController {
    
    @Autowired
    private AccountService accountService;

    @Autowired
    private BlockchainService blockchainService;

    public MiningController(BlockchainService blockchainService, AccountService accountService) {
        this.blockchainService = blockchainService;
        this.accountService = accountService;
    }

    @GetMapping(path = "/mining")
    public String showMining(Model model,Principal principal){

        Account account = accountService.findByName(principal.getName());

        model.addAttribute("account", account);

        boolean miningStatus = blockchainService.getMiningStatus();
        model.addAttribute("miningStatus", miningStatus);

        return "mining";
    }

    @GetMapping(path = "/mining/doMining")
    public String doMining(Model model,Principal principal){

        
        if (blockchainService.getMiningStatus()==false){
            Account account = accountService.findByName(principal.getName());
            blockchainService.setActiveAccount(account);
            System.out.println("Mining started"); 
            blockchainService.mine();
        }else{
             System.out.println("Mining interrupted"); 
            blockchainService.interruptMining();
        }
        
        return "redirect:/mining";
    }

}
