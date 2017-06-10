package com.iot.brillinx.controller;

import com.iot.brillinx.restapi.DeviceModelApi;
import com.iot.brillinx.restapi.IndustryApplicationApi;
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

/**
 * Created by Zhao Zhifeng on 2016/10/3.
 */
@Controller
@RequestMapping(value = "/industryApp")
public class IndustryApplicationController {
    private final Logger logger = Logger.getLogger(IndustryApplicationController.class);

    private static final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/deviceMonitorDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getCertainDeviceInstancePerformanceValue(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
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
            responseEntity = new RestTemplate().exchange(new URI(IndustryApplicationApi.certainDeviceInstancePerformanceValueUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
//            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
//            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/keyPerformanceIndex", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getCertainDeviceInstanceKeyPerformanceIndex(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
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
            responseEntity = new RestTemplate().exchange(new URI(IndustryApplicationApi.certainDeviceInstanceKeyPerformanceIndexUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
//            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
//            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/deviceTrackingInformation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getDeviceTrackingInformation(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
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
            responseEntity = new RestTemplate().exchange(new URI(IndustryApplicationApi.deviceTrackingInformationUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

}
