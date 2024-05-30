//package com.CareGiver.CareApp.bookingTests;
//
//
//import com.CareGiver.CareApp.data.models.Booking;
//import com.CareGiver.CareApp.data.models.BookingStatus;
//import com.CareGiver.CareApp.data.repositories.BookingRepository;
//import com.CareGiver.CareApp.services.BookingService;
//import com.CareGiver.CareApp.services.CareGiverService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class BookingTest {
//    @Autowired
//    private BookingService bookingService;
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Test
//    public void testThatUserCanCreateBooking() throws Exception {
//        Booking booking = new Booking();
//        booking.setUserId(2L);
//        booking.setCareGiverId(2L);
//        booking.setStatus(bookingstatus.PENDING);
//        booking.getServiceOfferedId();
//        booking.setStarTime("LocalDateTime");
//        booking.setEndTime("LocalDateTime");
//        when(bookingRepository.save(booking)).thenReturn(booking);
//        Booking createdBooking = bookingService.createBooking(booking);
//        assertEquals(usercreatedBooking.getUser());
//        assertEquals(BookingStatus.PENDING, createdBooking.getBookingStatus());
//        verify(bookingRepository).save(booking);
//    }
//
//
//}
