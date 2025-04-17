<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item ${pageContext.request.requestURI.endsWith('view/admin/dashboard') ? 'active' : ''}">
            <a class="nav-link" href="/view/admin/dashboard">
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
                    href="/view/admin/user"
            >
                <i class="bi bi-people"></i><span>Người sử dụng</span
            ><i class="bi bi-chevron-right ms-auto"></i>
            </a>
            <ul
                    id="user-nav"
                    class="nav-content collapse"
                    data-bs-parent="#sidebar-nav"
            >
                <li class="${pageContext.request.requestURI.endsWith('view/admin/user') ? 'active' : ''}">
                    <a href="/view/admin/user">
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

        <li class="nav-item ${pageContext.request.requestURI.endsWith('view/admin/product/list') ? 'active' : ''}">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#product-nav"
                    href="/view/admin/product/list"
            >
                <i class="bi bi-journal-text"></i><span>Sản phẩm</span
            ><i class="bi bi-chevron-right ms-auto"></i>
            </a>
        </li>
        <!-- End Forms Nav -->

        <li class="nav-item ${pageContext.request.requestURI.endsWith('view/admin/order/list') ? 'active' : ''}">
            <a
                    class="nav-link collapsed"
                    data-bs-target="#orders-nav"
                    href="/view/admin/order/list"
            >
                <i class="bi bi-layout-text-window-reverse"></i
                ><span>Đơn hàng</span
            ><i class="bi bi-chevron-right ms-auto"></i>
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
            ><i class="bi bi-chevron-right ms-auto"></i>
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

<style>
    .active {
        background-color: #fff;
        color: #4154f1;
        border-bottom: 2px solid #4154f1;
    }

    .nav-link i.bi-chevron-right,
    .nav-link i.bi-chevron-down {
        padding-right: 0 !important;
        margin-right: 0 !important;
    }

</style>
