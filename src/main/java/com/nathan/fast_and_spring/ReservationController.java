package com.nathan.fast_and_spring;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class ReservationController {
    
    private List<Reservation> reservations;

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations(){
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Reservation>> saveOrUpdatee(List<Reservation> toSave){

        boolean isUpdate = false;

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
                if(isUpdate == false)
                    isUpdate = true;
            }
        }

        List<Integer> idToReturn = toSave.stream()
                    .map(r -> r.getId())
                    .toList();
        
        List<Reservation> reservationToReturn = reservations.stream()
        .filter(r -> idToReturn.contains(r.getId()))
        .toList();

        return new ResponseEntity<>(reservationToReturn, ( isUpdate ? HttpStatus.OK : HttpStatus.CREATED ));
    }
}
