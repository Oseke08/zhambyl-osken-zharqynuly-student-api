package com.zhambyl.studentapi.controller;

import com.zhambyl.studentapi.exception.StudentNotFoundException;
import com.zhambyl.studentapi.model.Student;
import com.zhambyl.studentapi.repository.StudentRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;
    private final String studentName;

    public StudentController(StudentRepository repository,
                             @Value("${app.student.name}") String studentName) {
        this.repository = repository;
        this.studentName = studentName;
    }

    @GetMapping("/owner")
    public java.util.Map<String, String> owner() {
        return java.util.Map.of("studentName", studentName, "group", "IT-2 2307", "id", "37437");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student) {
        student.setId(null);
        return repository.save(student);
    }

    @GetMapping
    public List<Student> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Student replace(@PathVariable Long id, @Valid @RequestBody Student body) {
        Student s = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        s.setFullName(body.getFullName());
        s.setEmail(body.getEmail());
        s.setCourse(body.getCourse());
        return repository.save(s);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) throw new StudentNotFoundException(id);
        repository.deleteById(id);
    }
}
