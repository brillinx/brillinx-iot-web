/**
 * Created by Zhao Zhifeng on 2016/12/7.
 */
$(function () {
    //JSON.stringify(jsObj): JS object ==> 转换为Json字符串
    //JSON.parse(jsonStr): Json String ==> 转换为Json对象
    //#22get the performance value of a certain device instance
    getCertainDeviceInstancePerformanceValue();
    //#23get the key performance index of a certain device instance ( diagram)
    getCertainDeviceInstanceKeyPerformanceIndex();
    //#24get the device tracking information(diagram)
    getDeviceTrackingInformation();
});

//#22get the performance value of a certain device instance
function getCertainDeviceInstancePerformanceValue() {
    var emptyJsonObj = {};
    $.ajax({
        url: "/industryApp/deviceMonitorDetails",
        type: "post",
        dataType: "json",
        data:{"emptyJsonObj": JSON.stringify(emptyJsonObj)},
        success: function (result) {
            if (result.bSuccess == 1) {
                $(".info-box-number:eq(0)").text(result.devicePerformance.accumulateRunningHours + "小时");//set accumulateRunningHours
                $(".info-box-number:eq(1)").text(result.devicePerformance.batteryFullPercentage + "%");//set batteryFullPercentage
                $(".info-box-number:eq(2)").text(result.devicePerformance.latestCommunicateTime);//set latestCommunicateTime
                $(".info-box-number:eq(3)").text(result.devicePerformance.deviceHealthScore);//set deviceHealthScore
            }
            else {
                alert("get the performance value of a certain device instance failure");
            }
        },
        error: function (error) {
            alert("get the performance value of a certain device instance failure");
        }
    });
}

//#23get the key performance index of a certain device instance ( diagram)
function getCertainDeviceInstanceKeyPerformanceIndex() {
    var emptyJsonObj = {};
    $.ajax({
        url: "/industryApp/keyPerformanceIndex",
        type: "post",
        dataType: "json",
        data:{"emptyJsonObj": JSON.stringify(emptyJsonObj)},
        success: function (result) {
            if (result.bSuccess == 1) {
                console.log(JSON.stringify(result));
            }
            else {
                alert("get the key performance index of a certain device instance ( diagram) failure");
            }
        },
        error: function (error) {
            alert("get the key performance index of a certain device instance ( diagram) failure");
        }
    });
}

//#24get the device tracking information(diagram)
function getDeviceTrackingInformation() {
    var emptyJsonObj = {};
    $.ajax({
        url: "/industryApp/deviceTrackingInformation",
        type: "post",
        dataType: "json",
        data:{"emptyJsonObj": JSON.stringify(emptyJsonObj)},
        success: function (result) {
            if (result.bSuccess == 1) {
                console.log(JSON.stringify(result));
            }
            else {
                alert("get the device tracking information(diagram) failure");
            }
        },
        error: function (error) {
            alert("get the device tracking information(diagram) failure");
        }
    });
}







