package com.example.balo_center.module.service.admin;

import com.example.balo_center.domain.dto.UserFormDTO;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<UserFormDTO> getAllUsers(int page, int size, String searchName, String role, String sortBy);

    void saveUser(UserFormDTO form);

    UserFormDTO getUserById(String id);

    void updateUser(String id, UserFormDTO updatedUser);

    void deleteUser(String id);

    void toggleUserStatus(String id);
}