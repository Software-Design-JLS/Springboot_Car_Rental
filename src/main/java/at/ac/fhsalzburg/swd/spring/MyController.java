package at.ac.fhsalzburg.swd.spring;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import at.ac.fhsalzburg.swd.spring.dao.Car;
import at.ac.fhsalzburg.swd.spring.dao.Reservation;
import at.ac.fhsalzburg.swd.spring.dao.ServiceStation;
import at.ac.fhsalzburg.swd.spring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import at.ac.fhsalzburg.swd.spring.dao.Customer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.expression.Lists;

@Controller // marks the class as a web controller, capable of handling the HTTP requests. Spring will look at the methods of the class marked with the @Controller annotation and establish the routing table to know which methods serve which endpoints.
public class MyController {

	@Autowired
	// To wire the application parts together, use @Autowired on the fields, constructors, or methods in a component. Spring's dependency injection mechanism wires appropriate beans into the class members marked with @Autowired.
	private ApplicationContext context;

	@Resource(name = "sessionBean") // The @Resource annotation is part of the JSR-250 annotation collection and is packaged with Jakarta EE. This annotation has the following execution paths, listed by Match by Name, Match by Type, Match by Qualifier. These execution paths are applicable to both setter and field injection. https://www.baeldung.com/spring-annotations-resource-inject-autowire
	TestBean sessionBean;


	@Autowired
	CustomerServiceInterface customerService;

	@Autowired
	CarServiceInterface carService;

	@Autowired
	ServiceStationServiceInterface serviceStationService;

	@Autowired
	ReservationServiceInterface reservationService;

	@Autowired
	TestBean singletonBean;


	@RequestMapping("/")
	// The @RequestMapping(method = RequestMethod.GET, value = "/path") annotation specifies a method in the controller that should be responsible for serving the HTTP request to the given path. Spring will work the implementation details of how it's done. You simply specify the path value on the annotation and Spring will route the requests into the correct action methods: https://springframework.guru/spring-requestmapping-annotation/#:~:text=%40RequestMapping%20is%20one%20of%20the,map%20Spring%20MVC%20controller%20methods.
	public String index(Model model, HttpSession session) {

		if (session == null) {
			model.addAttribute("message", "no session");
		} else {
			Integer count = (Integer) session.getAttribute("count");
			if (count == null) {
				count = new Integer(0);
			}
			count++;
			session.setAttribute("count", count);
		}

		model.addAttribute("message", customerService.doSomething());

		model.addAttribute("halloNachricht", "welchem to SWD lab");

		model.addAttribute("customers", customerService.getAll());

		model.addAttribute("cars", carService.getAll());

		model.addAttribute("reservations", reservationService.getAll());

		model.addAttribute("serviceStations", serviceStationService.getAll());

		model.addAttribute("beanSingleton", singletonBean.getHashCode());

		TestBean prototypeBean = context.getBean("prototypeBean", TestBean.class);
		model.addAttribute("beanPrototype", prototypeBean.getHashCode());

		model.addAttribute("beanSession", sessionBean.getHashCode());


		return "index";
	}


	@RequestMapping(value = {"/addCustomer"}, method = RequestMethod.POST)
	public String addCustomer(Model model, //
							  @ModelAttribute("customerForm") CustomerForm customerForm) { // The @ModelAttribute is an annotation that binds a method parameter or method return value to a named model attribute and then exposes it to a web view: https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
		String firstName = customerForm.getFirstName();
		String lastName = customerForm.getLastName();
		String eMail = customerForm.getEMail();
		String tel = customerForm.getTel();
		String age = customerForm.getAge();
		String address = customerForm.getAddress();
		String gender = customerForm.getGender();
		customerService.addCustomer(firstName, lastName, address, age, gender, tel, eMail);
		return "redirect:/";
	}

	@RequestMapping(value = {"/addCustomer"}, method = RequestMethod.GET)
	public String showAddPersonPage(Model model) {
		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);

		model.addAttribute("message", customerService.doSomething());

