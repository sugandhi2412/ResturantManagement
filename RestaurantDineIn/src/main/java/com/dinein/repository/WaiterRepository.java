package com.dinein.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinein.model.Waiter;

@Repository
public interface WaiterRepository extends CrudRepository<Waiter, String>{

	Optional<Waiter> findTopByOrderByIdDesc();

	Optional<Waiter> findByEmailIdAndPassword(String emailId, String password);

}
