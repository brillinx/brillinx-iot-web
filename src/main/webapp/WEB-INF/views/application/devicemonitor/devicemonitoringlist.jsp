<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/27/027
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>BrillinX | 设备监控列表</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="resources/plugins/datatables/dataTables.bootstrap.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css">

    <!-- jquery ui css -->
    <link rel="stylesheet" href="resources/plugins/code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!-- ADD THE CLASS fixed TO GET A FIXED HEADER AND SIDEBAR LAYOUT -->
<!-- the fixed layout is not compatible with sidebar-mini -->
<body class="hold-transition skin-blue fixed sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="/index" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>BrillinX</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>BrillinX</b></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 4 messages</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                Support Team
                                                <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                    <!-- end message -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul>
                    </li>
                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 10 notifications</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">View all</a></li>
                        </ul>
                    </li>
                    <!-- Tasks: style can be found in dropdown.less -->
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">You have 9 tasks</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- Task item -->
                                        <a href="#">
                                            <h3>
                                                Design some buttons
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">View all tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">Kalas</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                    Kalas - Web Developer
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- =============================================== -->

    <!-- Left side column. contains the sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>Kalas</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">导航</li>
                <li>
                    <a href="/index">
                        <i class="fa fa-th"></i> <span>物联网平台概览</span>
                        <small class="label pull-right bg-green">new</small>
                    </a>
                </li>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-files-o"></i>
                        <span>设备管理</span>
                        <span class="label label-primary pull-right">2</span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/devicereg"><i class="fa fa-circle-o"></i> 设备注册</a></li>
                        <li><a href="/devicelist"><i class="fa fa-circle-o"></i> 设备管理</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-files-o"></i>
                        <span>数据接入</span>
                        <span class="label label-primary pull-right">2</span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/realtimedataconnect"><i class="fa fa-circle-o"></i> 实时数据接入</a></li>
                        <li><a href="/batchdataconnect"><i class="fa fa-circle-o"></i> 批量数据接入</a></li>
                    </ul>
                </li>

                <li>
                    <a href="/services">
                        <i class="fa fa-th"></i> <span>通用服务</span>
                        <small class="label pull-right bg-green">new</small>
                    </a>
                </li>
                <li class="active">
                    <a href="/applications">
                        <i class="fa fa-th"></i> <span>行业应用</span>
                        <small class="label pull-right bg-green">new</small>
                    </a>
                </li>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>用户中心</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="http://www.99houjie.com"><i class="fa fa-circle-o"></i> 用户论坛</a></li>
                        <li><a href="http://www.99houjie.com/forum.php?mod=forumdisplay&fid=40"><i class="fa fa-circle-o"></i> 使用手册</a></li>
                        <li><a href="http://www.99houjie.com/forum.php?mod=forumdisplay&fid=41"><i class="fa fa-circle-o"></i> 相关协议</a></li>
                    </ul>
                </li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- =============================================== -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                设备监控列表
                <small>设备监控</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">行业应用</a></li>
                <li><a href="#">智能设备应用</a></li>
                <li><a href="#">设备监控</a></li>
                <li class="active">设备监控列表</li>

            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="callout callout-info">
                <h4>说明</h4>

                <p>设备监控列表.</p>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">设备列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">

                            <table id="dataList" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>设备编号</th>
                                    <th>设备型号</th>
                                    <th>备注</th>
                                    <th>详情</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="deviceMonitorItem" items="${deviceMonitorList}">
                                        <tr>
                                            <td>${deviceMonitorItem.deviceModelId}</td>
                                            <td>${deviceMonitorItem.devceiModelName}</td>
                                            <td>相关介绍</td>
                                            <td>
                                                <button type="button" class="btn btn-block btn-primary" onclick="showDeviceAttribute('${deviceMonitorItem.id}')">设备属性</button>
                                            </td>
                                            <td>
                                                <a href="/devicemonitoringview"><button type="button" class="btn btn-block btn-danger">查看监控</button></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
<%--                                <tr>
                                    <td>ASFEFSFFSF</td>
                                    <td>B型
                                    </td>
                                    <td>相关介绍</td>
                                    <td>
                                        <button type="button" class="btn btn-block btn-primary">设备属性</button>
                                    </td>
                                    <td>
                                        <a href="devicemonitoringview"><button type="button" class="btn btn-block btn-danger">查看监控</button></a>
                                    </td>
                                </tr>--%>

                                </tbody>
<%--                                <tfoot>
                                <tr>
                                    <th>设备编号</th>
                                    <th>设备型号</th>
                                    <th>备注</th>
                                    <th>详情</th>
                                    <th>操作</th>
                                </tr>
                                </tfoot>--%>
                            </table>

                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->



        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.1
        </div>
        <strong>Copyright &copy; 2016 <a href="http://www.creatoland.com">CreatoLand</a>.</strong> All rights
        reserved.
    </footer>


    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript::;">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript::;">
                            <i class="menu-icon fa fa-user bg-yellow"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                                <p>New phone +1(800)555-1234</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript::;">
                            <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                                <p>nora@example.com</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript::;">
                            <i class="menu-icon fa fa-file-code-o bg-green"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                                <p>Execution time 5 seconds</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript::;">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="label label-danger pull-right">70%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript::;">
                            <h4 class="control-sidebar-subheading">
                                Update Resume
                                <span class="label label-success pull-right">95%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript::;">
                            <h4 class="control-sidebar-subheading">
                                Laravel Integration
                                <span class="label label-warning pull-right">50%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript::;">
                            <h4 class="control-sidebar-subheading">
                                Back End Framework
                                <span class="label label-primary pull-right">68%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Some information about this general settings option
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Allow mail redirect
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Other sets of options are available
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Expose author name in posts
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Allow the user to show his name in blog posts
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <h3 class="control-sidebar-heading">Chat Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Show me as online
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Turn off notifications
                            <input type="checkbox" class="pull-right">
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Delete chat history
                            <a href="javascript::;" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                        </label>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!--static dialog-->
