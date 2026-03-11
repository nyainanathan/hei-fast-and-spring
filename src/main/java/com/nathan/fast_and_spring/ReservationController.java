package com.nathan.fast_and_spring;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    
    private List<Reservation> reservations;

    @GetMapping("/booking")
    public List<Reservation> getReservations(){
        return this.reservations;
    }

}
