<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>Quản lý người dùng</title>
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

    <style>
        .user-details p {
            margin-bottom: 0.5rem;
            border-bottom: 1px solid #eee;
            padding-bottom: 0.5rem;
        }
        .user-details p:last-child {
            border-bottom: none;
        }
        .user-details strong {
            display: inline-block;
            width: 120px;
        }
        .status-badge {
            font-weight: 500;
            padding: 5px 10px;
            border-radius: 4px;
            font-size: 0.875rem;
        }
        .table th {
            background-color: #f8f9fa;
            font-weight: 600;
        }
        .filter-section {
            background-color: #fff;
            padding: 1rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-bottom: 1.5rem;
        }
        .table-responsive {
            overflow-x: auto;
        }
        .avatar-sm {
            width: 32px;
            height: 32px;
            border-radius: 50%;
            object-fit: cover;
        }
    </style>
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
    <div class="pagetitle d-flex justify-content-between align-items-center">
        <div>
            <h1>Quản lý người dùng</h1>
            <nav>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="dashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active">Người dùng</li>
                </ol>
            </nav>
        </div>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addUserModal">
            <i class="bi bi-plus-circle me-1"></i> Thêm người dùng
        </button>
    </div>

    <section class="section">
        <div class="row">
            <div class="col-12">
                <!-- Users Table -->
                <div class="card">
                    <div class="card-body">
                        <div class="container-fluid mt-4">
                            <!-- Show message -->
                            <div class="toast-container position-fixed top-0 end-0 p-3">
                                <c:if test="${not empty successMessage}">
                                    <div id="successToast" class="toast align-items-center text-white bg-success border-0" role="alert"
                                         aria-live="assertive" aria-atomic="true" data-bs-autohide="true" data-bs-delay="3000">
                                        <div class="d-flex">
                                            <div class="toast-body">${successMessage}</div>
                                            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                                                    aria-label="Close"></button>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${not empty errorMessage}">
                                    <div id="errorToast" class="toast align-items-center text-white bg-danger border-0" role="alert"
                                         aria-live="assertive" aria-atomic="true" data-bs-autohide="true" data-bs-delay="3000">
                                        <div class="d-flex">
                                            <div class="toast-body">${errorMessage}</div>
                                            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                                                    aria-label="Close"></button>
                                        </div>
                                    </div>
                                </c:if>
                            </div>

                            <!-- Search & Filter Form -->
                            <form class="row g-3 mb-4" method="get" action="${pageContext.request.contextPath}/view/admin/user">
                                <div class="col-md-4">
                                    <input type="text" class="form-control" placeholder="Tìm theo tên..." name="searchName" value="${param.searchName}">
                                </div>
                                <div class="col-md-3">
                                    <select class="form-select" name="role" onchange="this.form.submit()">
                                        <option value="">-- Vai trò --</option>
                                        <option value="ADMIN" ${param.role == 'ADMIN' ? 'selected' : ''}>Admin</option>
                                        <option value="USER" ${param.role == 'USER' ? 'selected' : ''}>User</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <select class="form-select" name="sortBy" onchange="this.form.submit()">
                                        <option value="">-- Sắp xếp --</option>
                                        <option value="nameAsc" ${param.sortBy == 'nameAsc' ? 'selected' : ''}>Tên: A-Z</option>
                                        <option value="nameDesc" ${param.sortBy == 'nameDesc' ? 'selected' : ''}>Tên: Z-A</option>
                                        <option value="dateAsc" ${param.sortBy == 'dateAsc' ? 'selected' : ''}>Ngày tạo: Cũ nhất</option>
                                        <option value="dateDesc" ${param.sortBy == 'dateDesc' ? 'selected' : ''}>Ngày tạo: Mới nhất</option>
                                    </select>
                                </div>
                                <div class="col-md-2">
                                    <button class="btn btn-primary w-100">Lọc</button>
                                </div>
                            </form>

                            <!-- Table -->
                            <div class="table-responsive">
                                <table class="table table-hover table-bordered align-middle">
                                    <thead class="table-light">
                                    <tr>
                                        <th>#</th>
                                        <th>Tên</th>
                                        <th>Email</th>
                                        <th>Số điện thoại</th>
                                        <th>Vai trò</th>
                                        <th>Trạng thái</th>
                                        <th>Ngày tạo</th>
                                        <th>Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:choose>
                                        <c:when test="${not empty users}">
                                            <c:forEach var="user" items="${users}" varStatus="status">
                                                <tr>
                                                    <td>${status.index + 1}</td>
                                                    <td>${user.fullname}</td>
                                                    <td>${user.email}</td>
                                                    <td>${user.userPhone}</td>
                                                    <td>
                                                        <span class="badge bg-${user.role == 'ADMIN' ? 'danger' : 'info'}">
                                                            ${user.role}
                                                        </span>
                                                    </td>
                                                    <td>
                                                        <span class="badge bg-${user.status == 'ACTIVE' ? 'success' : 'danger'}">
                                                            ${user.status == 'ACTIVE' ? 'Hoạt động' : 'Khóa'}
                                                        </span>
                                                    </td>
                                                    <td>
                                                        <fmt:formatDate value="${user.createdDate}" pattern="dd/MM/yyyy HH:mm"/>
                                                    </td>
                                                    <td>
                                                        <div class="d-flex gap-2">
                                                            <button class="btn btn-sm btn-info" data-bs-toggle="modal"
                                                                    data-bs-target="#viewUserModal_${user.id}">
                                                                <i class="bi bi-eye"></i>
                                                            </button>
                                                            <button class="btn btn-sm btn-warning" data-bs-toggle="modal"
                                                                    data-bs-target="#editUserModal_${user.id}">
                                                                <i class="bi bi-pencil"></i>
                                                            </button>
                                                            <button class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                                                    data-bs-target="#deleteUserModal_${user.id}">
                                                                <i class="bi bi-trash"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td colspan="8" class="text-center">Không có dữ liệu</td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                    </tbody>
                                </table>
                            </div>

                            <!-- Pagination -->
                            <c:if test="${not empty users}">
                                <nav aria-label="Page navigation" class="mt-4">
                                    <ul class="pagination justify-content-center">
                                        <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
                                            <a class="page-link" href="?page=${currentPage > 0 ? currentPage - 1 : 0}&size=${param.size}${not empty param.searchName ? '&searchName='.concat(param.searchName) : ''}${not empty param.role ? '&role='.concat(param.role) : ''}${not empty param.sortBy ? '&sortBy='.concat(param.sortBy) : ''}">Trước</a>
                                        </li>
                                        <c:forEach begin="0" end="${totalPages - 1}" var="i">
                                            <li class="page-item ${currentPage == i ? 'active' : ''}">
                                                <a class="page-link" href="?page=${i}&size=${param.size}${not empty param.searchName ? '&searchName='.concat(param.searchName) : ''}${not empty param.role ? '&role='.concat(param.role) : ''}${not empty param.sortBy ? '&sortBy='.concat(param.sortBy) : ''}">${i + 1}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
                                            <a class="page-link" href="?page=${currentPage + 1}&size=${param.size}${not empty param.searchName ? '&searchName='.concat(param.searchName) : ''}${not empty param.role ? '&role='.concat(param.role) : ''}${not empty param.sortBy ? '&sortBy='.concat(param.sortBy) : ''}">Sau</a>
                                        </li>
                                    </ul>
                                </nav>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- ======= Footer ======= -->
