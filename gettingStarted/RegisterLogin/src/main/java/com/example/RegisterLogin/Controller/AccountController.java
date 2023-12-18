package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Dto.AccountDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Entity.AccountForm;
import com.example.RegisterLogin.Service.AccountService;
import com.example.RegisterLogin.response.LoginResponse;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;

import java.io.Console;
import java.security.Principal;

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
    
    @GetMapping(path = "/myAccount")
    public String showAccount(Model model, Principal principal){

        System.out.println("TRYED TO LOG IN");
        if (principal==null){
            System.out.println("NO RIGHTS FOR myAccount");
            return "redirect:/newAccount";
        }

         for (int i=0;i<3;i++){
            System.out.println("");
        }
        System.out.println(principal.toString());
        for (int i=0;i<3;i++){
            System.out.println("");
        }

        System.out.println(principal.toString());
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userDetals", userDetails);
        return "myAccount";

        
    }

    @GetMapping(path = "/newAccount")
    public String showLogin(Model model,AccountForm accountForm){
        model.addAttribute("accountForm", accountForm);
        return "newAccount";
    }


    @PostMapping(path="/account/save")
    public String saveAccount(@Valid AccountForm accountForm, Errors result, Model model){

        if (result.hasErrors()) {
			return "newAccount";
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

        return "redirect:/newAccount";
    }
    
    

    @PostMapping(path="/account/login")
    public String loginAccount(@RequestParam String email,@RequestParam String password){

        LoginDTO loginDTO = new LoginDTO(email,password);

        for (int i=0;i<3;i++){
            System.out.println("");
        }
        System.out.println(loginDTO.toString());
        for (int i=0;i<3;i++){
            System.out.println("");
        }
        LoginResponse loginMesage = accountService.loginAccount(loginDTO);

        if (loginMesage.getStatus()==true){
            return "redirect:/myAccount";
        }else{
             return "redirect:/newAccount";
        }
       
    }

}
