package com.example.RegisterLogin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transaction {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "transaction_id",length = 43)
        private int id;
        @Column(name = "transaction_sender",length = 255)
        private String sender;
        @Column(name = "transaction_receiver",length = 255)
        private String receiver;
        @Column(name = "transaction_amount",length = 255)
        private double amount;

        public Transaction(int id,String sender, String receiver, double amount) {
            this.id = id;
            this.sender = sender;
            this.receiver = receiver;
            this.amount = amount;
        }


        public Transaction() {
        }


        public String getSender() {
            return sender;
        }

        public String getReceiver() {
            return receiver;
        }

        public double getAmount() {
            return amount;
        }

        private int getId() {
            return id;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", sender='" + getSender() + "'" +
            ", receiver='" + getReceiver() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }


    
    }
