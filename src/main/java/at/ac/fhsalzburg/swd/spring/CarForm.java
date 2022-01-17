package at.ac.fhsalzburg.swd.spring;

public class CarForm {

    private String model;
    private String type;
    private String transmission;
    private String mileage;
    private int numberOfPassengers;
    private String detail;
    private double price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public void setTransmission(String transmission)
    {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) { this.mileage = mileage; }

    public String getDetail() { return detail;
    }
    public void setDetail(String detail) { this.detail = detail; }

    public int getNumberOfPassengers() { return numberOfPassengers; }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}