package com.zensar.dto;

public class StudentDto {

	private int studentId;
	private String studentName;
	private int StudentAge;
	public StudentDto() {
		super();
	}
	public StudentDto(int studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		StudentAge = studentAge;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return StudentAge;
	}
	public void setStudentAge(int studentAge) {
		StudentAge = studentAge;
	}
	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", StudentAge=" + StudentAge
				+ "]";
	}

}
