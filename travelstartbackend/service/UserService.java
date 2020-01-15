package main.travelstartbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.travelstartbackend.model.User;
import main.travelstartbackend.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository userRepository;

	public User save(User user) 
	{
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) 
	{
		return userRepository.save(user);
	}

	public User find(String username) 
	{
		return userRepository.findByUsername(username);
	}

	public User find(int id) 
	{
		return userRepository.findOne(id);
	}
}
