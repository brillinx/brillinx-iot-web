package com.iot.brillinx.controller;

import com.brillinx.iot.service.core.entity.dataconnection.batch.BatchDataConnection;
import com.brillinx.iot.service.core.entity.dataconnection.realtime.RealtimeDataConnection;
import com.brillinx.iot.service.core.entity.device.Device;
import com.brillinx.iot.service.core.entity.event.Warning;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iot.brillinx.restapi.DataConnectApi;
import com.iot.brillinx.restapi.IndustryApplicationApi;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
@Controller
public class RouteController {

    private final Logger logger = Logger.getLogger(RouteController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/setpassword",method = RequestMethod.GET)
    public String setpassword(){
        return "setpassword";
    }

    @RequestMapping(value = "/forgetpassword",method = RequestMethod.GET)
    public String forgetpassword(){
        return "forgetpassword";
    }

    @RequestMapping(value = "/services",method = RequestMethod.GET)
    public String services(){
        return "service/services";
    }

    @RequestMapping(value = "/devicelist",method = RequestMethod.GET)
    public String devicelist(){
        return "devicemanagement/devicelist";
    }

    @RequestMapping(value = "/devicereg",method = RequestMethod.GET)
    public String devicereg(){
        return "devicemanagement/devicereg";
    }

    @RequestMapping(value = "/realtimedataconnect",method = RequestMethod.GET)
    public String realtimedataconnect(){
        return "dataconnect/realtime/realtimedataconnect";
    }

    @RequestMapping(value = "/reatimedataconnectlist",method = RequestMethod.GET)
    public String reatimedataconnectlist(Model model){
        ResponseEntity<String> responseEntity = null;
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = "{}";
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = new RestTemplate().exchange(new URI(DataConnectApi.realtimeDataConnectListUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
            Gson gson = new Gson();
            System.out.println(responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1));
            List<RealtimeDataConnection> realtimeDataConnectionList = gson.fromJson( responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1), new TypeToken<List<RealtimeDataConnection>>(){}.getType() );
            model.addAttribute("realtimeDataConnectionList", realtimeDataConnectionList);
            model.addAttribute("name", "william");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "dataconnect/realtime/reatimedataconnectlist";
    }

    @RequestMapping(value = "/reatimedataconnectreg",method = RequestMethod.GET)
    public String reatimedataconnectreg(){return "dataconnect/realtime/reatimedataconnectreg";}

    @RequestMapping(value = "/batchdataconnect",method = RequestMethod.GET)
    public String  batchdataconnect(){return "dataconnect/batch/batchdataconnect";}

    @RequestMapping(value = "/batchdataconnectlist",method = RequestMethod.GET)
    public String  batchdataconnectlist(Model model) {
        ResponseEntity<String> responseEntity = null;
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = "{}";
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
//            responseEntity = new RestTemplate().exchange(new URI(DataConnectApi.batchDataConnectListUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
//            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
//            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
            Gson gson = new Gson();
//            System.out.println(responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1));
//            List<RealtimeDataConnection> batchDataConnectionList = gson.fromJson( responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1), new TypeToken<List<RealtimeDataConnection>>(){}.getType() );
            List<RealtimeDataConnection> batchDataConnectionList = gson.fromJson( "[{\"id\":\"id\",\"batchDataConnectionName\":\"newbatchname\",\"deviceModelId\":\"deviceid\",\"batchDataConnectionComments\":\"comments\",\"status\":\"running\"}]", new TypeToken<List<BatchDataConnection>>(){}.getType() );
            model.addAttribute("batchDataConnectionList", batchDataConnectionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "dataconnect/batch/batchdataconnectlist";
    }

    @RequestMapping(value = "/batchdataconnectreg",method = RequestMethod.GET)
    public String  batchdataconnectreg(){return "dataconnect/batch/batchdataconnectreg";}

    @RequestMapping(value = "/applications",method = RequestMethod.GET)
    public String  application(){return "application/applications";}

    @RequestMapping(value = "/devicemonitoringlist",method = RequestMethod.GET)
    public String  devicemonitoringlist(Model model) {
        ResponseEntity<String> responseEntity = null;
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = "{}";
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "myorgid";
            String spaceId = "myspaceid";
            String userId = "myuserid";
            responseEntity = new RestTemplate().exchange(new URI(IndustryApplicationApi.deviceMonitorListUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
            Gson gson = new Gson();
            System.out.println(responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1));
            List<Device> deviceMonitorList = gson.fromJson( responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1), new TypeToken<List<Device>>(){}.getType() );
//            List<RealtimeDataConnection> batchDataConnectionList = gson.fromJson( "[{\"id\":\"id\",\"batchDataConnectionName\":\"newbatchname\",\"deviceModelId\":\"deviceid\",\"batchDataConnectionComments\":\"comments\",\"status\":\"running\"}]", new TypeToken<List<BatchDataConnection>>(){}.getType() );
            model.addAttribute("deviceMonitorList", deviceMonitorList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "application/devicemonitor/devicemonitoringlist";
    }

    @RequestMapping(value = "/devicemonitoringview",method = RequestMethod.GET)
    public String  devicemonitoringview(Model model){
        ResponseEntity<String> responseEntity = null;
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = "{}";
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "myorgid";
            String spaceId = "myspaceid";
            String userId = "myuserid";
            responseEntity = new RestTemplate().exchange(new URI(IndustryApplicationApi.certainDeviceWarningListUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
            Gson gson = new Gson();
            System.out.println(responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1));
            List<Device> deviceWarningList = gson.fromJson( responseEntity.getBody().substring(responseEntity.getBody().indexOf('['), responseEntity.getBody().lastIndexOf(']') + 1), new TypeToken<List<Warning>>(){}.getType() );
            model.addAttribute("deviceWarningList", deviceWarningList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "application/devicemonitor/devicemonitoringview";
    }

    @RequestMapping(value = "/predictivemaintenancelist",method = RequestMethod.GET)
    public String  predictivemaintenancelist(){return "application/predictivemaintenance/predictivemaintenancelist";}

    @RequestMapping(value = "/predictivemaintenanceview",method = RequestMethod.GET)
    public String  predictivemaintenanceview(){return "application/predictivemaintenance/predictivemaintenanceview";}

    @RequestMapping(value = "/predictivemaintenanceaction",method = RequestMethod.GET)
    public String  predictivemaintenanceaction(){return "application/predictivemaintenance/predictivemaintenanceaction";}
}
