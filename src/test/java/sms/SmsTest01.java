package sms;

import org.testng.annotations.Test;
import sms.keywords.Authorization;

public class SmsTest01 {

    @Test
    public void testAuth(){
        SmsBase smsBase = new SmsBase();
        System.out.println("Token: " + smsBase.getAuthToken());
    }
}
