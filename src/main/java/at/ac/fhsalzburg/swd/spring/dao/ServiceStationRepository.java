package at.ac.fhsalzburg.swd.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ServiceStationRepository extends CrudRepository<Reservation, Long> {
    public interface ReservationRepository  {

        @Transactional(timeout = 10)
        ServiceStation findById(long id);


    }
}
