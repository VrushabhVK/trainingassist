package com.gta.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gta.Entity.*;

public interface QaaRepo extends JpaRepository<Qaa, Long> {

	@Override
	List<Qaa> findAll();
	
	
	/*
	 * @Query("select q from Qaa q WHERE q.refId==?") List<Qaa> getSelQaa();
	 */
	
	public  List<Qaa> findByRefId(Long refId);
	
	
}
