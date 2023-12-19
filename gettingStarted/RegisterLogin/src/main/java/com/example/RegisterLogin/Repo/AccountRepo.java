package com.example.RegisterLogin.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.RegisterLogin.Entity.Account;

@Repository
@EnableJpaRepositories
public interface AccountRepo extends JpaRepository<Account,Integer>{

    Optional<Account> findOneByUsernameAndPassword(String username,String password);

    Account findByUsername(String username);
    
}
