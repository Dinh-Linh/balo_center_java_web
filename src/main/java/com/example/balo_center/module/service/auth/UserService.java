package com.example.balo_center.module.service.auth;

import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.request.SearchRequest;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();
    List<UserDTO> findUser(SearchRequest searchRequest);
    User addUser(UserDTO userDTO);
    User updateUser(UserDTO userDTO);
    void deleteUser(String id);
}
