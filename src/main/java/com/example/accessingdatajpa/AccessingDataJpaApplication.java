package com.example.accessingdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(BuddyInfoRepository repository) {
//        return (args) -> {
//            // save a few customers
//            repository.save(new BuddyInfo("Bob", "hello drive", "613-234-3333"));
//            repository.save(new BuddyInfo("Bill", "bye drive", "613-987-2222"));
//
//            // fetch all customers
//            System.out.println("BuddyInfos found with findAll():");
//            System.out.println("-------------------------------");
//            for (BuddyInfo bInfo : repository.findAll()) {
//                System.out.println(bInfo.getId());
//                System.out.println(bInfo.toString());
//            }
//
//            // fetch an individual customer by ID
//            BuddyInfo bI = repository.findById(1L);
//            System.out.println("BuddyInfo found with findById(1L):");
//            System.out.println("--------------------------------");
//            System.out.println(bI.toString());
//            System.out.println("");
//
//        };
//    }
}
