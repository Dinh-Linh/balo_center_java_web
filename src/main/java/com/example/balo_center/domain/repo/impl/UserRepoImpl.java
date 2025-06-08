package com.example.balo_center.domain.repo.impl;

import com.example.balo_center.domain.entity.User;
import com.example.balo_center.domain.repo.UserRepoCustom;
import com.example.balo_center.domain.request.SearchRequest;
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
        sql.append("ORDER BY u.created_date DESC ");
        System.out.print(sql);
        Query query = entityManager.createNativeQuery(sql.toString(), User.class);
        List<User> T = query.getResultList();
        return T;
    }
}
