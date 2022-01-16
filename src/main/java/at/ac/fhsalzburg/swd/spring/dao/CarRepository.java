package at.ac.fhsalzburg.swd.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    @Transactional(timeout = 10)
    List<Car> findByModel(String model);


    @Transactional(timeout = 10)
    Car findById(long id);
}
