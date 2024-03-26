package com.dinein.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinein.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, String>{

	Optional<Reservation> findTopByOrderByIdDesc();

	List<Reservation> findByCustomerId(String customerId);

	Optional<Reservation> findByBdateAndSlotTimeAndTableNoAndStatus(String bdate, String slotTime, int tableNo, String status);

	Optional<Reservation> findTopByOrderByReservationIdDesc();

	Optional<Reservation> findByReservationId(String reservationId);

}