<jsp:include page="footer.jsp"/>
<!-- End Footer -->

<!-- Include modals -->
<c:if test="${not empty users}">
    <c:forEach var="user" items="${users}">
        <%@ include file="crud_user/view_user.jsp" %>
        <%@ include file="crud_user/edit_user.jsp" %>
        <%@ include file="crud_user/delete_user.jsp" %>
    </c:forEach>
</c:if>
<jsp:include page="crud_user/add_user.jsp"/>

<!-- Vendor JS Files -->
<script src="${pageContext.request.contextPath}/resources/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/vendor/chart.js/chart.umd.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/vendor/echarts/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        var successToastEl = document.getElementById('successToast');
        if (successToastEl) {
            var successToast = new bootstrap.Toast(successToastEl);
            successToast.show();
        }

        var errorToastEl = document.getElementById('errorToast');
        if (errorToastEl) {
            var errorToast = new bootstrap.Toast(errorToastEl);
            errorToast.show();
        }

        // Functions to manually open modals
        function showViewUserModal(userId) {
            var modalId = 'viewUserModal_' + userId;
            var modalElement = document.getElementById(modalId);
            if (modalElement) {
                var modal = new bootstrap.Modal(modalElement);
                modal.show();
            } else {
                console.error('Modal element not found:', modalId);
            }
        }

        function showEditUserModal(userId, fullname, email, userPhone, role) {
            var modalId = 'editUserModal_' + userId;
            var modalElement = document.getElementById(modalId);
            if (modalElement) {
                // Populate form fields if necessary, e.g., modalElement.querySelector('#editFullname').value = fullname;
                modalElement.querySelector('input[name="id"]').value = userId;
                modalElement.querySelector('input[name="fullname"]').value = fullname;
                modalElement.querySelector('input[name="email"]').value = email;
                modalElement.querySelector('input[name="userPhone"]').value = userPhone;
                modalElement.querySelector('select[name="role"]').value = role;

                var modal = new bootstrap.Modal(modalElement);
                modal.show();
            } else {
                console.error('Modal element not found:', modalId);
            }
        }

        function showDeleteUserModal(userId, fullname) {
            var modalId = 'deleteUserModal_' + userId;
            var modalElement = document.getElementById(modalId);
            if (modalElement) {
                // Populate user name in the confirmation message
                modalElement.querySelector('.modal-body strong').textContent = fullname;
                modalElement.querySelector('input[name="userId"]').value = userId;

                var modal = new bootstrap.Modal(modalElement);
                modal.show();
            } else {
                console.error('Modal element not found:', modalId);
            }
        }

        // Expose functions to global scope for onclick attributes
        window.showViewUserModal = showViewUserModal;
        window.showEditUserModal = showEditUserModal;
        window.showDeleteUserModal = showDeleteUserModal;
    });
</script>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
