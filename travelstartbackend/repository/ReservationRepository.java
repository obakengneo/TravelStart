package main.travelstartbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.travelstartbackend.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>
{

}
