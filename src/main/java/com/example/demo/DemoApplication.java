package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new User("Alice"));
                repo.save(new User("Bob"));
                repo.save(new User("Charlie"));
                repo.save(new User("Diana"));
                repo.save(new User("Ethan"));
                repo.save(new User("Fiona"));
            }
        };
    }
}
