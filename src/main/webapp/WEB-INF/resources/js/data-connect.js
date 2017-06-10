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

//清空新建设备数据接入
function clearDeviceDataConnectInfo() {
    $("#realtimeDataConnectIdentifier").val("");// reset realtimeDataConnectIdentifier
    $("#realtimeDataConnectComments").val("");// reset realtimeDataConnectComments
    $("#device-type-select-list ").val("请选择");    // 设置Select的Value值为"请选择"的项选中
}

//生成数据接入信息
function generateDataConnectInfo() {
    var realtimeDataConnectIdentifier = $("#realtimeDataConnectIdentifier").val();// get realtimeDataConnectIdentifier
    var realtimeDataConnectComments = $("#realtimeDataConnectComments").val();// get realtimeDataConnectComments
    if (realtimeDataConnectIdentifier == "") {
        alert("数据接入标识不能为空");
        return false;
    }
    if ($("#device-type-select-list option:selected").val() == "请选择") {
        alert("请选择设备类型");
        return false;
    }
    if (realtimeDataConnectComments == "") {
        alert("数据接入备注不能为空");
        return false;
    }
    var newDeviceDataConnectJsonObj = {};
    newDeviceDataConnectJsonObj.realtimeDataConnectionId = realtimeDataConnectIdentifier;
    newDeviceDataConnectJsonObj.deviceModelId = $("#device-type-select-list option:selected").val();
    newDeviceDataConnectJsonObj.realtimeDataConnectComments = realtimeDataConnectComments;
    $.ajax({
        url : "/data/createNewDeviceDataConnect",
        type : "post",
        dataType: "json",
        data:{"newDeviceDataConnect": JSON.stringify(newDeviceDataConnectJsonObj)},
        success : function(result) {
            if (result.bSuccess == 1) {
                //                alert(JSON.stringify(result));
                //JSON.stringify(jsObj): JS object ==> 转换为Json字符串
                //JSON.parse(jsonStr): Json String ==> 转换为Json对象
                alert("生成数据接入信息成功");
                clearDeviceDataConnectInfo();
                getDeviceConnectedApiTokenList();
            }
            else {
                alert("生成数据接入信息失败,请联系系统管理员");
            }
        },
        error : function(error) {
            alert("生成数据接入信息失败,请联系系统管理员");
        }
    });
}

function RealtimeRestApiEntry(id, entryComment, operation, restApiUrl) {
    this.id = id;//ID
    this.entryComment = entryComment;//Restful API
    this.operation = operation;//操作
    this.restApiUrl = restApiUrl;//Example
}

//获取设备接入API及Token列表
function getDeviceConnectedApiTokenList() {
    var emptyJsonObj = {};
    $.ajax({
        url : "/data/getDeviceConnectedApiTokenList",
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
                thead += "<th>ID</th><th>Restful API</th><th>操作</th><th>Example</th>";

                var table = "<table class=\"table table-hover\" id=\"apiTokenDataList\">"
                    +"<thead><tr>"
                    +thead
                    +"</tr></thead>"
                    +"<tbody></tbody>"
                    +"</table>";

                $("#api_token_list_result_div").html(table);

                //首先清理之前的表格数据
                var dataBefore = $("#api_token_list_result_div table tbody tr").length;
                if (dataBefore > 0) {
                    $('#apiTokenDataList').dataTable().fnDestroy();
                }
                var realtimeRestApiEntriesArray = result.realtimeDataConnectionInfo.realtimeRestApiEntries;
                var data = new Array(realtimeRestApiEntriesArray.length);
                $.each(realtimeRestApiEntriesArray, function(index, obj) {
                    //alert(index); 0, 1, 2
                    data[index] = new RealtimeRestApiEntry(obj.id, obj.entryComment, obj.operation, obj.restApiUrl);
                });

                $('#apiTokenDataList').dataTable({
                    data : data,
                    columns: [
                        { data: 'id',
                            "defaultContent": ""
                        },
                        { data: 'entryComment',
                            "defaultContent": ""
                        },
                        { data: 'operation',
                            "defaultContent": ""
                        },
                        { data: 'restApiUrl',
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
                alert("获取设备接入API及Token列表失败,请联系系统管理员");
            }
        },
        error : function(error) {
            alert("获取设备接入API及Token列表失败,请联系系统管理员");
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

function DetailAttr(id, entryComment, operation, restApiUrl, deviceModelId, deviceModelName, realtimeDataConnectionId, realtimeDataConnectionName) {
    this.id = id;
    this.entryComment = entryComment;
    this.operation = operation;
    this.restApiUrl = restApiUrl;
    this.deviceModelId = deviceModelId;
    this.deviceModelName = deviceModelName;
    this.realtimeDataConnectionId = realtimeDataConnectionId;
    this.realtimeDataConnectionName = realtimeDataConnectionName;
}

//显示实时数据接入列表--详情
function getReatimeDataConnectListItemDetails() {
    var emptyJsonObj = {};
    $.ajax({
        url : "/data/getReatimeDataConnectListItemDetails",
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
                thead += "<th>id</th><th>entryComment</th><th>operation</th><th>restApiUrl</th><th>deviceModelId</th><th>deviceModelName</th><th>realtimeDataConnectionId</th><th>realtimeDataConnectionName</th>";

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
                var realtimeRestApiEntriesArray = result.realtimeDataConnectionInfo.realtimeRestApiEntries;
                var data = new Array(realtimeRestApiEntriesArray.length);
                $.each(realtimeRestApiEntriesArray, function(index, obj) {
                    //alert(index); 0, 1, 2
                    data[index] = new DetailAttr(obj.id, obj.entryComment, obj.operation, obj.restApiUrl, obj.deviceModelId, obj.deviceModelName, obj.realtimeDataConnectionId, obj.realtimeDataConnectionName);
                });

                $('#detailsDataList').dataTable({
                    data : data,
                    columns: [
                        { data: 'id',
                            "defaultContent": ""
                        },
                        { data: 'entryComment',
                            "defaultContent": ""
                        },
                        { data: 'operation',
                            "defaultContent": ""
                        },
                        { data: 'restApiUrl',
                            "defaultContent": ""
                        },
                        { data: 'deviceModelId',
                            "defaultContent": ""
                        },
                        { data: 'deviceModelName',
                            "defaultContent": ""
                        },
                        { data: 'realtimeDataConnectionId',
                            "defaultContent": ""
                        },
                        { data: 'realtimeDataConnectionName',
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