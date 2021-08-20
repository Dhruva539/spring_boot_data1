package com.cj.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cj.spring.bean.*;

/* For update, delete or drop queries @Modifying & @Transactional annotation 
 * need to be used along with @Query */
public interface UserRepository extends JpaRepository<User, Long>
{
	@Transactional
    @Query("UPDATE User SET name = :salutation || name")
    @Modifying
    void addSalutationToName(@Param("salutation") String salutation);
}
