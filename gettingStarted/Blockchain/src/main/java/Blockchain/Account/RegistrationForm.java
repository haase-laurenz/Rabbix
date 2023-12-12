package Blockchain.Account;

import org.springframework.validation.Errors;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.Valid;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;

public class RegistrationForm {
    
    private final @NotEmpty String name;

	@NotEmpty
	@Size(min = 8, message = "Password must be at least 8 characters")
	@Pattern(regexp = "^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d).*$", message = "Password must contain at least one letter, one number and be minimum 8 characters")
	private final String password;


	private final @NotEmpty String email;

	public RegistrationForm(String name, String password, String email) {

		this.name = name;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	

	public String getEmail() {
		return email;
	}

	public class PasswordMismatchException extends RuntimeException {
		public PasswordMismatchException(String message) {
			super(message);
		}
	}



}
