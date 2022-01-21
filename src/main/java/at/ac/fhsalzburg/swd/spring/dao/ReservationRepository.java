package at.ac.fhsalzburg.swd.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {


	@Transactional(timeout = 10)
	Optional<Reservation> findById(long id);


	
	
}
