package com.generation.desafio_pratico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("olá mundo.");
    }
}
