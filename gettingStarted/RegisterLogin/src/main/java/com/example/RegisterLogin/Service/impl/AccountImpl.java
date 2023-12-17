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


        Account employee = new Account(
            accountDTO.getAccountid(),
            accountDTO.getName(),
            accountDTO.getEMail(),
            passwordEncoder.encode(accountDTO.getPassword())
        );

        
        accountRepo.save(employee);

        return employee.getName();
    }

    @Override
    public LoginResponse loginAccount(LoginDTO loginDTO) {
        
        String msg="";
        Account employee = accountRepo.findByEmail(loginDTO.getEmail());

        if (employee!=null){

            String password = loginDTO.getPassword();
            String encodedPassword =employee.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if(isPwdRight){
                Optional<Account> real_employee = accountRepo.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);

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
    
}
