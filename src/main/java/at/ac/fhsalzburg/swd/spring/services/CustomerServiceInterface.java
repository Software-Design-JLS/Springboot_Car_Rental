package at.ac.fhsalzburg.swd.spring.services;

import at.ac.fhsalzburg.swd.spring.dao.Customer;

import java.util.List;

public interface CustomerServiceInterface {

	public abstract String doSomething();

	public abstract boolean addCustomer(String firstName, String lastName, String eMail, String Tel);
	public abstract boolean addCustomer(String firstName, String lastName, String address, String age, String gender, String tel, String eMail);

	public abstract boolean addCustomer(Customer costumer);

	//public abstract List<Customer> getCustomerList();

	public abstract Iterable<Customer> getAll();

	public abstract Customer getById(Long id);

	public abstract void deleteById(Long id);

	public abstract boolean hasCredit(Customer customer);

}
