package com.example.school.Controller;

import com.example.school.Model.Teacher;
import com.example.school.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping("/search/{keyword}")
    public List<Teacher> getTeacherByName(@PathVariable String keyword) {
        return teacherService.getTeacherByName(keyword);
    }

    @PostMapping
    Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }
}