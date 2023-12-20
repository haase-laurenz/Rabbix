package com.example.RegisterLogin.Entity;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

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

    @Column(name = "account_public_key", length = 255)
    private String publicKey;

    @Column(name = "account_private_key", length = 255)
    private String privateKey;

    @Column(name = "account_blocksMined", length = 43)
    private int blocksMined;
    
    @Column(name = "account_rabbixCoinsTotal", length = 43)
    private int rabbixCoinsTotal;

    @Column(name = "account_rabbixCoinsMined", length = 43)
    private int rabbixCoinsMined;


    public Account(int accountid, String username, String email, String password) {
        this.accountid = accountid;
        this.username = username;
        this.email = email;
        this.password = password;
        KeyPair keyPair = generateKeyPair();
        this.publicKey = bytesToHex(keyPair.getPublic().getEncoded(),16);
        this.privateKey = bytesToHex(keyPair.getPrivate().getEncoded(),16);
        this.blocksMined = 0;
        this.rabbixCoinsTotal = 0;
        this.rabbixCoinsMined = 0;
    }   


    public Account() {
    }

    private KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle die Ausnahme entsprechend
            return null;
        }
    }

    private String bytesToHex(byte[] bytes, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length && i < bytes.length; i++) {
            result.append(String.format("%02X", bytes[i]));
        }
        return result.toString();
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

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

    public int getBlocksMined() {
        return this.blocksMined;
    }

    public void setBlocksMined(int blocksMined) {
        this.blocksMined = blocksMined;
    }

    public int getRabbixCoinsTotal() {
        return this.rabbixCoinsTotal;
    }

    public void setRabbixCoinsTotal(int rabbixCoinsTotal) {
        this.rabbixCoinsTotal = rabbixCoinsTotal;
    }

    public int getRabbixCoinsMined() {
        return this.rabbixCoinsMined;
    }

    public void setRabbixCoinsMined(int rabbixCoinsMined) {
        this.rabbixCoinsMined = rabbixCoinsMined;
    }


    @Override
    public String toString() {
        return "{" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", publicKey='" + getPublicKey() + "'" +
            ", privateKey='" + getPrivateKey() + "'" +
            ", blocksMined='" + getBlocksMined() + "'" +
            ", rabbixCoinsTotal='" + getRabbixCoinsTotal() + "'" +
            ", rabbixCoinsMined='" + getRabbixCoinsMined() + "'" +
            "}";
    }






}
