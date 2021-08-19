package com.cj.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cj.spring.bean.*;

public interface UserRepository extends JpaRepository<User, Long>
{
	//Method Name
	List<User> findByNameAndCountry(String name, String country);
	
	//CustomQuery (JPQL Query)
	@Query(value="select new com.cj.spring.repository.UserCountryName(U.country, U.name) from User U")
	List<UserCountryName> findAbc();
	
	//CustomQuery (JPQL Query)
	@Query(value="select new com.cj.spring.repository.UserCountryName(U.country, U.name) from User U where U.name=?1")
	List<UserCountryName> findAbc1(String str);
	
	//Custom Query(using native Query)
	@Query(value="select U.country, U.name from user_info U", nativeQuery=true)
	List<Object[]> findXyz();
	
	//CustomQuery (JPQL Query using Named parameter)
	@Query("SELECT u FROM User u WHERE u.country = :country") //Named parameter
	List<User> findUserByCountry(@Param("country") String country);
	 
	//@Query("SELECT u FROM User u WHERE u.country = ?1 and u.name = ?2")
	//User findUserByCountryAndName(String country, String name);
}
