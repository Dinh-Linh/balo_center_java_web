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
            background: url('/path/to/image.jpg') center center;
            background-size: cover;
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
                                    <h1 class="h4 text-gray-800 mb-4">Welcome back</h1>
                                </div>
                                <form class="user">
                                    <div class="form-group">
                                        <label for="inputEmail">Email</label>
                                        <input type="email" class="form-control form-control-user"
                                               id="inputEmail" aria-describedby="emailHelp"
                                               placeholder="Enter your email...">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword">Password</label>
                                        <input type="password" class="form-control form-control-user"
                                               id="inputPassword" placeholder="Enter your password...">
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input" id="customCheckBox">
                                            <label class="custom-control-label ml-2" for="customCheckBox">Remember me</label>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-user btn-block">Login</button>
                                </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="#">Forgot Password?</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="register.jsp">Create an Account!</a>
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
