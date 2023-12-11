package gettingStarted;
import java.util.Arrays;

public class Block {

    private int prevHash;
    private int ownHash;
    private Transaction[] transactions;

    public Block(int prevHash, Transaction[] transactions) {
        this.prevHash = prevHash;
        this.transactions = transactions;
        Object[] contens = {Arrays.hashCode(transactions),prevHash};
        this.ownHash = Arrays.hashCode(contens);
        
    }
    
    
    public int getPrevHash() {
        return this.prevHash;
    }

    public void setPrevHash(int prevHash) {
        this.prevHash = prevHash;
    }

    public int getOwnHash() {
        return this.ownHash;
    }

    public void setOwnHash(int ownHash) {
        this.ownHash = ownHash;
    }

    public Transaction[] getTransactions() {
        return this.transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }
    
}
