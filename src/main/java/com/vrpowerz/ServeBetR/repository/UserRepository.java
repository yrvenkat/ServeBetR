package com.vrpowerz.ServeBetR.repository;

import com.vrpowerz.ServeBetR.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
