package at.ac.fhsalzburg.swd.spring;

import at.ac.fhsalzburg.swd.spring.dao.Car;
import at.ac.fhsalzburg.swd.spring.dao.Customer;
import at.ac.fhsalzburg.swd.spring.dao.CustomerRepository;
import at.ac.fhsalzburg.swd.spring.dao.ServiceStation;
import at.ac.fhsalzburg.swd.spring.services.CustomerService;
import at.ac.fhsalzburg.swd.spring.services.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class ReservationForm {


    private Customer customer;
    private Car car;
    private LocalDate reservationDate;
    private LocalDate returnDate;
    private ServiceStation returnServiceStation;
    private ServiceStation reservationServiceStation;


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