<div id="device-attribute-dialog-message" title="设备属性">
    <div class="box">
        <div class="box-header">
            <h3 class="box-title">Data Table With Full Features</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body" id="device_attr_result_div">
        </div>
        <!-- /.box-body -->
    </div>
    <!-- /.box -->
</div>
<!--end static dialog-->

<!-- jQuery 2.2.0 -->
<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resources/dist/js/demo.js"></script>
<!-- jquery ui js -->
<script src="resources/plugins/code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- page script -->
<script>
    // Dialog message
    $("#device-attribute-dialog-message").dialog({
        height: 300,
        width: 810,
        resizable: false,
        autoOpen: false,
        modal: true,
        buttons: {
            Ok: function () {
                $(this).dialog("close");
            }
        }
    });

    function DeviceAttr(id, seqNo, deviceModelId, propertyName, propertyComments, propertyValueRangeId) {
        this.id = id;
        this.seqNo = seqNo;
        this.deviceModelId = deviceModelId;
        this.propertyName = propertyName;
        this.propertyComments = propertyComments;
        this.propertyValueRangeId = propertyValueRangeId;
    }

    //显示设备属性
    function showDeviceAttribute(deviceModelId) {
        $.ajax({
            url : "/device/getDeviceModelAttributeById",
            type : "get",
            dataType: "json",
            data:{"deviceModelId": deviceModelId},
            success : function(result) {
                if (result.bSuccess == 1) {
                    //                alert(JSON.stringify(result));
                    //JSON.stringify(jsObj): JS object ==> 转换为Json字符串
                    //JSON.parse(jsonStr): Json String ==> 转换为Json对象
                    /*$('#device-attribute-dialog-message').empty();
                     var deviceModelPropertiesArray = result.deviceModel.deviceModelProperties;
                     for (var i = 0; i < deviceModelPropertiesArray.length; i++) {
                     $("#device-attribute-dialog-message").append("<p>" + JSON.stringify(deviceModelPropertiesArray[i]) + "</p><br/>"); // Add content at end of the #log element
                     }*/

                    //根据不同的表,生成各自表字段的表头
                    var thead = "";
                    thead += "<th>id</th><th>seqNo</th><th>deviceModelId</th><th>propertyName</th><th>propertyComments</th><th>propertyValueRangeId</th>";

                    var table = "<table class=\"table table-bordered table-striped\" id=\"deviceAttrDataList\">"
                        +"<thead><tr>"
                        +thead
                        +"</tr></thead>"
                        +"<tbody></tbody>"
                        +"</table>";

                    $("#device_attr_result_div").html(table);

                    //首先清理之前的表格数据
                    var dataBefore = $("#device_attr_result_div table tbody tr").length;
                    if (dataBefore > 0) {
                        $('#deviceAttrDataList').dataTable().fnDestroy();
                    }
                    var deviceModelPropertiesArray = result.deviceModel.deviceModelProperties;
                    var data = new Array(deviceModelPropertiesArray.length);
                    $.each(deviceModelPropertiesArray, function(index, obj) {
                        //alert(index); 0, 1, 2
                        data[index] = new DeviceAttr(obj.id, obj.seqNo, obj.deviceModelId, obj.propertyName, obj.propertyComments, obj.propertyValueRangeId);
                    });

//                    $("#deviceAttrDataList").DataTable();
                    $('#deviceAttrDataList').dataTable({
                        data : data,
                        columns: [
                            { data: 'id',
                                "defaultContent": ""
                            },
                            { data: 'seqNo',
                                "defaultContent": ""
                            },
                            { data: 'deviceModelId',
                                "defaultContent": ""
                            },
                            { data: 'propertyName',
                                "defaultContent": ""
                            },
                            { data: 'propertyComments',
                                "defaultContent": ""
                            },
                            { data: 'propertyValueRangeId',
                                "defaultContent": ""
                            }
                        ],
                        "destroy" : true,
                        "deferRender" : true,//懒加载
                        "scrollY" : "350px",
                        "scrollCollapse" : true,
                        "lengthChange" : true,
                        "lengthMenu" : [ 10, 25,
                            50, 100],//每页展示数量选项
                        language : {//国际化
                            "sProcessing" : "处理中...",
                            "sLengthMenu" : "每页显示 _MENU_ 项数据",
                            "sZeroRecords" : "没有匹配的数据",
                            "sInfo" : "显示第 _START_ 至 _END_ 项数据，共 _TOTAL_ 项",
                            "sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
                            "sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
                            "sInfoPostFix" : "",
                            "sSearch" : "搜索:",
                            "sEmptyTable" : "暂无数据",
                            "sLoadingRecords" : "载入中...",
                            "sInfoThousands" : ",",
                            "oPaginate" : {
                                "sFirst" : "首页",
                                "sPrevious" : "上页",
                                "sNext" : "下页",
                                "sLast" : "末页"
                            }
                        }
                    });

                    $('#device-attribute-dialog-message').dialog('open');
                }
                else {
                    alert("获取设备属性失败,请联系系统管理员");
                }
            },
            error : function(error) {
                alert("获取设备属性失败,请联系系统管理员");
            }
        });
    }
</script>
</body>
</html>
