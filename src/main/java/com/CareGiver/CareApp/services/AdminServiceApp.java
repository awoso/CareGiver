package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Admin;
import com.CareGiver.CareApp.data.repositories.AdminRepository;
import com.CareGiver.CareApp.dtos.requests.AdminLoginRequest;
import com.CareGiver.CareApp.dtos.requests.AdminRegistrationRequest;
import com.CareGiver.CareApp.dtos.requests.AdminUpdateProfileRequest;
import com.CareGiver.CareApp.dtos.requests.DeleteAdminRequest;
import com.CareGiver.CareApp.dtos.responses.AdminLoginResponse;
import com.CareGiver.CareApp.dtos.responses.AdminRegistrationResponse;
import com.CareGiver.CareApp.dtos.responses.AdminUpdateProfileResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceApp implements AdminService {
    private AdminRepository adminRepository;
    @Override
    public AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request) throws CareAppException {

        boolean isRegistered = adminRepository.findByEmail(request.getEmail())!=null;
        System.out.println(isRegistered);
        if (isRegistered) throw new CareAppException("Admin details already taken");

       Admin admin = new Admin();
       admin.setEmail(request.getEmail());
       admin.setPassword(request.getPassword());
       admin.setUserName(request.getUserName());
       admin.setCreatedAt(LocalDate.now());
       adminRepository.save(admin);

       AdminRegistrationResponse response = new AdminRegistrationResponse();
       response.setMessage("Admin successfully registered");
       response.setId(admin.getId());

       return response;
    }

    @Override
    public AdminUpdateProfileResponse updateAdmin(AdminUpdateProfileRequest request) throws CareAppException {
        Admin existingAdmin = adminRepository.findById(request.getAdminId()).orElse(null);
        if (existingAdmin == null) throw new CareAppException("Admin not found");
        if (!existingAdmin.isLogin()) throw new CareAppException("Dear " + existingAdmin.getUserName() + " kindly login to update your profile");
        existingAdmin.setEmail(request.getEmail());
        existingAdmin.setPassword(request.getPassword());
        existingAdmin.setUserName(request.getUserName());
        existingAdmin.setUpdatedAt(LocalDateTime.now());
        adminRepository.save(existingAdmin);

        AdminUpdateProfileResponse response = new AdminUpdateProfileResponse();
        response.setMessage("Admin successfully updated");
        response.setId(existingAdmin.getId());

        return response;

    }

    @Override
    public AdminLoginResponse login(AdminLoginRequest request) throws CareAppException {
        Admin existingAdmin = adminRepository.findByEmail(request.getEmail());
        if (existingAdmin == null) throw new CareAppException("Admin not found");
        if (!existingAdmin.getPassword().equals(request.getPassword())) throw new CareAppException("Invalid password");
        existingAdmin.setLogin(true);
        adminRepository.save(existingAdmin);
        AdminLoginResponse response = new AdminLoginResponse();
        response.setMessage("Admin successfully logged in");
        return response;
    }

    @Override
    public void deleteAdmin(DeleteAdminRequest request) throws CareAppException {
        Admin existingAdmin = adminRepository.findById(request.getAdminId()).orElse(null);
        if (existingAdmin==null) throw new CareAppException("Admin not found");
        adminRepository.delete(existingAdmin);

    }

    @Override
    public List<Admin> findAllAdmins(List<Admin> all) {
        return adminRepository.findAll();
    }
}
