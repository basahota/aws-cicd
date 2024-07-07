package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseServiceApplication {


    public static void main(String[] args) {
        System.out.println("add startup logs ");
        SpringApplication.run(CourseServiceApplication.class, args);
    }

}
