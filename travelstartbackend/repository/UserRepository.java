package main.travelstartbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.travelstartbackend.model.User;

public interface UserRepository extends JpaRepository<User, Integer>    
{
	User findByUsername (String username);
}
