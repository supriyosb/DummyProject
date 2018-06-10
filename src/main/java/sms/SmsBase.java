package sms;

import sms.keywords.Authorization;

public class SmsBase {
    private String authToken;

    public SmsBase() {
        authToken = new Authorization().authorize().getToken();
    }

    public String getAuthToken(){
        return authToken;
    }
}
