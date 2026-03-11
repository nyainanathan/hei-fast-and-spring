package com.nathan.fast_and_spring;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class ReservationController {
    
    private List<Reservation> reservations;

    @GetMapping
    public List<Reservation> getReservations(){
        return this.reservations;
    }

    @PostMapping
    public List<Reservation> saveOrUpdatee(List<Reservation> toSave){

        for(Reservation newRes : toSave){

            //Verify if the booking is already present
            int reservationIndex = -1;

            for(int i = 0 ; i < reservations.size() ; i++){
                if(newRes.getId() == reservations.get(i).getId()){
                    reservationIndex = i;
                    break;
                }
            }

            //By this time
            //If reservationIndex is still 0, then update
            //Otherwise create a new Reservation

            if(reservationIndex == -1) {
                reservations.add(newRes);
            } else {
                reservations.get(reservationIndex).SetEverything(newRes);
            }
        }

        return toSave;
    }
}
