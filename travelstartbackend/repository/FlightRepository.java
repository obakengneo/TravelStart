package main.travelstartbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.travelstartbackend.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>
{

}
