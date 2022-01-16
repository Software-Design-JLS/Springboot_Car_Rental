package at.ac.fhsalzburg.swd.spring.startup;

import java.util.Date;

import at.ac.fhsalzburg.swd.spring.dao.Car;
import at.ac.fhsalzburg.swd.spring.dao.CarRepository;
import at.ac.fhsalzburg.swd.spring.services.CarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import at.ac.fhsalzburg.swd.spring.dao.Customer;
import at.ac.fhsalzburg.swd.spring.dao.CustomerRepository;
import at.ac.fhsalzburg.swd.spring.services.CustomerServiceInterface;

@Profile("!test")
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    CustomerServiceInterface customerService;

    @Autowired
    CarServiceInterface carService;

    
    @Autowired
    CustomerRepository repo;

    @Autowired
    CarRepository repoCar;

   // Initialize System with preset accounts and stocks
    @Override
    @Transactional // this method runs within one database transaction; performing a commit at the end
    public void run(String...args) throws Exception {

        customerService.addCustomer("Max", "Mustermann", "Puch Urstein", "23","male","+40723571234", "max@muster.man");

    	Customer customer = customerService.getAll().iterator().next();
    	customer = customerService.getById(1l);


    	carService.addCar("Benz", "SUVs", "Automatic","Unlimited ", 5, "Volkswagen Golf or similar", 66 );

        Car car = carService.getAll().iterator().next();
        car = carService.getById(1l);
    }
}
