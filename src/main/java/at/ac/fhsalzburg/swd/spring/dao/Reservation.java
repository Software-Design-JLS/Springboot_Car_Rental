package at.ac.fhsalzburg.swd.spring.dao;

import java.util.Collection;
import java.util.Date;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
	@ManyToOne
	private Customer customer; //here??

	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date reservationDate; //what is this for?

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date departureDate;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date returnDate;

	private String pickupLocation;
	private String returnLocation;
	private String extras; //how to model?
	private double price;
	private boolean payed;
	private boolean status;

	public Reservation(Long id, Customer customer, Date reservationDate, Date departureDate, Date returnDate, String pickupLocation, String returnLocation, String extras, double price, boolean payed, boolean status) {
		this.id = id;
		this.customer = customer;
		this.reservationDate = reservationDate;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.pickupLocation = pickupLocation;
		this.returnLocation = returnLocation;
		this.extras = extras;
		this.price = price;
		this.payed = payed;
		this.status = status;
	}

	public Reservation() {
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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getReturnLocation() {
		return returnLocation;
	}

	public void setReturnLocation(String returnLocation) {
		this.returnLocation = returnLocation;
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