		return "addCustomer";
	}


	// Mappings for REST-Service

	@GetMapping("/customers")
	// @GetMapping annotation maps HTTP GET requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	public @ResponseBody
	List<Customer> allUsers() {

		return (List<Customer>) customerService.getAll();
	}

	@GetMapping("/serviceStations")
	// @GetMapping annotation maps HTTP GET requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	public @ResponseBody
	List<ServiceStation> allServiceStations() {

		return (List<ServiceStation>) serviceStationService.getAll();
	}

	@RequestMapping(value = {"/customers/{id}"}, method = RequestMethod.GET)
	public @ResponseBody
	Customer getCustomer(@PathVariable long id) {
		Customer customer = customerService.getById(id);

		return customer;
	}

	@RequestMapping(value = {"/customers/{id}"}, method = RequestMethod.PUT)
	public String setCustomer(@RequestBody Customer customer) {

		customerService.addCustomer(customer);

		return "redirect:/customers";
	}

	@DeleteMapping("/customers/{id}")
	// @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE).
	public String delete(@PathVariable String id) {
		Long customerid = Long.parseLong(id);
		customerService.deleteById(customerid);
		return "redirect:/customers";
	}

	@RequestMapping(value = {"/addCar"}, method = RequestMethod.POST)
	public String addCar(Model model, //
						 @ModelAttribute("carForm") CarForm carForm) { // The @ModelAttribute is an annotation that binds a method parameter or method return value to a named model attribute and then exposes it to a web view: https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
		String modell = carForm.getModel();
		String type = carForm.getType();
		String transmission = carForm.getTransmission();
		String mileage = carForm.getMileage();
		String detail = carForm.getDetail();
		int numberOfPassengers = carForm.getNumberOfPassengers();
		double price = carForm.getPrice();
		carService.addCar(modell, type, transmission, mileage, numberOfPassengers, detail, price);
		return "redirect:/";
	}

	@RequestMapping(value = {"/addCar"}, method = RequestMethod.GET)
	public String showAddCarPage(Model model) {
		CarForm carForm = new CarForm();
		model.addAttribute("carForm", carForm);

		model.addAttribute("cars", carService.getAll());

		model.addAttribute("message", carService.doSomething());

		return "addCar";
	}

	// Mappings for REST-Service

	@GetMapping("/cars")
	// @GetMapping annotation maps HTTP GET requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	public @ResponseBody
	List<Car> allCars() {

		return (List<Car>) carService.getAll();
	}

	@RequestMapping(value = {"/cars/{id}"}, method = RequestMethod.GET)
	public @ResponseBody
	Car getCar(@PathVariable long id) {
		Car car = carService.getById(id);

		return car;
	}

	@RequestMapping(value = {"/cars/{id}"}, method = RequestMethod.PUT)
	public String setCar(@RequestBody Car car) {

		carService.addCar(car);

		return "redirect:/cars";
	}

	@DeleteMapping("/cars/{id}")
	// @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE).
	public String deleteCar(@PathVariable String id) {
		Long carid = Long.parseLong(id);
		carService.deleteById(carid);
		return "redirect:/cars";
	}


	//Reservation

	@RequestMapping(value = {"/addReservation"}, method = RequestMethod.POST)
	public String addReservation(Model model, //
								 @ModelAttribute("reservationForm") ReservationForm reservationForm) { // The @ModelAttribute is an annotation that binds a method parameter or method return value to a named model attribute and then exposes it to a web view: https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
		Customer customer = reservationForm.getCustomer();
		Car car = reservationForm.getCar();
		LocalDate reservationDate = reservationForm.getReservationDate();
		LocalDate returnDate = reservationForm.getReturnDate();
		ServiceStation returnServiceStation = reservationForm.getReturnServiceStation();
		ServiceStation reservationServiceStation = reservationForm.getReservationServiceStation();

		reservationService.addReservation(customer, car, reservationDate, returnDate, returnServiceStation, reservationServiceStation);
		return "redirect:/";
	}


	@RequestMapping(value = {"/addReservation"}, method = RequestMethod.GET)
	public String showAddReservationPage(Model model) {
		ReservationForm reservationForm = new ReservationForm();
		model.addAttribute("reservationForm", reservationForm);

		model.addAttribute("reservations", reservationService.getAll());

		model.addAttribute("message", reservationService.doSomething());

		return "addReservation";
	}

	// Mappings for REST-Service

	@GetMapping("/reservations")
	// @GetMapping annotation maps HTTP GET requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
	public @ResponseBody
	List<Reservation> allReservations() {

		return (List<Reservation>) reservationService.getAll();
	}

	@RequestMapping(value = {"/reservations/{id}"}, method = RequestMethod.GET)
	public @ResponseBody
	Reservation getReservation(@PathVariable long id) {
		Reservation reservation = reservationService.getById(id);

		return reservation;
	}

	@RequestMapping(value = {"/reservations/{id}"}, method = RequestMethod.PUT)
	public String setReservation(@RequestBody Reservation reservation) {

		reservationService.addReservation(reservation);

		return "redirect:/reservations";
	}



}






