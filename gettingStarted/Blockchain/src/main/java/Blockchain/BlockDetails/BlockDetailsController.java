package Blockchain.BlockDetails;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BlockDetailsController {
    
    @GetMapping(path = "/details")
    public String overview(Model model){

        return "blockdetails";
    }
}
