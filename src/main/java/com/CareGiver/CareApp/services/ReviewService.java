package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.UserReviewRequest;
import com.CareGiver.CareApp.dtos.responses.UserReviewResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;

public interface ReviewService {
    UserReviewResponse makeReview(UserReviewRequest request) throws CareAppException;
}
