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
    private AddressRepository addrRepository;

    @GetMapping("/addrs")
    public List<Address> getAllAddress() {
        return addrRepository.findAll();
    }
}