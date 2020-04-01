package com.crossover.techtrial.service;

import com.crossover.techtrial.model.Customer;
import com.crossover.techtrial.model.HourlyElectricity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * CustomerService interface for Customers.
 * @author Crossover
 *
 */
public interface CustomerService {
  
  /**
   * Register a panel for electricity monitoring.
   * @param customer to register with system.
   */
  
  void register(Customer customer);
  
  //Customer findBySerial(String serial);
  
  Page<Customer> findAll(Pageable pageable);
  
   void delete(Customer customer);
   
   void update(String fullname, Long Id);
}
