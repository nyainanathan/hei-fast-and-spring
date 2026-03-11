package com.nathan.fast_and_spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class ReservationController {
    
    private List<Reservation> reservations = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Reservation>> getReservations(){
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdatee( @RequestBody List<Reservation> toSave){

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

            System.out.println("index " +reservationIndex);
            System.out.println("Date" +  newRes.getReservationDate());

            //By this time
            //If reservationIndex is still 0, then update
            //Otherwise create a new Reservation

            if(reservationIndex == -1) {

                if(newRes.getRoomNumber() < 1 || newRes.getRoomNumber() > 9)
                    return new ResponseEntity<>("You can only chose rooms with number between 1 and 9", HttpStatus.BAD_REQUEST);

                //Before creating the new reservaions,
                //checking if the room is AVAILABLE on the CHOSEN DATE
                for(Reservation res : reservations) {
                    if(
                        res.getRoomNumber() == newRes.getRoomNumber()
                        &&
                        res.getReservationDate().equals(newRes.getReservationDate())
                    ) {
                        return new ResponseEntity<>(
                            "Room_" + res.getRoomNumber() +"_is already taken on_" + res.getReservationDate()
                            , HttpStatus.BAD_REQUEST );
                    }
                }

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
