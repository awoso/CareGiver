package com.CareGiver.CareApp.bookingTests;



import com.CareGiver.CareApp.dtos.requests.UserBookingRequest;
import com.CareGiver.CareApp.dtos.responses.UserBookingResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class BookingTest {
    @Autowired
    private BookingService bookingService;


    @Test
    public void testThatAUserCanBookASpecificCareGiver() throws CareAppException, Exception {
        UserBookingRequest request = new UserBookingRequest();
        request.setUserId(1L);
        request.setCareGiverId(1L);
        request.setStarTime("30/05/2024");
        request.setEndTime("12/06/2024");

        UserBookingResponse response = bookingService.bookService(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatAttemptToBookAnUnregisteredUserThrowsException(){
        UserBookingRequest request = new UserBookingRequest();
        request.setUserId(2L);
        request.setCareGiverId(1L);
        request.setStarTime("30/05/2024");
        request.setEndTime("12/06/2024");

        assertThrows(CareAppException.class, () -> bookingService.bookService(request));
    }


    @Test
    public void testThatAttemptBookAnUnregisterCareGiverThrowsException(){
        UserBookingRequest request = new UserBookingRequest();
        request.setUserId(1L);
        request.setCareGiverId(2L);
        request.setStarTime("30/05/2024");
        request.setEndTime("12/06/2024");

        assertThrows(CareAppException.class, () -> bookingService.bookService(request));
    }

}
