package com.studentrecord.studentprojection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentrecord.studentprojection.model.StudentView;
import com.studentrecord.studentprojection.model.StudentViewDTO;
import com.studentrecord.studentprojection.repository.StudentViewRepository;

@RestController
@RequestMapping("/student/detail")
public class StudentProjectionController {
	
	@Autowired
	StudentViewRepository studentViewRepository;
	
	
	
	@GetMapping("/")
	public List<StudentView> getAllStudent() {
		return studentViewRepository.findAll();
	}
	
	@GetMapping("/nameageandbranch")
	public List<StudentViewDTO> getAllStudentNameAgeAndBranch() {
		return studentViewRepository.getStudentNameAgeAndBranch();
	}
	
	@PostMapping("/")
	public StudentView addAllStudent(@RequestBody StudentView studentView) {
		return studentViewRepository.save(studentView);
	}
}
