package com.example.coursespringboot.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());

        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        // validate email
        if(!student.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalStateException("email not valid");
        }

        studentRepository.save(student);

    }

    public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);

        if(!exists) {
            throw new IllegalStateException("student with id " + studentID + " does not exist");
        };

        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentID + " does not exist"
                ));

        // check name valid
        if(name != null && !name.isEmpty() && !student.getName().equals(name)) {
            student.setName(name);
        }

        // check email valid
        if(email != null && !email.isEmpty() && !student.getEmail().equals(email)) {
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);

            if(studentByEmail.isPresent()) {
                throw new IllegalStateException("email taken");
            }

            // validate email
            if(!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                throw new IllegalStateException("email not valid");
            }

            student.setEmail(email);
        }

        studentRepository.save(student);
    }
}
