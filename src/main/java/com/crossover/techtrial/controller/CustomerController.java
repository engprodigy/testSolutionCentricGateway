package com.crossover.techtrial.controller;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.service.HourlyElectricityService;
import com.crossover.techtrial.service.PanelService;
import com.crossover.techtrial.model.Customer;
import com.crossover.techtrial.service.CustomerService;
import com.crossover.techtrial.authentication.AppConfig;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 

/**
 * Customer Controller for all Rest APIs related to Customer.
 * @author Crossover
 *
 */

@RestController
@Component
public class CustomerController {

  @Autowired
  CustomerService customerService;
  
 
  
  
  
  /**
   * Register a customer.
   * @param customer to register.
   * @return
   */
  @PostMapping(path = "/api/customer/register")
  public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
    customerService.register(customer);
    return  ResponseEntity.accepted().build();
  }
  
   @PutMapping(path = "/api/customer/update/{fullname}/{id}")
  public ResponseEntity<?> updateCustomer(@PathVariable(value = "id") long customerid,
          @PathVariable(value = "fullname") String fullname) {
    customerService.update(fullname, customerid);
    return  ResponseEntity.accepted().build();
  }
 
   
  /**
   * Get Hourly Electricity from Previous dates.
   */
  
  @GetMapping(path = "/api/customer/all")
  public ResponseEntity<?> getAllCustomer(
      @PageableDefault(size = 5,value = 0) Pageable pageable) {
   
    Page<Customer> page = customerService.findAll(
        pageable);
    if (page == null) {
      return ResponseEntity.notFound().build(); 
    }else{
    return ResponseEntity.ok(page);
    }
  }
  
  /**
   * 
   * @param customer to delete.
   * @return
   */
  @DeleteMapping(path = "/api/customer/delete")
  public ResponseEntity<?> DeleteEntry(@RequestBody Customer customer) {
    customerService.delete(customer);
    return  ResponseEntity.accepted().build();
  }
  
  
}
  
  