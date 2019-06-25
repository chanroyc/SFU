/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package assignment_3;


/**
 *
 * @author chanroyc
 */


import java.sql.*;

class sourceI {
	private static Connection con;
	private static String space = "                                           ";

	public static void main(String[] args)
	{
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sSQL= "SELECT COUNT(CustomerId) as customer_count FROM SalesLT.Customer";
		String temp="";
		
		String sUsername = "s_chanroyc";
		String sPassword= "7gJe7aLyPtg243NT";
                String sDatabase= "AdventureWorksLT";
		// ^^^ modify these 2 lines before compiling this program
		// please replace the username with your CCN id
		// please get the password from table 'helpdesk' of your course database
		
        String connectionUrl = "jdbc:sqlserver://cypress;" +
			        "user = " + sUsername + ";" +
			        "password = " + sPassword + ";" +
                                "database = " + sDatabase;
			        
        //System.out.println("\n connectionUrl = " + connectionUrl + "\n\n");
        
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException ce)
			{
				System.out.println("\n\nNo JDBC dirver; exit now.\n\n");
				return;
			}
		
		try
		{
			con = DriverManager.getConnection(connectionUrl);
		}catch (SQLException se)
			{
				System.out.println("\n\nFail to connect to CSIL SQL Server; exit now.\n\n");
				return;
			}
		
		try
		{
			pstmt = con.prepareStatement(sSQL);
			rs = pstmt.executeQuery();
			System.out.println("\nSuccessfully connected to CSIL SQL Server!\n");
			System.out.println("The Total Customer Count in table SalesLT.Customer:\n");
			
			while (rs.next()) {
				temp= rs.getString("customer_count");	//the table has a field 'username'
				System.out.println(temp+"\n\n");
			}
			rs.close();
			
		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return;
			}
	}//end of main
}


