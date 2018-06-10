package sms.keywords;

import HttpCalls.HttpCalls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jira.resource.TestBean;
import org.apache.http.HttpResponse;
import sms.api.SmsGatewayApiHolder;
import sms.config.SmsGatewayConfig;
import sms.resource.MessageBean;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {
    private String authToken;

    public Message(String authToken) {
        this.authToken = authToken;
    }

    public Message() {
    }

    public List<MessageBean> send(List<MessageBean> messageBeanList){
        String uri = SmsGatewayConfig.SMS_GATEWAY_URL + SmsGatewayApiHolder.SEND_MESSAGE_API;

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("Accept", "application/json, text/plain, */*");
        header.put("Authorization", authToken);

        String payload = new Gson().toJson(messageBeanList);

        HttpResponse response = new HttpCalls().doPost(uri, header, payload);

        String content = Utils.getStringContent(response);
        messageBeanList = new Gson().fromJson(content, new TypeToken<List<MessageBean>>(){}.getType());
        return messageBeanList;
    }
}
