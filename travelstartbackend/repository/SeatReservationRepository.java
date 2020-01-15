package main.travelstartbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.travelstartbackend.model.SeatReservation;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, Integer>
{

}
