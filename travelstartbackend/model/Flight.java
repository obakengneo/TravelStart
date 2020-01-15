package main.travelstartbackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "flight")
public class Flight 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	private int flightId;
	
	@Column(name = "departure_time")
	private String departureTime;
	
	@Column(name = "departure_date")
	private String departureDate;
	
	@Column(name = "arrival_time")
	private String arrivalTime;
	
	@Column(name = "departure_city")
	private String departureCity;
	
	@Column(name = "arrival_city")
	private String arrivalCity;
	
	@Column(name = "available_seats")
	private int availableSeats;
	
	@Column(name = "flight_company")
	private String flightCompany;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "adult_price")
	private double adultPrice;
	
	@Column(name = "child_price")
	private double childPrice;
	
	@Column(name = "reserved_seats")
	private int reservedSeats;
	
	@Column(name = "preferred_class")
	private String preferredClass;
	
	
	public Flight(int flightId, String departureTime, String arrivalTime, String departureCity, String arrivalCity,
			int availableSeats, String flightCompany, int capacity, double adultPrice, double childPrice, String departureDate, int reservedSeats, String preferredClass) 
	{
		super();
		this.flightId = flightId;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.availableSeats = availableSeats;
		this.flightCompany = flightCompany;
		this.capacity = capacity;
		this.adultPrice = adultPrice;
		this.childPrice = childPrice;
		this.departureDate = departureDate;
		this.reservedSeats = reservedSeats;
		this.preferredClass = preferredClass;
	}
	
	public Flight() 
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
	public String getDepartureTime() 
	{
		return departureTime;
	}
	public void setDepartureTime(String departureTime) 
	{
		this.departureTime = departureTime;
	}
	public String getArrivalTime() 
	{
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) 
	{
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureCity() 
	{
		return departureCity;
	}
	public void setDepartureCity(String departureCity) 
	{
		this.departureCity = departureCity;
	}
	public String getArrivalCity() 
	{
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) 
	{
		this.arrivalCity = arrivalCity;
	}
	public int getAvailableSeats() 
	{
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) 
	{
		this.availableSeats = availableSeats;
	}
	public String getFlightCompany() 
	{
		return flightCompany;
	}
	public void setFlightCompany(String flightCompany) 
	{
		this.flightCompany = flightCompany;
	}
	public int getCapacity() 
	{
		return capacity;
	}
	public void setCapacity(int capacity) 
	{
		this.capacity = capacity;
	}
	public double getAdultPrice() 
	{
		return adultPrice;
	}
	public void setAdultPrice(double adultPrice) 
	{
		this.adultPrice = adultPrice;
	}
	public double getChildPrice() 
	{
		return childPrice;
	}
	public void setChildPrice(double childPrice) 
	{
		this.childPrice = childPrice;
	}

	public String getDepartureDate() 
	{
		return departureDate;
	}

	public void setDepartureDate(String departureDate) 
	{
		this.departureDate = departureDate;
	}

	public int getReservedSeats() 
	{
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) 
	{
		this.reservedSeats = reservedSeats;
	}

	public String getPreferredClass() 
	{
		return preferredClass;
	}

	public void setPreferredClass(String preferredClass) 
	{
		this.preferredClass = preferredClass;
	}

	
	/*
	@Override
	public String toString() 
	{
		return "Flight [id =" + flightId + ", flightCompany =" + flightCompany + ", departureDate =" + departureDate + ", departureCity ="
				+ departureCity + ", departureTime =" + departureTime + ", arrivalDate=" + arrivalDate + ", arrivalCity ="
				+ arrivalCity + ", arrivalTime =" + arrivalTime + ", capacity=" + capacity + ", adultPrice =" + adultPrice
				+ ", childPrice =" + childPrice + ", availableTickets=" + availableSeats + "]";
	}*/
	
}
