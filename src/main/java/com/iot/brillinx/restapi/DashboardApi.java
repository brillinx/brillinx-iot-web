package com.iot.brillinx.restapi;

/**
 * Created by Zhao Zhifeng on 2016/10/18.
 */
public class DashboardApi {
    //#18get the resource usage for a specific user 首页dashboard
    public static String resourceUsageForSpecificUserUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/stats/thing/resourceusageperuser.json";
    }

    //#19get ingress data (the historical storage usage per user) - the http://www.highcharts.com/demo/line-time-series
    public static String historicalStorageUsagePerUserUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/stats/history/thing/storageusageperuser.json";
    }

    //#20get the deployment map of devices
    public static String deviceDeploymentMapUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/stats/thing/devicedeploymentmapperuser.json";
    }
}
