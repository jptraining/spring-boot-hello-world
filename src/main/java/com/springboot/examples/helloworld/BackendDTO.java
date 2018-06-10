package com.springboot.examples.helloworld;

public class BackendDTO {
    private String salutation = null;
    private long time;
    private String ip;
    public String getSalutation() {
        return salutation;
    }
    public String getIp() {
        return ip;
    }
    public long getTime() {
        return time;
    }    
    public void setTime(long time) {
        this.time = time;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }        
}