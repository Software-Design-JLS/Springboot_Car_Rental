package at.ac.fhsalzburg.swd.spring.services;


import at.ac.fhsalzburg.swd.spring.dao.Customer;
import at.ac.fhsalzburg.swd.spring.dao.Reservation;
import at.ac.fhsalzburg.swd.spring.dao.ServiceStation;

import java.util.List;

public interface ServiceStationServiceInterface {

    //public abstract void receiveInfos();

   // public abstract void manageDetailsOfCar();

    //public abstract void manageReservation();

    public abstract Iterable<ServiceStation> getAll();

    public abstract ServiceStation getById(Long id);

    public boolean existsById(Long id);

}
