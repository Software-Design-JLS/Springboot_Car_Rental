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
    public boolean addCar(Long id, String model, String color, String licencePlate, int mileage, double consumption, boolean emobility, String fuel, String type, String status, String damage, String detail, Date availableDate, double price) {


        Car newCar = new Car(id, model, color, licencePlate, mileage, consumption, emobility, fuel, type, status, damage, detail, availableDate, price);
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
