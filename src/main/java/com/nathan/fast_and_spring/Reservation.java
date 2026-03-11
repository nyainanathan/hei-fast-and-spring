package com.nathan.fast_and_spring;

import java.time.LocalDate;

public class Reservation {
    private String clientName;
    private String clientPhoneNumber;
    private String clientEmail;
    private Integer roomNumber;
    private String roomDescription;
    private LocalDate reservationDate;

    public Reservation(String clientName, String clientPhoneNumber, String clientEmail,
                       Integer roomNumber, String roomDescription, LocalDate reservationDate) {
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.roomNumber = roomNumber;
        this.roomDescription = roomDescription;
        this.reservationDate = reservationDate;
    }
    
    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

}
