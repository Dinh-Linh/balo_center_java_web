<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>User Page</title>
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
    <script src="${pageContext.request.contextPath}/resources/template/bootstrap/js/bootstrap.min.js"/>

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

<!-- Main hearing -->
<main id="main" class="main">
    <div class="pagetitle d-flex justify-content-between">
        <h1>User</h1>
        <nav>
            <ol class="breadcrumb d-flex">
                <li class="breadcrumb-item ms-auto">
                    <a href="index.html"><i class="bi bi-house"></i></a>
                </li>
                <li class="breadcrumb-item active">User</li>
            </ol>
        </nav>
    </div>
    <!-- End Page Title -->
    <div class="container-fluid mt-4">
        <!-- Header: Tiêu đề + Thêm mới -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h4 class="mb-0">Danh sách người dùng</h4>
            <a href="/view/admin/user/add" class="btn btn-success">+ Thêm mới</a>
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
                <th>Tên</th>
                <th>Email</th>
                <th>Vai trò</th>
                <th>Ngày tạo</th>
                <th>Trạng thái</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Nguyễn Văn A</td>
                <td>a@gmail.com</td>
                <td>Admin</td>
                <td>01/04/2024</td>
                <td><span class="badge bg-success">Hoạt động</span></td>
                <td>
                    <button class="btn btn-sm btn-primary me-1">Xem</button>
                    <button class="btn btn-sm btn-warning me-1">Sửa</button>
                    <button class="btn btn-sm btn-danger">Xóa</button>
                </td>
            </tr>
            <!-- More rows -->
            </tbody>
        </table>

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

<!-- Vendor JS Files -->
<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/chart.js/chart.umd.js"></script>
<script src="assets/vendor/echarts/echarts.min.js"></script>
<script src="assets/vendor/quill/quill.js"></script>
<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="assets/vendor/tinymce/tinymce.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>
</body>
</html>
