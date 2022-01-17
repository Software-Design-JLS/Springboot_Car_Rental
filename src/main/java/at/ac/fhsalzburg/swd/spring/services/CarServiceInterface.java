package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.Car;

import java.util.Date;

public interface CarServiceInterface {


    public abstract boolean addCar(String model, String type, String transmission, String mileage, int numberOfPassengers, String detail, double price);

    public abstract boolean addCar(Car car);

    public abstract void deleteById(Long id);

    // public abstract String editCar();

    public abstract String doSomething();

    public abstract Iterable<Car> getAll();

    public abstract Car getById(Long id);

}
