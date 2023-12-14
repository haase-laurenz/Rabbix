package Blockchain.Account;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.security.core.Authentication;

import jakarta.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {
    
    private final AccountManagement accountManagement;

    public AccountController(AccountManagement accountManagement){
        this.accountManagement=accountManagement;
    }


    @GetMapping(path = "/account")
    public String overview(Model model, RegistrationForm form){
        
    /*
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal(); // Get the principal (currently authenticated user)

        if (principal instanceof UserDetails) { // Check if the principal is an instance of UserDetails (assuming you
												// use UserDetails)
			UserDetails userDetails = (UserDetails) principal;

			String username = userDetails.getUsername(); // Now you can access userDetails.getUsername() to get the
															// username

			Account myaccount = accountManagement.findByName(username);

            model.addAttribute("account", myaccount);
		}
        */
        model.addAttribute("accountForm",form );

        return "account";
    }

    @PostMapping("/account/register")
	String registerNew(@Valid RegistrationForm form, Errors result) {

		if (result.hasErrors()) {
			return "register";
		}


		accountManagement.createAccount(form);

		return "redirect:/account";
	}

}
