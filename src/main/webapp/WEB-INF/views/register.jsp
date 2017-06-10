<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/27/027
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>BrillinX | 新用户注册</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="../../index.html"><b>BrillinX</b></a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">新用户注册</p>

        <form action="#">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" id="username" placeholder="用户名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="email" class="form-control" id="email" placeholder="邮箱(作为登录名)">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="password" placeholder="请输入密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="password2" placeholder="请再输入一次密码">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> 我同意 <a href="#">用户协议</a>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="button" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>



        <a href="/" class="text-center">已有账号？></a>
        <br><br>
        Copyright &copy; 2016 <a href="http://www.creatoland.com">CreatoLand</a>. All rights
        reserved.
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.0 -->
<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="resources/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        $(document).ready(function(){
            $('button[type=button]').on('click',function(){
                var username = $('#username').val();
                var password = $('#password').val();
                var email = $('#email').val();
                var password2 = $('#password2').val();

                if(password != password2){
                    alert("两次输入密码不正确，请重新输入！");
                    return;
                }

                $.ajax({
                    type:'post',
                    url:'/register',
                    data:{username:username,password:password,email:email},
                    cache:false,
                    dataType:'json',
                    success:function(data){
                        if (data == 1) {
                            alert("恭喜你，注册创建成功，关闭对话框跳转登录页面！");
                            window.location.href = "<?php echo base_url(); ?>";
                        }
                    },
                    error:function(){
                        window.location.href = "/";
                    }
                });
            });
        });
    });
</script>
</body>
</html>

