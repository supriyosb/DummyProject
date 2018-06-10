package sms.keywords;

import HttpCalls.HttpCalls;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import sms.api.SmsGatewayApiHolder;
import sms.config.SmsGatewayConfig;
import sms.resource.AuthTokenBean;
import sms.resource.UserBean;
import utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Authorization {

    public AuthTokenBean authorize(){
        String uri = SmsGatewayConfig.SMS_GATEWAY_URL + SmsGatewayApiHolder.AUTH_API;

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json, text/plain, */*");

        UserBean userBean = new UserBean();
        userBean.setUsername(SmsGatewayConfig.SMS_GATEWAY_USER);
        userBean.setPassword(SmsGatewayConfig.SMS_GATEWAY_PASSWORD);

        String payload = new Gson().toJson(userBean);

        HttpResponse response = new HttpCalls().doPost(uri, header, payload);

        String content = Utils.getStringContent(response);

        AuthTokenBean authTokenBean = new Gson().fromJson(content, AuthTokenBean.class);
        return authTokenBean;

    }
}
