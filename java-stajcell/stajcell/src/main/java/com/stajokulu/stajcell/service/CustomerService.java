package com.stajokulu.stajcell.service;

import com.stajokulu.stajcell.model.Customer;
import com.stajokulu.stajcell.repository.BalanceRepository;
import com.stajokulu.stajcell.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer create(String identityNumber, String name, String surname, String gender, String birthYear, String address) {

        Customer customer = new Customer();

        customer.setIdentityNumber(identityNumber);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setGender(gender);
        customer.setBirthYear(birthYear);
        customer.setAddress(address);

        return customerRepository.save(customer);
    }

    public Customer find(String identityNumber) {

        return customerRepository.findById(identityNumber).orElse(null);
    }
}
