/**
 * Created by Zhao Zhifeng on 2016/10/18.
 */
$(function () {
    //getDeviceConnectedApiTokenList();
    getDeviceTypeSelectList();
});

//生成设备类型下拉列表
function getDeviceTypeSelectList() {
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
                var deviceModelArray = result.deviceModels;
                $("#device-type-select-list").append("<option value='请选择'>请选择</option>");   //为Select追加一个Option("请选择"下拉项)
                $.each(deviceModelArray, function(index, obj) {
                    //alert(index); 0, 1, 2
                    //data[index] = new Device(obj.id, obj.deviceModelName, obj.deviceModelComments);
                    $("#device-type-select-list").append("<option value='" + obj.id + "'>" + obj.deviceModelName + "</option>");   //为Select追加一个Option(下拉项)
                });
            }
            else {
                alert("获取设备类型下拉列表失败,请联系系统管理员");
            }
        },
        error : function(error) {
            alert("获取设备类型下拉列表失败,请联系系统管理员");
        }
    });
}

function showDeviceInfoConfig() {
    if ($("#device-type-select-list option:selected").val() == "请选择") {
        alert("请选择设备类型");
        return false;
    }
    showDeviceAttribute( $('#device-type-select-list option:selected').val() );//parameter deviceModelId
}

//取消    新建批量数据接入
function cancelCreateBatchDataConnect() {
    $("#batchDataConnectIdentifier").val("");// reset batchDataConnectIdentifier
    $("#device-type-select-list").val("请选择");    // 设置Select的Value值为"请选择"的项选中
    if ($('#filename').val().length != 0) {//file has been uploaded
        $.ajax({
            url:"/data/deleteUploadedFile",
            type : "POST",
            data:{fileName:$("#filename").val()},
            success:function(result) {
                if (result == "success") {
                    $('#filename').val("");
                }
                else {
                    alert("已上传文件删除失败");
                }
            }
        });
    }
    $("#batchDataConnectComments").val("");// reset batchDataConnectComments
}

//提交    新建批量数据接入
function submitCreateBatchDataConnect() {
    var batchDataConnectIdentifier = $("#batchDataConnectIdentifier").val();// get batchDataConnectIdentifier
    var uploadFileName = $("#filename").val();// get filename
    var batchDataConnectComments = $("#batchDataConnectComments").val();// get batchDataConnectComments
    if (batchDataConnectIdentifier == "") {
        alert("批量数据接入标识不能为空");
        return false;
    }
    if ($("#device-type-select-list option:selected").val() == "请选择") {
        alert("请选择设备类型");
        return false;
    }
    if (uploadFileName == "") {
        alert("请选择数据文件");
        return false;
    }
    if (batchDataConnectComments == "") {
        alert("批量数据接入备注不能为空");
        return false;
    }
    var newCreateBatchDataConnectJsonObj = {};
    newCreateBatchDataConnectJsonObj.batchDataConnectionId = batchDataConnectIdentifier;
    newCreateBatchDataConnectJsonObj.deviceModelId = $("#device-type-select-list option:selected").val();
    newCreateBatchDataConnectJsonObj.uploadFileName = uploadFileName;
    newCreateBatchDataConnectJsonObj.batchDataConnectComments = batchDataConnectComments;
    $.ajax({
        url : "/data/newCreateBatchDataConnect",
        type : "post",
        dataType: "json",
        data:{"newCreateBatchDataConnect": JSON.stringify(newCreateBatchDataConnectJsonObj)},
        success : function(result) {
            if (result.bSuccess == 1) {
                //                alert(JSON.stringify(result));
                //JSON.stringify(jsObj): JS object ==> 转换为Json字符串
                //JSON.parse(jsonStr): Json String ==> 转换为Json对象
                alert("新建批量数据接入成功");
                $("#batchDataConnectIdentifier").val("");// reset batchDataConnectIdentifier
                $("#device-type-select-list").val("请选择");    // 设置Select的Value值为"请选择"的项选中
                $('#filename').val("");                 //reset filename
                $("#batchDataConnectComments").val("");// reset batchDataConnectComments
            }
            else {
                alert("新建批量数据接入失败,请联系系统管理员");
            }
        },
        error : function(error) {
            alert("新建批量数据接入失败,请联系系统管理员");
        }
    });
}

// Dialog message
$("#details-dialog-message").dialog({
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

function DetailAttr(id, batchDataConnectionName, deviceModelId, batchDataConnectionComments, status) {
    this.id = id;
    this.batchDataConnectionName = batchDataConnectionName;
    this.deviceModelId = deviceModelId;
    this.batchDataConnectionComments = batchDataConnectionComments;
    this.status = status;
}

//显示批量数据接入列表--详情
function getBatchDataConnectListItemDetails() {
    var emptyJsonObj = {};
    $.ajax({
        url : "/data/getBatchDataConnectListItemDetails",
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
                thead += "<th>id</th><th>batchDataConnectionName</th><th>deviceModelId</th><th>batchDataConnectionComments</th><th>status</th>";

                var table = "<table class=\"table table-bordered table-striped\" id=\"detailsDataList\">"
                    +"<thead><tr>"
                    +thead
                    +"</tr></thead>"
                    +"<tbody></tbody>"
                    +"</table>";

                $("#details_result_div").html(table);

                //首先清理之前的表格数据
                var dataBefore = $("#details_result_div table tbody tr").length;
                if (dataBefore > 0) {
                    $('#detailsDataList').dataTable().fnDestroy();
                }
                var obj = result.batchDataConnection;
/*                var data = new Array(realtimeRestApiEntriesArray.length);
                $.each(realtimeRestApiEntriesArray, function(index, obj) {
                    //alert(index); 0, 1, 2
                    data[index] = new DetailAttr(obj.id, obj.entryComment, obj.operation, obj.restApiUrl, obj.deviceModelId, obj.deviceModelName, obj.realtimeDataConnectionId, obj.realtimeDataConnectionName);
                });*/
                var data = new Array();
                data[0] = new DetailAttr(obj.id, obj.batchDataConnectionName, obj.deviceModelId, obj.batchDataConnectionComments, obj.status);
                $('#detailsDataList').dataTable({
                    data : data,
                    columns: [
                        { data: 'id',
                            "defaultContent": ""
                        },
                        { data: 'batchDataConnectionName',
                            "defaultContent": ""
                        },
                        { data: 'deviceModelId',
                            "defaultContent": ""
                        },
                        { data: 'batchDataConnectionComments',
                            "defaultContent": ""
                        },
                        { data: 'status',
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

                $('#details-dialog-message').dialog('open');
            }
            else {
                alert("获取详情失败,请联系系统管理员");
            }
        },
        error : function(error) {
            alert("获取详情失败,请联系系统管理员");
        }
    });
}
