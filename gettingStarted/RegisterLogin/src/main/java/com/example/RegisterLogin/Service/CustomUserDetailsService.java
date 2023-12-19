package com.example.RegisterLogin.Service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.Config.CustomUserDetails;
import com.example.RegisterLogin.Entity.Account;
import com.example.RegisterLogin.Repo.AccountRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private AccountRepo accountRepo;
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Account account = accountRepo.findByUsername(username);

        if (account == null){
            throw new UsernameNotFoundException("No User found");
        }

        return new CustomUserDetails(account.getUsername(), account.getPassword(), authorities(), account.getEmail());
        
    }

    public Collection<? extends GrantedAuthority> authorities(){
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
    
}
