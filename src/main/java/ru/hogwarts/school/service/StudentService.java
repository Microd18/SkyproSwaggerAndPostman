package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private Long lastId = 0L;

    Map<Long, Student> studentMap = new HashMap<>();

    public Student addStudent(Student student) {
        student.setId(++lastId);
        studentMap.put(lastId, student);
        return student;
    }

    public Student addStudent(Long id, String name, int age) {
        Student student = new Student(id, name, age);
        return addStudent(student);
    }

    public Student findStudent(Long lastId) {
        return studentMap.get(lastId);
    }

    public Student editStudent(Student student) {
        if (!studentMap.containsKey(student.getId())) {
            return null;
        }
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(Long lastId) {
        return studentMap.remove(lastId);
    }

    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
