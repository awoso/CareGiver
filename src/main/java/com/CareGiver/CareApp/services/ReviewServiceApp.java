package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Review;
import com.CareGiver.CareApp.data.models.User;
import com.CareGiver.CareApp.data.repositories.ReviewRepository;
import com.CareGiver.CareApp.dtos.requests.UserReviewRequest;
import com.CareGiver.CareApp.dtos.responses.UserReviewResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewServiceApp implements ReviewService{

    private final UserService userService;
    private final ReviewRepository reviewRepository;
    @Override
    public UserReviewResponse makeReview(UserReviewRequest request) throws CareAppException {
        User existingUser = userService.findUserById(request.getUserId());

        if (existingUser == null) throw new CareAppException("User not found");

        List<Review> existingUserReviews = existingUser.getReviews();
        Review review = new Review();
        review.setCareGiverId(request.getCareGiverId());
        review.setUserId(request.getUserId());
        review.setCareGiverId(request.getCareGiverId());
        review.setComment(request.getComment());
        review.setRating(request.getRating());

        reviewRepository.save(review);
        existingUserReviews.add(review);
        userService.save(existingUser);

        UserReviewResponse response = new UserReviewResponse();
        response.setMessage("Thank you for your review");
        response.setReviewId(review.getId());

        return response;

    }
}
