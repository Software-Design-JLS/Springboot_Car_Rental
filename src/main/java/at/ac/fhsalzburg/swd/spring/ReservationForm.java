package at.ac.fhsalzburg.swd.spring;

import at.ac.fhsalzburg.swd.spring.dao.*;
import at.ac.fhsalzburg.swd.spring.services.CarServiceInterface;
import at.ac.fhsalzburg.swd.spring.services.CustomerService;
import at.ac.fhsalzburg.swd.spring.services.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ReservationForm {


    private Customer customer;
    private Car car;
    @DateTimeFormat(iso=ISO.DATE)
    private LocalDate reservationDate;
    @DateTimeFormat(iso=ISO.DATE)
    private LocalDate returnDate;
    private ServiceStation returnServiceStation;
    private ServiceStation reservationServiceStation;
    private Reservation reservation;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturnServiceStation(ServiceStation returnServiceStation) {
        this.returnServiceStation = returnServiceStation;
    }

    public void setReservationServiceStation(ServiceStation reservationServiceStation) {
        this.reservationServiceStation = reservationServiceStation;
    }

    public Customer getCustomer(){
        return customer;
    }


    public Car getCar(){
        return car;
    }

    public LocalDate getReservationDate(){
        return reservationDate;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }

    public ServiceStation getReturnServiceStation(){
        return returnServiceStation;
    }

    public ServiceStation getReservationServiceStation(){
        return reservationServiceStation;
    }


}
