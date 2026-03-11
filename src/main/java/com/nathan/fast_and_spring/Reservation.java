package com.nathan.fast_and_spring;

import java.time.LocalDate;

public class Reservation {

    private Integer id;
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

    
    public void SetEverything(Reservation newRes){
        if(newRes.getClientName() != null)
            this.setClientEmail(newRes.getClientEmail());
        
        if(newRes.getClientName() != null)
            this.setClientName(newRes.getClientName());
        
        if(newRes.getClientPhoneNumber() != null)
            this.setClientPhoneNumber(newRes.getClientPhoneNumber());;
        
        if(newRes.getReservationDate() != null)
            this.setReservationDate(newRes.getReservationDate());
        
        if(newRes.getRoomDescription()!=null)
            this.setRoomDescription(newRes.getRoomDescription());
        
        if(newRes.getRoomNumber() != null)
            this.setRoomNumber(newRes.getRoomNumber());
    }



    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return String return the clientPhoneNumber
     */
    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    /**
     * @param clientPhoneNumber the clientPhoneNumber to set
     */
    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    /**
     * @return String return the clientEmail
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * @param clientEmail the clientEmail to set
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * @return Integer return the roomNumber
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return String return the roomDescription
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     * @param roomDescription the roomDescription to set
     */
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    /**
     * @return LocalDate return the reservationDate
     */
    public LocalDate getReservationDate() {
        return reservationDate;
    }

    /**
     * @param reservationDate the reservationDate to set
     */
    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

}
