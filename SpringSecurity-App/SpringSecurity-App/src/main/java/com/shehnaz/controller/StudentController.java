package com.shehnaz.controller;

import com.shehnaz.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(List.of
            (new Student(1,"Shehnaz","Java"),
                    new Student(2,"Abdul","Python"),
                    new Student(3,"Raheem","SpringBoot")));


    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return students;
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }
}
