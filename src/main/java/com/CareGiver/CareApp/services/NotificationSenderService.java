package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.WelcomeMessageWelcomeRequest;

public interface NotificationSenderService{


    public void notifyWelcomeMessage(WelcomeMessageWelcomeRequest request);
}
