package com.cj.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cj.spring.bean.User;
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
		return (List<User>) userRepository.findAll();
	}
	
	public List<User> getUser(String sortBy, boolean direction)
    {		
		List<User> lstu = new ArrayList<>();
		Sort sort;
		if(direction)
		{
			sort = Sort.by(sortBy);
		}
		else
		{
			sort = Sort.by(Sort.Direction.DESC, sortBy);	
		}
		
        Iterable<User> pagedResult = userRepository.findAll(sort);
        
        pagedResult.forEach(lstu::add);
         
        return lstu;
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
}
