/**
 * Created by Zhao Zhifeng on 2016/10/3.
 */
function addDeviceAttr(attributeName, desc) {
    //alert(attributeName + "" + desc);
    if (attributeName == "") {
        alert("属性名不能为空");
        return false;
    }
    if (desc == "") {
        alert("含义不能为空");
        return false;
    }
    $("#deviceAttrList").append(
                                '<div class="row">' +
                                    '<div class="col-xs-3">' +
                                        '<input type="text" class="form-control" placeholder="' + attributeName + '">' +
                                    '</div>' +
                                    '<div class="col-xs-3">' +
                                        '<input type="text" class="form-control" placeholder="' + desc + '">' +
                                    '</div>' +
                                    '<div class="col-xs-2">' +
                                        '<button type="button" class="btn btn-block btn-success">查看取值范围</button>' +
                                    '</div>' +
                                    '<div class="col-xs-2">' +
                                        '<button type="button" class="btn btn-block btn-danger" onclick="deleteDeviceAttrItem(this)">删除</button>' +
                                    '</div>' +
                                '</div>'
                                )
    //清除"增加设备属性"中的属性名、含义
    $("#attribute").val("");//clear attribute
    $("#description").val("");//clear description
}

function deleteDeviceAttrItem(obj) {
    if (!confirm("确认要删除？")) {
        return false;
    }
    $(obj).parent().parent().remove();
}

function submitDeviceAttrList() {
    var deviceModelJsonObj = {};
    var deviceModelName = $("#deviceModelName").val();// get deviceModelName
    var deviceModelComments = $("#deviceModelComments").val();// get deviceModelComments
    if (deviceModelName == "") {
        alert("设备型号不能为空");
        return false;
    }
    if (deviceModelComments == "") {
        alert("设备备注不能为空");
        return false;
    }
    deviceModelJsonObj.deviceModelName = deviceModelName;
    deviceModelJsonObj.deviceModelComments = deviceModelComments;
    deviceModelJsonObj.deviceModelProperties = [];
    var rowArray = $('#deviceAttrList .row');
    //alert(rowArray.length);
    //传递HTML文本字符串给$()方法，jQuery根据传入的文本创建好HTML元素并封装为jQuery对象返回
    //根据HTML文本字符串创建HTML元素并封装为jQuery对象返回
    $.each(rowArray, function(index){
        //alert($(this).html());
        //alert($(this).find("input").length);
        //alert(typeof $(this).find("input")[0]);
        //HTML元素($(this).find("input")[0])封装为jQuery对象以便调用jquery方法
        var currentDeviceAttrName = $($(this).find("input")[0]).attr("placeholder");
        var currentDeviceAttrDesc = $($(this).find("input")[1]).attr("placeholder");
        //key--设备属性名称, value--设备属性含义/描述
        var tmpDeviceAttrJsonObj = {};
        tmpDeviceAttrJsonObj.seqNo = index + 1;
        tmpDeviceAttrJsonObj.propertyName = currentDeviceAttrName;
        tmpDeviceAttrJsonObj.propertyComments = currentDeviceAttrDesc;
        deviceModelJsonObj.deviceModelProperties.push(tmpDeviceAttrJsonObj);
    });
    //将JS对象转化为JSON字符串
    //alert(JSON.stringify(deviceModelJsonObj));
    //convert HTML Element into jQuery object in order to use jQuery method
    //$(rowAttributeArray[i]).attr("id") is Json Object id: 从1970.1.1开始的毫秒数
    $.ajax({
        url: "/device/submitDeviceAttrList",
        type: "post",
        dataType: "json",
        data:{"currentDeviceModel": JSON.stringify(deviceModelJsonObj)},
        success: function (result) {
            if (result.bSuccess == 1) {
                alert("设备注册成功，转到设备管理页面");
                $("#deviceModelName").val("");// clear deviceModelName
                $("#deviceModelComments").val("");// clear deviceModelComments
                $("#attribute").val("");//clear attribute
                $("#description").val("");//clear description
                $("#deviceAttrList").empty();//clear deviceAttrList
                window.location.href = "/devicelist";
            }
            else {
                alert("设备注册失败,请联系系统管理员");
            }
        },
        error: function (error) {
            //设备注册失败
            alert("设备注册失败,请联系系统管理员");
        }
    });



}