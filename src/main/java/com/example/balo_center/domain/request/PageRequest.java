package com.example.balo_center.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {
    private int page = 0;
    private int size = 5;
    private String sortBy = "createdDate";
    private String sortDirection = "DESC";
} 