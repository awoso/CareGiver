package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.CareGiver;
import com.CareGiver.CareApp.data.models.Location;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.CareGiverRegistrationResponse;
import com.CareGiver.CareApp.dtos.responses.CareGiverResponse;
import com.CareGiver.CareApp.dtos.responses.CareGiverUpdateProfileResponse;
import com.CareGiver.CareApp.dtos.responses.UploadImageResponse;
import com.CareGiver.CareApp.dtos.responses.ViewCareGiverBookingsResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface CareGiverService {
     CareGiverRegistrationResponse registerCareGiver(CareGiverRegistrationRequest request) throws CareAppException;

    CareGiverResponse login(CareGiverLoginRequest request)throws CareAppException;

    CareGiverUpdateProfileResponse updateCareGiver(CareGiverUpdateProfileRequest request) throws CareAppException;

//    void logoutCareGiver(CareGiverLogoutRequest request) throws CareAppException;


    CareGiverResponse logout(CareGiverLogoutRequest request) throws CareAppException;

    void logoutCareGiver(CareGiverLogoutRequest request) throws CareAppException;

    List<CareGiver> findCareGiverByLocation(Location location) throws CareAppException;

    UploadImageResponse upoadProfilePicture(CareGiverUploadProfilePictureRequest request) throws CareAppException, IOException;
    CareGiver findById(Long careGiverId);

    void save(CareGiver existingCareGiver);

    ViewCareGiverBookingsResponse getAllBooking(ViewCareGiverBookingsRequest request) throws CareAppException;
}
