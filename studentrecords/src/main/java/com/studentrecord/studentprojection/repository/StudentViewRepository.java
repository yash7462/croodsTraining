package com.studentrecord.studentprojection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentrecord.studentprojection.model.StudentView;
@Repository
public interface StudentViewRepository extends JpaRepository<StudentView, Long> {

}
