package at.ac.fhsalzburg.swd.spring.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Reservation {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	@ManyToOne
	private Car car;

	@ManyToOne
	private Customer customer;

    private LocalDate reservationDate;

	private LocalDate returnDate;

	@ManyToOne
	private ServiceStation rentalServiceStation;

	@ManyToOne
	private ServiceStation returnServiceStation;
	private String extras; //how to model?
	private double price;
	private boolean payed;
	private boolean status;


	protected Reservation() {}

	public Reservation(Customer customer, Car car, LocalDate reservationDate, LocalDate returnDate, ServiceStation rentalServiceStation, ServiceStation returnServiceStation) {
		this.customer = customer;
		this.car = car;
		this.reservationDate = reservationDate;
		this.returnDate = returnDate;
		this.rentalServiceStation = rentalServiceStation;
		this.returnServiceStation = returnServiceStation;
		/*this.extras = extras;
		this.price = price;
		this.payed = payed;
		this.status = status;*/
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar(){
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public ServiceStation getRentalServiceStation() {
		return rentalServiceStation;
	}

	public void setRentalServiceStation(ServiceStation rentalServiceStation) {
		this.rentalServiceStation = rentalServiceStation;
	}

	public ServiceStation getReturnServiceStation() {
		return returnServiceStation;
	}

	public void setReturnServiceStation(ServiceStation returnServiceStation) {
		this.returnServiceStation = returnServiceStation;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
