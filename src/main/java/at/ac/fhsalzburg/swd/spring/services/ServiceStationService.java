package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceStationService implements ServiceStationServiceInterface {
    @Autowired
    private ServiceStationRepository repo;

    public ServiceStationService(){

    }

    @Override
    public boolean addServiceStation(String location) {


        ServiceStation newServiceStation = new ServiceStation(location);
        repo.save(newServiceStation);
        return true;
    }

    @Override
    public boolean addServiceStation(ServiceStation serviceStation) {

        repo.save(serviceStation);

        return false;

    }

    @Override
    public Iterable<ServiceStation> getAll() {
        return repo.findAll();
    }


    @Override
    public ServiceStation getById(Long id) {
        return repo.findById(id).get();
    }


    public boolean existsById(Long id) {

        return repo.existsById(id);
    }

}
