package com.school.controller;

import com.school.service.StudentService;

public class GetStudent {
	
	public static void main(String ars[]) {
		StudentService studentService= new StudentService();
		int res= studentService.getStudent(5);
//		System.out.println(res);
	}
	

}
