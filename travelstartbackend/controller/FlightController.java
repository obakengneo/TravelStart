package main.travelstartbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.travelstartbackend.model.Flight;
import main.travelstartbackend.service.FlightService;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FlightController 
{
	@Autowired
	private FlightService flightService;

	//get all the flights in the database
	@GetMapping("/flights")
	public List<Flight> getAllFlights() 
	{
		return flightService.getAllFlights();
	}
	
	//get a specific flight by its flight id
	@GetMapping("/flight/{id}")
	public Flight getFlight(@PathVariable int id) 
	{
		return flightService.getFlight(id);
	}

	//add a new flight
	@PostMapping("/flight")
	public Flight addFlight(@RequestBody Flight flight) 
	{
		return flightService.addFlight(flight);
	}
	
	//update flight by flight id
	@PutMapping("/flight/{id}")
	public Flight updateFlight(@RequestBody Flight flight)
	{
		return flightService.updateFlight(flight);
	}
	
	@GetMapping("/search/{departureCity}/{arrivalCity}/{numberOfTravellers}/{preferredClass}")
	public List<Flight> searchFlights(@PathVariable String departureCity,
			@PathVariable String arrivalCity, @PathVariable int numberOfTravellers, @PathVariable String preferredClass)  
	{
		return flightService.searchFlights(departureCity, arrivalCity, numberOfTravellers, preferredClass);
	}

	//delete a flight by flightId
	@GetMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) 
	{
		return flightService.deleteFlight(id);
	}
	
	//get flights by user id that were reserved
	@GetMapping("/flightByUser/{id}")
	public List<Flight> searchFlightsById(@PathVariable int userId) 
	{
		return flightService.searchFlightByUserId(userId);
	}
}
