package com.studentrecord.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentrecord.student.exception.ResourceNotFoundException;
import com.studentrecord.student.model.StudentRecords;
import com.studentrecord.student.model.StudentRecordsDTO;
import com.studentrecord.student.repository.CountryRepository;
import com.studentrecord.student.repository.StudentRepository;

@Component
public class StudentDao {

	@Autowired
	StudentRepository studentrepo;

	@Autowired
	CountryRepository countryrepo;

	
	public List<StudentRecordsDTO> getByFirstName(String firstName) {
		return studentrepo.findByFirstName(firstName);
	}

	/**
	 * get all student records
	 * 
	 * @return
	 */
	
	public List<StudentRecords> getAllStudentRecords() {
		return studentrepo.findAll();
	}

	/**
	 * get student record by it's id
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	
	public ResponseEntity<StudentRecords> getStudentRecordsById(@PathVariable(value = "id") long id)
			throws ResourceNotFoundException {
		StudentRecords sturecords = studentrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found"));

		return ResponseEntity.ok().body(sturecords);
	}

	/**
	 * create/add new record of student by its country
	 * 
	 * @param countryid
	 * @param studentrecords
	 * @return
	 * @throws ResourceNotFoundException
	 */
	
	public StudentRecords addStudentRecords(@PathVariable(value = "countryid") long countryid,
			@RequestBody StudentRecords studentrecords) throws ResourceNotFoundException {
		return countryrepo.findById(countryid).map(country -> {
			studentrecords.setCountry(country);
			return studentrepo.save(studentrecords);
		}).orElseThrow(() -> new ResourceNotFoundException("category  " + countryid + " not found"));
		// return studentrepo.save(studentrecords);
	}

	/**
	 * update student record by it's student id
	 * 
	 * @param id
	 * @param studentrecords
	 * @return
	 * @throws ResourceNotFoundException
	 */
	
	public ResponseEntity<StudentRecords> updateStudentRecords(@PathVariable(value = "id") long id,
			@RequestBody StudentRecords studentrecords) throws ResourceNotFoundException {

		StudentRecords sturecords = studentrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found"));

		sturecords.setFirstName(studentrecords.getFirstName());
		sturecords.setLastName(studentrecords.getLastName());
		sturecords.setMobileNo(studentrecords.getMobileNo());
		sturecords.setEmail(studentrecords.getEmail());
		sturecords.setDateOfBirth(studentrecords.getDateOfBirth());

		return ResponseEntity.ok(studentrepo.save(sturecords));
	}

	/**
	 * Delete student record by its student id
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	
	public ResponseEntity<StudentRecords> deleteStudentRecords(@PathVariable(value = "id") long id)
			throws ResourceNotFoundException {

		StudentRecords sturecords = studentrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found"));

		studentrepo.deleteByid(id);
		return ResponseEntity.ok().build();
	}
}
