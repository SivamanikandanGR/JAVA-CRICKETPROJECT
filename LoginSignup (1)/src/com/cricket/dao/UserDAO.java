package com.cricket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cricket.bean.UserBean;
import com.cricket.util.DBconnection;
public class UserDAO {
Connection con=DBconnection.getDBConnection();
	
	
	public String generateid(String teamname) 
	{
		
		String result="";
		if(con!=null)
		{
			try 
			{
				System.out.println("skdksamkd----------------------------------");
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select max(id)+1 from signup");
				
				while(rs.next())
				{
					System.out.println("idd"+rs.getInt(1));
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
	public String register(UserBean user) {
		
		System.out.println("user in dao : "+user);
		String output="Failed";	
		if(con!=null)
		{
			try
			{
				System.out.println("register 1 connected");
				//PreparedStatement pst=con.prepareStatement("insert into signups(firstname,lastname,mobilenumber,address,gender,emailid,password,confirmpassword,teamname,securityquestion,securityanswer) values(?,?,?,?,?,?,?,?,?,?,?)");
				String sql="insert into signup (firstname,lastname,mobilenumber,address,gender,emailid,password,confirmpassword,teamname,securityquestion,securityanswer,idd) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				//PreparedStatement pst=con.prepareStatement("insert into namee values(?,?)");
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1,user.getFirstName());
				pst.setString(2,user.getLastName());
     			pst.setString(3,user.getMobileNumber());
				pst.setString(4,user.getAddress());
			    pst.setString(5,user.getGender());
				pst.setString(6,user.getEmailID());
				pst.setString(7,user.getPassword());
				pst.setString(8,user.getConfirmPassword());
				pst.setString(9,user.getTeamName());
				pst.setString(10, user.getSecurityQuestion());
				pst.setString(11,user.getSecurityAnswer());
				pst.setString(12, user.getidd());
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
	
	

	public String validateLogin(String MobileNumber, String Password) 
	{
		String teamname="";
		String result="Fail";
		System.out.println("Mobile number - " +MobileNumber);
		System.out.println("Password - " + Password);
		if(con!=null)
		{
			try
			{
				PreparedStatement pst=con.prepareStatement("select teamname,emailid,password from signup where mobilenumber=? and password=?");
				pst.setString(1,MobileNumber);
				pst.setString(2, Password);
				ResultSet rs=pst.executeQuery();
		
				while(rs.next())
				{
					teamname=rs.getString(1);
				}
			}
			catch(Exception e)
			{
				
			}
			System.out.println("Signupmode - " + teamname);

		}
		
		return teamname;
	}
	
		public String changepass(String Password, String MobileNumber,String SecurityQuestion, String SecurityAnswer)
		{
			String result="FAIL";
			
			System.out.println("DAO :chane pass-"+ Password+ " "+ MobileNumber +" "+SecurityQuestion + " " +SecurityAnswer);
			if(con!=null)
			{
				try 
				{
					PreparedStatement pst=con.prepareStatement("update signup set password="+Password+" where mobilenumber="+MobileNumber+" and securityquestion='"+SecurityQuestion+"' and securityanswer='"+SecurityAnswer+"'");
	                if(pst.executeUpdate()>0)
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
			return result;
		}
		public String getcookiedetails(String mobileNumber) 
		{
			
			String getid="";
			System.out.println("Cookies DAO Mobile number - " +mobileNumber);
			if(con!=null)
			{
				try
				{
					PreparedStatement pst=con.prepareStatement("select id from signup where mobilenumber=?");
					pst.setString(1,mobileNumber);
					ResultSet rs=pst.executeQuery();
			
					while(rs.next())
					{
						getid=rs.getString(1);
					}
				}
				catch(Exception e)
				{
					
				}
				
				System.out.println("cookie id - " + getid);
		}

			return getid;
		}  
		
		
		
		public String updateprofile(String mobilenumber, String securityquestion, String securityanswer,String emailid, String id) {
			String result="FAIL";
			if(con!=null)
			{
				try 
				{
					System.out.println("DAO- Connected");
					System.out.println("email-"+emailid);
					System.out.println("mobilenumber-"+mobilenumber);
					System.out.println("securityquestion-"+securityquestion);
					System.out.println("securityanswer-"+securityanswer);
					System.out.println("id-"+id);
					PreparedStatement pst1=con.prepareStatement("update signup set emailid='"+emailid+"' where mobilenumber='"+mobilenumber+"' and securityquestion='"+securityquestion+"'and securityanswer='"+securityanswer+"' and id='"+id+"' ");
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
			return result;
		}
		
		}