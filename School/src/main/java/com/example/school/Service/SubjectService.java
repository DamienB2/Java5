package com.example.school.Service;

import com.example.school.Model.Subject;
import com.example.school.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

}
