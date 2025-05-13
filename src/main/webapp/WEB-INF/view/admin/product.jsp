<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>Product Page</title>
    <meta content="" name="description"/>
    <meta content="" name="keywords"/>

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon"/>
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon"/>

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect"/>
    <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"
    />
    <!-- Vendor CSS Files -->
    <link
            href="${pageContext.request.contextPath}/resources/assets/vendor/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <link
            href="${pageContext.request.contextPath}/resources/assets/vendor/css/bootstrap-icons.css"
            rel="stylesheet"
    />
    <link
            href="${pageContext.request.contextPath}/resources/assets/vendor/css/boxicons.min.css"
            rel="stylesheet"
    />
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.snow.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.bubble.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/remixicon/remixicon.css" rel="stylesheet"/>
    <link
            href="${pageContext.request.contextPath}/resources/assets/vendor/simple-datatables/style.css"
            rel="stylesheet"
    />

    <!-- Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/style.css" rel="stylesheet"/>

    <!-- =======================================================
* Template Name: NiceAdmin
* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
* Updated: Apr 20 2024 with Bootstrap v5.3.3
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
======================================================== -->
</head>

<body>
<!-- ======= Header ======= -->
<jsp:include page="header.jsp"/>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<jsp:include page="sidebar.jsp"/>
<!-- End Sidebar-->

<main id="main" class="main">
    <div class="pagetitle d-flex justify-content-between">
        <h1>Product</h1>
        <nav>
            <ol class="breadcrumb d-flex">
                <li class="breadcrumb-item ms-auto">
                    <a href="index.html"><i class="bi bi-house"></i></a>
                </li>
                <li class="breadcrumb-item active">Product</li>
            </ol>
        </nav>
    </div>
    <!-- End Page Title -->
    <div class="container-fluid mt-4">
        <!-- Header: Tiêu đề + Thêm mới -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h4 class="mb-0">Danh sách sản phẩm</h4>
            <div class="dropdown">
                <button class="btn btn-success" type="button" id="#openModalBtn"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    + Thêm mới
                </button>

            </div>
        </div>

        <!-- Search & Filter -->
        <form class="row g-3 mb-4">
            <div class="col-md-4">
                <input type="text" class="form-control" placeholder="Tìm theo tên..." name="searchName">
            </div>
            <div class="col-md-3">
                <select class="form-select" name="role">
                    <option value="">-- Vai trò --</option>
                    <option value="admin">Admin</option>
                    <option value="editor">Editor</option>
                    <option value="user">User</option>
                </select>
            </div>
            <div class="col-md-3">
                <select class="form-select" name="status">
                    <option value="">-- Trạng thái --</option>
                    <option value="active">Hoạt động</option>
                    <option value="inactive">Bị khóa</option>
                </select>
            </div>
            <div class="col-md-2">
                <button class="btn btn-primary w-100">Lọc</button>
            </div>
        </form>

        <!-- Table -->
        <table class="table table-hover table-bordered align-middle">
            <thead class="table-light">
            <tr>
                <th>#</th>
                <th>Tên sản phẩm</th>
                <th>Danh mục</th>
                <th>Thương hiệu</th>
                <th>Số lượng</th>
                <th>Đã bán</th>
                <th>Giá</th>
                <th>Mô tả</th>
                <th>Chi tiết</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty products}">
                    <c:forEach var="product" items="${products}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${product.productName}</td>
                            <td>${product.categoryName}</td>
                            <td>${product.branchName}</td>
                            <td>${product.quantity}</td>
                            <td>${product.sold}</td>
                            <td>${product.price} VND</td>
                            <td>${product.shortDesc}</td>
                            <td><span class="badge bg-primary">Xem</span></td>
                            <td>
                                <button class="btn btn-sm btn-primary me-1 " data-bs-toggle="modal" data-bs-target="#viewProductModal_${product.id}">Xem</button>
                                <button class="btn btn-sm btn-warning me-1">Sửa</button>
                                <button class="btn btn-sm btn-danger">Xóa</button>
                            </td>
                        </tr>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="10" class="text-center text-danger fw-bold">Không có sản phẩm</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>

        </table>
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <%@ include file="crud_product/view_product.jsp"%>
            </c:forEach>
        </c:if>

        <!-- Pagination -->
        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-end">
                <li class="page-item disabled">
                    <a class="page-link">Trước</a>
                </li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Sau</a>
                </li>
            </ul>
        </nav>
    </div>
</main>
<!-- End #main -->

<!-- ======= Footer ======= -->
<jsp:include page="footer.jsp"/>
<!-- End Footer -->

<a
        href="#"
        class="back-to-top d-flex align-items-center justify-content-center"
><i class="bi bi-arrow-up-short"></i
></a>

<!-- Nút mở Modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addProductModal">
    Thêm sản phẩm mới
</button>

<jsp:include page="crud_product/create_product.jsp"/>

<!-- Template Main JS File -->
<script src="/js/bootstrap.min.js"></script>
<script>
    document.getElementById("#openModalBtn").addEventListener("click", function () {
        var myModal = new bootstrap.Modal(document.getElementById("addProductModal"));
        myModal.show();
    });
</script>
</body>
</html>
