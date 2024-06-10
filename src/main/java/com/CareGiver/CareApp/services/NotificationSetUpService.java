package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.NotificationSenderRequest;

public interface NotificationSetUpService {

    public void sendNotification(NotificationSenderRequest senderRequest, String subject,
                                 String htmlContent);
}
