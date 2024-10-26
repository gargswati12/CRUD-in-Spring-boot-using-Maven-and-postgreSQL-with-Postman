package com.swati.crud.students;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="student")
public class Student {
    @Id
   //@GeneratedValue(strategy = GenerationType.SEQUENCE)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generator")
@SequenceGenerator(name = "student_id_generator", sequenceName = "student_id_seq", allocationSize = 1)
    private int id;
    private String name;
    private int age;
    private String courses;

    public Student(){}

    public Student( String name, int age, String courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }


}
