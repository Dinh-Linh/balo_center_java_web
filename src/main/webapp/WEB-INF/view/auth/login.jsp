<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/template/bootstrap/css/bootstrap.min.css">
    <script src="/template/bootstrap/js/bootstrap.bundle.min.js"></script>
    <title>Login</title>
    <style>
        .bg-login-image {
            background: url('https://static-00.iconduck.com/assets.00/login-icon-2048x2048-cafqaoiq.png') center center;
            background-size: 50% 50%;
            background-repeat: no-repeat;
        }

        form.user * {
            margin: 3px;
            padding: 3px;
            box-sizing: border-box;
        }
    </style>
</head>
<body class="bg-gradient-primary">
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-xl-10 col-lg-12 col-md-9">
            <div class="card shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-800 mb-4">Chào mừng trở lại</h1>
                                </div>
                                <form class="user" action="/login" method="post">
                                    <div class="form-group">
                                        <label for="inputEmail">Email</label>
                                        <input type="email" class="form-control form-control-user"
                                               name="email" id="inputEmail" aria-describedby="emailHelp"
                                               placeholder="Nhập email của bạn...">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword">Mật khẩu</label>
                                        <input type="password" class="form-control form-control-user"
                                               name="password" id="inputPassword" placeholder="Nhập mật khẩu của bạn...">
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input" id="customCheckBox">
                                            <label class="custom-control-label ml-2" for="customCheckBox">Nhớ mật khẩu</label>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-user btn-block mx-auto d-block">Login</button>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="#">Quên mật khẩu?</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="register.jsp">Tạo tài khoản mới!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
