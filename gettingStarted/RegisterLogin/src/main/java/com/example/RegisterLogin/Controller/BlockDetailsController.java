package com.example.RegisterLogin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.RegisterLogin.Entity.Block;
import com.example.RegisterLogin.Entity.Transaction;
import com.example.RegisterLogin.Service.BlockchainService;

import java.util.Collections;

@Controller
public class BlockDetailsController {
    
    @Autowired
    private BlockchainService blockchainService;


    public BlockDetailsController(BlockchainService blockchainService) {
        this.blockchainService = blockchainService;
    }

    @GetMapping(path = "/blockDetails")
    public String showBlockDetails(Model model){
        List<Block> allBlocks = blockchainService.findAllBlocks();
        Collections.reverse(allBlocks); 
        model.addAttribute("blocks", allBlocks );
        return "blockdetails";
    }

    @GetMapping(path = "/newBlock")
    public String createNewBlock(){

        Block block = new Block(0, blockchainService.getLastHash(), new ArrayList<Transaction>(), blockchainService.getHeight());
        blockchainService.saveBlock(block);
        return "redirect:/blockDetails";
    }
    

    



}
