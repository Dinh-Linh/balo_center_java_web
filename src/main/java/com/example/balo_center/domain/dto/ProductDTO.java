package com.example.balo_center.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String id;
    private String productName;
    private String categoryName;
    private String branchName;
    private Integer quantity;
    private Integer sold;
    private Double price;
    private String shortDesc;
    private String detailsDesc;

    public ProductDTO(String id, String productName, String categoryName, String branchName, Integer quantity, Integer sold, Double price, String shortDesc) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.branchName = branchName;
        this.quantity = quantity;
        this.sold = sold;
        this.price = price;
        this.shortDesc = shortDesc;
    }

}
