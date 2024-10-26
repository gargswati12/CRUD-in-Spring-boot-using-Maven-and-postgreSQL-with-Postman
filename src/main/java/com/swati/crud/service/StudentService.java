package com.swati.crud.service;


import com.swati.crud.repository.StudentRepository;
import com.swati.crud.students.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

   private final StudentRepository studentrepo;

    @Autowired
    public StudentService(StudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }
    public List<Student> getAllStudents(){
        return studentrepo.findAll();
    }
    public Optional<Student> getStudentById(Long id){
        return studentrepo.findById(id);
    }
    public Student createStudent(Student student){
       return  studentrepo.save(student);
    }
    public void deleteStudent(Long id){
        if(studentrepo.existsById(id))
        {
            studentrepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Student not found with id"+ id);
        }
    }

}
