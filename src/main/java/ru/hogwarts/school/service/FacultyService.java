package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;


public class FacultyService {
    //исправить
    private long number = 0;

    Map<Long, Faculty> facultyMap = new HashMap<>();

    public void createFaculty(Faculty faculty) {
        facultyMap.put(++number, faculty);
    }

    public void createFaculty(long id, String name, String colour) {
        Faculty faculty = new Faculty(id, name, colour);
        createFaculty(faculty);
    }

    public Faculty returnFaculty(long number) {
        return facultyMap.get(number);
    }

    public void updateFaculty(long number, long id, String name, String colour) {
        Faculty newFaculty = new Faculty(id, name, colour);
        updateFaculty(number, newFaculty);
    }

    public void updateFaculty(long number, Faculty newFaculty) {
        facultyMap.put(number, newFaculty);
    }

    public void deleteFaculty(long number) {
        facultyMap.remove(number);
    }


}
