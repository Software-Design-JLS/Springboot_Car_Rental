package at.ac.fhsalzburg.swd.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ServiceStationRepository extends CrudRepository<ServiceStation, Long> {


        @Transactional(timeout = 10)
        ServiceStation findById(long id);


}
