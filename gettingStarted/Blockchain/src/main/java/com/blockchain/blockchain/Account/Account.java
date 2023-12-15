package com.blockchain.blockchain.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@Table(name="ACCOUNT")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="BALANCE")
    private double balance;

    public Account(){
    }

    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 10000;
    }


    
}
