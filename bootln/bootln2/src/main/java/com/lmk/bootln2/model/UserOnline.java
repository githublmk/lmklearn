package com.lmk.bootln2.model;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class UserOnline implements Serializable {

    private String id;

    private String userId;

    private String username;

    private String host;
    private String systemHost;
    private String status;
    private Date startTimestamp;
    private Date lastAccessTime;
    private Long timeout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSystemHost() {
        return systemHost;
    }

    public void setSystemHost(String systemHost) {
        this.systemHost = systemHost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "UserOnline{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", host='" + host + '\'' +
                ", systemHost='" + systemHost + '\'' +
                ", status='" + status + '\'' +
                ", startTimestamp=" + startTimestamp +
                ", lastAccessTime=" + lastAccessTime +
                ", timeout=" + timeout +
                '}';
    }
}
