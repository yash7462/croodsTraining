package com.studentrecord.studentprojection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentrecord.studentprojection.model.StudentView;
import com.studentrecord.studentprojection.model.StudentViewDTO;
@Repository
public interface StudentViewRepository extends JpaRepository<StudentView, Long> {
	
	/**
	 * "SELECT new com.studentrecord.studentprojection.model.StudentViewDTO(s.name, s.age, s.branch) FROM StudentView s"
	 *		   \__________________________________________________________/ \_____________________/       \_________/
	 *              |this is full package name which you want to store|       |Field you want|             |this is Class/Entity name not table name|		
	 * @return
	 */
	@Query("SELECT new com.studentrecord.studentprojection.model.StudentViewDTO(s.name, s.age, s.branch) FROM StudentView s")
	List<StudentViewDTO> getStudentNameAgeAndBranch();
}


/*
 * package com.studentrecord.studentprojection.repository;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.repository.CrudRepository; import
 * org.springframework.stereotype.Component; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.studentrecord.studentprojection.model.StudentViewDTO;
 * 
 * @Repository public interface StudentViewDTORepository extends
 * CrudRepository<StudentViewDTO, Long> {
 * 
 * @Query("SELECT new com.studentrecord.studentprojection.model.StudentViewDTO(s.name, s.age, s.branch) FROM studentview s"
 * ) List<StudentViewDTO> getStudentNameAgeAndBranch(); }
 */