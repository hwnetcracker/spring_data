package com.netcracker.spring.Data.service;

import com.netcracker.spring.Data.repository.CustomerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service("customerService")
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<String> findLastNameAndSaleByDistrict(String district){
        return customerRepository.findByDistrict(district).stream().map(x-> "lastName="+x.getLastName()+" sale="+x.getSale()).collect(Collectors.toList());
    }
}
