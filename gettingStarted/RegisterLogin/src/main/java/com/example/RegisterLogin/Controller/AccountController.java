package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Dto.AccountDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Entity.Account;
import com.example.RegisterLogin.Entity.AccountForm;
import com.example.RegisterLogin.Service.AccountService;
import com.example.RegisterLogin.response.LoginResponse;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;

import java.io.Console;
import java.security.Principal;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
public class AccountController {

    @Autowired 
    private UserDetailsService userDetailsService;

    @Autowired
    private AccountService accountService;


    public AccountController(UserDetailsService userDetailsService, AccountService accountService) {
        this.userDetailsService = userDetailsService;
        this.accountService=accountService;
    }

    
    @GetMapping(path = "/myAccount")
    public String showAccount(Model model,Principal principal){

       
        
        Account account = accountService.findByName(principal.getName());

        System.out.println("Account: "+account.toString());

        model.addAttribute("account", account);
        
        return "myAccount";

        
    }

    @GetMapping(path = "/login")
    public String showLogin(Model model,AccountForm accountForm){
        model.addAttribute("accountForm", accountForm);
        return "login";
    }


    @PostMapping(path="/account/save")
    public String saveAccount(@Valid AccountForm accountForm, Errors result, Model model){

        if (result.hasErrors()) {
			return "login";
		}

        AccountDTO accountDTO = new AccountDTO(0, accountForm.getName(), accountForm.getEmail(), accountForm.getPassword());

        for (int i=0;i<3;i++){
            System.out.println("");
        }
        System.out.println(accountDTO.toString());
        for (int i=0;i<3;i++){
            System.out.println("");
        }
        String name = accountService.addAccount(accountDTO);

        return "redirect:/login";
    }
    
    

    @PostMapping(path="/account/login")
    public String loginAccount(@RequestParam String username,@RequestParam String password){

        LoginDTO loginDTO = new LoginDTO(username,password);

        for (int i=0;i<3;i++){
            System.out.println("");
        }
        System.out.println("loginDTO "+loginDTO.toString());
        for (int i=0;i<3;i++){
            System.out.println("");
        }
        LoginResponse loginMesage = accountService.loginAccount(loginDTO);

        if (loginMesage.getStatus()==true){
            return "redirect:/myAccount";
        }else{
             return "redirect:/login";
        }
       
    }

}
