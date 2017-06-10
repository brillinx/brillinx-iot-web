package com.iot.brillinx.controller;

import com.brillinx.iot.service.restserver.protocol.UserLogin.IoTUserLoginRequest;
import com.brillinx.iot.service.restserver.protocol.UserLogin.IoTUserLoginResponse;
import com.google.gson.Gson;
import com.iot.brillinx.restapi.UserLoginApi;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/27/027.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = Logger.getLogger(UserController.class);

    private RestTemplate restTemplate = new RestTemplate();

    private Gson gson = new Gson();

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String Login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password){


//        IoTUserLoginRequest ioTUserLoginRequest = new IoTUserLoginRequest(username, password);
//        IoTUserLoginResponse ioTUserLoginResponse = null;
//        String requestBody = gson.toJson(ioTUserLoginRequest);
//
//        HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, null);
//        try {
//            ResponseEntity<String> responseEntity = restTemplate.exchange(new URI(UserLoginApi.getUserLoginUrl()), HttpMethod.POST, requestEntity, String.class);
//
//            ioTUserLoginResponse = gson.fromJson(responseEntity.getBody(), IoTUserLoginResponse.class);
//
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

        return "1";
    }
}
