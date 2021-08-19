package com.cj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cj.spring.bean.*;
import com.cj.spring.repository.UserCountryName;
import com.cj.spring.repository.UserRepository;

@Service
//@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public List<User> getUser() {
		displayUsers(
				userRepository.findByNameAndCountry("ccccccccccccccccccccccccc", "IND"));
		
		displayUsers(
				userRepository.findByNameOrCountry("ccccccccccccccccccccccccc", "IND"));
		
		displayUsers(
				userRepository.findByNameContainsIgnoreCase("ccccccccccccccccccccCCCCC"));
		

		System.out.println("No. of people with the name:"+userRepository.countByName("ccccccccccccccccccccccccc"));
		
		displayUsers(
				userRepository.findDistinctByName("bbbbbbbb"));
		/*
		displayUsers(
				userRepository.findFirst4ByNameOrderByNameAsc(String name);
	    
		displayUsers(
				userRepository.findByNameContainsOrCountryContainsAllIgnoreCase(String namePart, String titlePart);
		 */
		return userRepository.findAll();
	}
	
	public void displayUsers(List<User> luser) {
		luser.forEach(obj->System.out.println(obj.getName()+"\t"+obj.getCountry()));
		System.out.println("-----------------------------------------");
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
		//return null;
	}

	public User update(User user, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	public User updatePartially(User user, long id) {
		// TODO Auto-generated method stub
		User usr = findById(id);
		usr.setCountry(user.getCountry());
		return userRepository.save(usr);
	}


	public List<User> findByNameAndCountry(String name, String country) {
		return userRepository.findByNameAndCountry(name, country);
	}
}
