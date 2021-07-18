package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean flag = false;
		// jdbc code to insert data...
		try {
			Connection connc = ConnectionProvider.conn();
			
			String query = "insert into student(sname,sphone,scity) values(?,?,?)";
			//PreparedStatement
			PreparedStatement pstmt =  connc.prepareStatement(query);
			//set the value of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			//execute..
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		// jdbc code to delete data...
		try {
			Connection connc = ConnectionProvider.conn();
			
			String query = "delete from student where sid=?";
			//PreparedStatement
			PreparedStatement pstmt =  connc.prepareStatement(query);
			//set the value of parameters
			pstmt.setInt(1, userId);
			//execute..
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
	}

	public static void showAllStudent() {
		boolean flag = false;
		// jdbc code to show data...
		try {
			Connection connc = ConnectionProvider.conn();
			
			String query = "select * from student";
			//PreparedStatement
			Statement stmt =  connc.createStatement();
			//set the value of parameters
			ResultSet set = stmt.executeQuery(query);
			//execute..
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID: " +id);
				System.out.println("Name: " +name);
				System.out.println("Phone: " +phone);
				System.out.println("City: " +city);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static boolean updateStudentToDB(Student st) {
		boolean flag = false;
		// jdbc code to update data...
		try {
			Connection connc = ConnectionProvider.conn();
			
			String query = "update student set sname=?, sphone=?, scity=? where sid=? ";
			//PreparedStatement
			PreparedStatement pstmt =  connc.prepareStatement(query);
			//set the value of parameters
			pstmt.setInt(4, st.getStudentId());
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			//execute..
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
