package com.neo.service;

import com.neo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(StudentDTO studentDTO, int id);

    StudentDTO getStudentById(int id);

    List<StudentDTO> getAllStudents();

    void deleteStudent(int id);

}
