package com.blockchain.blockchain.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Table(name="STUDENT")
public class Account {
    
    @Id
    @Column(name="ID")
    private int Id;
    @Column(name="MARK")
    private int mark;
    @Column(name="NAME")
    private String name;
    
    public Account(){
    }
    
}
