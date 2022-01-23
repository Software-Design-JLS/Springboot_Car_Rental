package at.ac.fhsalzburg.swd.spring.startup;

import java.time.LocalDate;
import java.util.Date;

import at.ac.fhsalzburg.swd.spring.dao.*;
import at.ac.fhsalzburg.swd.spring.services.CarServiceInterface;
import at.ac.fhsalzburg.swd.spring.services.ReservationServiceInterface;
import at.ac.fhsalzburg.swd.spring.services.ServiceStationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import at.ac.fhsalzburg.swd.spring.services.CustomerServiceInterface;

@Profile("!test")
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    CustomerServiceInterface customerService;

    @Autowired
    CarServiceInterface carService;

    @Autowired
    ReservationServiceInterface reservationService;

    @Autowired
    ServiceStationServiceInterface serviceStationService;


    /*
    @Autowired
    CustomerRepository repo;

    @Autowired
    CarRepository repoCar; */

   // Initialize System with preset accounts and stocks
    @Override
    @Transactional // this method runs within one database transaction; performing a commit at the end
    public void run(String...args) throws Exception {

        customerService.addCustomer("Max", "Mustermann", "Puch Urstein", "23", "male", "+40723571234", "max@muster.man");
        customerService.addCustomer("Ioana", "Lazea", "Salzburg", "21", "female", "+40726871238", "lazea@ioana.man");
        customerService.addCustomer("Sandro", "Sulkni", "Wien", "21", "male", "+40723395634", "sandro@sulki.man");
        customerService.addCustomer("Litharshi", "Siva", "Bremen", "24", "female", "+40793771232", "litharshi@siva.man");
        customerService.addCustomer("Alex", "Meier", "Hamburg", "26", "male", "+40723293864", "alex@meier.man");

        Customer customer = customerService.getAll().iterator().next();
        customer = customerService.getById(1l);


        carService.addCar("Benz", "SUVs", "Automatic", "Unlimited ", 5, "Economy", 66,"Available");
        carService.addCar("VW", "Passenger Vans", "Manual", "Limited ", 4, "Mini", 80,"Not Available");
        carService.addCar("BMW", "Cars", "Manual", "Unlimited ", 4, "Compact", 40,"Available");
        carService.addCar("Polo", "Passenger Vans", "Automatic", "Limited ", 5, "Intermediate", 100,"Available");

        Car car = carService.getAll().iterator().next();
        //car = carService.getById(2l);


        serviceStationService.addServiceStation("Wien");
        serviceStationService.addServiceStation("Salzburg");
        serviceStationService.addServiceStation("Puch");


        reservationService.addReservation(customerService.getById(2l), carService.getById(8l), LocalDate.parse("2022-01-21"), LocalDate.parse("2022-02-21"), serviceStationService.getById(11l), serviceStationService.getById(10l));
        Reservation reservation = reservationService.getAll().iterator().next();
        reservationService.returnCar(reservationService.getById(13l));

    }
}
