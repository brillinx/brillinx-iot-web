package com.iot.brillinx.controller;

import com.google.gson.Gson;
import com.iot.brillinx.restapi.DeviceModelApi;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhao Zhifeng on 2016/10/3.
 */
@Controller
@RequestMapping(value = "/device")
public class DeviceController {
    private final Logger logger = Logger.getLogger(DeviceController.class);

    private static final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/submitDeviceAttrList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String submitDeviceAttrList(@RequestParam("currentDeviceModel") String currentDeviceModelStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("currentDeviceModelStr=" + currentDeviceModelStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = currentDeviceModelStr;
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DeviceModelApi.createUrl(orgId, spaceId, userId)), HttpMethod.POST, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/getDeviceList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getDeviceList(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
        ResponseEntity<String> responseEntity = null;
        String substitution = null;
        try {
            System.out.println("emptyJsonObjStr=" + emptyJsonObjStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");

            HttpEntity<String> requestEntity = new HttpEntity<String>("{}", requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DeviceModelApi.getAllUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/getDeviceModelAttributeById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getDeviceModelAttributeById(@RequestParam("deviceModelId") String deviceModelId) {
        ResponseEntity<String> responseEntity = null;
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");

            HttpEntity<String> requestEntity = new HttpEntity<String>("{}", requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DeviceModelApi.getUrl(orgId, spaceId, userId, "mydatamodelid.json")), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/deleteDeviceModelById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteDeviceModelById(@RequestParam("deviceModelId") String deviceModelId) {
        ResponseEntity<String> responseEntity = null;
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");

            HttpEntity<String> requestEntity = new HttpEntity<String>("{}", requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DeviceModelApi.deleteUrl(orgId, spaceId, userId, "datamodelid.json")), HttpMethod.DELETE, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

}
