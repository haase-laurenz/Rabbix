package Blockchain.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private double balance;


    public Account() {
    }

    public Account(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public double getBalance() {
        return this.balance;
    }
}
