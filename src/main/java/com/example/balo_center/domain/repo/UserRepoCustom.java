package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.dto.UserDTO;
import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.request.SearchRequest;

import java.util.List;

public interface UserRepoCustom {
    List<User> searchUsers (SearchRequest searchRequest);
}
