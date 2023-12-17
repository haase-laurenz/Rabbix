package com.example.RegisterLogin.Dto;


public class AccountDTO {
    

    private int Accountid;
    private String name;
    private String email;    
    private String password;


    public AccountDTO(int Accountid, String name, String email, String password) {
        this.Accountid = Accountid;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public AccountDTO() {
    }


    public int getAccountid() {
        return this.Accountid;
    }

    public void setAccountid(int Accountid) {
        this.Accountid = Accountid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEMail() {
        return this.email;
    }

    public void setEMail(String email) {
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
            " Accountid='" + getAccountid() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEMail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }



}
