<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <title>Dashboard - NiceAdmin Bootstrap Template</title>
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
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link" href="dashboard">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <!-- End Dashboard Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#user-nav"
                    data-bs-toggle="collapse"
                    href="#"
            >
                <i class="bi bi-people"></i><span>Người sử dụng</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                    id="user-nav"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="user/list">
                        <i class="bi bi-list-task"></i
                        ><span>Danh sách</span>
                    </a>
                </li>
                <li>
                    <a href="user/add">
                        <i class="bi bi-plus-lg"></i
                        ><span>Thêm mới</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bi bi-circle"></i
                        ><span>Cấp quyền</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="bi bi-archive"></i
                        ><span>Thùng rác</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Components Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#product-nav"
                    href="product/list"
            >
                <i class="bi bi-journal-text"></i><span>Sản phẩm</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
        </li>
        <!-- End Forms Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#orders-nav"
                    href="order/list"
            >
                <i class="bi bi-layout-text-window-reverse"></i
                ><span>Đơn hàng</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
        </li>
        <!-- End Tables Nav -->

        <li class="nav-item">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#charts-nav"
                    data-bs-toggle="collapse"
                    href="#"
            >
                <i class="bi bi-bar-chart"></i><span>Charts</span
            ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                    id="charts-nav"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="charts-chartjs.jsp">
                        <i class="bi bi-circle"></i
                        ><span>Chart.js</span>
                    </a>
                </li>
                <li>
                    <a href="charts-apexcharts.html">
                        <i class="bi bi-circle"></i
                        ><span>ApexCharts</span>
                    </a>
                </li>
                <li>
                    <a href="charts-echarts.html">
                        <i class="bi bi-circle"></i><span>ECharts</span>
                    </a>
                </li>
            </ul>
        </li>
        <!-- End Charts Nav -->

        <!-- <li class="nav-item">
            <a
                class="nav-link collapsed"
                data-bs-target="#icons-nav"
                data-bs-toggle="collapse"
                href="#"
            >
                <i class="bi bi-gem"></i><span>Icons</span
                ><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul
                id="icons-nav"
                class="nav-content collapse"
                data-bs-parent="#sidebar-nav"
            >
                <li>
                    <a href="icons-bootstrap.html">
                        <i class="bi bi-circle"></i
                        ><span>Bootstrap Icons</span>
                    </a>
                </li>
                <li>
                    <a href="icons-remix.html">
                        <i class="bi bi-circle"></i
                        ><span>Remix Icons</span>
                    </a>
                </li>
                <li>
                    <a href="icons-boxicons.html">
                        <i class="bi bi-circle"></i
                        ><span>Boxicons</span>
                    </a>
                </li>
            </ul>
        </li> -->
        <!-- End Icons Nav -->

        <!-- <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li> -->
        <!-- End Profile Page Nav -->

        <!-- <li class="nav-item">
            <a class="nav-link collapsed" href="pages-faq.html">
                <i class="bi bi-question-circle"></i>
                <span>F.A.Q</span>
            </a>
        </li> -->
        <!-- End F.A.Q Page Nav -->

        <!-- <li class="nav-item">
            <a class="nav-link collapsed" href="pages-contact.html">
                <i class="bi bi-envelope"></i>
                <span>Contact</span>
            </a>
        </li> -->
        <!-- End Contact Page Nav -->

        <!-- <li class="nav-item">
            <a class="nav-link collapsed" href="pages-register.html">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
            </a>
        </li> -->
        <!-- End Register Page Nav -->

        <!-- <li class="nav-item">
            <a class="nav-link collapsed" href="pages-login.html">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
            </a>
        </li> -->
        <!-- End Login Page Nav -->

        <!-- <li class="nav-item">
            <a class="nav-link collapsed" href="pages-error-404.html">
                <i class="bi bi-dash-circle"></i>
                <span>Error 404</span>
            </a>
        </li> -->
        <!-- End Error 404 Page Nav -->

        <!-- <li class="nav-item">
            <a class="nav-link collapsed" href="pages-blank.html">
                <i class="bi bi-file-earmark"></i>
                <span>Blank</span>
            </a>
        </li> -->
        <!-- End Blank Page Nav -->
    </ul>
</aside>
<!-- End Sidebar-->
</body>
</html>