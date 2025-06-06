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

<section class="vh-100 d-flex align-items-center justify-content-center bg-gradient-custom"
         style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Đăng ký</p>
                                
                                <% if (request.getAttribute("error") != null) { %>
                                    <div class="alert alert-danger" role="alert">
                                        <%= request.getAttribute("error") %>
                                    </div>
                                <% } %>
                                
                                <% if (request.getAttribute("success") != null) { %>
                                    <div class="alert alert-success" role="alert">
                                        <%= request.getAttribute("success") %>
                                    </div>
                                <% } %>
                                
                                <form class="mx-1 mx-md-4" action="${pageContext.request.contextPath}/view/register" method="POST">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="fullName">Họ tên</label>
                                            <input type="text" id="fullName" name="fullName" class="form-control"
                                                   placeholder="Nguyen Van A" required/>

                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="email">Email</label>
                                            <input type="email" id="email" name="email" class="form-control"
                                                   placeholder="abc@gmail.com" required/>

                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="password">Mật khẩu</label>
                                            <input type="password" id="password" name="password" class="form-control"
                                                   placeholder="*********" required/>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="confirmPassword">Nhập lại mật khẩu</label>
                                            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control"
                                                   placeholder="*********" required/>
                                        </div>
                                    </div>

                                    <div class="form-check d-flex justify-content-center mb-2">
                                        <input class="form-check-input me-2" type="checkbox" value=""
                                               id="form2Example3c" required/>
                                        <label class="form-check-label" for="form2Example3c">
                                            I agree all statements in <a href="#!">Terms of service</a>
                                        </label>
                                    </div>
                                    <div class="d-flex justify-content-center column-gap-3">
                                        <p>If you have an account?</p><a href="${pageContext.request.contextPath}/auth/login">Đăng nhập</a>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Đăng ký</button>
                                    </div>
                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="/image/bag.svg"
                                     class="img-custom" alt="Sample image">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

<style>
    .img-custom {
        width: 100% !important;
        height: auto !important;
        object-fit: contain !important; /* hoặc cover */
    }

    .bg-gradient-custom {
        background: linear-gradient(135deg, #b4e8de, #8a64eb);
        min-height: 100vh;
        width: 100%;
        color: white;
    }
    img{
        image-rendering: -webkit-optimize-contrast;
        image-rendering: crisp-edges;
    }
</style>
</html>