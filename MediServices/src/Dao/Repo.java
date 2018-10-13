package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;
import util.DbTranscation;

public class Repo {
	Connection conn = DbTranscation.getConnection();
	
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
				u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(6), rt.getString(7));
			}
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return u;
	}
	
	public ArrayList<User> getall(String id)
	{
		ArrayList<User> list = new ArrayList<>();
		try 
		{
			String sql = "select * from basic_detail";
			Statement st = conn.createStatement();
			ResultSet rt = st.executeQuery(sql);
			while(rt.next())
			{
				User u = new User(rt.getString(1), rt.getString(2), rt.getString(3), rt.getString(4), rt.getString(6), rt.getString(7));
				list.add(u);
			}
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	public String createUser(User u)
	{
		String sql = "insert into basic_detail (Name, Dob, gender,Address,contact,Aadhar_ID) VALUES (?, ?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, u.getName());
			pr.setString(2, u.getDob());
			pr.setString(3, u.getGender());
			pr.setString(4, u.getAddress());
			pr.setString(5, u.getContact());
			pr.setString(6, u.getAadhar());
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
			String sql = "update basic_detail SET name = ?, dob = ?, gender = ?, address = ?, contact = ? where Aadhar_ID = ?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(6, u.getAadhar());
			pr.setString(1, u.getName());
			pr.setString(2, u.getDob());
			pr.setString(3, u.getGender());
			pr.setString(4, u.getAddress());
			pr.setString(5, u.getContact());
			pr.executeQuery();	
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
