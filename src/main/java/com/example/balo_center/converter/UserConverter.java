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
        return modelMapper.map(user,UserDTO.class);
    }


    public User toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
}
