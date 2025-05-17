package com.example.balo_center.service.user.impl;

import com.example.balo_center.domain.mapper.UserMapper;
import com.example.balo_center.domain.dto.response.UserDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.repository.UserRepository;
import com.example.balo_center.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUser() {
         //List<User> users = userRepo.findAll();
        List<User>  users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "role"));
         List<UserDTO> results = new ArrayList<>();
         for(User user : users){
             UserDTO userDTO = userMapper.toUserDTO(user);
             results.add(userDTO);
         }
        return results;
    }
}
