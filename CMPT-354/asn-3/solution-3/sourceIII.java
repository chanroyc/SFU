import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

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
public class sourceIII {
private static Connection con;
	private static String space = "                                           ";
        
        

	public static void main(String[] args) throws Exception
	{
            String sColor = JOptionPane.showInputDialog("LIST OF COLORS:\n"
                    + "Black\n"
                    + "Blue\n"
                    + "Grey\n"
                    + "Multi\n"
                    + "Red\n"
                    + "Silver\n"
                    + "Silver/Black\n"
                    + "White\n"
                    + "Yellow\n\n"
                    + "ENTER COLOR FILTER: ");
                                
                JOptionPane.showMessageDialog(null, "You have chosen to filter /" +sColor +"/ colored products.\n\n Please wait a moment for the application to make the query.");
                        
                PreparedStatement pstmt = null;
		ResultSet rs;
                
		String sSQL= "SELECT C.CustomerID, C.FirstName, C.LastName, Max(S1.UnitPrice) as HighestPrice\n" +
                "FROM SalesLT.SalesOrderDetail S1, SalesLT.Customer C, SalesLT.SalesOrderHeader S2, SalesLT.Product P\n" +
                "WHERE S1.SalesOrderID = S2.SalesOrderID AND\n" +
                "S1.ProductID = P.ProductID AND\n" +
                "S1.SalesOrderID = S2.SalesOrderID AND\n" +
                "C.CustomerID = S2.CustomerID AND\n" +
                "P.color =" + " '" + sColor + "'\n" +
                "GROUP BY C.CustomerID, C.FirstName, C.LastName\n" +
                "ORDER BY C.LastName DESC";
                
                String customer_id = "";
                String first_name = "";
                String last_name = "";
                String HighestPrice = "";
		
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
			
                        JTable table = new JTable(buildTableModel(rs));
                        JOptionPane.showMessageDialog(null, new JScrollPane(table), "RedSpending", JOptionPane.INFORMATION_MESSAGE);
                        
			
		}catch (SQLException se)
			{
				System.out.println("\nSQL Exception occured, the state : "+
								se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
				return;
			}
                
	}//end of main

/*************************************************************************************************************

* Method by Paul Vargas @stackoverflow http://stackoverflow.com/users/870248/paul-vargas
* Link to Method: http://stackoverflow.com/questions/10620448/most-simple-code-to-populate-jtable-from-resultset

**************************************************************************************************************/
public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}    
}


