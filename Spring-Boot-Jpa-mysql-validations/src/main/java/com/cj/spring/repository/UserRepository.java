package com.cj.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cj.spring.bean.User;

interface UserCountryName{
	String getCountry();
	String getName();
}

public interface UserRepository extends JpaRepository<User, Long>
{
	List<User> findByNameAndCountry(String name, String country);
	
	/*@Query(value="select U.country, U.name from user_info U", nativeQuery=true)
	List<Object[]> findXyz(String stitle);
	
	//JPQL Query
	@Query(value="select new UserCountryName(U.country, U.name) from User U")
	List<UserCountryName> findAbc();
	
	//JPQL Query
	@Query(value="select U.country, U.name from User U where U.name=?1")
	List<UserCountryName> findAbc1(String str);
	
	
	@Query("SELECT u FROM User u WHERE u.status = ?1")
User findUserByStatus(Integer status);
 
@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
User findUserByStatusAndName(Integer status, String name);
	 */
	
	//return a Map
	//In JPQL of repository method, use the alias while selecting a property of Entity 
	//and define the List of Map as return type.
	//@Query(value="select U.country as country, U.name as name from user_info U", nativeQuery=true)
	//List<Map<String, Object>> findMno(String stitle);  
	
}
