package com.school.service;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {
  StudentDao studentDao=new StudentDao();
  
  
  
  public void getAll() {
	   studentDao.getAll();
  }
  
  
  public int getStudent(int id) {
	  
	  return studentDao.getStudent(id); 
  }
  
  public boolean deleteStudentId(int id) {
	  boolean s= studentDao.deleteStudentId(id);
	  return s;
	  
  }
  
  public Student saveStudent(Student student) {
	  return studentDao.saveStudent(student);
  }
}
