package com.cj.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cj.spring.bean.*;
import com.cj.spring.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public List<User> findAllByCreatedbatetimeBetween(Date startDateTime, Date enddateTime) {
		return userRepository.findAllByCreateddatetimeBetween(startDateTime, enddateTime);
	}

	public List<User> findAllWithCreateddatetimeBefore(Date datetime) {
		return userRepository.findAllWithCreateddatetimeBefore(datetime);
	}
	
}
