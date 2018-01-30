package com.stone.contract.req;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by john on 16-7-6.
 */
public class BaseReq implements Serializable {
    private String token;
    private Integer userId;

    private String sign;
    @NotNull(message = "deviceSerialId不能为空")
    private String deviceSerialId;
    @NotNull(message = "version不能为空")
    private String version;
    @NotNull(message = "appType不能为空")
    private Integer appType;
    @NotNull(message = "deviceType不能为空")
    private Integer deviceType;
    @NotNull(message = "phoneSystemVersion不能为空")
    private String phoneSystemVersion;
    @NotNull(message = "channel不能为空")
    private String channel;
    @NotNull(message = "timestamp不能为空")
    private String timestamp;

    private String hashKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public String getDeviceSerialId() {
        return deviceSerialId;
    }

    public void setDeviceSerialId(String deviceSerialId) {
        this.deviceSerialId = deviceSerialId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getPhoneSystemVersion() {
        return phoneSystemVersion;
    }

    public void setPhoneSystemVersion(String phoneSystemVersion) {
        this.phoneSystemVersion = phoneSystemVersion;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }


    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
