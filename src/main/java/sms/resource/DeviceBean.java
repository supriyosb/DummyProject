package sms.resource;

import com.google.gson.annotations.SerializedName;

public class DeviceBean {
    @SerializedName("attributes")
    private DeviceAttributesBean deviceAttributesBean;
    private int id;
    private String type;
    private String name;

    public DeviceAttributesBean getDeviceAttributesBean() {
        return deviceAttributesBean;
    }

    public void setDeviceAttributesBean(DeviceAttributesBean deviceAttributesBean) {
        this.deviceAttributesBean = deviceAttributesBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
