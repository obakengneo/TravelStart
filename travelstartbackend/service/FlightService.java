package main.travelstartbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import main.travelstartbackend.model.Flight;
import main.travelstartbackend.repository.FlightRepository;
import main.travelstartbackend.repository.SeatReservationRepository;

@Service
public class FlightService 
{
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private SeatReservationRepository seatReservationRepository;
	
	//get all the flights in the database
	public List<Flight> getAllFlights() 
	{
		return flightRepository.findAll();
	}
	
	//getting a specific flight
	public Flight getFlight(@PathVariable int id) 
	{
		Flight flight = new Flight();

		for (int i = 0; i < flightRepository.findAll().size(); i++) 
		{
			if (flightRepository.findAll().get(i).getFlightId() == id) 
			{
				flight = flightRepository.findAll().get(i);
				break;
			}
		}

		return flight;
	}

	//adding new flights to card or by Administrator
	public Flight addFlight(@RequestBody Flight flight) 
	{
		return flightRepository.save(flight);
	}
	
	//update a flight
	public Flight updateFlight(Flight flight) 
	{
		return flightRepository.save(flight);
	}
	
	//get number of reserved seats of a certain flight and use the size
	public List<Integer> reservedSeats(int flightId) 
	{
		List<Integer> seats = new ArrayList<>();

		for (int i = 0; i < seatReservationRepository.findAll().size(); i++)
		{
			if (seatReservationRepository.findAll().get(i).getFlightId() == flightId)
			{
				seats.add(seatReservationRepository.findAll().get(i).getSeatNo());
			}
		}

		return seats;
	}
	
	//calculate number of available seats
	public int seatsAvailable(int reservedSeats, int flightId)
	{
		int availableSeats = 0;
		
		availableSeats = getFlight((int)flightId).getCapacity() - reservedSeats;
		
		/*getFlight((int) flightId).setAvailableSeats(availableSeats);
		updateFlight(getFlight((int) flightId));*/
		
		return availableSeats;
	}

	//search for available flights and only the available flights
	public List<Flight> searchFlights(@PathVariable String departureCity, @PathVariable String arrivalCity, @PathVariable int numberOfTravellers, @PathVariable String preferredClass) 
	{
		List<Flight> flights = new ArrayList<>();
		int flightId = -1;

		for (int i = 0; i < getAllFlights().size(); i++) 
		{
			if (flightRepository.findAll().get(i).getDepartureCity()
					.contains(departureCity)&& flightRepository.findAll().get(i).getArrivalCity()
							.contains(arrivalCity) && flightRepository.findAll().get(i).getPreferredClass()
							.contains(preferredClass)) // && flightRepository.findAll().get(i).getDepartureDate().equals(departureDate)) 
			{
				flightId = flightRepository.findAll().get(i).getFlightId();
				
				if (getFlight((int) flightId).getCapacity() > reservedSeats(flightId).size() && seatsAvailable(reservedSeats(flightId).size(), flightId) >= numberOfTravellers) 
				{
					flights.add(getAllFlights().get(i));
				}
			}
		}

		return flights;
	}
	
	//delete the flight in cart
	public boolean deleteFlight(int id) 
	{
		flightRepository.delete(flightRepository.getOne(id));
		return true;
	}

	//get flights by user id that were reserved
	public List<Flight> searchFlightByUserId(@PathVariable int userId) 
	{
		List<Flight> flights = new ArrayList<>();

		for (int i = 0; i < flightRepository.findAll().size(); i++) 
		{
			if (flightRepository.findAll().get(i).getFlightId() == userId) 
			{
				flights.add(flightRepository.findAll().get(i));
			}
		}
		
		return flights;
	}
}
