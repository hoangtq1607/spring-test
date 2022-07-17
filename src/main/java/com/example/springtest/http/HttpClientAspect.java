package com.example.springtest.http;

import com.example.springtest.http.annotation.Client;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Aspect
@Component
public class HttpClientAspect {

    Logger log = LoggerFactory.getLogger(HttpClientAspect.class);

    RestTemplate restTemplate = new RestTemplateBuilder()
            .interceptors((request, body, execution) -> {
                log.info("{} {} {}", request.getMethod(), request.getURI(), new String(body, StandardCharsets.UTF_8));
                return execution.execute(request, body);
            }).build();

    @Around("execution(* com.example.springtest.http.client..*(..))")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
//        Client client = joinPoint.getTarget().getClass().getAnnotation(Client.class);
//        String url = client.url();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = signature.getReturnType();
        String methodName = signature.getMethod().getName().toLowerCase(Locale.ROOT);
        HttpMethod method = HttpMethod.GET;
        if (methodName.startsWith("get")) {
//            return restTemplate.getForEntity(url, returnType);
        }
        return "OK";
    }
}
