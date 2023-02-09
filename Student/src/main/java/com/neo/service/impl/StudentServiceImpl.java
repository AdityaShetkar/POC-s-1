package com.neo.service.impl;

import com.neo.Exception.ResourceNotFoundException;
import com.neo.dto.StudentDTO;
import com.neo.model.Student;
import com.neo.repository.StudentRepository;
import com.neo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = this.dtoToStudent(studentDTO);
        Student savedStudent = this.studentRepository.save(student);
        return this.studentToDto(savedStudent);
    }

    public StudentDTO getStudentById(int id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));

        return this.studentToDto(student);
    }

    public StudentDTO updateStudent(StudentDTO studentDTO, int id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));

        student.setName(studentDTO.getName());
        student.setCity(studentDTO.getCity());
        student.setRoll_no(studentDTO.getRoll_no());
        student.setEmail(studentDTO.getEmail());
        student.setPan(studentDTO.getPan());
        student.setAadhar_card(studentDTO.getAadhar_card());

        Student updatedStudent = this.studentRepository.save(student);
        StudentDTO studentDTO1 = this.studentToDto(updatedStudent);

        return studentDTO1;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = this.studentRepository.findAll();

        List<StudentDTO> studentDTOS = students.stream().map(student -> this.studentToDto(student)).collect(Collectors.toList());
        return studentDTOS;
    }

    public void deleteStudent(int id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));

        this.studentRepository.delete(student);
    }

    private Student dtoToStudent(StudentDTO studentDTO) {
        Student student = this.modelMapper.map(studentDTO, Student.class);

//        student.setId(studentDTO.getId());
//        student.setName(studentDTO.getName());
//        student.setCity(studentDTO.getCity());
//        student.setRoll_no(studentDTO.getRoll_no());
//        student.setEmail(studentDTO.getEmail());
//        student.setPan(studentDTO.getPan());
//        student.setAadhar_card(studentDTO.getAadhar_card());

        return student;
    }

    public StudentDTO studentToDto(Student student) {
        StudentDTO studentDTO = this.modelMapper.map(student, StudentDTO.class);
//        studentDTO.setId(student.getId());
//        studentDTO.setName(student.getName());
//        studentDTO.setCity(student.getCity());
//        studentDTO.setRoll_no(student.getRoll_no());
//        studentDTO.setEmail(student.getEmail());
//        studentDTO.setPan(student.getPan());
//        studentDTO.setAadhar_card(student.getAadhar_card());

        return studentDTO;

    }

}
