package com.zensar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("from Student s where  s.studentId=?1 or s.studentAge=?2")
	List<Student> repoQuery1(int studentId, int studentAge);

	// List<Student> getByStudentName(String studentName);
	// List<Student> findByStudentName(String studentName);
	// List<Student> findByStudentNameAndStudentAge(String studentName,int studentAge);
	List<Student> test(String studentName);

	List<Student> test1(String studentName, int studentAge);

	List<Student> test3(String studentName, int studentId);

	@Query("from Student s where s.studentName=:name and s.studentAge=:age")
	List<Student> testt(@Param("name") String studentName, @Param("age") int age);
	
	
	
	
}

