package com.gta.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gta.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	
	@Override
	List<Category> findAll();
	

}
