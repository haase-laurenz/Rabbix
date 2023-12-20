package com.example.RegisterLogin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UpdateController {

    private void addJavaScriptToModel(Model model) {
        String jsCode = "window.location.reload();";
        model.addAttribute("reloadScript", jsCode);
    }
    
    @GetMapping(path = "/mining/update")
    public String updateMining(Model model){
        System.out.println("Update Mining");
        addJavaScriptToModel(model);
        return "redirect:/mining";
    }


}
