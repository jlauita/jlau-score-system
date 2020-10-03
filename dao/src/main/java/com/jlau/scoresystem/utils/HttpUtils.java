package com.jlau.scoresystem.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by cxr1205628673 on 2020/9/20.
 */
public class HttpUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static RestTemplate restTemplate = new RestTemplate();
    public static String getJson(String url){
        HttpHeaders httpHeaders = new HttpHeaders();
        String jsonStr = restTemplate.getForObject(url,String.class);
        return jsonStr;
    }
    public static String sendGetRequest(String url, Map<String,Object> params){
        String result = restTemplate.getForObject(url,String.class,params);
        return result;
    }
    public static String sendPostRequest(String url,Map<String,Object> params) throws JsonProcessingException{
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity requests = new HttpEntity(objectMapper.writeValueAsString(params),httpHeaders);
        String result = restTemplate.postForObject(url,requests,String.class);
        return result;
    }
}
