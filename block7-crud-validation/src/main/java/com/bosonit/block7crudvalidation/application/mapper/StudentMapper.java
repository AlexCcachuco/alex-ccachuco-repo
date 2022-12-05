package com.bosonit.block7crudvalidation.application.mapper;

import com.bosonit.block7crudvalidation.controller.dto.*;
import com.bosonit.block7crudvalidation.domain.Asignatura;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface StudentMapper {


    @Mapping(source="persona.id_persona", target="id_persona")
    @Mapping(source="profesor.id", target = "id_profesor")
    StudentDTO studentToStudentDTO(Student student);

    @Mapping(source = "id_persona", target ="persona.id_persona")
    @Mapping(source = "id_profesor", target ="profesor.id")
    Student studentDtoToStudent(StudentDTO studentDto);

    @Mapping(source="persona", target="persona")
    @Mapping(source = "profesor.id", target = "id_profesor")
    StudentFullDTO studentToStudentFullDTO(Student student);


    @Mapping(source="persona", target = "persona")
    @Mapping(source ="profesor", target = "profesordto")
    PersonaStudentDTO studentToPersonaStudentDTO(Student student);

    List<StudentDTO> map(List<Student> students);

}
