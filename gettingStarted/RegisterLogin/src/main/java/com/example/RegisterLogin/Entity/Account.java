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

    @Column(name = "account_name",length = 255)
    private String name;

    @Column(name = "account_email",length = 255)
    private String email;    

    @Column(name = "account_password",length = 255)
    private String password;


    public Account(int accountid, String name, String email, String password) {
        this.accountid = accountid;
        this.name = name;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }





}
