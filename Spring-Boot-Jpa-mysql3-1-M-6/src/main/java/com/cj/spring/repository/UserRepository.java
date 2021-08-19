package com.cj.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cj.spring.bean.Address;
import com.cj.spring.bean.User;
public interface UserRepository extends JpaRepository<User, Long>
{
    //List<User> findByAddressId(Long addressId);
    //Optional<Address> findByIdAndAddressId(Long id, Long addressId);
}
