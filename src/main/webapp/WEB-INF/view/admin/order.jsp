<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <title>Quản lý đơn hàng</title>

    <!-- Favicons -->
    <link href="${pageContext.request.contextPath}/resources/assets/img/favicon.png" rel="icon"/>
    <link href="${pageContext.request.contextPath}/resources/assets/img/apple-touch-icon.png" rel="apple-touch-icon"/>

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect"/>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet"/>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Vendor CSS Files -->
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/css/bootstrap-icons.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/css/boxicons.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.snow.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.bubble.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/remixicon/remixicon.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/vendor/simple-datatables/style.css" rel="stylesheet"/>

    <!-- Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/style.css" rel="stylesheet"/>
    
    <!-- Custom CSS -->
    <style>
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

    <main id="main" class="main">
        <div class="pagetitle d-flex justify-content-between align-items-center">
            <div>
                <h1>Quản lý đơn hàng</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="dashboard">Dashboard</a></li>
                        <li class="breadcrumb-item active">Đơn hàng</li>
                    </ol>
                </nav>
            </div>
            <div class="search-form" style="max-width: 300px;">
                <div class="input-group">
                    <input type="text" class="form-control" id="searchOrder" placeholder="Tìm kiếm đơn hàng...">
                    <button class="btn btn-primary" type="button">
                        <i class="bi bi-search"></i>
                    </button>
                </div>
            </div>
        </div>

        <section class="section">
            <div class="row">
                <div class="col-12">
                    <!-- Orders Table -->
                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover align-middle" id="ordersTable">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Mã đơn hàng</th>
                                            <th scope="col">Khách hàng</th>
                                            <th scope="col">Ngày đặt</th>
                                            <th scope="col">Tổng tiền</th>
                                            <th scope="col">Trạng thái</th>
                                            <th scope="col">Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="order" items="${orders}" varStatus="status">
                                            <tr>
                                                <td>${status.index + 1}</td>
                                                <td>
                                                    <span class="fw-medium">#${order.id}</span>
                                                </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAA7AAAAOwBeShxvQAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAKoSURBVFiF7ZdPSBRRHMc/b2Z2/+3urCUpuZmUhRgaJGhJlxAi6BJB0LVDHSKCOtS9U4fwkKcuRdQhglqljh0i6GBQiKBUhLWwRqXLuqAUbvszZ2ceLWG7M7OzM7tB0Pd0Zt7v+/t+Z37v994T2CXIsgxA9/2lGxG/+woQkuV4qWJkZASAYDCIw+FAkiQURUGWZUQxYbfhcJhwOEwkEkFRFPx+P4FAAEVRACgvL6e6uppQKEQoFCIYDBIMBhFFkYqKCvx+P4IgYBgG8XicWCxGNBolGo2iqioAqqpSWVlJVVUVsViMWCyGrusbcW1tbZbvkiTR0tJCPB4nHo+j6zqGYQBQWlpKWVkZmqahqiqKouD1egkEAgBks1kikQjhcJhEIoGu6/h8PrxeL7quEw6HmZ+fJ5PJAOByuWhoaMDj8ZBOp0kmk6RSKeLxONlslkAgQDAYxDAMstks8XicUChEIpFgfn6euro6PB4PhmGQTCaZm5sjlUoBUFJSQn19PR6PB1VVSaVSpNNpVFXF7/dTUlKCYRgkk0nm5uZIp9MIgkBtbS0ejwdd10mn02QyGURRxO12I0kS2WyWVCpFJpNBEAS8Xi+SJKFpGolEgmw2iyiKuN1uJEkin8+TSqXQNA1BEKioqMDpdKLrOslkEl3XEUURl8uFJEm2+S4IgmB3wjRNTNPcEWzbAZ/Pt9MxbEe2HXA6nTsdw3Zk2wGXy7XTMWxHth2oqqra6Ri2I9sO1NTU7HQM25GF7YwLgvC/4/wR/6wDVsKuri5qa2t/O8nU1BTj4+MAmKaJaZosLy/T399PY2MjAGNjY4yOjuL3+2lra6O3t5e2tjYGBwcxTZOFhQVGR0dxuVxMTk7S3d1NZ2cnPT09TE9PMzMzQzabZXBwkKamJnp7e+ns7KS9vZ2hoSFM0+Tly5dMTEzgdruZmpqiu7ubjo4Oent7mZ6e5jvVA5pT5SVH7QAAAABJRU5ErkJggg==" 
                                                             alt="Avatar" class="avatar-sm">
                                                        <div class="ms-2">
                                                            <div class="fw-medium">${order.user.fullname}</div>
                                                            <div class="text-muted small">${order.phone}</div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy HH:mm"/>
                                                </td>
                                                <td>
                                                    <span class="fw-medium">
                                                        <fmt:formatNumber value="${order.total_price}" type="currency" currencySymbol="₫"/>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span class="badge status-badge bg-${order.status == 'PENDING' ? 'warning' : 
                                                                                        order.status == 'PROCESSING' ? 'info' : 
                                                                                        order.status == 'SHIPPED' ? 'primary' : 
                                                                                        order.status == 'DELIVERED' ? 'success' : 'danger'}">
                                                        ${order.status == 'PENDING' ? 'Chờ xử lý' :
                                                         order.status == 'PROCESSING' ? 'Đang xử lý' :
                                                         order.status == 'SHIPPED' ? 'Đang giao hàng' :
                                                         order.status == 'DELIVERED' ? 'Đã giao hàng' : 'Đã hủy'}
                                                    </span>
                                                </td>
                                                <td>
                                                    <div class="d-flex gap-2">
                                                        <a href="${pageContext.request.contextPath}/view/admin/order/${order.id}" 
                                                           class="btn btn-sm btn-primary" title="Xem chi tiết">
                                                            <i class="bi bi-eye"></i>
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <!-- Pagination -->
                            <div class="d-flex justify-content-between align-items-center mt-3">
                                <div class="text-muted">
                                    Hiển thị ${orders.size()} trên tổng số ${totalItems} đơn hàng
                                </div>
                                <nav aria-label="Page navigation">
                                    <ul class="pagination mb-0">
                                        <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
                                            <a class="page-link" href="?page=${currentPage - 1}&size=${size}">
                                                <i class="bi bi-chevron-left"></i>
                                            </a>
                                        </li>
                                        <c:forEach begin="0" end="${totalPages - 1}" var="i">
                                            <li class="page-item ${currentPage == i ? 'active' : ''}">
                                                <a class="page-link" href="?page=${i}&size=${size}">${i + 1}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="page-item ${currentPage + 1 >= totalPages ? 'disabled' : ''}">
                                            <a class="page-link" href="?page=${currentPage + 1}&size=${size}">
                                                <i class="bi bi-chevron-right"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <!-- Toast Container -->
    <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
        <div id="successToast" class="toast align-items-center text-white bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    <i class="bi bi-check-circle me-2"></i>
                    Cập nhật trạng thái thành công!
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
    </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Vendor JS Files -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

    <!-- Custom JavaScript -->
    <script>
        // Đợi cho tất cả tài nguyên được tải xong
        window.addEventListener('load', function() {
            // Khởi tạo toast
            const toastElList = document.getElementById('successToast');
            const toast = new bootstrap.Toast(toastElList, {
                animation: true,
                autohide: true,
                delay: 3000
            });

            // Kiểm tra URL parameter và hiển thị toast nếu cần
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.has('success')) {
                toast.show();
            }
        });
    </script>
</body>
</html>
