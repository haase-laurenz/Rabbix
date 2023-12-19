package com.example.RegisterLogin.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.Dto.AccountDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Entity.Account;
import com.example.RegisterLogin.Repo.AccountRepo;
import com.example.RegisterLogin.Service.AccountService;
import com.example.RegisterLogin.response.LoginResponse;

@Service
public class AccountImpl implements AccountService{

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String addAccount(AccountDTO accountDTO) {


        Account account = new Account(
            accountDTO.getAccountid(),
            accountDTO.getName(),
            accountDTO.getEMail(),
            passwordEncoder.encode(accountDTO.getPassword())
        );

        
        accountRepo.save(account);

        return account.getUsername();
    }

    @Override
    public LoginResponse loginAccount(LoginDTO loginDTO) {
        
        String msg="";
        Account account = accountRepo.findByUsername(loginDTO.getUsername());

        if (account!=null){

            String password = loginDTO.getPassword();
            String encodedPassword =account.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if(isPwdRight){
                Optional<Account> real_employee = accountRepo.findOneByUsernameAndPassword(loginDTO.getUsername(),encodedPassword);

                if (real_employee.isPresent()){
                    return new LoginResponse("Login Success", true);
                }else{
                    return new LoginResponse("Login Failed", false);
                }

            }else{
                return new LoginResponse("Password didnt match", false);
            }

        }else{
            return new LoginResponse("Email not exists", false);
        }
    }

    @Override
    public Account findByName(String username) {
        return accountRepo.findByUsername(username);
    }
    
}
