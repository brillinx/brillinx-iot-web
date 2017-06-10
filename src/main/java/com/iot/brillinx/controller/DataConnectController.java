package com.iot.brillinx.controller;

import com.google.gson.Gson;
import com.iot.brillinx.restapi.DataConnectApi;
import com.iot.brillinx.restapi.DeviceModelApi;
import com.iot.brillinx.utils.Configuration;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhao Zhifeng on 2016/10/18.
 */
@Controller
@RequestMapping(value = "/data")
public class DataConnectController {
    //private String realPath = "C:" + File.separator + "upload";//for Windows

    private String realPath = Configuration.getValue(Configuration.IOT_UPLOAD_FILE_DIRECTORY_ROOT) + File.separator + "upload";//for Windows

    private final Logger logger = Logger.getLogger(DataConnectController.class);

    private static final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/createNewDeviceDataConnect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String submitDeviceAttrList(@RequestParam("newDeviceDataConnect") String newDeviceDataConnectStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("newDeviceDataConnectStr=" + newDeviceDataConnectStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = newDeviceDataConnectStr;
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DataConnectApi.createNewDeviceDataConnectUrl(orgId, spaceId, userId)), HttpMethod.POST, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/getDeviceConnectedApiTokenList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getDeviceConnectedApiTokenList(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("emptyJsonObjStr=" + emptyJsonObjStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = emptyJsonObjStr;
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DataConnectApi.getDeviceConnectedApiTokenListUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/getReatimeDataConnectListItemDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getReatimeDataConnectListItemDetails(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("emptyJsonObjStr=" + emptyJsonObjStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = emptyJsonObjStr;
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DataConnectApi.realtimeDataConnectListDetailsUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/uploadFile", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile mf) throws IOException {
        String filename = mf.getOriginalFilename();
        logger.info("fileName = " + filename);
        //文件路径
        String filePath = realPath + File.separator + filename;
        File file = new File(filePath);
        // 写入本地
        Map map = new HashMap();
        try {
            if ( !new File(realPath).exists() ) {//若文件目录不存在，则创建目录
                new File(realPath).mkdirs();
            }
            mf.transferTo(file);
            map.put("result", "上传成功！");
            map.put("code", 1);
            map.put("filePath", filePath);
            logger.info("成功");
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("result", "上传失败！");
            map.put("code", 0);
            logger.info("失败");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("result", "上传失败！");
            map.put("code", 0);
            logger.info("失败");
        }
        Gson gson = new Gson();
        String str = gson.toJson(map);
        System.out.println("str=" + str);
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/newCreateBatchDataConnect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String newCreateBatchDataConnect(@RequestParam("newCreateBatchDataConnect") String newCreateBatchDataConnectStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("newCreateBatchDataConnectStr=" + newCreateBatchDataConnectStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = newCreateBatchDataConnectStr;
            HttpEntity<String> requestEntity = new HttpEntity<String>("{}", requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DataConnectApi.newCreateBatchDataConnectUrl(orgId, spaceId, userId)), HttpMethod.POST, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }

    /**
     * 点击取消按钮删除已上传的文件
     */
    @RequestMapping("/deleteUploadedFile")
    @ResponseBody
    public String deleteUploadedFile(@RequestParam String fileName) {
        try {
            //delete uploaded file from corresponding directory
            File file = new File(realPath, fileName);
            // 路径为文件且不为空则进行删除
            if (file.isFile() && file.exists()) {
                file.delete();
                return "success";
            }
        } catch (Exception e) {
            logger.error("deleteUploadedFile exception:", e);
        }
        return "error";
    }

    @RequestMapping(value = "/getBatchDataConnectListItemDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getBatchDataConnectListItemDetails(@RequestParam("emptyJsonObj") String emptyJsonObjStr) {
        ResponseEntity<String> responseEntity = null;
        try {
            System.out.println("emptyJsonObjStr=" + emptyJsonObjStr);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-type", "application/json");
            requestHeaders.set("Token", "mytoken");
            String requestBody = emptyJsonObjStr;
            HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, requestHeaders);
            String orgId = "testorg";
            String spaceId = "testspace";
            String userId = "testuser";
            responseEntity = restTemplate.exchange(new URI(DataConnectApi.batchDataConnectListDetailsUrl(orgId, spaceId, userId)), HttpMethod.GET, requestEntity, String.class);
            System.out.println("ResponseEntity StatusCode=" + responseEntity.getStatusCode());
            System.out.println("ResponseEntity Body=" + responseEntity.getBody());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return responseEntity.getBody();
    }
}
