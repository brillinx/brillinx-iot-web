package com.iot.brillinx.restapi;

/**
 * Created by Zhao Zhifeng on 2016/10/18.
 */
public class IndustryApplicationApi {
    //#21get all device instances
    public static String deviceMonitorListUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/device.json";
    }

    //#22get the performance value of a certain device instance
    public static String certainDeviceInstancePerformanceValueUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/stats/thing/deviceperformance/mydeviceid.json";
    }

    //#23get the key performance index of a certain device instance ( diagram)
    public static String certainDeviceInstanceKeyPerformanceIndexUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/stats/thing/deviceperformance/mydeviceid/mycomponentid/mymeasurementid.json";
    }

    //#24get the device tracking information(diagram)
    public static String deviceTrackingInformationUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/stats/thing/devicetracking/mydeviceid/starttime/endtime.json";
    }

    //#25get the warning list of a certain device
    public static String certainDeviceWarningListUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/device/thing/event/warning/mydeviceid.json";
    }

}
