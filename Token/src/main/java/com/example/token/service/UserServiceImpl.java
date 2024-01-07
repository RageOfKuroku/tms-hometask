package com.example.token.service;

import com.example.token.dto.UserDto;
import com.example.token.entity.UserEntity;
import com.example.token.mapper.UserMapper;
import com.example.token.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username).orElse(null);
    }

    public UserDto save(UserDto dto) {
        UserEntity save = repository.save(mapper.toEntity(dto));
        return mapper.toDto(save);
    }
}
