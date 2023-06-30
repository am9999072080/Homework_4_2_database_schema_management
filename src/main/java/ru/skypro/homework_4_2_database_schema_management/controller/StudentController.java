package ru.skypro.homework_4_2_database_schema_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework_4_2_database_schema_management.model.Faculty;
import ru.skypro.homework_4_2_database_schema_management.model.Student;
import ru.skypro.homework_4_2_database_schema_management.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
@Tag(name = "Api: Для работы со студентами")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Создание студента")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student addedStudent = service.add(student);
        return ResponseEntity.ok(addedStudent);
    }

    @PutMapping
    @Operation(summary = "Обновление студента")
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student updatedStudent = service.update(student);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping({"{id}"})
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    @Operation(summary = "Удаление студента")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        Student deletedStudent = service.remove(id);

        return ResponseEntity.ok(deletedStudent);
    }

    @GetMapping({"{id}"})
    @ApiResponse(responseCode = "404", description = "Запрос некорректный")
    @Operation(summary = "Получение студента по ID")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        Student student = service.get(id);

        return ResponseEntity.ok(student);
    }

    @GetMapping({"all"})
    @Operation(summary = "Получение списка всех студентов")
    public ResponseEntity<Collection<Student>> getAll() {
        Collection<Student> students = service.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("age")
    @Operation(summary = "Получение списка всех студентов по возрасту")
    public ResponseEntity<Collection<Student>> getByAge(@RequestParam Integer startAge,
                                                        @RequestParam Integer endAge) {
        Collection<Student> students = service.getByAge(startAge, endAge);
        return ResponseEntity.ok(students);
    }

    @GetMapping({"faculty/{studentId}"})
    @Operation(summary = "Получение факультет по студенту")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long studentId) {
        Faculty faculty = service.get(studentId).getFaculty();//вызываем service
        return ResponseEntity.ok(faculty);
    }

    @GetMapping({"count"})
    @Operation(summary = "Получение общее количество студентов")
    public ResponseEntity<Integer> getStudentsCount() {
        Integer count = service.getStudentsCount();
        return ResponseEntity.ok(count);
    }
    @GetMapping("age/average")
    @Operation(summary = "Получение среднего возраста студентов")
    public ResponseEntity<Float> getStudentsAverageAge() {
        Float averageAge = service.getStudentsAverageAge();
        return ResponseEntity.ok(averageAge);
    }
    @GetMapping("last")
    @Operation(summary = "Получение 5 последних студентов")
    public ResponseEntity<Collection<Student>> getLastFiveStudents() {
        Collection<Student> students = service.getLastFiveStudents();
        return ResponseEntity.ok(students);
    }
}
