package com.crossover.techtrial.repository;

import com.crossover.techtrial.model.Customer;
import com.crossover.techtrial.model.HourlyElectricity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
/**
 * PanelRepository allows all operations to Panel Entity.
 * @author Crossover
 *
 */

@RestResource(exported = false)
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    //Customer findBySerial(String serial);
    Page<Customer> findAll(Pageable pageable);
    
    
     
}
