package at.ac.fhsalzburg.swd.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CarRepository extends CrudRepository<Car, Long> {
    @Transactional(timeout = 10)
    Car findById(long id);
}
