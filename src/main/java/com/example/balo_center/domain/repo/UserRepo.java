package com.example.balo_center.domain.repo;

import com.example.balo_center.domain.dto.UserFormDTO;
import com.example.balo_center.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Query("select new com.example.balo_center.domain.dto.UserFormDTO(u.id, u.email, u.fullname, u.password, u.userPhone, u.role, u.status, u.avatar, u.createdDate) "
            +
            "from User u " +
            "where (:searchName is null or :searchName = '' or u.fullname like concat('%', :searchName, '%') or u.email like concat('%', :searchName, '%')) "
            +
            "and (:role is null or :role = '' or u.role = :role)")
    Page<UserFormDTO> findAllUsers(@Param("searchName") String searchName,
            @Param("role") String role,
            Pageable pageable);

    @Query("select new com.example.balo_center.domain.dto.UserFormDTO(u.id, u.email, u.fullname, u.password, u.userPhone, u.role, u.status, u.avatar, u.createdDate) "
            +
            "from User u where u.id = :id")
    UserFormDTO findUserById(@Param("id") String id);

    Optional<User> findUsersByEmail(String email);

    boolean existsByEmail(String email);
}
