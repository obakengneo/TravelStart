package main.travelstartbackend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.travelstartbackend.model.Reservation;
import main.travelstartbackend.service.ReservationService;


@RestController
@RequestMapping("/reserve")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReservationController 
{
	@Autowired
	private ReservationService reservationService;

	/*@Autowired
	private EmailSend emailSend;

	@RequestMapping("/send-email/{to}/{subject}/{body}")
	public boolean sendMail(@PathVariable String to, @PathVariable String subject, @PathVariable String body)
			throws MessagingException {
		
		emailSend.send(to, subject, body);
		return true;
	}*/

	@GetMapping("/reservations")
	public List<Reservation> getAllReservations() 
	{
		return reservationService.getAllReservations();
	}

	/*
	 * @GetMapping("/reservations/{id}") public List<Reservation> findAllById(@PathVariable int
	 * id) { return reservationService.findAllById(id); }
	 */

	@PostMapping("/reservation")
	public Reservation reserve(@RequestBody Reservation reservation) 
	{
		return reservationService.reserve(reservation);
	}

	@GetMapping("/delete/{id}")
	public boolean cancelReservation(@PathVariable int id) 
	{
		return reservationService.deleteReservation(id);
	}}
