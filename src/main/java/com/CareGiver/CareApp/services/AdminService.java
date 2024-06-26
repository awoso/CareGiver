package com.CareGiver.CareApp.services;


import com.CareGiver.CareApp.data.models.Admin;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.AdminLoginResponse;
import com.CareGiver.CareApp.dtos.responses.AdminRegistrationResponse;
import com.CareGiver.CareApp.dtos.responses.AdminUpdateProfileResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;

import java.util.List;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws CareAppException;

    AdminUpdateProfileResponse updateAdmin(AdminUpdateProfileRequest request) throws CareAppException;

    AdminLoginResponse login(AdminLoginRequest request) throws CareAppException;

    void deleteAdmin(DeleteAdminRequest request) throws CareAppException;

    List<Admin> findAllAdmins(List<Admin> all);

    void logout(AdminLogOutRequest request) throws CareAppException;
}
