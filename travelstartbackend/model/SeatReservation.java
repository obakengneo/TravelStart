package main.travelstartbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seat_reservation")
public class SeatReservation 
{
	
	private int flightId;
	
	private int travellerId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatNo;
	
	private String firstName;
	
	private String lastName;
	
	public SeatReservation(int flightId, int travellerId, int seatNo, String firstName, String lastName) 
	{
		super();
		this.flightId = flightId;
		this.travellerId = travellerId;
		this.seatNo = seatNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public SeatReservation() 
	{
		super();
	}

	public int getFlightId() 
	{
		return flightId;
	}

	public void setFlightId(int flightId) 
	{
		this.flightId = flightId;
	}

	public int getTravellerId() 
	{
		return travellerId;
	}

	public void setTravellerId(int travellerId) 
	{
		this.travellerId = travellerId;
	}

	public int getSeatNo() 
	{
		return seatNo;
	}

	public void setSeatNo(int seatNo) 
	{
		this.seatNo = seatNo;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	
}
