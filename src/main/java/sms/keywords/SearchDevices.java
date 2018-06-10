package sms.keywords;

import HttpCalls.HttpCalls;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import sms.api.SmsGatewayApiHolder;
import sms.config.SmsGatewayConfig;
import sms.resource.DeviceBean;
import sms.resource.SearchDeviceBean;
import utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchDevices {

    private String authToken;

    public SearchDevices(String authToken) {
        this.authToken = authToken;
    }

    public SearchDevices() {
    }

    public SearchDeviceBean search(){
        String uri = SmsGatewayConfig.SMS_GATEWAY_URL + SmsGatewayApiHolder.SEARCH_DEVICE_API;

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json, text/plain, */*");
        header.put("Authorization", authToken);

        String payload = "";

        HttpResponse response = new HttpCalls().doPost(uri, header, payload);

        String content = Utils.getStringContent(response);

        SearchDeviceBean searchDeviceBean = new Gson().fromJson(content, SearchDeviceBean.class);
        return searchDeviceBean;
    }

    public static Integer getDeviceIdByDeviceName(SearchDeviceBean searchDeviceBean){
        Integer deviceId=null;
        List<DeviceBean> deviceBeanList = searchDeviceBean.getDeviceBeanList();
        for(DeviceBean device : deviceBeanList){
            if(device.getName().equalsIgnoreCase(SmsGatewayConfig.SMS_GATEWAY_DEVICE_NAME)){
                deviceId = device.getId();
                break;
            }
        }
        return deviceId;
    }
}
