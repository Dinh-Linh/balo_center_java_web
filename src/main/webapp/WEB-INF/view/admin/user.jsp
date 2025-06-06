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
            <a href="#" class="btn btn-success" id="openModalBtn">+ Thêm mới</a>
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
            <c:forEach var="user" items="${users}" varStatus="itemStart">
                <tr>
                    <td>${itemStart.index + 1}</td>
                    <td>${user.fullname}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>
                        <fmt:formatDate value="${user.createdDate}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${user.status == 'ACTIVE'}">
                                <span class="badge bg-success">${user.status}</span>
                            </c:when>
                            <c:when test="${user.status == 'LOCKED'}">
                                <span class="badge bg-danger">${user.status}</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge bg-secondary">${user.status}</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <button class="btn btn-sm btn-primary me-1" onclick="detailsUser(
                                '${user.id}',
                                '${user.fullname}',
                                '${user.email}',
                                '${user.userPhone}',
                                '${user.role}',
                                '${user.status}',
                                '${user.createdDate}'
                        )">Xem</button>
                        <button class="btn btn-sm btn-warning me-1" onclick="editUser(
                                '${user.id}',
                                '${user.fullname}',
                                '${user.email}',
                                '${user.userPhone}',
                                '${user.role}',
                                '${user.status}',
                                '${user.createdDate}'
                        )">Sửa</button>
                        <button class="btn btn-sm btn-danger btn-delete-user" data-id="${user.id}">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
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

<!-- Nút mở Modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addUserModal">
    Thêm người dùng mới
</button>

<!-- Modal thêm người dùng -->
<jsp:include page="crud_user/add_user.jsp"/>

<%--Modal delete người dùng--%>
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title" id="deleteModalLabel">Xác nhận xoá</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn xoá?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Xoá</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="userDetailsModal" tabindex="-1" aria-labelledby="userDetailsModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="userDetailsModalLabel">Thông tin người dùng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="user-details">
                    <p><strong>ID:</strong> <span id="userId"></span></p>
                    <p><strong>Tên đầy đủ:</strong> <span id="userFullname"></span></p>
                    <p><strong>Email:</strong> <span id="userEmail"></span></p>
                    <p><strong>Số điện thoại:</strong> <span id="userPhone"></span></p>
                    <p><strong>Vai trò:</strong> <span id="userRole"></span></p>
                    <p><strong>Trạng thái:</strong> <span id="userStatus"></span></p>
                    <p><strong>Ngày tạo:</strong> <span id="userCreatedDate"></span></p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="editUserModal" tabindex="-1" aria-labelledby="userEditModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="userEditModalLabel">Chỉnh sửa thông tin người dùng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editUserForm">
                    <input type="hidden" id="edituserId">
                    <div class="mb-3">
                        <label for="edituserFullname" class="form-label">Tên đầy đủ</label>
                        <input type="text" class="form-control" id="edituserFullname" required>
                    </div>
                    <div class="mb-3">
                        <label for="edituserEmail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="edituserEmail" required>
                    </div>
                    <div class="mb-3">
                        <label for="edituserPhone" class="form-label">Số điện thoại</label>
                        <input type="tel" class="form-control" id="edituserPhone" required>
                    </div>
                    <div class="mb-3">
                        <label for="edituserRole" class="form-label">Vai trò</label>
                        <input type="text" class="form-control" id="edituserRole" required>
                    </div>
                    <div class="mb-3">
                        <label for="edituserStatus" class="form-label">Trạng thái</label>
                        <select class="form-select" id="edituserStatus" required>
                            <option value="ACTIVE">ACTIVE</option>
                            <option value="LOCKED">LOCKED</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="edituserCreatedDate" class="form-label">Ngày tạo</label>
                        <input type="text" class="form-control" id="edituserCreatedDate" readonly>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="updateUser()">Cập nhật</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<!-- Template Main JS File -->
<script src="${pageContext.request.contextPath}/resources/assets/vendor/js/bootstrap.bundle.min.js"></script>
<script>
    document.getElementById("openModalBtn").addEventListener("click", function () {
        var myModal = new bootstrap.Modal(document.getElementById("addUserModal"));
        myModal.show();
    });

    // Fix delete user modal
    document.querySelectorAll(".btn-delete-user").forEach(button => {
        button.addEventListener("click", function (){
            const confirmDelModal = new bootstrap.Modal(document.getElementById("confirmDeleteModal"));
            confirmDelModal.show();
        });
    });

    // Fix details user modal
    function detailsUser(id, fullname, email, userPhone, role, status, createdDate) {
        try {
            // Format date
            const formattedDate = createdDate ? new Date(createdDate).toLocaleDateString('vi-VN') : 'Không có';

            // Update modal content
            document.getElementById('userId').textContent = id || 'Không có';
            document.getElementById('userFullname').textContent = fullname || 'Không có';
            document.getElementById('userEmail').textContent = email || 'Không có';
            document.getElementById('userPhone').textContent = userPhone || 'Không có';
            document.getElementById('userRole').textContent = role || 'Không có';
            document.getElementById('userStatus').textContent = status || 'Không có';
            document.getElementById('userCreatedDate').textContent = formattedDate;

            // Show modal
            const userDetailsModal = new bootstrap.Modal(document.getElementById('userDetailsModal'));
            userDetailsModal.show();
        } catch (error) {
            console.error('Lỗi khi hiển thị modal:', error);
            alert('Có lỗi xảy ra khi hiển thị thông tin người dùng');
        }
    }

    function editUser(id, fullname, email, userPhone, role, status, createdDate) {
        try {
            // Format date
            const formattedDate = createdDate ? new Date(createdDate).toLocaleDateString('vi-VN') : 'Không có';

            // Update modal content
            document.getElementById('edituserId').value = id || '';
            document.getElementById('edituserFullname').value = fullname || '';
            document.getElementById('edituserEmail').value = email || '';
            document.getElementById('edituserPhone').value = userPhone || '';
            document.getElementById('edituserRole').value = role || '';
            document.getElementById('edituserStatus').value = status.toUpperCase() || 'ACTIVE';
            document.getElementById('edituserCreatedDate').value = formattedDate;

            // Show modal using Bootstrap 5 syntax
            const editUserModal = new bootstrap.Modal(document.getElementById('editUserModal'));
            editUserModal.show();
        } catch (error) {
            console.error('Lỗi khi hiển thị modal chỉnh sửa:', error);
            alert('Có lỗi xảy ra khi hiển thị thông tin người dùng');
        }
    }



</script>
</body>
</html>
