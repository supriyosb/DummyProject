package sms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sms.keywords.Authorization;
import sms.keywords.SearchDevices;
import sms.resource.MessageBean;
import sms.resource.SearchDeviceBean;

import java.util.ArrayList;
import java.util.List;

public class SmsTest01 {

    @Test(dataProvider="SearchData")
    public void testAuth(String phoneNumber, String messageText){
        //Authentication
        SmsBase smsBase = new SmsBase();
        System.out.println("Token: " + smsBase.getAuthToken());

        //Getting device ID
        SearchDeviceBean searchDeviceBean = smsBase.initializer().init().getSearchDevices().search();
        Integer deviceId = SearchDevices.getDeviceIdByDeviceName(searchDeviceBean);
        System.out.println("Device ID: " + deviceId);

        //Sending SMS
        MessageBean messageBean = new MessageBean(deviceId, phoneNumber, messageText);
        List<MessageBean> messageBeanList = new ArrayList<MessageBean>();
        messageBeanList.add(messageBean);
        List<MessageBean> messageBeanListResponse = smsBase.initializer().init().getMessage().send(messageBeanList);
        String messageCreationTime = messageBeanListResponse.get(0).getCreatedAt();
        System.out.println("Message Created At: " + messageCreationTime);
    }

    @DataProvider(name="SearchData")
    public Object[][] getDataFromDataprovider(){
        return new Object[][]
                {
                        { "9475365797", "This is Hello World. Programming Language: Java - Via SMSGateway.Me API" },
                        { "9874711168", "This is Hello World. Programming Language: Java - Via SMSGateway.Me API" },
                        { "7003372215", "This is Hello World. Programming Language: Java - Via SMSGateway.Me API" }
                };

    }
}
