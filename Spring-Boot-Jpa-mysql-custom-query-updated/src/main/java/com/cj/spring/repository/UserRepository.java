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
	
	@Query(value="from User U")
	List<User> findUsers();
	
	//CustomQuery (JPQL Query)
	@Query(value="select new com.cj.spring.repository.UserCountryName(U.country, U.name) from User U where U.name=?1")
	List<UserCountryName> findAbc1(String str);
	
	//CustomQuery (JPQL Query)
	@Query(value="select new com.cj.spring.repository.UserCountryName(U.country, U.name) from User U where U.name like %?1%")
	List<UserCountryName> findAbc2(String str);
	
	//Custom Query(using native Query)
	@Query(value="select U.country, U.name from user_info U", nativeQuery=true)
	List<Object[]> findXyz();
	
	//CustomQuery (JPQL Query using Named parameter)
	@Query("SELECT u FROM User u WHERE u.country = :ctry") //Named parameter
	List<User> findUserByCountry(@Param("ctry") String country);
	 
	//@Query("SELECT u FROM User u WHERE u.country = ?1 and u.name = ?2")
	//User findUserByCountryAndName(String country, String name);
}
