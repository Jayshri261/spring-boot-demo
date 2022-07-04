package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zensar.dto.StudentDto;
import com.zensar.Repository.StudentRepository;
import com.zensar.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public com.zensar.dto.StudentDto getStudent(int studentId) {
		Student student = studentRepository.findById(studentId).get();

		return modelMapper.map(student, StudentDto.class);
		// StudentDto dto = mapToDto(student);
		// return dto;
	}

	@Override
	public List<StudentDto> getAllStudent(int pageNumber, int pageSize,String sortBy,Direction dir) {
		// List<Student> listofStudents = studentRepository.findAll();
		List<StudentDto> ListOfDto = new ArrayList<com.zensar.dto.StudentDto>();
		Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber, pageSize,dir,sortBy));
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(0, 3,Direction.DESC,"studentName"));
		List<Student> content = findAll.getContent();
		for (Student student : content) {
			// ListOfDto.add(mapToDto(student));
			ListOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return ListOfDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		System.out.println(studentDto);
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student insertedStudent = studentRepository.save(student);
		// StudentDto dto = mapToDto(insertedStudent);
		return modelMapper.map(insertedStudent, StudentDto.class);
		// return dto;

	}

	@Override
	public void updateStudent(int studentId, StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public List<com.zensar.dto.StudentDto> getBystudentName(String studentName) {
		List<com.zensar.dto.StudentDto> studentDtos = new ArrayList<>();
		List<Student> students = studentRepository.test(studentName);
		for (Student student : students)
			studentDtos.add(modelMapper.map(student, com.zensar.dto.StudentDto.class));
		return studentDtos;

		// return studentRepository.getByStudentName(studentName);
		// return studentRepository.findByStudentName(studentName);
	}

	@Override
	public List<com.zensar.dto.StudentDto>findBystudentNameAndstudentAge(String studentName, int studentAge) {
		List<com.zensar.dto.StudentDto> studentDtos = new ArrayList<>();
		List<Student> students = studentRepository.testt(studentName, studentAge);
		for (Student student : students)
			studentDtos.add(modelMapper.map(student, StudentDto.class));
		return studentDtos;
	}

	@Override
	public List<Student> test(String studentName) {
		return studentRepository.test(studentName);
	}

	@Override
	public List<Student> test1(String studentName, int studentAge) {
		return studentRepository.test1(studentName, studentAge);
	}

	@Override
	public List<Student> test3(String studentName, int studentId) {
		return studentRepository.test3(studentName, studentId);
	}

	@Override
	public List<Student> repoQuery1(int studentId, int studentAge) {
		return studentRepository.repoQuery1(studentId, studentAge);
	}

	/*
	 * public StudentDto mapToDto(Student student) { StudentDto dto = new
	 * StudentDto(); dto.setStudentId(student.getStudentId());
	 * dto.setStudentName(student.getStudentName()); dto.setStudentAge(student.getStudentAge());
	 * return dto;
	 * 
	 * } public Student mapToEntity(StudentDto studentDto) { Student student = new
	 * Student(); student.setStudId(studentDto.getStudId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge());
	 * 
	 * return student; }
	 * 
	 */
	
	
}


