package com.example.RegisterLogin.response;

public class LoginResponse {
    
    String mesage;
    Boolean status;


    public LoginResponse(String mesage, Boolean status) {
        this.mesage = mesage;
        this.status = status;
    }


    public LoginResponse() {
    }


    public String getMesage() {
        return this.mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "{" +
            " mesage='" + getMesage() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }


}
