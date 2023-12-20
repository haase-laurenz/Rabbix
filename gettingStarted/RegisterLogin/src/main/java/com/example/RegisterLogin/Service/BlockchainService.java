package com.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.Entity.Block;
import com.example.RegisterLogin.Entity.Transaction;
import com.example.RegisterLogin.Repo.BlockRepo;

@Service
public class BlockchainService {
    
    @Autowired
    private BlockRepo blockRepo;

    public BlockchainService(BlockRepo blockRepo) {
        this.blockRepo = blockRepo;
    }

    private volatile boolean miningInterrupted = false;

    public List<Block> findAllBlocks(){
        return blockRepo.findAll();
    }

    @Async
    public void mine(){
        miningInterrupted = false;

    }

    public void interruptMining(){
        miningInterrupted = true;
    }

    public void mineBlock(){
        Block block = new Block(0, getLastHash(), new ArrayList<Transaction>(), getHeight());
        while (miningInterrupted == false) {
            block.mine();
            saveBlock(block);
        }
    }
    
    
    public void saveBlock(Block block){
        if (block.getOwnHash()!=null){
            blockRepo.save(block);
        }else{
            System.out.println("No hash generated");
        }
        
    }

    public void generateGenesisBlock(){
        Block block = new Block(0, "0000000000000000000000000000000000000000000000000000000000000000", new ArrayList<Transaction>(),0);
        block.mine();
        if (block.getOwnHash()!=null){
            blockRepo.save(block);
        }
        
    }

    public int getHeight(){
        return blockRepo.findAll().size();
    }

    public String getLastHash() {
        List<Block> blocks = blockRepo.findAllByOrderByIdDesc();

        if (!blocks.isEmpty()) {
            Block lastBlock = blocks.get(0);
            return lastBlock.getOwnHash();
        } else {
            // Handle the case when there are no blocks in the database
            return null; // or throw an exception or return a default value
        }
    }

}
