package com.iot.brillinx.restapi;

/**
 * Created by sonny on 2016/10/10.
 */
public class DeviceModelApi {


    public static String createUrl(String orgId, String spaceId, String userId){

        // e.g. "http://127.0.0.1:8081/v1/iot/:orgid/:spaceid/:userid/devicemodel.json"
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/devicemodel.json";
    }

    public static String getUrl(String orgId, String spaceId, String userId, String deviceModelId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/devicemodel/thing/" + deviceModelId;
    }

    public static String getAllUrl(String orgId, String spaceId, String userId) {

        //e.g. http://127.0.0.1:8081/v1/iot/:orgid/:spaceid/:userid/devicemodel.json
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/devicemodel.json";
    }

    public static String updateUrl(String orgId, String spaceId, String userId){
        return null;
    }

    public static String deleteUrl(String orgId, String spaceId, String userId, String deviceModelId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/devicemodel/thing/" + deviceModelId;
    }


}
