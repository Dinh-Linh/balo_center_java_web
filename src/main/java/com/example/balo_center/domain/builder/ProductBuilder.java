package com.example.balo_center.domain.builder;

import com.example.balo_center.domain.dto.response.ProductFormResponseDTO;
import com.example.balo_center.domain.entity.Branch;
import com.example.balo_center.domain.entity.Category;
import com.example.balo_center.domain.entity.ProductSell;

import java.util.Arrays;

public class ProductBuilder {
    private final ProductSell productSell = new ProductSell();

    public ProductBuilder withBasicInfo(ProductFormResponseDTO formResponseDTO) {
        productSell.setProductName(formResponseDTO.productName());
        productSell.setQuality(formResponseDTO.quantity());
        productSell.setSold(0);
        productSell.setPrice(formResponseDTO.price());
        setDescription(formResponseDTO.detailsDesc());
        return this;
    }

    private void setDescription(String detailDesc) {
        productSell.setProductDetailDesc(detailDesc);
        String[] words = detailDesc.split("\\s+");
        productSell.setProductShortDesc(
                words.length <= 5 ?
                        detailDesc :
                        String.join(" ", Arrays.toString(Arrays.copyOfRange(words, 0, 10)) + "...")
        );
    }

    public ProductBuilder withCategory(Category category) {
        productSell.setCategory(category);
        return this;
    }

    public ProductBuilder withBranch(Branch branch) {
        productSell.setBranch(branch);
        return this;
    }

    public ProductSell build() {
        return productSell;
    }
}
