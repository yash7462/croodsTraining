package com.studentrecord.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentrecord.student.dao.StudentDao;
import com.studentrecord.student.exception.ResourceNotFoundException;
import com.studentrecord.student.model.StudentRecords;

@RestController
@RequestMapping("/studentprofile")
public class StudentController {

	@Autowired
	StudentDao studentdao;

	/*
	 * @GetMapping("/") public String getDemo() { return "hello world"; }
	 */

	/**
	 * get all student records
	 * 
	 * @return
	 */
	@GetMapping("/")
	public List<StudentRecords> getAllStudentRecords() {
		return studentdao.getAllStudentRecords();
	}

	/**
	 * get student record by it's id
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/{id}")
	public ResponseEntity<StudentRecords> getStudentRecordsById(@PathVariable(value = "id") long id)
			throws ResourceNotFoundException {

		return studentdao.getStudentRecordsById(id);
	}

	/**
	 * create/add new record of student by its country
	 * 
	 * @param countryid
	 * @param studentrecords
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PostMapping("/{countryid}")
	public StudentRecords addStudentRecords(@PathVariable(value = "countryid") long countryid,
			@RequestBody StudentRecords studentrecords) throws ResourceNotFoundException {
		return studentdao.addStudentRecords(countryid, studentrecords);
	}

	/**
	 * update student record by it's student id
	 * 
	 * @param id
	 * @param studentrecords
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/{id}")
	public ResponseEntity<StudentRecords> updateStudentRecords(@PathVariable(value = "id") long id,
			@RequestBody StudentRecords studentrecords) throws ResourceNotFoundException {

		return studentdao.updateStudentRecords(id, studentrecords);
	}

	/**
	 * Delete student record by its student id
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<StudentRecords> deleteStudentRecords(@PathVariable(value = "id") long id)
			throws ResourceNotFoundException {
		return studentdao.deleteStudentRecords(id);
	}

}
