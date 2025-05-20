<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navbar Start -->
<div class="container-fluid mb-5">
    <div class="row border-top px-xl-5">

        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                <a href="" class="text-decoration-none d-block d-lg-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span
                            class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0">
                        <a href="/homepage" class="nav-item nav-link active">Home</a>
                        <a href="/shop" class="nav-item nav-link">Shop</a>
                        <a href="/detail" class="nav-item nav-link">Shop Detail</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="cart.jsp" class="dropdown-item">Shopping Cart</a>
                                <a href="/checkout" class="dropdown-item">Checkout</a>
                            </div>
                        </div>
                        <a href="/contact" class="nav-item nav-link">Contact</a>
                    </div>
                    <div class="navbar-nav ml-auto py-0">
                        <sec:authorize access="!isAuthenticated()">
                            <a href="${pageContext.request.contextPath}/view/auth/login" class="nav-item nav-link">Login</a>
                            <a href="${pageContext.request.contextPath}/view/auth/register" class="nav-item nav-link">Register</a>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <span class="nav-item nav-link">Hello, ${username}</span>
                            <form action="${pageContext.request.contextPath}/logout" method="post" style="display: inline;">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" class="nav-item nav-link" style="background: none; border: none;">Logout</button>
                            </form>
                        </sec:authorize>
                    </div>
                </div>
            </nav>
            <div id="header-carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active" style="height: 510px;">
                        <img class="img-fluid" src="${pageContext.request.contextPath}/eshopper/img/carousel-1.jpg"
                             alt="Image">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 700px;">
                                <h4 class="text-light text-uppercase font-weight-medium mb-3">10% Off Your First
                                    Order</h4>
                                <h3 class="display-4 text-white font-weight-semi-bold mb-4">Fashionable Dress</h3>
                                <a href="" class="btn btn-light py-2 px-3">Shop Now</a>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item" style="height: 510px;">
                        <img class="img-fluid" src="${pageContext.request.contextPath}/eshopper/img/carousel-2.jpg"
                             alt="Image">
                        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                            <div class="p-3" style="max-width: 700px;">
                                <h4 class="text-light text-uppercase font-weight-medium mb-3">10% Off Your First
                                    Order</h4>
                                <h3 class="display-4 text-white font-weight-semi-bold mb-4">Reasonable Price</h3>
                                <a href="" class="btn btn-light py-2 px-3">Shop Now</a>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
                    <div class="btn btn-dark" style="width: 45px; height: 45px;">
                        <span class="carousel-control-prev-icon mb-n2"></span>
                    </div>
                </a>
                <a class="carousel-control-next" href="#header-carousel" data-slide="next">
                    <div class="btn btn-dark" style="width: 45px; height: 45px;">
                        <span class="carousel-control-next-icon mb-n2"></span>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
<!-- Navbar End -->