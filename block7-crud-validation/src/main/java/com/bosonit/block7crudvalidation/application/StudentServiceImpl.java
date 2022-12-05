package com.bosonit.block7crudvalidation.application;


import com.bosonit.block7crudvalidation.application.mapper.AsignaturaMapper;
import com.bosonit.block7crudvalidation.controller.dto.AsignaturaDTO;
import com.bosonit.block7crudvalidation.controller.dto.AsignaturaWithStudentsDTO;
import com.bosonit.block7crudvalidation.controller.dto.StudentDTO;
import com.bosonit.block7crudvalidation.controller.dto.StudentFullDTO;
import com.bosonit.block7crudvalidation.domain.Asignatura;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.domain.Student;
import com.bosonit.block7crudvalidation.application.mapper.StudentMapper;
import com.bosonit.block7crudvalidation.repository.AsignaturaRepository;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import com.bosonit.block7crudvalidation.repository.StudentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepo;

    @Autowired
    AsignaturaRepository asignaturaRepo;

    @Autowired
    PersonaRepository personaRepo;

    StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    AsignaturaMapper asignaturaMapper = Mappers.getMapper(AsignaturaMapper.class);

    public StudentDTO createStudent(StudentDTO studentDto){

        System.out.println(studentDto.toString() + " dto");
        Persona persona = personaRepo.findById(studentDto.getId_persona()).orElseThrow();
        Student student = mapper.studentDtoToStudent(studentDto);

        student.setPersona(persona);

        System.out.println(student.toString()+ " object");
        studentRepo.save(student);
        return mapper.studentToStudentDTO(student);
    }

    public List<StudentDTO> getAllStudents(){
        return mapper.map(studentRepo.findAll());
    }

    public void deleteById(int id){
        studentRepo.deleteById(id);
    }

    public StudentDTO updateStudent(StudentDTO studentDto, int id){
        Student student = mapper.studentDtoToStudent(studentDto);
        student.setId_student(id);
        studentRepo.save(student);
        return mapper.studentToStudentDTO(student);
    }

    public StudentDTO getStudentById(int id){
        Student student = studentRepo.findById(id).orElseThrow();
        return mapper.studentToStudentDTO(student);
    }

    public StudentFullDTO getStudentFullById(int id){

        Student student = studentRepo.findById(id).orElseThrow();
        StudentFullDTO studentdto = mapper.studentToStudentFullDTO(student);
        return studentdto;
    }

    public AsignaturaWithStudentsDTO createRelationStudentAsignatura(int id_student, int id_asignatura){
        Student student = studentRepo.findById(id_student).orElseThrow();
        Asignatura asignatura = asignaturaRepo.findById(id_asignatura).orElseThrow();

        //Mete una asignatura en la lista de asignaturas de un estudiante
        student.getAsignaturas().add(asignatura);
        // Mete un estudiante en la lista de estudiantes de una asignatura
        asignatura.getStudents().add(student);

        asignaturaRepo.save(asignatura);
        studentRepo.save(student);

        List<StudentDTO> listStudents = mapper.map(asignatura.getStudents());

        AsignaturaWithStudentsDTO asignatura_students = asignaturaMapper.asignaturaToAsignaturaWithStudentsDto(asignatura);
        asignatura_students.setStudents(listStudents);
        return asignatura_students;
    }

    public void deleteRelationStudentAsignatura(int id_student, int id_asignatura) {
        Student student = studentRepo.findById(id_student).orElseThrow();
        Asignatura asignatura = asignaturaRepo.findById(id_asignatura).orElseThrow();

        student.getAsignaturas().remove(asignatura);
        asignatura.getStudents().remove(student);

        asignaturaRepo.save(asignatura);
        studentRepo.save(student);

//        List<StudentDTO> listStudents = mapper.map(asignatura.getStudents());
//
//        AsignaturaWithStudentsDTO asignatura_students = asignaturaMapper.asignaturaToAsignaturaWithStudentsDto(asignatura);
//        asignatura_students.setStudents(listStudents);
//        return asignatura_students;

    }

}
