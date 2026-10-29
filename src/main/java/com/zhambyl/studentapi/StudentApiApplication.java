package com.zhambyl.studentapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }

    @Bean
    CommandLineRunner printStudentName(@Value("${app.student.name}") String studentName) {
        return args -> System.out.println("Student API started for: " + studentName + " | IT-2 2307 | ID 37437");
    }
}
