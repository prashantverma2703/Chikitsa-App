package com.test.restdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
	static Connection conn = DbTranscation.getConnection();
	
	public User getUser(String id)
	{
		User u = null;
		try 
		{
			String sql = "select * from basic_detail where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rt = pr.executeQuery();
			if(rt.next())
			{
				u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5),rt.getString(6), rt.getString(7), rt.getString(8));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return u;
	}
	
	public ArrayList<User> getall()
	{
		ArrayList<User> list = new ArrayList<>();
		try 
		{
			String sql = "select * from basic_detail";
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			while(rt.next())
			{
				User u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(5), rt.getString(6), rt.getString(7), rt.getString(8));
				list.add(u);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	public String createUser(User u)
	{
		String sql = "insert into basic_detail (Aadhar_ID, password, Name, Dob, gender, Address, contact, usertype) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, u.getAadhar());
			pr.setString(2, u.getPassword());
			pr.setString(3, u.getName());
			pr.setString(4, u.getDob());
			pr.setString(5, u.getGender());
			pr.setString(6, u.getAddress());
			pr.setString(7, u.getContact());
			pr.setString(8, u.getUsertype());
			boolean i = pr.execute();
			System.out.println(i);
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return u.getName();
	}
	
	public void deleteuser(String id)
	{
		try 
		{
			String sql = "delete from basic_detail where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.executeQuery();
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void updateuser(String id, User u)
	{
		try 
		{
			String sql = "update basic_detail SET name = ?, dob = ?, gender = ?, address = ?, contact = ?, usertype = ? where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(7, u.getAadhar());
			pr.setString(1, u.getName());
			pr.setString(2, u.getDob());
			pr.setString(3, u.getGender());
			pr.setString(4, u.getAddress());
			pr.setString(5, u.getContact());
			pr.setString(6, u.getUsertype());
			pr.executeQuery();	
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public User getData(String id) {
		
		return null;
	}
}
