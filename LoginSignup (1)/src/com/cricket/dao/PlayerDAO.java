package com.cricket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cricket.bean.PlayerBean;
import com.cricket.util.DBconnection;

public class PlayerDAO {
	Connection con=DBconnection.getDBConnection();
	public String generateid(String teamname) 
	{
		
		String result="";
		if(con!=null)
		{
			try 
			{
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select max(pid)+1 from player");
				while(rs.next())
				{
					System.out.println("ppid"+rs.getInt(1));
					result=result+rs.getInt(1);
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			result=teamname.substring(0,2)+result;
			System.out.println("sequence value" + result);
	}
		return result;
		
	}
	public String insertplayer(PlayerBean playerbean) {

		System.out.println("user in dao : "+playerbean);
		String output="Failed";	
		if(con!=null)
		{
			try
			{
				System.out.println("player Dao");
				PreparedStatement pst=con.prepareStatement("insert into player (name,nickname,age,birthplace,role,battingstyle,bowlingstyle,wicketkeeper,rating,pid,teamname) values(?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1,playerbean.getName());
				pst.setString(2,playerbean.getNickname());
				pst.setString(3,playerbean.getAge());
				pst.setString(4,playerbean.getBirthplace());
				pst.setString(5,playerbean.getRole());
				pst.setString(6,playerbean.getBattingstyle());
				pst.setString(7,playerbean.getBowlingstyle());
				pst.setString(8,playerbean.getWicketkeeper());
				pst.setString(9,playerbean.getRating());
				pst.setString(10,playerbean.getpid());
				pst.setString(11,playerbean.getTeamname());
				if(pst.executeUpdate()>0)
					output="Success";
			}
			catch(Exception e)
			{
				
			}
			System.out.println("register output -" + output );
		}
		return output;
	}
	public String delete(String name) {
		String result="FAIL";
		if(con!=null)
		{
			try 
			{
				PreparedStatement pst1=con.prepareStatement("delete from player where pid='"+name+"'");
				if(pst1.executeUpdate()>0)
                {
                	result="success";
                }
		    }
			catch (SQLException e) 
			{
				e.printStackTrace();
			} 
	}
		System.out.println("result -" +result);
		System.out.println(name);
		return result;
	}
	public String search(String pid, String name) {
		String result="fail";
		System.out.println("DAO search");
		if(con!=null)
		{
			try 
			{
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select role from player where name='"+name+"'");
				while(rs.next())
				{
					result=rs.getString(1);
					
					
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
			System.out.println("mail id--" + result);
	}
		return result;
	}

}
