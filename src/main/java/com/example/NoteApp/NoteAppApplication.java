package com.example.NoteApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.note")
@EntityScan(basePackages = "com.example.note")
@ComponentScan(basePackages = "com.example.note")
public class NoteAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteAppApplication.class, args);
    }
}
