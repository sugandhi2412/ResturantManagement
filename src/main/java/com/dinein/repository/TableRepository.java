package com.dinein.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinein.model.Table;

@Repository
public interface TableRepository extends CrudRepository<Table, String>{

	Optional<Table> findTopByOrderByIdDesc();
	Optional<Table> findByTableNo(int roomNo);
	List<Table> findByCapacity(int capacity);
	
	@Query(value = "SELECT DISTINCT capacity FROM table")
    List<Table> findDistinctByCapacity();

}
