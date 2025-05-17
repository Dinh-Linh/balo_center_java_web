package com.example.balo_center.domain.builder;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import com.example.balo_center.domain.entity.Product;

import java.util.Arrays;

public class ProductBuilder {
    private final Product product = new Product();

    public ProductBuilder withBasicInfo(ProductFormResponseDTO formResponseDTO) {
        product.setProductName(formResponseDTO.productName());
        product.setQuality(formResponseDTO.quantity());
        product.setSold(0);
        product.setPrice(formResponseDTO.price());
        setDescription(formResponseDTO.detailsDesc());
        return this;
    }

    private void setDescription(String detailDesc) {
        product.setProductDetailDesc(detailDesc);
        String[] words = detailDesc.split("\\s+");
        product.setProductShortDesc(
                words.length <= 5 ?
                        detailDesc :
                        String.join(" ", Arrays.toString(Arrays.copyOfRange(words, 0, 10)) + "...")
        );
    }

    public ProductBuilder withCategory(Category category) {
        product.setCategory(category);
        return this;
    }

    public ProductBuilder withBranch(Branch branch) {
        product.setBranch(branch);
        return this;
    }

    public Product build() {
        return product;
    }
}
