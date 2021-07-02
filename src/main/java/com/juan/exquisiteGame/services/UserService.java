package com.juan.exquisiteGame.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.exquisiteGame.models.User;
import com.juan.exquisiteGame.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User find(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	public User getSingleUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public List<User> allUsers() {
		return this.uRepo.findAll(); 
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		
		if (user == null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	public User saveUser(User user) {
		return this.uRepo.save(user);
	}
}
