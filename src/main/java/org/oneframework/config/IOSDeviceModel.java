package org.oneframework.config;

public class IOSDeviceModel {
    private String deviceName;
    private String platformName;
    private String platformVersion;
    private String automationName;
    private String udid;
    private String app;
    private boolean reset;
    private IOSDeviceModel iphone6s, iphone6, ipadAir, ipadAir2;

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getUdid() {
        return udid;
    }

    public String getApp() {
        return app;
    }

    public boolean isReset() {
        return reset;
    }

    public IOSDeviceModel getIphone6s() {
        return iphone6s;
    }

    public IOSDeviceModel getIphone6() {
        return iphone6;
    }

    public IOSDeviceModel getIpadAir() {
        return ipadAir;
    }

    public IOSDeviceModel getIpadAir2() {
        return ipadAir2;
    }

}
