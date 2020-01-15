package main.travelstartbackend.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reservation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationNo;
	
	private String typeOfReservation;
	
	private Date reservationDate;
	
	public Reservation(int reservationNo, String typeOfReservation, Date reservationDate) 
	{
		super();
		this.reservationNo = reservationNo;
		this.typeOfReservation = typeOfReservation;
		this.reservationDate = reservationDate;
	}
	
	public Reservation() 
	{
		super();
	}

	public int getReservationNo() 
	{
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) 
	{
		this.reservationNo = reservationNo;
	}

	public String getTypeOfReservation() 
	{
		return typeOfReservation;
	}

	public void setTypeOfReservation(String typeOfReservation) 
	{
		this.typeOfReservation = typeOfReservation;
	}

	public Date getReservationDate() 
	{
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) 
	{
		this.reservationDate = reservationDate;
	}
	
}
