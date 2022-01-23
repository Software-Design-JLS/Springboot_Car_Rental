package at.ac.fhsalzburg.swd.spring.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import at.ac.fhsalzburg.swd.spring.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ReservationService implements ReservationServiceInterface {


    int i;

    @Autowired
    private ReservationRepository repo;

    @Autowired
    private CarRepository carRepo;

    public ReservationService() {
        i=0;
    }

    @Override
    public boolean addReservation(Customer customer, Car car, LocalDate reservationDate, LocalDate returnDate, ServiceStation rentalServiceStation, ServiceStation returnServiceStation) {


        Reservation newReservation = new Reservation(customer, car, reservationDate, returnDate, rentalServiceStation, returnServiceStation);
        newReservation.setStatus(true);
        newReservation.setPayed(false);
        newReservation.setPrice(car.getPrice());
        newReservation.setExtras("Insurance");
        Car updatedCar = new Car(car.getModel(), car.getType(),car.getTransmission(),car.getMileage(),car.getNumberOfPassengers(),car.getDetail(),car.getPrice(),car.getStatus());
        updatedCar.setStatus("Not Available");
        updatedCar.setId(car.getId());


        repo.save(newReservation);
        carRepo.save(updatedCar);
        return true;
    }

    @Override
    public boolean addReservation(Reservation reservation) {

        repo.save(reservation);

        return false;

    }

    @Override
    public String doSomething()	{
        i++;
        return Integer.toString(i);

    }
    @Override
    public boolean returnCar(Reservation reservationToFinish) {

        Reservation newReservation = new Reservation(reservationToFinish.getCustomer(), reservationToFinish.getCar(), reservationToFinish.getReservationDate(),reservationToFinish.getReturnDate(), reservationToFinish.getRentalServiceStation(), reservationToFinish.getReturnServiceStation());
        newReservation.setStatus(false);
        newReservation.setPayed(true);
        newReservation.setPrice(reservationToFinish.getCar().getPrice());
        newReservation.setExtras("Insurance");
        newReservation.setId(reservationToFinish.getId());
        Car updatedCar = new Car(reservationToFinish.getCar().getModel(), reservationToFinish.getCar().getType(),reservationToFinish.getCar().getTransmission(),reservationToFinish.getCar().getMileage(),reservationToFinish.getCar().getNumberOfPassengers(),reservationToFinish.getCar().getDetail(),reservationToFinish.getCar().getPrice(),reservationToFinish.getCar().getStatus());
        updatedCar.setStatus("Available");
        updatedCar.setId(reservationToFinish.getCar().getId());


        repo.save(newReservation);
        carRepo.save(updatedCar);
        return true;
    }

        @Override
        public Iterable<Reservation> getAll () {
            return repo.findAll();
        }

        @Override
        public Reservation getById (Long id){
            return repo.findById(id).get();
        }

        @Override
        public void deleteById (Long id){

            repo.deleteById(id);

        }
    }


