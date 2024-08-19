package com.example.school.Controller;

import com.example.school.Model.Student;
import com.example.school.Model.Subject;
import com.example.school.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

}
