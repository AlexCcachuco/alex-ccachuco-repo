package com.bosonit.block7crudvalidation.security;

import com.bosonit.block7crudvalidation.domain.Persona;
import com.bosonit.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PersonaRepository personaRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Persona persona = personaRepo.findOneByUsuario(username).orElseThrow(()-> new UsernameNotFoundException("User "+ username +"  not exists!"));

       return new UserDetailsImpl(persona);
    }
}
