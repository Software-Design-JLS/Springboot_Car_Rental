package at.ac.fhsalzburg.swd.spring.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.*;

import at.ac.fhsalzburg.swd.spring.CarForm;
import at.ac.fhsalzburg.swd.spring.ReservationForm;
import at.ac.fhsalzburg.swd.spring.dao.*;
import at.ac.fhsalzburg.swd.spring.services.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.*;

import at.ac.fhsalzburg.swd.spring.CustomerForm;
import at.ac.fhsalzburg.swd.spring.MyController;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class ControllerTest {
	
    @Autowired
    private MockMvc mvc;
 	
    // in these tests we focus on the controller, so we don't test the repo and mock the needed behavior
    @MockBean
    private CustomerRepository repo;
    // in these tests we focus on the controller, so we don't test the repo and mock the needed behavior
    @MockBean
    private CarRepository repoCar;
    // in these tests we focus on the controller, so we don't test the repo and mock the needed behavior
    @MockBean
    private ServiceStationRepository repoServiceStation;
    @Autowired
    MyController myController;
 
    @Test
    public void whenControllerInjected_thenNotNull() throws Exception {
        assertThat(myController).isNotNull();
    }
    
    // Test /
    @Test
    public void givenNothing_whenHome_thenIndex()
  	      throws Exception {
    
    	mvc.perform(MockMvcRequestBuilders.get("/")
        		.contentType(MediaType.TEXT_HTML))
        		.andExpect(status().isOk())
        		.andExpect(model().attributeExists("customers"))
        		.andExpect(view().name("index"));;
    	
    }
    
    // HTTP add customer test
    @Test
    public void givenCustomerForm_whenAddCustomer_thenRedirect()
    	      throws Exception {
    	
    	CustomerForm form = new CustomerForm();
        form.setFirstName("Max");
        form.setLastName("MusterMann");
        form.setEMail("max@musterm.ann");
        form.setTel("123");
        form.setAge("21");
        form.setGender("male");
        form.setAddress("Puch Urstein");
        
        mvc.perform(MockMvcRequestBuilders.post	("/addCustomer",form)
        		.contentType(MediaType.TEXT_HTML))
        		.andExpect(status().is3xxRedirection());
    
    }

    // HTTP add car test
    @Test
    public void givenCarForm_whenAddCar_thenRedirect()
            throws Exception {

        CarForm form = new CarForm();
        form.setModel("Toyota");
        form.setType("Cars");
        form.setTransmission("Automatic");
        form.setMileage("Limited");
        form.setNumberOfPassengers(5);
        form.setDetail("Mini");
        form.setPrice(70);
        form.setStatus("Available");

        mvc.perform(MockMvcRequestBuilders.post	("/addCar",form)
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection());

    }

    // HTTP add reservation test
    @Test
    public void givenReservationForm_whenAddReservation_thenRedirect()
            throws Exception {

        ReservationForm form = new ReservationForm();
        //customer
        Customer customer = new Customer("Max", "Mustermann", "Puch Urstein", "23", "Male", "+40723571234", "max@muster.man");
        repo.save(customer);
        List<Customer> allCustomers = Arrays.asList(customer);
        // mock the repo: whenever findAll is called, we will get our predefined customer
        given(repo.findAll()).willReturn(allCustomers);

        //car
        Car car = new Car("VW", "Passenger Vans", "Manual", "Limited ", 4, "Mini", 80,"Not Available");
        repoCar.save(car);
        List<Car> allCars = Arrays.asList(car);
        // mock the repo: whenever findAll is called, we will get our predefined customer
        given(repoCar.findAll()).willReturn(allCars);


        //service

        ServiceStation service = new ServiceStation("Salzburg");
        repoServiceStation.save(service);
        List<ServiceStation> allStations = Arrays.asList(service);
        // mock the repo: whenever findAll is called, we will get our predefined customer
        given(repoServiceStation.findAll()).willReturn(allStations);

        form.setCustomer(repo.findAll().iterator().next());
        form.setCar(repoCar.findAll().iterator().next());
        form.setReservationDate(LocalDate.parse("2022-01-21"));
        form.setReturnDate(LocalDate.parse("2022-01-28"));
        form.setReservationServiceStation(repoServiceStation.findAll().iterator().next());
        form.setReturnServiceStation(repoServiceStation.findAll().iterator().next());

        mvc.perform(MockMvcRequestBuilders.post	("/addReservation",form)
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection());

    }


    
    
    // REST Service Test
    @Test
    public void givenCustomer_whenGetCustomer_thenReturnJsonArrayTest()
      throws Exception {
         
    	Customer customer = new Customer("Max","Mustermann","max@muster.com","123");
     
        List<Customer> allCustomers = Arrays.asList(customer);
        
        // mock the repo: whenever findAll is called, we will get our predefined customer
        given(repo.findAll()).willReturn(allCustomers);
        
        // call REST service and check
        mvc.perform(get("/customers")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.length()", is(1)))
          .andExpect(jsonPath("$[0].lastName", is(customer.getLastName())));

        
    }
    
    

}
