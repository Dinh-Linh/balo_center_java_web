package com.example.balo_center.converter;

import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;


    //Entity -> DTO
    public UserDTO toUserDTO(User user){
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }


    public User toUserEntity(UserDTO userDTO){
        User user = modelMapper.map(userDTO,User.class);
        return user;
    }
}
