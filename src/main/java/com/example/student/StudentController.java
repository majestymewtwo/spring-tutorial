package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
/*
    @RestController is used to indicate that this is a REST
    (Representational State Transfer) API.

    @RequestMapping is used to map the path of requests that must be handled

    @RequiredArgsConstructor is used to inject objects with using the new() keyword
*/
public class StudentController {
    // This is our repository object that we created to do CRUD operations
    private final StudentRepository studentRepository;
    // We are handling a GET request
    @GetMapping("/students")
    // We are returning a list of students using the built-in findAll() method of the repository
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    // We are handling a POST request
    @PostMapping("/newStudent")
    // @RequestBody is used to obtain the data passed in the request, then we use the save() method
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    // We are handling a PUT request
    @PutMapping("/updateStudent")
    // @RequestBody is again used to obtain data passed in the request, then we use the save() method again
    public Student updateStudent(@RequestBody Student updated) {
        // We check is entity exists in the database, or else we throw an exception
        Student student = studentRepository.findById(updated.getId()).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        BeanUtils.copyProperties(updated, student);
        return studentRepository.save(student);
    }
    // We are handling a DELETE request
    // {id} is a dynamic data that is passed along the URI
    @DeleteMapping("/deleteStudent/{id}")
    // We used @PathVariable to obtain the {id} attribute passed to the URI
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        // We delete using the deleteById() method
        studentRepository.deleteById(id);
        // We then return a String along with 200 Status Code (OK) after successfully deleting the entity
        return ResponseEntity.ok("Deleted Student Successfully");
    }
}
