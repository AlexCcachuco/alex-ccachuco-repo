package com.bosonit.block7crudvalidation.application;

import com.bosonit.block7crudvalidation.IFeignProfessor;
import com.bosonit.block7crudvalidation.controller.dto.PersonaDTO;
import com.bosonit.block7crudvalidation.controller.dto.PersonaProfessorListDTO;
import com.bosonit.block7crudvalidation.controller.dto.ProfessorDTO;
import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.domain.Professor;
import com.bosonit.block7crudvalidation.domain.Student;
import com.bosonit.block7crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.block7crudvalidation.application.mapper.PersonaMapper;
import com.bosonit.block7crudvalidation.application.mapper.ProfessorMapper;
import com.bosonit.block7crudvalidation.application.mapper.StudentMapper;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import com.bosonit.block7crudvalidation.repository.ProfessorRepository;
import com.bosonit.block7crudvalidation.repository.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.*;



@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepo;
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    ProfessorRepository professorRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IFeignProfessor feignProfessor;

    @PersistenceContext
    private EntityManager entityManager;

    private PasswordEncoder passwordEncoder;

    PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);
    StudentMapper mapperStudent= Mappers.getMapper(StudentMapper.class);
    ProfessorMapper mapperProfessor = Mappers.getMapper(ProfessorMapper.class);

    public PersonaDTO addPersona(PersonaDTO personaDto)   {
        checkInputData(personaDto);
        Persona persona = mapper.personaDtoToPersona(personaDto);
        persona.setPassword(passwordEncoder.encode(persona.getPassword()));
        personaRepo.save(persona);
        return mapper.personaToPersonaDTO(persona);
    }

    public PersonaDTO getPersonaById(int id){
        Persona persona = personaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        return mapper.personaToPersonaDTO(persona);
    }

    public PersonaDTO getPersonaByName(String name){
        Persona persona = personaRepo.findByName(name).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another name"));
        return mapper.personaToPersonaDTO(persona);
    }

    public List<PersonaDTO> getAllPersonas(){
        return mapper.map(personaRepo.findAll());
    }

    public void deleteById(int id){
        personaRepo.deleteById(id);
    }

    public PersonaDTO updatePersona(PersonaDTO personaInputDto, int id){
        personaRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Person not found! Try another id"));
        checkInputData(personaInputDto);
        Persona persona = mapper.personaDtoToPersona(personaInputDto);
        persona.setId_persona(id);
        personaRepo.save(persona);
        return mapper.personaToPersonaDTO(persona);
    }

    public void checkInputData(PersonaDTO persona){
        if(Objects.isNull(persona.getUsuario()) || persona.getUsuario().isBlank()){
            throw new UnprocessableEntityException("Username cant be null or empty");
        } else if(persona.getUsuario().length() > 10){
            throw new UnprocessableEntityException("Username length cannot be more than 10");
        }
    }


    public Optional<?> getStudentOrProfessorByIdPersona(int id){
        //Obtengo student o professor mediante su id
        Student student = studentRepo.findStudentByIdPersona(id);
        Professor professor = professorRepo.findProfessorByIdPersona(id);
        // Si estudiante no es null, mapea y envia sus datos
        // Si estudiante es null, mapea y envia professor
        return (!Objects.isNull(student)) ?
                Optional.ofNullable(mapperStudent.studentToPersonaStudentDTO(student)) :
                Optional.ofNullable(mapperProfessor.studentToPersonaProfessorDTO(professor));
    }

    public Optional<?> getStudentOrProfessorByName(String name){
        //Obtengo student o professor mediante su id
        Student student = studentRepo.findByName(name);
        Professor professor = professorRepo.findByName(name);
        // Si estudiante no es null, mapea y envia sus datos
        // Si estudiante es null, mapea y envia professor
        return (!Objects.isNull(student)) ?
                Optional.ofNullable(mapperStudent.studentToPersonaStudentDTO(student)) :
                Optional.ofNullable(mapperProfessor.studentToPersonaProfessorDTO(professor));
    }


    public ProfessorDTO getProfessorById(int id){
        ProfessorDTO professor = restTemplate.getForObject("http://localhost:8080/profesor/{id}", ProfessorDTO.class, id);
        return professor;
    }
    public ProfessorDTO getProfessorByIdFeign(int id){
        ProfessorDTO professorDTO = feignProfessor.callProfessor(id);
        return professorDTO;
    }

    public List<PersonaDTO> getCustomQuery(HashMap<String, Object> conditions){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

       conditions.forEach((field,value) -> {
           switch (field){
               case "usuario":
                   predicates.add(cb.like(root.get(field), "%"+ (String) value + "%"));
                   break;
               case "name":
                   predicates.add(cb.like(root.get(field), "%"+ (String) value + "%"));
                   break;
               case "surname":
                   predicates.add(cb.like(root.get(field), "%"+ (String) value + "%"));
                   break;
               case "created_date":
                   System.out.println(field.toString());
                   System.out.println(value.toString());
                   predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                   break;
           }
           if(!Objects.isNull(field) && field.equals("order")){
               switch (value.toString()){
                   case "usuario":
                       query.orderBy(cb.desc(root.get("usuario")));
                       break;
                   case "name":
                       query.orderBy(cb.desc(root.get("name")));
                       break;
               }
           }
       });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList().stream().map(mapper::personaToPersonaDTO).toList();
    }

    public Page<PersonaDTO> findPersonByPage(int page, int pageSize){
        Page<Persona> personaPages = personaRepo.findAll(PageRequest.of(page, pageSize));
        return personaPages.map(mapper::personaToPersonaDTO);
    }
}
