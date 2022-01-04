package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.Car;
import at.ac.fhsalzburg.swd.spring.dao.Customer;
import at.ac.fhsalzburg.swd.spring.dao.Reservation;


import java.util.Date;

public interface ReservationServiceInterface {


    public abstract Reservation addReservation(Long id, Customer customer, Date reservationDate, Date departureDate, Date returnDate, String pickupLocation, String returnLocation, String extras, double price, boolean payed, boolean status,  Iterable<Car> cars);

    public abstract Iterable<Reservation> getAll();

    // public abstract String editReservation();

    public abstract void deleteById(Long id);

    public abstract Reservation getById(Long id);

    // public abstract boolean payReservation();

    // public abstract boolean payAdditionalCost();

    // public abstract boolean confirmReservation();
}
