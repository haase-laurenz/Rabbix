package com.example.RegisterLogin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {

    @Id
    @Column(name = "account_id",length = 43)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountid;

    @Column(name = "account_username",length = 255)
    private String username;

    @Column(name = "account_email",length = 255)
    private String email;    

    @Column(name = "account_password",length = 255)
    private String password;


    public Account(int accountid, String username, String email, String password) {
        this.accountid = accountid;
        this.username = username;
        this.email = email;
        this.password = password;
    }   


    public Account() {
    }


    public int getaccountid() {
        return this.accountid;
    }

    public void setaccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "{" +
            " accountid='" + getaccountid() + "'" +
            ", name='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }





}
