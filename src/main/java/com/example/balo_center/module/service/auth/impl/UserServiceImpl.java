package com.example.balo_center.module.service.auth.impl;

import com.example.balo_center.converter.UserConverter;
import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.entity.repo.UserRepo;
import com.example.balo_center.module.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepo userRepo;

        @Autowired
        private UserConverter userConverter;

    @Override
    public List<UserDTO> getAllUser() {
         List<User> users = userRepo.findAll();
         List<UserDTO> results = new ArrayList<>();
         for(User user : users){
             UserDTO userDTO = userConverter.toUserDTO(user);
             results.add(userDTO);
         }
        return results;
    }
}
