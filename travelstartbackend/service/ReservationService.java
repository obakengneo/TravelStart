package main.travelstartbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.travelstartbackend.model.Reservation;
import main.travelstartbackend.repository.ReservationRepository;

@Service
public class ReservationService 
{
	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> getAllReservations() 
	{
		return reservationRepository.findAll();
	}

	public Reservation reserve(Reservation reserve) 
	{
		return reservationRepository.save(reserve);
	}

	public boolean deleteReservation(int id) 
	{
		for (int i = 0; i < reservationRepository.findAll().size(); i++) 
		{
			if (reservationRepository.findAll().get(i).getReservationNo() == id) 
			{
				reservationRepository.delete(reservationRepository.findAll().get(i));
				break;
			}
		}

		return true;
	}
}
