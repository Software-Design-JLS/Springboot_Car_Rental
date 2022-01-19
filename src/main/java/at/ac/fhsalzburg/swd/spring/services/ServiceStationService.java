package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceStationService implements ServiceStationServiceInterface {
    @Autowired
    private ServiceStationRepository stationRepository;

    public ServiceStationService(){

    }


    @Override
    public Iterable<ServiceStation> getAll() {
        return stationRepository.findAll();
    }


    @Override
    public ServiceStation getById(Long id) {
        return stationRepository.findById(id).get();
    }


    public boolean existsById(Long id) {

        return stationRepository.existsById(id);
    }

}
