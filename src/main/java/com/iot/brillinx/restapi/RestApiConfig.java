package com.iot.brillinx.restapi;

import com.iot.brillinx.utils.Configuration;

/**
 * Created by kaizhao on 10/10/16.
 */
public class RestApiConfig {

    //e.g. in the format of http://115.29.248.226:8081/v1/iot/
    public static String IotRestServiceURL = Configuration.getValue(Configuration.IOT_REST_SERVICE_URL);
}
