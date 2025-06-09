package com.example.balo_center.domain.repo.impl;

import com.example.balo_center.domain.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class UserRepoImpl implements UserRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;

    private String buildWhere(SearchRequest searchRequest){
        StringBuilder where = new StringBuilder(" ");
        if (searchRequest.getSearchName()!= null && !searchRequest.getSearchName().isEmpty()){
            where.append(" AND u.fullName").append(" LIKE '%").append(searchRequest.getSearchName()).append("%'");
        }
        if(searchRequest.getSearchRole()!= null && !searchRequest.getSearchRole().isEmpty()){
            where.append(" AND u.role").append(" LIKE '%").append(searchRequest.getSearchRole()).append("%'");
        }
        if(searchRequest.getSearchStatus()!= null && !searchRequest.getSearchStatus().isEmpty()){
            where.append(" AND u.status").append(" LIKE '%").append(searchRequest.getSearchStatus()).append("%'");
        }
        return where.toString();
    }

    @Override
    public List<User> searchUsers(SearchRequest searchRequest) {
        StringBuilder sql = new StringBuilder("SELECT u.* FROM users u ");
        sql.append(" Where 1=1 ");
        sql.append(buildWhere(searchRequest));
        sql.append(" GROUP BY u.id ");
        Query query = entityManager.createNativeQuery(sql.toString(), User.class);
        // Thêm phân trang
        query.setFirstResult(searchRequest.getPage() * searchRequest.getSize());
        query.setMaxResults(searchRequest.getSize());
        
        return query.getResultList();
    }

    @Override
    public long countTotalUsers(SearchRequest searchRequest) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT u.id) FROM users u ");
        sql.append(" Where 1=1 ");
        sql.append(buildWhere(searchRequest));
        
        Query query = entityManager.createNativeQuery(sql.toString());
        return ((Number) query.getSingleResult()).longValue();
    }
}
