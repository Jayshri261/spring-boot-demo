package com.zensar.Service;

import java.util.List;

import org.springframework.boot.actuate.health.Health;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.dto.StudentDto;
import com.zensar.entity.Student;

public interface StudentService {
	public StudentDto getStudent(int StudentId);

	public List<StudentDto> getAllStudent(int pageNumber,int pageSize,String sortBy,Direction dir);

	public StudentDto insertStudent(StudentDto studentDto);

	public void updateStudent(int studentId, StudentDto studentDto);

	public void deleteStudent(int studentId);

	 List<StudentDto> getBystudentName(String studentName);
	 List<StudentDto> findBystudentNameAndstudentAge(String studentName,int studentAge);
	 List<Student> test(String studentName);
	 List<Student> test1(String studentName,int studentAge);
	 List<Student> test3(String studentName,int studentId);
	 List<Student> repoQuery1(int studentId,int studentAge);

	
}
