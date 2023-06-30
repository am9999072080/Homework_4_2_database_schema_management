package ru.skypro.homework_4_2_database_schema_management.services;

import ru.skypro.homework_4_2_database_schema_management.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student add(Student student);

    Student remove(Long id);

    Student update(Student student);

    Student get(Long id);

    Collection<Student> getByAge(Integer startAge, Integer endAge);

    Collection<Student> getAll();

    Integer getStudentsCount();

    Float getStudentsAverageAge();

    List<Student> getLastFiveStudents();
}
