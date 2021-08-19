package com.cj.spring.repository;

import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cj.spring.bean.*;

public interface UserRepository extends JpaRepository<User, Long>
{
	  List<User> findAllByCreateddatetimeBetween(Date startDateTime, Date enddateTime);

	  @Query("select U from User U where U.createddatetime <= :datetime")
	  List<User> findAllWithCreateddatetimeBefore(@Param("datetime") Date datetime);
}
