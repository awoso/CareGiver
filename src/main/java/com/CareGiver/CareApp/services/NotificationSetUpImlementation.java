package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.DataSender;
import com.CareGiver.CareApp.dtos.requests.NotificationSenderRequest;
import com.CareGiver.CareApp.dtos.requests.ReceiverRequest;
import com.CareGiver.CareApp.dtos.responses.NotificationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationSetUpImlementation implements NotificationSetUpService{

    @Value("${brevo.base.url}")
    private String url;
    @Value("${brevo.api.key}")
    private String apiKey;
    @Override
    public void sendNotification(NotificationSenderRequest senderRequest, String subject, String htmlContent) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("api-key",apiKey);
        for (ReceiverRequest to : senderRequest.getTo()){
            DataSender dataSender = new DataSender();
            dataSender.setSender(senderRequest);
            dataSender.getTo().add(to);
            dataSender.setSubject(subject);
            dataSender.setHtmlContent(htmlContent);
            HttpEntity<?> httpEntity = new HttpEntity<>(dataSender,httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForEntity(url,httpEntity, NotificationResponse.class);
        }
    }
}
