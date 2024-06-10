package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Booking;
import com.CareGiver.CareApp.data.models.CareGiver;
import com.CareGiver.CareApp.data.models.Image;
import com.CareGiver.CareApp.data.models.Location;
import com.CareGiver.CareApp.data.repositories.CareGiverRepository;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.CareGiverRegistrationResponse;
import com.CareGiver.CareApp.dtos.responses.CareGiverResponse;
import com.CareGiver.CareApp.dtos.responses.CareGiverUpdateProfileResponse;
import com.CareGiver.CareApp.dtos.responses.UploadImageResponse;
import com.CareGiver.CareApp.dtos.responses.ViewCareGiverBookingsResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor

public class CareGiverServiceApp implements  CareGiverService {

    private final CareGiverRepository careGiverRepository;
    private final CloudinaryImageService cloudinaryImageService;
    private final ImageService imageService;


    @Override
    public CareGiverRegistrationResponse registerCareGiver(CareGiverRegistrationRequest request) throws CareAppException {
        boolean isRegistered = careGiverRepository.findByEmail(request.getEmail()) != null;
        if (isRegistered) throw new CareAppException("Email already taken");
        CareGiver careGiver = new CareGiver();
        careGiver.setEmail(request.getEmail());
        careGiver.setUserName(request.getUserName());
        careGiver.setPassword(request.getPassword());
        careGiver.setQualification(request.getQualification());
        careGiver.setYearsOfExperience(request.getYearsOfExperience());
        careGiver.setServicesOffered(request.getServicesOffered());
        careGiver.setAvailable(true);
        careGiver.setCreatedAt(LocalDateTime.now());
        careGiver.setLogin(false);
        careGiver.setLocation(Location.valueOf(request.getLocation()));
        careGiverRepository.save(careGiver);

        CareGiverRegistrationResponse response = new CareGiverRegistrationResponse();
        response.setId(careGiver.getCareGiverId());
        response.setMessage("Successfully registered");

        return response;
    }

    @Override
    public CareGiverResponse login(CareGiverLoginRequest request) throws CareAppException {
        CareGiver careGiver = careGiverRepository.findByEmail(request.getEmail());
        if (careGiver == null) throw new CareAppException("Email does not exist");
        if (!careGiver.getPassword().equals(request.getPassword())) throw new CareAppException("Wrong password");
        careGiver.setLogin(true);
        careGiverRepository.save(careGiver);
        CareGiverResponse response = new CareGiverResponse();
        response.setMessage("Successfully logged in");
        return response;
    }

    @Override
    public CareGiverUpdateProfileResponse updateCareGiver(CareGiverUpdateProfileRequest request) throws CareAppException {
        CareGiver exisitngCareGiver = careGiverRepository.findById(request.getCareGiverId()).orElse(null);
        if (exisitngCareGiver == null) throw new CareAppException("CareGiver does not exist");
        if (!exisitngCareGiver.isLogin()) throw new CareAppException("Dear " + exisitngCareGiver.getUserName() + "kindly login to update your profile");
        exisitngCareGiver.setEmail(request.getEmail());
        exisitngCareGiver.setUserName(request.getUserName());
        exisitngCareGiver.setPassword(request.getPassword());
        exisitngCareGiver.setQualification(request.getQualification());
        exisitngCareGiver.setServicesOffered(request.getServicesOffered());
        exisitngCareGiver.setAvailable(true);
        exisitngCareGiver.setCreatedAt(LocalDateTime.now());
        careGiverRepository.save(exisitngCareGiver);

        CareGiverUpdateProfileResponse response = new CareGiverUpdateProfileResponse();
        response.setMessage(" caregiver Successfully updated");
        return response;

    }

    @Override
    public void logoutCareGiver(CareGiverLogoutRequest request) throws CareAppException {
        CareGiver existingCareGiver = careGiverRepository.findByEmail(request.getEmail());
        if (existingCareGiver == null) throw new CareAppException("Caregiver not found");
        existingCareGiver.setLogin(false);
        careGiverRepository.save(existingCareGiver);
    }

    @Override
    public List<CareGiver> findCareGiverByLocation(Location location) throws CareAppException {
        List<CareGiver> careGiver = careGiverRepository.findCareGiversByLocation(Location.valueOf(String.valueOf(location)));

        if (careGiver == null){
            throw new CareAppException("Caregiver not found");
        }
        return careGiver;
    }

    @Override
    public UploadImageResponse upoadProfilePicture(CareGiverUploadProfilePictureRequest request) throws CareAppException, IOException {
        CareGiver existingCareGiver = careGiverRepository.findById(request.getCareGiverId()).orElse(null);
        if (existingCareGiver == null) throw new CareAppException("Caregiver not found");
        UploadImageResponse response = cloudinaryImageService.uploadImage(request.getUploadImageRequest());


        Image image = imageService.saveImage(response);
        existingCareGiver.setImage(image);
        careGiverRepository.save(existingCareGiver);
        response.setUrl(response.getUrl());
        return response;




    }

    public CareGiver findById(Long careGiverId) {
        return careGiverRepository.findById(careGiverId).orElse(null);
    }

    @Override
    public void save(CareGiver existingCareGiver) {
        careGiverRepository.save(existingCareGiver);
    }

    @Override
    public ViewCareGiverBookingsResponse getAllBooking(ViewCareGiverBookingsRequest request) throws CareAppException {
        CareGiver existingCareGiver = careGiverRepository.findById(request.getCareGiverId()).orElse(null);
        if (existingCareGiver == null) throw new CareAppException("Care giver not found");

        List<Booking> existingCareGiverBookings = existingCareGiver.getBookings();
        ViewCareGiverBookingsResponse response = new ViewCareGiverBookingsResponse();
        response.setCareGiverBookings(existingCareGiverBookings);
        return response;
    }

    @Override
    public CareGiverResponse logout(CareGiverLogoutRequest request) throws CareAppException {
        CareGiver careGiver = careGiverRepository.findByEmail(request.getEmail());
        if (careGiver == null) throw new CareAppException("Email does not exist");
        careGiver.setLogin(false);
        careGiverRepository.save(careGiver);
        CareGiverResponse response = new CareGiverResponse();
        response.setMessage("Successfully logged out");
        return response;
    }

}
