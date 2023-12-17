package com.example.RegisterLogin.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.RegisterLogin.Dto.AccountDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Service.AccountService;
import com.example.RegisterLogin.response.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;
    
    @PostMapping(path="/save")
    public String saveAccount(@RequestBody AccountDTO accountDTO){

        for (int i=0;i<3;i++){
            System.out.println("");
        }
        System.out.println(accountDTO.toString());
        for (int i=0;i<3;i++){
            System.out.println("");
        }
        String name = accountService.addAccount(accountDTO);
        return name;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginAccount(@RequestBody LoginDTO loginDTO){

        for (int i=0;i<3;i++){
            System.out.println("");
        }
        System.out.println(loginDTO.toString());
        for (int i=0;i<3;i++){
            System.out.println("");
        }
        LoginResponse loginMesage = accountService.loginAccount(loginDTO);
        return ResponseEntity.ok(loginMesage);
    }

}
