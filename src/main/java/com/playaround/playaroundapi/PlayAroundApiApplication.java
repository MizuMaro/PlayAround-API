package com.playaround.playaroundapi;

import com.playaround.playaroundapi.bo.User;
import com.playaround.playaroundapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PlayAroundApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayAroundApiApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner demo(UserRepository repository) {

		return (args) -> {

		};
	}
}
