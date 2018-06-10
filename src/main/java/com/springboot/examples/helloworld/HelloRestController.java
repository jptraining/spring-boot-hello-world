package com.springboot.examples.helloworld;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="hello")
public class HelloRestController {
    private String salutation = null;
    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "text/plain")
    public String hello() throws UnknownHostException {
            String hostname = null;
            try {
                hostname = InetAddress.getLocalHost().getHostAddress();    
            } catch (UnknownHostException e) {
                hostname = "unknown";
            }
            return salutation + " " + hostname;
    }
    public String getSalutationtr() {
        return salutation;
    }
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }    
}