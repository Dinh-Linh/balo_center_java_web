package com.example.balo_center.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest extends PageRequest {
    private String searchName;
    private String searchRole;
    private String searchStatus;
}
