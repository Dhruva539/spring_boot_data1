package com.cj.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.cj.spring.bean.*;
public interface AddressRepository extends JpaRepository<Address, Long>
{

}
