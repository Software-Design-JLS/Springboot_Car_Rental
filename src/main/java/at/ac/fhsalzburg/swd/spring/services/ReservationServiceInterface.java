package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.Car;
import at.ac.fhsalzburg.swd.spring.dao.Customer;
import at.ac.fhsalzburg.swd.spring.dao.Reservation;
import at.ac.fhsalzburg.swd.spring.dao.ServiceStation;


import java.time.LocalDate;
import java.util.Date;

public interface ReservationServiceInterface {


    public abstract boolean addReservation(Customer customer, Car car, LocalDate reservationDate, LocalDate returnDate, ServiceStation rentalServiceStation, ServiceStation returnServiceStation);

    public abstract boolean addReservation(Reservation reservation);

    public abstract boolean returnCar(Reservation reservationToFinish);
    public abstract Iterable<Reservation> getAll();

    // public abstract String editReservation();

    public abstract void deleteById(Long id);

    public abstract Reservation getById(Long id);

    public abstract String doSomething();

    // public abstract boolean payReservation();

    // public abstract boolean payAdditionalCost();

    // public abstract boolean confirmReservation();
}
