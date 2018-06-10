package sms;

import sms.keywords.Message;
import sms.keywords.SearchDevices;

public class Initializer {
    private String authToken;
    private SearchDevices searchDevices;
    private Message message;

    public Initializer(String authToken) {
        this.authToken = authToken;
    }

    public Initializer init(){
        searchDevices = new SearchDevices(authToken);
        message = new Message(authToken);
        return this;
    }

    public SearchDevices getSearchDevices() {
        return searchDevices;
    }

    public Message getMessage() {
        return message;
    }
}
