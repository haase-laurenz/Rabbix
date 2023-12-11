package startingProject.Blockchain;
import java.util.Arrays;
import java.util.Objects;

public class Block {

    private final int prevHash;
    private final int ownHash;
    private final Transaction[] transactions;

    public Block(int prevHash, Transaction[] transactions) {
        this.prevHash = prevHash;
        this.transactions = transactions;
        Object[] contens = {Arrays.hashCode(transactions),prevHash};
        this.ownHash = Arrays.hashCode(contens);
        
    }
    
    
    public int getPrevHash() {
        return this.prevHash;
    }

    public int getOwnHash() {
        return this.ownHash;
    }

    public Transaction[] getTransactions() {
        return this.transactions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(transactions), prevHash);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Block otherBlock = (Block) obj;
        return Arrays.equals(transactions, otherBlock.transactions) &&
                prevHash == otherBlock.prevHash;
    }


}
