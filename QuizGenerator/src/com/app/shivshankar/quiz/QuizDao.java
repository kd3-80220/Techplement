package com.app.shivshankar.quiz;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDao implements AutoCloseable{

	private Connection con;
	public QuizDao() throws SQLException {
		con = DbUtil.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int addQuestion(Question question) throws SQLException {
		String sql = "insert into questionbank values (?,?,?,?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, question.getQuestion());
			stmt.setString(2, question.getOptions().get(0));
			stmt.setString(3, question.getOptions().get(1));
			stmt.setString(4, question.getOptions().get(2));
			stmt.setString(5, question.getOptions().get(3));
			stmt.setInt(6, question.getCorrectOptionIndex());
			int cnt = stmt.executeUpdate();
			return cnt; 
		} //stmt.close();
	}
	
	 public ArrayList<Question> getTestQuestions() throws SQLException {
	        ArrayList<Question> tQuestions = new ArrayList<>();
	        PreparedStatement stmt=null;
	        ResultSet rs=null;
	        try{
	    
	            String query = "SELECT * FROM questionbank";
	            stmt= con.prepareStatement(query);
	            rs= stmt.executeQuery();

	            while (rs.next()) {
	            	ArrayList<String> options=new ArrayList<String>();
	                // Assuming Question class has constructor that takes necessary fields
	            	options.add(rs.getString("option1"));
	            	options.add(rs.getString("option2"));
	            	options.add(rs.getString("option3"));
	            	options.add(rs.getString("option4"));
	                Question question = new Question(
	                        rs.getString("question"),
	                        options,
	                        rs.getInt("correctoption")
	                );
	                tQuestions.add(question);
	            }
	        
	        }finally {
	        	if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	        }
	        return tQuestions;
	 }
	 
	 public void addScore(String nm,int score) throws SQLException
	 {
		 String query="insert into performance values(?,?)";
		 try(PreparedStatement stmt=con.prepareStatement(query)){
			 stmt.setString(1, nm);
			 stmt.setInt(2, score);
			 int cnt=stmt.executeUpdate();
		 }
	 }
	 
	 public void seeAllStudentPerformance() throws SQLException
	 {
		 PreparedStatement stmt=null;
	     ResultSet rs=null;
		 try{
			 String query="select *from performance";
			 stmt=con.prepareStatement(query);
			 rs=stmt.executeQuery();
			 while(rs.next())
			 {
				 System.out.println(" Name: "+rs.getString(1)+" Score: "+rs.getInt(2));
			 }
		 }finally {
			 	if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            } 
		 }
	 }
	
}
