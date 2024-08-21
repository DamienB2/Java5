package com.example.school.Controller;

import com.example.school.Model.Student;
import com.example.school.Model.Subject;
import com.example.school.Model.Teacher;

import com.example.school.Service.StudentService;
import com.example.school.Service.SubjectService;
import com.example.school.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;


    @GetMapping
    List<Subject> getSubject(){
        return subjectService.getSubjects();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrolleStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);
        subject.enrollStudent(student);
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId){
        Subject subject = subjectService.getSubjectById(subjectId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        subject.assignTeacher(teacher);
        return subjectService.createSubject(subject);
    }
}
