package com.example.RegisterLogin;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.RegisterLogin.Entity.Block;
import com.example.RegisterLogin.Entity.Transaction;
import com.example.RegisterLogin.Service.BlockchainService;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAsync
@ComponentScan(basePackages = "com.example")
public class RegisterLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterLoginApplication.class, args);
	}

	@Bean
    public CommandLineRunner init(BlockchainService blockchainService) {
        return args -> {

			if (blockchainService.getHeight()==0){

				 // generate First Block
				blockchainService.generateGenesisBlock();

				Block block = new Block(0,blockchainService.getLastHash(), List.of(
						new Transaction(0,"sender1", "receiver1", 100.00),
						new Transaction(0,"sender2", "receiver2", 50.00)
				),blockchainService.getHeight());
				block.mine();
				blockchainService.saveBlock(block);
			}
			
        };
    }

}
