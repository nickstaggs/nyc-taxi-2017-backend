package com.nickstaggs.nycyellowtaxi2017;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.nickstaggs.nycyellowtaxi2017.repository")
public class NycYellowTaxi2017App {

    public static void main(String[] args) {
        SpringApplication.run(NycYellowTaxi2017App.class, args);
    }
}
