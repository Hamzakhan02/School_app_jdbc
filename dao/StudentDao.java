package com.school.dao;
 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.school.configuration.HelperClass;
import com.school.dto.Student;


public class StudentDao {
   HelperClass helperClass=new HelperClass();
   Connection connection=null;
   int i=0;
   //to save a student data
   
   
   public boolean deleteStudentId(int id) {
	     connection=helperClass.getConnection();
	     
	     String sql="DELETE FROM student WHERE Id=?";
	     
	      try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		preparedStatement.setInt(1,id);
		
		 i= preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		} if(i<0) {
			return false;
		}else {
			return true;
		}
   }
   
   
   
// 
   
   public void getAll() {
	   connection=helperClass.getConnection();
	     
	     String sql="SELECT * FROM student";
	     try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			 ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	   
   }
   
   
   
   
   
   
   
   public int getStudent(int id) {
	   
	   connection=helperClass.getConnection();
	     
	     String sql="SELECT * FROM student WHERE Id=?";
	    
	   
	   
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 preparedStatement.setInt(1, id);
		 ResultSet resultSet= preparedStatement.executeQuery();
		   while(resultSet.next()){
			   System.out.println(resultSet.getInt(1));
			   System.out.println(resultSet.getString(2));
			   System.out.println(resultSet.getString(3));
			   System.out.println("================================");
		   }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try{
			connection.close();
		}catch(SQLException e) {
		    e.printStackTrace();
		}
		
	}return id;
	   //4.Execute the statement
	   //statemet.execute("INSERT INTO student VALUE(1,"HAMZA","HAMZA@GAMAIL");
//	   int a = statement.executeUpdate("UPDATE student SET name='abc',email='abc@gmail.com' WHERE Id=1");
	   
	  
	   }

	

   
   
   
   
//   
   
   public Student saveStudent(Student student) {
	   connection= helperClass.getConnection();
	   String sql="INSERT INTO student VALUES(?,?,?)";
	   try {
		   //create statement
		   PreparedStatement preparedStatement = connection.prepareStatement(sql);
		   //passed the values to delimiters/placeholders--->?
		   preparedStatement.setInt(1, student.getId());
		   preparedStatement.setString(2, student.getName());
		   preparedStatement.setString(3, student.getEmail());
		   //exexcute
		   preparedStatement.execute();
		   
	   }catch(SQLException e){
		   e.printStackTrace();
		   
		   
	   }finally {
		   try {
			   connection.close();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }   
	   }
	   return student;
   }
}
