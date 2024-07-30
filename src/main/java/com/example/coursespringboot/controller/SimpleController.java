package com.example.coursespringboot.controller;

import com.example.coursespringboot.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/students")
    public List<Student> hellos() {
        return List.of(
                new Student(
                        1L, "Mariam", "mariam@gmail.com", LocalDate.of(2000, Month.JANUARY, 5), 21
                ),
                new Student (
                        2L, "Alex", "alex@gmail.com", LocalDate.of(2004, Month.JANUARY, 5), 21
                )
        );
    }
}
