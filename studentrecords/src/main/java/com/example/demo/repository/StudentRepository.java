package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.StudentRecords;

public interface StudentRepository extends JpaRepository<StudentRecords, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM studentprofile WHERE id = ?1", nativeQuery = true)
	int deleteByid(@Param("id") long id);
}
