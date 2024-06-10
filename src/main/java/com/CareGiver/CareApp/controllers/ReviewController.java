package com.CareGiver.CareApp.controllers;

import com.CareGiver.CareApp.dtos.requests.UserReviewRequest;
import com.CareGiver.CareApp.dtos.responses.UserReviewResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Review/")
@AllArgsConstructor
public class ReviewController {

    public final ReviewService reviewService;
    @PostMapping("makeReview")
    public ResponseEntity<UserReviewResponse> review(@RequestBody UserReviewRequest request) throws CareAppException{
        return new ResponseEntity<>(reviewService.makeReview(request), HttpStatus.CREATED);
    }


}
