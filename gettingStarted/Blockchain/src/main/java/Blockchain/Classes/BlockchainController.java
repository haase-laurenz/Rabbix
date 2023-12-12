package Blockchain.Classes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller 
class BlockchainController {

    private final Blockchain blockchain;

    public BlockchainController() {
        this.blockchain = new Blockchain(); 
        this.blockchain.generateGenesisBlock();
    }

    @GetMapping(path = "/")
    public String index(Model model){

        return "index";
    }

    @GetMapping(path = "/home")
    public String overview(Model model){

        model.addAttribute("blocks", blockchain.getAllBlocks());
        return "home";
    }

    @GetMapping(path = "/home/newBlock")
    public String newBlock(Model model){

        blockchain.generateNewBlock();
        return "redirect:/home";
    }

    

}
