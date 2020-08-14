package com.studentrecord.student.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studentrecord.student.model.StudentRecords;
import com.studentrecord.student.model.StudentRecordsDTO;

public interface StudentRepository extends JpaRepository<StudentRecords, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM studentprofile WHERE id = ?1", nativeQuery = true)
	int deleteByid(@Param("id") long id);
	
	List<StudentRecordsDTO> findByFirstName(String firstName);
}
