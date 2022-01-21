package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.*;
import at.ac.fhsalzburg.swd.spring.dao.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.ac.fhsalzburg.swd.spring.dao.Car;

import java.util.Date;

@Service
public class CarService implements CarServiceInterface {

    int i;

    @Autowired
    private CarRepository repo;

    public CarService() {
        i=0;
    }

    @Override
    public String doSomething() {
        i++;
        return Integer.toString(i);

    }

    @Override
    public boolean addCar( String model, String type, String transmission, String mileage, int numberOfPassengers, String detail, double price, String status) {


        Car newCar = new Car(model, type, transmission, mileage, numberOfPassengers, detail, price,status);
        repo.save(newCar);
        return true;
    }

    @Override
    public boolean addCar(Car car) {

        repo.save(car);

        return false;

    }

    @Override
    public Iterable<Car> getAll() {
        return repo.findAll();
    }

    @Override
    public Car getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
