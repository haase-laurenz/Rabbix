package startingProject.Blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    
    private List<Block> allBlocks = new ArrayList<>();


    public Blockchain() {
        Transaction[] transactions = new Transaction[0];
        this.allBlocks.add(new Block(0,transactions));
    }


    public List<Block> getAllBlocks() {
        return this.allBlocks;
    }

    public void generateNewBlock(){
        int prevHash=allBlocks.getLast().getOwnHash();
        allBlocks.add(new Block(prevHash, new Transaction[0]));
    }

}