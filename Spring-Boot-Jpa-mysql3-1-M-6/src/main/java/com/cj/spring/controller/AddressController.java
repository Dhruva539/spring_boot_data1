package com.cj.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cj.spring.bean.Address;
import com.cj.spring.bean.User;
import com.cj.spring.repository.AddressRepository;
import com.cj.spring.repository.UserRepository;

import java.util.List;

import javax.validation.Valid;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}/addresses")
    public List<Address> getAllAddressByUserId(@PathVariable (value = "userId") Long userId) {
        return addressRepository.findByUserId(userId);
    }

    @PostMapping("/users/{userId}/address")
    public Address createAddress(@PathVariable (value = "userId") Long userId,
                                 @Valid @RequestBody Address address) {
        return userRepository.findById(userId).map(user -> {
            address.setUser(user);
            return addressRepository.save(address);
        }).get();
    }
}