package at.ac.fhsalzburg.swd.spring.services;


import at.ac.fhsalzburg.swd.spring.dao.Car;
import at.ac.fhsalzburg.swd.spring.dao.Customer;
import at.ac.fhsalzburg.swd.spring.dao.Reservation;
import at.ac.fhsalzburg.swd.spring.dao.ServiceStation;

import java.time.LocalDate;
import java.util.List;

public interface ServiceStationServiceInterface {

    //public abstract void receiveInfos();

   // public abstract void manageDetailsOfCar();

    //public abstract void manageReservation();
    public abstract boolean addServiceStation(String location);

    public abstract boolean addServiceStation(ServiceStation serviceStation);

    public abstract Iterable<ServiceStation> getAll();

    public abstract ServiceStation getById(Long id);

    public boolean existsById(Long id);

}
