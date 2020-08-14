package com.studentrecord.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentrecord.student.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
