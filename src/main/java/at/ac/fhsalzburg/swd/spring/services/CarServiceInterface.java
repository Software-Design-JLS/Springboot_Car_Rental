package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.Car;

import java.util.Date;

public interface CarServiceInterface {

    public abstract boolean addCar(Long id, String model, String color, String licencePlate, int mileage, double consumption, boolean emobility, String fuel, String type, String status, String damage, String detail, Date availableDate, double price);

    public abstract boolean addCar(Car car);

    public abstract void deleteById(Long id);

    // public abstract String editCar();

    public abstract String doSomething();

    public abstract Iterable<Car> getAll();

    public abstract Car getById(Long id);

}
