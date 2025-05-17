package com.example.balo_center.domain.mapper;

import com.example.balo_center.domain.dto.response.UserDTO;
import com.example.balo_center.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
}
