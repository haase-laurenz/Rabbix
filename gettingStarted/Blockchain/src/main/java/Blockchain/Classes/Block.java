package Blockchain.Classes;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Block {

    private final String prevHash;
    private final String ownHash;
    private final List<Transaction> transactions;

    public Block(String prevHash, List<Transaction> transactions) {
        this.prevHash = prevHash;
        this.transactions = transactions;
        this.ownHash = calculateHash();
        
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




}
