package at.ac.fhsalzburg.swd.spring.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import at.ac.fhsalzburg.swd.spring.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Car updatedCar = new Car(car.getModel(), car.getType(),car.getTransmission(),car.getMileage(),car.getNumberOfPassengers(),car.getDetail(),car.getPrice(),car.getStatus());
        updatedCar.setStatus("Not available");
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


