package com.dinein.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinein.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String>{

	Optional<Category> findTopByOrderByIdDesc();

	Optional<Category> findByCatId(String catId);


}
