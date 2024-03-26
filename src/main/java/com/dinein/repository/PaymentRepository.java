package com.dinein.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinein.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, String>{

	Optional<Payment> findTopByOrderByIdDesc();

	Optional<Payment> findByOrderId(String orderId);

	

}
