package com.vrpowerz.ServeBetR.repository;

import com.vrpowerz.ServeBetR.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String Username);

    Page<User> findAll(Pageable pageable);
}
