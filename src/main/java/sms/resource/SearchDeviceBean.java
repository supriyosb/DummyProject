package sms.resource;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchDeviceBean {
    @SerializedName("results")
    private List<DeviceBean> deviceBeanList;
    private int count;

    public List<DeviceBean> getDeviceBeanList() {
        return deviceBeanList;
    }

    public void setDeviceBeanList(List<DeviceBean> deviceBeanList) {
        this.deviceBeanList = deviceBeanList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
