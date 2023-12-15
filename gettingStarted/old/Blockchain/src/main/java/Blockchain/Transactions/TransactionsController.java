package Blockchain.Transactions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionsController {
    
    @GetMapping(path = "/transactions")
    public String overview(Model model){

        return "transactions";
    }
}
