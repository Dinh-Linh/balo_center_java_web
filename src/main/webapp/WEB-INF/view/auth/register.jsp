<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/bootstrap/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/template/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/bootstrap/css/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
          integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <title>Register</title>
</head>
<body>
<!-- Header -->
<header class="bg-white shadow-sm" style="background-color: #eee">
    <div class="container py-3">
        <div class="d-flex align-items-center justify-content-between">
            <!-- Logo -->
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/resources/image/logo.png" alt="Logo" style="height: 50px;">
            </a>

            <!-- Search Bar -->
            <div class="flex-grow-1 mx-4 p-2">
                <div class="input-group">
                    <input type="text" class="form-control p-2" placeholder="Searching..." >
                    <button class="btn btn-primary" type="button">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>

            <!-- Account & Cart -->
            <div class="d-flex align-items-center">
                <a href="#" class="text-dark me-4 text-decoration-none">
                    <i class="fas fa-user fa-lg"></i>Account
                </a>
                <a href="#" class="text-dark text-decoration-none">
                    <i class="fas fa-shopping-cart fa-lg"></i>Cart
                </a>
            </div>
        </div>
    </div>

    <!-- Line dưới header -->
    <hr class="m-0 w-75 center">
</header>
<section class="vh-100 d-flex align-items-center justify-content-center" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>
                                <form class="mx-1 mx-md-4">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="form3Example1c">Your Name</label>
                                            <input type="text" id="form3Example1c" class="form-control" placeholder="Nguyen Van A"/>

                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="form3Example3c">Your Email</label>
                                            <input type="email" id="form3Example3c" class="form-control" placeholder="abc@gmail.com"/>

                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="form3Example4c">Your Password</label>
                                            <input type="password" id="form3Example4c" class="form-control" placeholder="*********"/>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="form3Example4cd">Repeat your password</label>
                                            <input type="password" id="form3Example4cd" class="form-control" placeholder="*********"/>
                                        </div>
                                    </div>

                                    <div class="form-check d-flex justify-content-center mb-2">
                                        <input class="form-check-input me-2" type="checkbox" value=""
                                               id="form2Example3c"/>
                                        <label class="form-check-label" for="form2Example3c">
                                            I agree all statements in <a href="#!">Terms of service</a>
                                        </label>
                                    </div>
                                    <div class="d-flex justify-content-center column-gap-3">
                                        <p>If you have an account?</p><a href="login.jsp">Login</a>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="button" data-mdb-button-init data-mdb-ripple-init
                                                class="btn btn-primary btn-lg">Register
                                        </button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>