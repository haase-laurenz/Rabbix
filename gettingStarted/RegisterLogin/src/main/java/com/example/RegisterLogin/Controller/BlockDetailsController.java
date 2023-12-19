package com.example.RegisterLogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.RegisterLogin.Entity.Block;
import com.example.RegisterLogin.Service.BlockchainService;

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
        System.out.println("Block 0 : "+allBlocks.get(0).toString());
        System.out.println("Block 1 : "+allBlocks.get(1).toString());
        model.addAttribute("blocks", allBlocks );
        return "blockdetails";
    }




}
