package com.example.RegisterLogin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        boolean blockChainStatus = blockchainService.isValid();
        model.addAttribute("blockChainStatus", blockChainStatus);
        return "blockdetails";
    }

    @GetMapping(path = "/newBlock")
    public String createNewBlock(){

        Block block = new Block(0, blockchainService.getLastHash(), new ArrayList<Transaction>(), blockchainService.getHeight());
        block.mine();
        blockchainService.saveBlock(block);
        return "redirect:/blockDetails";
    }

    @GetMapping("/block/{block}")
    String detail(@PathVariable Block block, Model model) {

        model.addAttribute("block", block);

		return "block";
	}
    

    



}
