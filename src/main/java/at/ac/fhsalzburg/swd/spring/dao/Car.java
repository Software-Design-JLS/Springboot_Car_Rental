package at.ac.fhsalzburg.swd.spring.dao;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String model;
    private String color;
    private String licencePlate;
    private int mileage;
    private double consumption;
    private boolean emobility;
    private String fuel;
    private String type;
    private String status;
    private String damage;
    private String detail;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date availableDate;
    private double price;


    public Car(Long id, String model, String color, String licencePlate, int mileage, double consumption, boolean emobility, String fuel, String type, String status, String damage, String detail, Date availableDate, double price) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.licencePlate = licencePlate;
        this.mileage = mileage;
        this.consumption = consumption;
        this.emobility = emobility;
        this.fuel = fuel;
        this.type = type;
        this.status = status;
        this.damage = damage;
        this.detail = detail;
        this.availableDate = availableDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public boolean isEmobility() {
        return emobility;
    }

    public void setEmobility(boolean emobility) {
        this.emobility = emobility;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
