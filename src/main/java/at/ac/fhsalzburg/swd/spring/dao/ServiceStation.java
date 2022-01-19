package at.ac.fhsalzburg.swd.spring.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ServiceStation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String location;


    public ServiceStation(Long id, String location) {
        this.id = id;
        this.location = location;
    }

    protected ServiceStation(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
