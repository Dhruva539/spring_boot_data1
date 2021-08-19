package com.cj.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cj.spring.bean.*;

/* Repository methods based on Method names and declaration */
public interface UserRepository extends JpaRepository<User, Long>
{
	List<User> findByNameAndCountry(String name, String country);
	
	List<User> findByNameOrCountry(String name, String country);
	
	List<User> findByNameContainsIgnoreCase(String name);
	
	int countByName(String name);
	
	List<User> findDistinctByName(String name);
	
	List<User> findFirst4ByNameOrderByNameAsc(String name);
	
    List<User> findTop3ByNameOrderByNameAsc(String name);
    
    List<User> findByNameContainsOrCountryContainsAllIgnoreCase(String namePart, String titlePart);
}
