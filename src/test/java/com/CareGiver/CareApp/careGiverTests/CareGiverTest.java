package com.CareGiver.CareApp.careGiverTests;




import com.CareGiver.CareApp.data.models.CareGiver;
import com.CareGiver.CareApp.data.repositories.CareGiverRepository;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.*;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.CareGiverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CareGiverTest {
    @Autowired
    private CareGiverService careGiverService;
    @Autowired
    private CareGiverRepository careGiverRepository;


    @Test
    public void testThatCareGiverCanRegister() throws CareAppException {
        CareGiverRegistrationRequest request = new CareGiverRegistrationRequest();
        request.setEmail("awosoogaga@gmail.com");
        request.setPassword("awoso3456");
        request.setUserName("awosoo");
        request.setQualification("Bsc");
        request.setYearsOfExperience(2);
        request.setServicesOffered("babycare");
        CareGiverRegistrationResponse response = careGiverService.registerCareGiver(request);

        assertThat(response).isNotNull();

    }

    @Test
    public void testThatIfCareGiverAttemptsToRegisterWithAnAlreadyTakenEmailExceptionIsThrown() {
        CareGiverRegistrationRequest request = new CareGiverRegistrationRequest();
        request.setEmail("awosoogaga@gmail.com");
        request.setPassword("awoso3456");
        request.setUserName("awosoo");
        request.setQualification("Bsc");
        request.setYearsOfExperience(2);
        request.setServicesOffered("babycare");
        assertThrows(CareAppException.class, () -> careGiverService.registerCareGiver(request));
    }

    @Test
    public void testThatMultipleCareGiversCanRegister() throws CareAppException {

        CareGiverRegistrationRequest request = new CareGiverRegistrationRequest();
        request.setEmail("davidFelix1@gmail.com");
        request.setPassword("david001");
        request.setUserName("DavidFlex");
        request.setQualification("phD");
        request.setYearsOfExperience(3);
        request.setServicesOffered("Elderly Care");

        CareGiverRegistrationResponse response = careGiverService.registerCareGiver(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatCareGiverCanLogin() throws CareAppException {
        CareGiverLoginRequest request = new CareGiverLoginRequest();
        request.setEmail("davidFelix1@gmail.com");
        request.setPassword("david001");
        CareGiverResponse response = careGiverService.login(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatCareGiverCanUpdateProfile() throws CareAppException {
        CareGiverUpdateProfileRequest request = new CareGiverUpdateProfileRequest();
        request.setEmail("davidFelix1@gmail.com");
        request.setPassword("david001");
        request.setUserName("DavidFlex");
        request.setQualification("Bsc");
        request.setYearsOfExperience(3);
        request.setServicesOffered("babycare");

        CareGiverUpdateProfileResponse response = careGiverService.updateCareGiver(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatCareGiverCanLogOut() throws CareAppException {
        CareGiverLogoutRequest request = new CareGiverLogoutRequest();
        request.setEmail("davidFelix1@gmail.com");
        CareGiver careGiver = careGiverRepository.findByEmail(request.getEmail());
        assert careGiver != null;
        careGiverService.logoutCareGiver(request);
        assertFalse(careGiver.isLogin());
    }
    @Test
    public void testThatCareGiverCanLogOut_chain() throws CareAppException {
        CareGiverRegistrationRequest request = new CareGiverRegistrationRequest();
        request.setEmail("awosoogaga@gmail13.com1");
        request.setPassword("awoso3456");
        request.setUserName("awosoo");
        request.setQualification("Bsc");
        request.setYearsOfExperience(2);
        request.setServicesOffered("babycare");
        CareGiverRegistrationResponse response = careGiverService.registerCareGiver(request);
        assertThat(response).isNotNull();

//         login
        CareGiverLoginRequest loginRequest = new CareGiverLoginRequest();
        loginRequest.setEmail("awosoogaga@gmail.com1");
        loginRequest.setPassword("awoso3456");
        CareGiverResponse careGiverResponse = careGiverService.login(loginRequest);
        assertNotNull(careGiverResponse);
//         logout
        CareGiverLogoutRequest logoutRequest = new CareGiverLogoutRequest();
        logoutRequest.setEmail("awosoogaga@gmail.com1");
        CareGiverResponse response1 = careGiverService.logout(logoutRequest);
        assertThat(response1).isNotNull();


    }


}