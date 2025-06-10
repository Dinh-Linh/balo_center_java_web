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
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
        // List<User> users = userRepo.findAll();
        List<User> users = userRepo.findAll(Sort.by(Sort.Direction.ASC, "role"));
        List<UserDTO> results = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = userConverter.toUserDTO(user);
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public List<UserDTO> findUser(SearchRequest searchRequest) {
        List<User> users = userRepo.searchUsers(searchRequest);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User x : users) {
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
        User existingUser = userRepo.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userDTO.getId()));
        Timestamp timestamp = existingUser.getCreatedDate();
        User user = userConverter.toUserEntity(userDTO);
        user.setCreatedDate(timestamp);
        userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public byte[] exportUsersToExcel(SearchRequest searchRequest) throws IOException {
        // Tạo một SearchRequest mới để lấy tất cả user đã lọc
        SearchRequest exportRequest = new SearchRequest();
        exportRequest.setSearchName(searchRequest.getSearchName());
        exportRequest.setSearchRole(searchRequest.getSearchRole());
        exportRequest.setSearchStatus(searchRequest.getSearchStatus());
        // Đặt size = 0 để lấy tất cả user đã lọc
        exportRequest.setSize(0);
        exportRequest.setPage(0);
        
        // Lấy tất cả user đã lọc
        List<UserDTO> users = findUser(exportRequest);
        
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Users");
            
            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"STT", "ID", "Họ và tên", "Email", "Số điện thoại", "Vai trò", "Trạng thái", "Ngày tạo"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }
            
            // Create data rows
            int rowNum = 1;
            for (int i = 0; i < users.size(); i++) {
                UserDTO user = users.get(i);
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(i + 1); // STT
                row.createCell(1).setCellValue(user.getId()); // ID
                row.createCell(2).setCellValue(user.getFullname());
                row.createCell(3).setCellValue(user.getEmail());
                row.createCell(4).setCellValue(user.getUserPhone());
                row.createCell(5).setCellValue(user.getRole());
                row.createCell(6).setCellValue(user.getStatus());
                row.createCell(7).setCellValue(user.getCreatedDate().toString());
            }
            
            // Auto-size columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            // Write to ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }
}