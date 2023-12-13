package Blockchain.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

@Service
public class AccountManagement {
    
    
    private final AccountRepository accounts;
    @Autowired
    public AccountManagement(AccountRepository accounts){
        this.accounts=accounts;
    }   

    public Account createAccount(RegistrationForm form){
        
        Errors errors = new BeanPropertyBindingResult(form, "form");

        Assert.notNull(form, "Registration form must not be null!");

        try {

			return accounts.save(new Account(form.getName(), form.getEmail(), form.getPassword(), 1000));

		} catch (Exception ex) {

			return null;
		}

    }

    public Streamable<Account> findAll() {
		return accounts.findAll();
	}

    public Account findByName(String name) {
        return accounts.findByName(name);
    }
    
}
