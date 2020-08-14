package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
