package com.example.RegisterLogin.Entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Blocks")
public class Block {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "block_id",length = 43)
    private int id;

    @Column(name = "block_prevHash",length = 255)
    private String prevHash;

    @Column(name = "block_ownHash",length = 255)
    private String ownHash;

    @Column(name = "block_height",length = 255)
    private int height;

    @Column(name = "block_transactions",length = 255)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "block_id")
    private List<Transaction> transactions;

    @Column(name = "block_timestamp",length = 255)
    private LocalDateTime timestamp;

    private int nonce;

    private final String difficulty = "00000";

    public Block(int id,String prevHash, List<Transaction> transactions, int height) {
        this.id=id;
        this.prevHash = prevHash;
        this.transactions = transactions;
        this.nonce=0;
        this.ownHash = null;
        this.height = height;
        this.timestamp = LocalDateTime.now();
        
    }


    public Block() {
    }

    public void mine(){
        this.ownHash = calculateHash();
        while(!this.ownHash.substring(0, difficulty.length()).equals(difficulty)){
           
            nonce++;
            this.ownHash = calculateHash();
        }
        nonce++;
        this.ownHash = calculateHash();
        System.out.println("nonce: "+nonce);
        System.out.println("SOLVED THE PUZZLE!");
    }

    
    private String calculateHash() {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Konkateniere den vorherigen Hash mit den gehashten Transaktionen
        StringBuilder blockData = new StringBuilder();
        for (Transaction transaction : transactions) {
            blockData.append(transaction.getSender())
                     .append(transaction.getReceiver())
                     .append(transaction.getAmount());
        }
        blockData.append(prevHash);
        blockData.append(nonce);

        byte[] hashBytes = digest.digest(blockData.toString().getBytes());

        // Konvertiere die Byte-Array-Darstellung des Hashes in einen Hex-String
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            hexString.append(String.format("%02x", hashByte));
        }

        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}

    
    public String getPrevHash() {
        return this.prevHash;
    }

    public String getOwnHash() {
        return this.ownHash;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public int getTransactionSize(){
        return this.transactions.size();
    }
    
    public String getTimestamp() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.timestamp.format(formatter);
    }

    public int getId() {
        return id;
    }

    public String getHeight() {
        return Integer.toString(height);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", prevHash='" + getPrevHash() + "'" +
            ", ownHash='" + getOwnHash() + "'" +
            ", height='" + getHeight() + "'" +
            ", transactions='" + getTransactions() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }


    


   


   


    
    
}
