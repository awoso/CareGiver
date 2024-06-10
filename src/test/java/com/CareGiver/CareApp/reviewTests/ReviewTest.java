package com.CareGiver.CareApp.reviewTests;

import com.CareGiver.CareApp.dtos.requests.UserReviewRequest;
import com.CareGiver.CareApp.dtos.responses.UserReviewResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReviewTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    public void testThatAUSerCanGiveReview() throws CareAppException {
        UserReviewRequest request = new UserReviewRequest();
        request.setUserId(1L);
        request.setCareGiverId(1L);
        request.setRating(5);
        request.setComment("Good");

        UserReviewResponse response = reviewService.makeReview(request);

        assertThat(response).isNotNull();

    }
}
