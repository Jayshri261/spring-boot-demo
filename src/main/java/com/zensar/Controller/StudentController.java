package com.zensar.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.StudentDto;
import com.zensar.Service.StudentServiceImpl;
import com.zensar.entity.Student;

@RestController
@RequestMapping(value = "/Student-Api", consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class StudentController {
	@Autowired
	private StudentServiceImpl studentservice;

	// @RequestMapping("/students/{StudentId}")
	@GetMapping(value = "/student/{StudentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studId") int StudentId) {
		return new ResponseEntity<StudentDto>(studentservice.getStudent(StudentId), HttpStatus.OK);
	}

	// @RequestMapping(value={"/students","/listofstudents"},method=RequestMethod.GET)
	@GetMapping(value = { "/students", "/listofstudents" })
	public ResponseEntity<List<StudentDto>> getAllStudent(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,

			@RequestParam(value = "sortBy", required = false, defaultValue = "studentName") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "DESC") Direction dir)

	{
		return new ResponseEntity<List<StudentDto>>(studentservice.getAllStudent(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
	}

	// @RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentservice.insertStudent(studentDto), HttpStatus.CREATED);

	}

	// @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		studentservice.updateStudent(studentId, studentDto);
		return new ResponseEntity<String>("Student Updated Successfully", HttpStatus.OK);
	}

	// @RequestMapping(value = "/students/{studentId}", method =
	// RequestMethod.DELETE)
	@DeleteMapping(value = "/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		studentservice.deleteStudent(studentId);
		return new ResponseEntity<String>("StudentDEleted Successfully", HttpStatus.OK);

	}

	@GetMapping(value = "/students/studentname/{studentName}")
	public ResponseEntity<List<StudentDto>> getBystudentName(@PathVariable("studentName") String studentName) {
		return new ResponseEntity<List<StudentDto>>(studentservice.getBystudentName(studentName), HttpStatus.OK);
	}

	@GetMapping(value = "/students/{studentName}")
	public List<Student> test(@PathVariable String studentName) {
		return studentservice.test(studentName);
	}

	@GetMapping(value = "/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findBystudentNameAndstudentAge(@PathVariable String studentName,
			@PathVariable int studentAge) {
		return new ResponseEntity<List<StudentDto>>(
				studentservice.findBystudentNameAndstudentAge(studentName, studentAge), HttpStatus.OK);
	}

	@GetMapping(value = "/students/student/{studentName}/{studentAge}")
	public List<Student> test1(@PathVariable String studentName, @PathVariable int studentAge) {
		return studentservice.test1(studentName, studentAge);
	}

	@GetMapping(value = "students/studd/{studentName}/{studentId}")
	public List<Student> test3(@PathVariable String studentName, @PathVariable int studentId) {
		return studentservice.test3(studentName, studentId);
	}

	@GetMapping(value = "students/studrepo/{studentId}/{studentAge}")
	public List<Student> repoQuery1(@PathVariable int studentId, @PathVariable int studentAge) {
		return studentservice.repoQuery1(studentId, studentAge);
	}

	// http://localhost:8080/student-api/students?pageNumber=0&pageSz=3&SortBy=studentName&dir=DESC

}
