package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Dto.AccountDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Entity.Account;
import com.example.RegisterLogin.response.LoginResponse;

public interface AccountService {

    String addAccount(AccountDTO accountDTO);

    LoginResponse loginAccount(LoginDTO loginDTO);

    Account findByName(String name);

}
