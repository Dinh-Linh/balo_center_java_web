<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="editProductModal_${productSell.id}" tabindex="-1" aria-labelledby="editProductModalLabel_${productSell.id}" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editProductModalLabel_${productSell.id}">Chỉnh sửa sản phẩm: ${productSell.productName}</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/admin/productSell/update" method="post">
                    <input type="hidden" name="id" value="${productSell.id}">
                    <div class="mb-3">
                        <label for="productName_${productSell.id}" class="form-label">Tên sản phẩm</label>
                        <input type="text" class="form-control" id="productName_${productSell.id}" name="productName" value="${productSell.productName}" required>
                    </div>
                    <div class="mb-3">
                        <label for="categoryName_${productSell.id}" class="form-label">Danh mục</label>
                        <input type="text" class="form-control" id="categoryName_${productSell.id}" name="categoryName" value="${productSell.categoryName}">
                    </div>
                    <div class="mb-3">
                        <label for="branchName_${productSell.id}" class="form-label">Thương hiệu</label>
                        <input type="text" class="form-control" id="branchName_${productSell.id}" name="branchName" value="${productSell.branchName}">
                    </div>
                    <div class="mb-3">
                        <label for="quantity_${productSell.id}" class="form-label">Số lượng</label>
                        <input type="number" class="form-control" id="quantity_${productSell.id}" name="quantity" value="${productSell.quantity}" min="0">
                    </div>
                    <div class="mb-3">
                        <label for="sold_${productSell.id}" class="form-label">Đã bán</label>
                        <input type="number" class="form-control" id="sold_${productSell.id}" name="sold" value="${productSell.sold}" min="0">
                    </div>
                    <div class="mb-3">
                        <label for="price_${productSell.id}" class="form-label">Giá (VND)</label>
                        <input type="number" class="form-control" id="price_${productSell.id}" name="price" value="${productSell.price}" min="0" step="0.01">
                    </div>
                    <div class="mb-3">
                        <label for="detailsDesc_${productSell.id}" class="form-label">Mô tả chi tiết</label>
                        <textarea class="form-control" id="detailsDesc_${productSell.id}" name="detailsDesc" rows="4">${productSell.detailsDesc}</textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                        <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>