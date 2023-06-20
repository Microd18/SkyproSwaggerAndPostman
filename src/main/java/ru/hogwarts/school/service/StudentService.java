package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private  long number = 0;

    Map<Long, Student> studentMap = new HashMap<>();

    public void createStudent(Student student) {
        studentMap.put(++number, student);
    }

    public void createStudent(long id, String name, int age) {
        Student student = new Student(id, name, age);
        createStudent(student);
    }

    public Student returnStudent(long number) {
        return studentMap.get(number);
    }

    public void updateStudent(long number, long id, String name, int age) {
        Student newStudent = new Student(id, name, age);
        updateStudent(number, newStudent);
    }

    public void updateStudent(long number, Student newStudent) {
        studentMap.put(number, newStudent);
    }

    public void deleteStudent(long number) {
        studentMap.remove(number);
    }
}
