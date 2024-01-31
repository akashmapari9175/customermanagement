package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.customer.entity.Customer;
import com.customer.repository.CustomerRepo;

//@Controller
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/")
	public String welcomeCar() {
		return "welcome";
	}
	
	@PostMapping("/savecustomer")
	public Customer saveCar(@RequestBody Customer customer) {
		Customer savecustomer = customerRepo.save(customer);
		return savecustomer;
	}
	@GetMapping("/allcustomer")
	public List<Customer> findAllCar(){
		List<Customer> allcustomer = customerRepo.findAll();
		return allcustomer;
	}
	
	@GetMapping("/getcustomer/{id}")
	public Customer findCarById(@PathVariable int id) {
		Customer findById = customerRepo.findById(id).get();
		return findById;
	}
	@PutMapping("/update/{id}")
	public Customer updateCar(@RequestBody Customer customer,@PathVariable int id) {
		Customer customer1 = customerRepo.findById(id).get();
		customer1.setAddress(customer.getAddress());
		customer1.setCity(customer.getCity());
		customer1.setCustomerId(id);
		customer1.setEmail(customer.getEmail());
		customer1.setState(customer.getState());
		customer1.setStreet(customer.getStreet());
		customer1.setFirst_name(customer.getFirst_name());
		customer1.setLast_name(customer.getLast_name());
		Customer save = customerRepo.save(customer1);
		return save;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteCarById(@PathVariable int id) {
		customerRepo.deleteById(id);
		return "Customer deleted Successfully";
	}
	
	
}
