package com.springboot.examples.helloworld;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="greeting")
public class GreeterRestController {
    private String salutation;
    private String backendServiceHost;
    private int backendServicePort;
    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(method = RequestMethod.GET, value = "/greeting", produces = "text/plain")
    public String greeting() throws UnknownHostException {
            String backendServiceUrl = String.format("http://%s:%d/api/backend?greeting={greeting}&param={placeholder}",backendServiceHost, backendServicePort);
            System.out.println("===================== Calling backend : " + backendServiceUrl + "=============================================");
            BackendDTO response = restTemplate.getForObject(backendServiceUrl, BackendDTO.class, salutation, backendServiceHost);
            return response.getSalutation() + " sur la machine: " + response.getIp();
    }
    public String getSalutationtr() {
        return salutation;
    }
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }     
    public String getBackendServiceHost() {
        return backendServiceHost;
    }
    public void setBackendServiceHost(String backendServiceHost) {
        this.backendServiceHost = backendServiceHost;
    }      
    public void setBackendServicePort(int backendServicePort) {
        this.backendServicePort = backendServicePort;
    }      
    public int getBackendServicePort() {
        return backendServicePort;
    }      
}