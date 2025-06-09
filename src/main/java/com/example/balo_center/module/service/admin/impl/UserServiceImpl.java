package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.domain.dto.UserFormDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.repo.UserRepo;
import com.example.balo_center.module.service.admin.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Page<UserFormDTO> getAllUsers(int page, int size, String searchName, String role, String sortBy) {
        Pageable pageable = PageRequest.of(page, size);

        if (sortBy != null && !sortBy.isEmpty()) {
            Sort sort = switch (sortBy) {
                case "nameAsc" -> Sort.by(Sort.Direction.ASC, "fullname");
                case "nameDesc" -> Sort.by(Sort.Direction.DESC, "fullname");
                case "dateAsc" -> Sort.by(Sort.Direction.ASC, "createdDate");
                case "dateDesc" -> Sort.by(Sort.Direction.DESC, "createdDate");
                default -> Sort.unsorted();
            };
            pageable = PageRequest.of(page, size, sort);
        }

        return userRepo.findAllUsers(searchName, role, pageable);
    }

    @Override
    public void saveUser(UserFormDTO form) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(form.getEmail());
        user.setFullname(form.getFullname());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setUserPhone(form.getUserPhone());
        user.setRole(form.getRole());
        user.setStatus("ACTIVE");
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userRepo.save(user);
    }

    @Override
    public UserFormDTO getUserById(String id) {
        return userRepo.findUserById(id);
    }

    @Override
    public void updateUser(String id, UserFormDTO updatedUser) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        if (updatedUser.getFullname() != null) {
            existingUser.setFullname(updatedUser.getFullname());
        }
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getUserPhone() != null) {
            existingUser.setUserPhone(updatedUser.getUserPhone());
        }
        if (updatedUser.getRole() != null) {
            existingUser.setRole(updatedUser.getRole());
        }
        if (updatedUser.getStatus() != null) {
            existingUser.setStatus(updatedUser.getStatus());
        }

        userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public void toggleUserStatus(String id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        user.setStatus(user.getStatus().equals("ACTIVE") ? "LOCKED" : "ACTIVE");
        userRepo.save(user);
    }
}