package com.example.springtest.http.client;

import com.example.springtest.http.annotation.Client;
import org.springframework.stereotype.Service;

@Service
public interface TestClient extends Client {

    String getOK();

}
