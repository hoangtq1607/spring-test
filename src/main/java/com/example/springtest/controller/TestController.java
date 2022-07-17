package com.example.springtest.controller;

import com.example.springtest.http.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TestController {

    @Autowired
    private TestClient testClient;

    @GetMapping("/cookie")
    public String getCookie() {
        return testClient.getOK();
    }
}
