<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Dashboard - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon" />
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect" />
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
    <link
      href="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.snow.css"
      rel="stylesheet"
    />
    <link
      href="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.bubble.css"
      rel="stylesheet"
    />
    <link
      href="${pageContext.request.contextPath}/resources/assets/vendor/remixicon/remixicon.css"
      rel="stylesheet"
    />
    <link
      href="${pageContext.request.contextPath}/resources/assets/vendor/simple-datatables/style.css"
      rel="stylesheet"
    />

    <!-- Template Main CSS File -->
    <link
      href="${pageContext.request.contextPath}/resources/assets/css/style.css"
      rel="stylesheet"
    />

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
    <jsp:include page="header.jsp" />
    <!-- End Header -->

    <!-- ======= Sidebar ======= -->
    <jsp:include page="sidebar.jsp" />
    <!-- End Sidebar-->

    <main id="main" class="main">
      <div class="pagetitle d-flex justify-content-between">
        <h1>Dashboard</h1>
        <nav>
          <ol class="breadcrumb d-flex">
            <li class="breadcrumb-item ms-auto">
              <a href="index.html"><i class="bi bi-house"></i></a>
            </li>
            <li class="breadcrumb-item active">Dashboard</li>
          </ol>
        </nav>
      </div>
      <!-- End Page Title -->

      <section class="section dashboard">
        <div class="row">
          <!-- Left side columns -->
          <div class="col-lg-8">
            <div class="row">
              <!-- Total Products Card -->
              <div class="col-xxl-3 col-md-6">
                <div class="card info-card sales-card">
                  <div class="filter">
                    <a class="icon" href="#" data-bs-toggle="dropdown"
                      ><i class="bi bi-three-dots"></i
                    ></a>
                    <ul
                      class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                    >
                      <li class="dropdown-header text-start">
                        <h6>Filter</h6>
                      </li>

                      <li>
                        <a class="dropdown-item" href="#">Today</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Month</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Year</a>
                      </li>
                    </ul>
                  </div>

                  <div class="card-body">
                    <h5 class="card-title">Tổng sản phẩm</h5>

                    <div class="d-flex align-items-center">
                      <div
                        class="card-icon rounded-circle d-flex align-items-center justify-content-center"
                      >
                        <i class="bi bi-box"></i>
                      </div>
                      <div class="ps-3">
                        <h6>${summary.totalProducts}</h6>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Total Products Card -->

              <!-- Total Orders Card -->
              <div class="col-xxl-3 col-md-6">
                <div class="card info-card revenue-card">
                  <div class="filter">
                    <a class="icon" href="#" data-bs-toggle="dropdown"
                      ><i class="bi bi-three-dots"></i
                    ></a>
                    <ul
                      class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                    >
                      <li class="dropdown-header text-start">
                        <h6>Filter</h6>
                      </li>

                      <li>
                        <a class="dropdown-item" href="#">Today</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Month</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Year</a>
                      </li>
                    </ul>
                  </div>

                  <div class="card-body">
                    <h5 class="card-title">Tổng đơn hàng</h5>

                    <div class="d-flex align-items-center">
                      <div
                        class="card-icon rounded-circle d-flex align-items-center justify-content-center"
                      >
                        <i class="bi bi-cart"></i>
                      </div>
                      <div class="ps-3">
                        <h6>${summary.totalOrders}</h6>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Total Orders Card -->

              <!-- Total Revenue Card -->
              <div class="col-xxl-3 col-md-6">
                <div class="card info-card revenue-card">
                  <div class="filter">
                    <a class="icon" href="#" data-bs-toggle="dropdown"
                      ><i class="bi bi-three-dots"></i
                    ></a>
                    <ul
                      class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                    >
                      <li class="dropdown-header text-start">
                        <h6>Filter</h6>
                      </li>

                      <li>
                        <a class="dropdown-item" href="#">Today</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Month</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Year</a>
                      </li>
                    </ul>
                  </div>

                  <div class="card-body">
                    <h5 class="card-title">Tổng doanh thu</h5>

                    <div class="d-flex align-items-center">
                      <div
                        class="card-icon rounded-circle d-flex align-items-center justify-content-center"
                      >
                        <i class="bi bi-currency-dollar"></i>
                      </div>
                      <div class="ps-3">
                        <h6 style="font-size: 0.65em">
                          <fmt:formatNumber
                            value="${summary.totalRevenue}"
                            type="currency"
                            currencySymbol="₫"
                          />
                        </h6>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Total Revenue Card -->

              <!-- Total Customers Card -->
              <div class="col-xxl-3 col-md-6">
                <div class="card info-card customers-card">
                  <div class="filter">
                    <a class="icon" href="#" data-bs-toggle="dropdown"
                      ><i class="bi bi-three-dots"></i
                    ></a>
                    <ul
                      class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                    >
                      <li class="dropdown-header text-start">
                        <h6>Filter</h6>
                      </li>

                      <li>
                        <a class="dropdown-item" href="#">Today</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Month</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Year</a>
                      </li>
                    </ul>
                  </div>

                  <div class="card-body">
                    <h5 class="card-title">Tổng khách hàng</h5>

                    <div class="d-flex align-items-center">
                      <div
                        class="card-icon rounded-circle d-flex align-items-center justify-content-center"
                      >
                        <i class="bi bi-people"></i>
                      </div>
                      <div class="ps-3">
                        <h6>${summary.totalUsers}</h6>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Total Customers Card -->

              <!-- Reports -->
              <div class="col-12">
                <div class="card">
                  <div class="filter">
                    <a class="icon" href="#" data-bs-toggle="dropdown"
                      ><i class="bi bi-three-dots"></i
                    ></a>
                    <ul
                      class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                    >
                      <li class="dropdown-header text-start">
                        <h6>Filter</h6>
                      </li>

                      <li>
                        <a class="dropdown-item" href="#">Today</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Month</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">This Year</a>
                      </li>
                    </ul>
                  </div>

                  <div class="card-body">
                    <h5 class="card-title">
                      Thống kê doanh thu, đơn hàng, người dùng<span
                        >/Hôm nay</span
                      >
                    </h5>

                    <!-- Line Chart -->
                    <div
                      id="reportsChart"
                      style="max-height: 400px; min-height: 250px"
                    >
                      <canvas
                        id="reportsChartCanvas"
                        style="display: block; width: 100%; height: 100%"
                      ></canvas>
                    </div>

                    <script>
                      document.addEventListener("DOMContentLoaded", () => {
                        const canvas = document.querySelector(
                          "#reportsChartCanvas"
                        );
                        console.log("Reports Chart Canvas:", canvas);
                        console.log("Chart object:", typeof Chart);
                        if (canvas && typeof Chart !== "undefined") {
                          new Chart(canvas, {
                            type: "line",
                            data: {
                              labels: [
                                "00:00",
                                "00:05",
                                "00:10",
                                "00:15",
                                "00:20",
                                "00:25",
                                "00:30",
                                "00:35",
                              ],
                              datasets: [
                                {
                                  label: "Doanh thu",
                                  data: [65, 59, 80, 81, 56, 55, 40, 80],
                                  fill: true,
                                  borderColor: "rgb(75, 192, 192)",
                                  tension: 0.3,
                                },
                                {
                                  label: "Đơn hàng",
                                  data: [15, 20, 10, 18, 17, 12, 15, 20],
                                  fill: true,
                                  borderColor: "rgb(255, 99, 132)",
                                  tension: 0.3,
                                },
                                {
                                  label: "Người dùng",
                                  data: [5, 7, 6, 9, 8, 10, 7, 10],
                                  fill: true,
                                  borderColor: "rgb(54, 162, 235)",
                                  tension: 0.3,
                                },
                              ],
                            },
                            options: {
                              scales: {
                                y: {
                                  beginAtZero: true,
                                },
                              },
                            },
                          });
                        }
                      });
                    </script>
                    <!-- End Line Chart -->
                  </div>
                </div>
              </div>
              <!-- End Reports -->

              <!-- Top Selling Products -->
              <div class="col-12">
                <div class="card top-selling">
                  <div class="card-body pb-0">
                    <h5 class="card-title">
                      Sản phẩm bán chạy nhất<span>/Hôm nay</span>
                    </h5>

                    <table class="table table-borderless">
                      <thead>
                        <tr>
                          <th scope="col">#</th>
                          <th scope="col">Sản phẩm</th>
                          <th scope="col">Giá</th>
                          <th scope="col">Đã bán</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach
                          var="product"
                          items="${topSellingProducts}"
                          varStatus="loop"
                        >
                          <tr>
                            <th scope="row">
                              <a href="#">${loop.index + 1}</a>
                            </th>
                            <td>
                              <a href="#" class="text-primary fw-bold"
                                >${product.productName}</a
                              >
                            </td>
                            <td>
                              <fmt:formatNumber
                                value="${product.price}"
                                type="currency"
                                currencySymbol="₫"
                              />
                            </td>
                            <td class="fw-bold">${product.totalSold}</td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <!-- End Top Selling Products -->
            </div>
          </div>
          <!-- End Left side columns -->

          <!-- Right side columns -->
          <div class="col-lg-4">
            <!-- Recent Activity -->
            <div class="card">
              <div class="filter">
                <a class="icon" href="#" data-bs-toggle="dropdown"
                  ><i class="bi bi-three-dots"></i
                ></a>
                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li class="dropdown-header text-start">
                    <h6>Filter</h6>
                  </li>

                  <li>
                    <a class="dropdown-item" href="#">Today</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">This Month</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">This Year</a>
                  </li>
                </ul>
              </div>

              <div class="card-body">
                <h5 class="card-title">
                  Hoạt động gần đây <span>| Hôm nay</span>
                </h5>

                <div class="activity">
                  <div class="activity-item d-flex">
                    <div class="activite-label">32 min</div>
                    <i
                      class="bi bi-circle-fill activity-badge text-success align-self-start"
                    ></i>
                    <div class="activity-content">
                      Quia quae rerum
                      <a href="#" class="fw-bold text-dark"
                        >expedita officilis</a
                      >
                      beatae
                    </div>
                  </div>
                  <!-- End activity item-->

                  <div class="activity-item d-flex">
                    <div class="activite-label">2 hrs</div>
                    <i
                      class="bi bi-circle-fill activity-badge text-danger align-self-start"
                    ></i>
                    <div class="activity-content">
                      Voluptates corrupti molestias voluptatem
                    </div>
                  </div>
                  <!-- End activity item-->

                  <div class="activity-item d-flex">
                    <div class="activite-label">1 day</div>
                    <i
                      class="bi bi-circle-fill activity-badge text-primary align-self-start"
                    ></i>
                    <div class="activity-content">
                      Necessitatibus ipsum sit
                      <a href="#" class="fw-bold text-dark">dolor eum</a>
                      assumenda fuga
                    </div>
                  </div>
                  <!-- End activity item-->

                  <div class="activity-item d-flex">
                    <div class="activite-label">2 days</div>
                    <i
                      class="bi bi-circle-fill activity-badge text-info align-self-start"
                    ></i>
                    <div class="activity-content">
                      Aspernatur rerum perferendis et.
                    </div>
                  </div>
                  <!-- End activity item-->

                  <div class="activity-item d-flex">
                    <div class="activite-label">4 weeks</div>
                    <i
                      class="bi bi-circle-fill activity-badge text-warning align-self-start"
                    ></i>
                    <div class="activity-content">
                      Sit rerum enim excepteur debitis quas
                    </div>
                  </div>
                  <!-- End activity item-->
                </div>
              </div>
            </div>
            <!-- End Recent Activity -->

            <!-- Popular Products Chart -->
            <div class="card">
              <div class="filter">
                <a class="icon" href="#" data-bs-toggle="dropdown"
                  ><i class="bi bi-three-dots"></i
                ></a>
                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                  <li class="dropdown-header text-start">
                    <h6>Filter</h6>
                  </li>

                  <li>
                    <a class="dropdown-item" href="#">Today</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">This Month</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">This Year</a>
                  </li>
                </ul>
              </div>

              <div class="card-body pb-0">
                <h5 class="card-title">
                  Sản phẩm phổ biến <span>| Hôm nay</span>
                </h5>

                <div id="popularProductsChart" class="echart"></div>

                <script>
                  document.addEventListener("DOMContentLoaded", () => {
                    const topSellingProductsJson = "${topSellingProductsJson}";
                    let topSellingProducts = [];
                    if (
                      topSellingProductsJson &&
                      topSellingProductsJson !== ""
                    ) {
                      try {
                        topSellingProducts = JSON.parse(topSellingProductsJson);
                      } catch (e) {
                        console.error(
                          "Error parsing topSellingProductsJson:",
                          e
                        );
                      }
                    }
                    const productNames = topSellingProducts.map(
                      (p) => p.productName
                    );
                    const totalSolds = topSellingProducts.map(
                      (p) => p.totalSold
                    );

                    new Chart(document.querySelector("#popularProductsChart"), {
                      type: "pie",
                      data: {
                        labels: productNames,
                        datasets: [
                          {
                            label: "Số lượng đã bán",
                            data: totalSolds,
                            backgroundColor: [
                              "rgb(255, 99, 132)",
                              "rgb(54, 162, 235)",
                              "rgb(255, 205, 86)",
                              "rgb(75, 192, 192)",
                              "rgb(153, 102, 255)",
                              "rgb(255, 159, 64)",
                            ],
                            hoverOffset: 4,
                          },
                        ],
                      },
                      options: {
                        responsive: true,
                        plugins: {
                          legend: {
                            position: "top",
                          },
                          title: {
                            display: true,
                            text: "Sản phẩm phổ biến",
                          },
                        },
                      },
                    });
                  });
                </script>
              </div>
            </div>
            <!-- End Popular Products Chart -->
          </div>
          <!-- End Right side columns -->
        </div>
      </section>
    </main>
    <!-- End #main -->

    <!-- ======= Footer ======= -->
    <jsp:include page="footer.jsp" />
    <!-- End Footer -->

    <a
      href="#"
      class="back-to-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>

    <!-- Vendor JS Files -->
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/chart.js/chart.umd.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/quill/quill.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
  </body>
</html>
