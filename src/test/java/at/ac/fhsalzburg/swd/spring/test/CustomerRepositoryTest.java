package at.ac.fhsalzburg.swd.spring.test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import at.ac.fhsalzburg.swd.spring.dao.Car;
import at.ac.fhsalzburg.swd.spring.dao.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import at.ac.fhsalzburg.swd.spring.dao.Customer;
import at.ac.fhsalzburg.swd.spring.dao.CustomerRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarRepository carRepository;
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Customer customer = new Customer("Ioana", "Lazea", "Salzburg", "21", "Female", "+40726871238", "lazea@ioana.man");
        entityManager.persist(customer);
        entityManager.flush();
        List<Customer> given = new ArrayList<Customer>();
        given.add(customer);
     
        // when
        List<Customer> found = customerRepository.findByLastName(customer.getLastName());
     
        // then
        assertIterableEquals(given, found);
        
    }



 
}