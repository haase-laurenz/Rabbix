package com.example.RegisterLogin.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.Entity.Block;
import com.example.RegisterLogin.Entity.Transaction;
import com.example.RegisterLogin.Repo.BlockRepo;

@Service
public class BlockchainService {
    
    @Autowired
    private BlockRepo blockRepo;

    public List<Block> findAllBlocks(){
        return blockRepo.findAll();
    }

    public void saveBlock(Block block){
        blockRepo.save(block);
    }

    public void generateGenesisBlock(){
        Block block = new Block(0, "0000000000000000000000000000000000000000000000000000000000000000", new ArrayList<Transaction>(),1);
        blockRepo.save(block);
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
