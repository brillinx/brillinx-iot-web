package com.iot.brillinx.restapi;

/**
 * Created by kaizhao on 10/10/16.
 */
public class UserLoginApi {

    public static String getUserLoginUrl()
    {
        // e.g. http://localhost:8081/v1/iot/user/login.json

        return RestApiConfig.IotRestServiceURL + "user/login.json";
    }
}
