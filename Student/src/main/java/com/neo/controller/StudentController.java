package com.neo.controller;

import com.neo.dto.StudentDTO;
import com.neo.model.Student;
import com.neo.repository.StudentRepository;
import com.neo.response.ApiResponse;
import com.neo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO addStudentDTO = this.studentService.addStudent(studentDTO);
        return new ResponseEntity<>(addStudentDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("id") int id) {
        this.studentService.deleteStudent(id);
        return new ResponseEntity(new ApiResponse("Student Deleted Successfully..!", true), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable("id") int id) {
        StudentDTO updatedStudent = this.studentService.updateStudent(studentDTO, id);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/get")
    public ResponseEntity<List<StudentDTO>> getAllStudent() {
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.studentService.getStudentById(id));
    }

}
