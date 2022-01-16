package at.ac.fhsalzburg.swd.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import at.ac.fhsalzburg.swd.spring.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements ReservationServiceInterface {


    @Autowired
    private CustomerServiceInterface customerService;

    @Autowired
    private ReservationRepository repo;

    public ReservationService() {

    }


    @Override
    public Reservation addReservation(Long id, Customer customer, Date reservationDate, Date departureDate, Date returnDate, String pickupLocation, String returnLocation, String extras, double price, boolean payed, boolean status,  Iterable<Car> cars) {
        List<Car> carlist = new ArrayList<Car>();
        cars.forEach(carlist::add);

        /*if (customerService.hasCredit(customer)) {
            Reservation reservation = new Reservation(id, customer, reservationDate, departureDate, returnDate, pickupLocation, returnLocation, extras, price, payed, status, carlist);
            reservation=repo.save(reservation);

            return reservation;
        }
        else {
            return null;
        }*/
        return null;
    }



    @Override
    public Iterable<Reservation> getAll() {
        return repo.findAll();
    }

    @Override
    public Reservation getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}



