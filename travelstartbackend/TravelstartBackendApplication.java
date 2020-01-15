package main.travelstartbackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.travelstartbackend.repository.UserRepository;

@SpringBootApplication
public class TravelstartBackendApplication implements CommandLineRunner 
{
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) 
	{
		SpringApplication.run(TravelstartBackendApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception
	{
		
	}
}
