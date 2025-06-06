<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Import Sản phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/bootstrap/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/template/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="modal fade" id="importProductModal" tabindex="-1" aria-labelledby="importProductModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Import Sản phẩm từ Excel</h3>
                    </div>
                    <div class="card-body">
                        <!-- Thông báo lỗi -->
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" role="alert">
                                    ${error}
                            </div>
                        </c:if>

                        <!-- Thông báo thành công -->
                        <c:if test="${not empty success}">
                            <div class="alert alert-success" role="alert">
                                    ${success}
                            </div>
                        </c:if>

                        <!-- Danh sách lỗi chi tiết -->
                        <c:if test="${not empty errors}">
                            <div class="alert alert-warning" role="alert">
                                <h5>Các lỗi chi tiết:</h5>
                                <ul>
                                    <c:forEach items="${errors}" var="error">
                                        <li>${error.message}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <!-- Form upload -->
                        <form action="/admin/product/import" method="post" enctype="multipart/form-data">
                            <div class="mb-3">
                                <label for="file" class="form-label">Chọn file Excel (.xlsx)</label>
                                <input type="file" class="form-control" id="file" name="file" accept=".xlsx" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Import</button>
                                <a href="view/admin/product" class="btn btn-secondary">Quay lại</a>
                            </div>
                        </form>

                        <!-- Hướng dẫn -->
                        <div class="mt-4">
                            <h5>Hướng dẫn:</h5>
                            <p>File Excel cần có các cột theo thứ tự sau:</p>
                            <ol>
                                <li>Tên sản phẩm</li>
                                <li>Giá</li>
                                <li>Mô tả</li>
                                <li>Số lượng</li>
                                <li>Danh mục</li>
                            </ol>
                            <p>Lưu ý: Các trường bắt buộc là Tên sản phẩm, Giá, Số lượng và Danh mục.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>--%>
</html>