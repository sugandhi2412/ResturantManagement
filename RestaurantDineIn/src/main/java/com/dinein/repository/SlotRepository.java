package com.dinein.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinein.model.Slot;

@Repository
public interface SlotRepository extends CrudRepository<Slot, String>{


	Optional<Slot> findBySlotTimeStartingWith(String substring);


}
