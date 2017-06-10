package com.iot.brillinx.restapi;

/**
 * Created by Zhao Zhifeng on 2016/10/18.
 */
public class DataConnectApi {
    //#13realtime data connection creation 新建设备数据接入
    public static String createNewDeviceDataConnectUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/dataconnect/realtime.json";
    }

    //#17get a specific realtime data connection info 设备接入API及Token
    public static String getDeviceConnectedApiTokenListUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/dataconnect/realtimeinfo/thing/realtimeid.json";
    }
    //#14get set of realtime data connections 实时数据接入列表
    public static String realtimeDataConnectListUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/dataconnect/realtime.json";
    }
    //#17get a specific realtime data connection info 实时数据接入列表--详情
    public static String realtimeDataConnectListDetailsUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/dataconnect/realtimeinfo/thing/realtimeid.json";
    }

    //#8batch data connection creation  新建批量数据接入    提交
    public static String newCreateBatchDataConnectUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/dataconnect/batch.json";
    }

    //#9get set of batch data connections 批量数据接入列表
    public static String batchDataConnectListUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/dataconnect/batch.json";
    }

    //#10get a specific batch data connection 批量数据接入列表--详情
    public static String batchDataConnectListDetailsUrl(String orgId, String spaceId, String userId){
        return RestApiConfig.IotRestServiceURL + orgId + "/" + spaceId + "/" + userId + "/dataconnect/batch/thing/batchid.json";
    }
}
