package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.converter.UserConverter;
import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.dto.UserFormDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.repo.UserRepo;
import com.example.balo_center.domain.request.SearchRequest;
import com.example.balo_center.module.service.admin.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUser() {
        //List<User> users = userRepo.findAll();
        List<User>  users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "role"));
        List<UserDTO> results = new ArrayList<>();
        for(User user : users){
            UserDTO userDTO = userConverter.toUserDTO(user);
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public List<UserDTO> findUser(SearchRequest searchRequest) {
        List<User> users = userRepo.searchUsers(searchRequest);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User x : users){
            UserDTO userDTO = userConverter.toUserDTO(x);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public long countTotalUsers(SearchRequest searchRequest) {
        return userRepo.countTotalUsers(searchRequest);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        if (userRepo.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }
        User user = userConverter.toUserEntity(userDTO);
        user.setCreatedDate(Timestamp.from(Instant.now()));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        Timestamp timestamp = userRepo.findById(userDTO.getId()).getCreatedDate();
        User user = userConverter.toUserEntity(userDTO);
        user.setCreatedDate(timestamp);
        userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}