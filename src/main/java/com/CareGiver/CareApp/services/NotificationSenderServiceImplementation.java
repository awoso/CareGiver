package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.NotificationSenderRequest;
import com.CareGiver.CareApp.dtos.requests.ReceiverRequest;
import com.CareGiver.CareApp.dtos.requests.WelcomeMessageWelcomeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationSenderServiceImplementation implements NotificationSenderService {

    private final NotificationSetUpService notificationSetUpService;
    @Override
    public void notifyWelcomeMessage(WelcomeMessageWelcomeRequest request) {
        NotificationSenderRequest senderRequest = new NotificationSenderRequest();
        senderRequest.setName("Care Giver");
        senderRequest.setEmail("gaga.awoso@gmail.com");
        List<ReceiverRequest> receivers =  new ArrayList<>();
        ReceiverRequest receiverRequest = new ReceiverRequest();
        receiverRequest.setName(request.getName());
        receiverRequest.setEmail(request.getEmail());
        receivers.add(receiverRequest);
        senderRequest.setTo(receivers);
        String subject = "Registration";
        String htmlContent = "welcome oga "+request.getName();
        notificationSetUpService.sendNotification(senderRequest,subject,htmlContent);
    }
}
