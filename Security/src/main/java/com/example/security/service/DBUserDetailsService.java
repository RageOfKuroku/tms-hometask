package com.example.security.service;

import com.example.security.dto.UserDto;
import com.example.security.model.Person;
import com.example.security.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DBUserDetailsService implements UserDetailsService {

    private final PasswordEncoder encoder;

    private final PersonRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> user = repository.findByLogin(username);
        return user
                .orElse(null);
    }
@Transactional
    public void save(UserDto user) {

        String username = user.getUsername();
        String password = user.getPassword();

        Person person = new Person();
        person.setLogin(username);
        person.setPassword(encoder.encode(password));
        person.setPerm("USER");
        repository.save(person);
    }
}
