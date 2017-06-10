package com.iot.brillinx.restapi;

/**
 * Created by kaizhao on 10/10/16.
 */
public class UserApi {


    public static String createUrl(String orgId, String spaceId, String userId){

        // e.g. http://localhost:8081/v1/iot/myorgid/myspaceid/user.json
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/user.json";
    }

    public static String getUrl(String orgId, String spaceId, String userId, String deviceModelId){
        return null;
    }

    public static String getAllUrl(String orgId, String spaceId, String userId) {
        return null;
    }

    public static String updateUrl(String orgId, String spaceId, String userId){
        return null;
    }

    public static String deleteUrl(String orgId, String spaceId, String userId, String deviceModelId){
        return null;
    }



}
