package com.vrpowerz.ServeBetR.repository;

import com.vrpowerz.ServeBetR.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


/**
 * @author Venkataraghavan Yanamandram
 *
 */

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);
}
