package com.vrpowerz.ServeBetR.repository;

import com.vrpowerz.ServeBetR.model.ServiceCall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

public interface ServiceCallRepository extends CrudRepository<ServiceCall, Long> {
    Page<ServiceCall> findAll(Pageable pageable);
}
