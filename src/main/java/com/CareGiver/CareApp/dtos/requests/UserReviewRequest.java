package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserReviewRequest {
    private Long careGiverId;
    private Long userId;
    private int rating;
    private String comment;
}
