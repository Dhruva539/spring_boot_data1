package com.cj.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cj.spring.bean.User;

public interface UserService {
	public void createUser(User user);

	public List<User> findAllByCreatedbatetimeBetween(Date startDateTime, Date enddateTime);

	public List<User> findAllWithCreateddatetimeBefore(Date datetime);
}
