package com.example.coursespringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentID) {
        studentService.deleteStudent(studentID);
    }

    @PutMapping("/{studentID}")
    public void updateStudent(@PathVariable("studentID") Long studentID,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "email", required = false) String email) {
        studentService.updateStudent(studentID, name, email);
    }
}
