package com.iot.brillinx.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iot.brillinx.restapi.DashboardApi;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Zhao Zhifeng on 2016/10/3.
 */
@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
    private final Logger logger = Logger.getLogger(DashboardController.class);

    private static final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/getResourceUsageForSpecificUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getResourceUsageForSpecificUser(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("emptyJsonObjStr=" + emptyJsonObjStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = "{}";
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = new RestTemplate().exchange(new URI(DashboardApi.resourceUsageForSpecificUserUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
//            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
//            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/getHistoricalStorageUsagePerUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getHistoricalStorageUsagePerUser(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("emptyJsonObjStr=" + emptyJsonObjStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = "{}";
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "myorgid";
            String spaceId = "myspaceid";
            String userId = "myuserid";
            responseEntity = new RestTemplate().exchange(new URI(DashboardApi.historicalStorageUsagePerUserUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
//            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
//            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/getDeviceDeploymentMap", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getDeviceDeploymentMap(@RequestParam("emptyJsonObj") String emptyJsonObjStr) throws UnsupportedEncodingException {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("emptyJsonObjStr=" + emptyJsonObjStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = "{}";
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "myorgid";
            String spaceId = "myspaceid";
            String userId = "myuserid";
            responseEntity = new RestTemplate().exchange(new URI(DashboardApi.deviceDeploymentMapUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return URLEncoder.encode(responseEntity.getBody(), "UTF-8");
    }

}
