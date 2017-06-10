/**
 * Created by Zhao Zhifeng on 2016/10/19.
 */
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

//删除设备
function deleteDeviceModel(deviceModelId) {
    if (!confirm("确认要删除？")) {
        return false;
    }
    $.ajax({
        url : "/device/deleteDeviceModelById",
        type : "get",
        dataType: "json",
        data:{"deviceModelId": deviceModelId},
        success : function(result) {
            //{"responseId":10015,"bSuccess":1}
            if (result.bSuccess == 1) {
                alert("删除设备成功");
                //重新获取设备列表
                getDeviceList();
            }
            else {
                alert("删除设备失败,请联系系统管理员");
            }
        },
        error : function(error) {
            alert("删除设备失败,请联系系统管理员");
        }
    });
}

function Device(id, deviceModelName, deviceModelComments, deviceModelProperties, operation) {
    this.id = id;//设备编号
    this.deviceModelName = deviceModelName;//设备型号
    this.deviceModelComments = deviceModelComments;//备注
    this.deviceModelProperties = deviceModelProperties;//详情
    this.operation = operation;//操作
}

//获取设备列表
function getDeviceList() {
    var emptyJsonObj = {};
    $.ajax({
        url : "/device/getDeviceList",
        type : "get",
        dataType: "json",
        data:{"emptyJsonObj": JSON.stringify(emptyJsonObj)},
        success : function(result) {
            if (result.bSuccess == 1) {
                //                alert(JSON.stringify(result));
                //JSON.stringify(jsObj): JS object ==> 转换为Json字符串
                //JSON.parse(jsonStr): Json String ==> 转换为Json对象
                //根据不同的表,生成各自表字段的表头
                var thead = "";
                thead += "<th>设备编号</th><th>设备型号</th><th>备注</th><th>详情</th><th>操作</th>";

                var table = "<table class=\"table table-bordered table-striped\" id=\"dataList\">"
                    +"<thead><tr>"
                    +thead
                    +"</tr></thead>"
                    +"<tbody></tbody>"
                    +"</table>";

                $("#result_div").html(table);

                //首先清理之前的表格数据
                var dataBefore = $("#result_div table tbody tr").length;
                if (dataBefore > 0) {
                    $('#dataList').dataTable().fnDestroy();
                }
//                alert(result.deviceModels.length);
                var deviceModelArray = result.deviceModels;
                var data = new Array(result.deviceModels.length);
                $.each(deviceModelArray, function(index, obj) {
                    //alert(index); 0, 1, 2
                    data[index] = new Device(obj.id, obj.deviceModelName, obj.deviceModelComments, "<button type='button' class='btn btn-block btn-primary device_attribute_modal_link' onclick='showDeviceAttribute(\"" + obj.id + "\")'>设备属性</button>", "<button type='button' class='btn btn-block btn-danger' onclick='deleteDeviceModel(\"" + obj.id + "\")'>删除设备</button>");
                });

                $('#dataList').dataTable({
                    data : data,
                    columns: [
                        { data: 'id',
                            "defaultContent": ""
                        },
                        { data: 'deviceModelName',
                            "defaultContent": ""
                        },
                        { data: 'deviceModelComments',
                            "defaultContent": ""
                        },
                        { data: 'deviceModelProperties',
                            "defaultContent": ""
                        },
                        { data: 'operation',
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
            }
            else {
                alert("获取设备列表失败,请联系系统管理员");
            }
        },
        error : function(error) {
            //获取设备列表失败
            alert("获取设备列表失败,请联系系统管理员");
        }
    });
}

$(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false
    });

    getDeviceList();
});
