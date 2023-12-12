package Blockchain.Classes;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    
    private List<Block> allBlocks = new ArrayList<>();


    public Blockchain() {
    }


    public List<Block> getAllBlocks() {
        return this.allBlocks;
    }

    public void generateNewBlock(){
        String prevHash=allBlocks.getLast().getOwnHash();
        List<Transaction> transactions=new ArrayList<>();
        transactions.add(new Transaction("Laurenz", "Alex", 0.01));
        transactions.add(new Transaction("Laurenz", "Alex", 0.01));
        allBlocks.add(new Block(prevHash, transactions));
    }

    public void generateGenesisBlock(){
        allBlocks.add(new Block("0000000000000000000000000000000000000000000000000000000000000000",new ArrayList<Transaction>()));
    }


}
