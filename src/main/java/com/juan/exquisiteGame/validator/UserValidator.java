package com.juan.exquisiteGame.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.juan.exquisiteGame.models.User;
import com.juan.exquisiteGame.repositories.UserRepository;



@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
	if(this.uRepo.existsByEmail(user.getEmail())) {
		errors.rejectValue("email", "unique", "email is taken");
		}
	}
}
