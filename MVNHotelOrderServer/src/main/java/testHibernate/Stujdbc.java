package testHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stujdbc {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/wsw";
	
	static final String USER = "root";
	static final String PASS = "root";
	
	int getNUM() {
		Connection conn = null;
		Statement stmt = null;
		
		try{
			//register JDBC server
			Class.forName(JDBC_DRIVER);
			
			//open a connection		
			System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    
		    // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      String sql;
		      sql = "SELECT * FROM STUDENT";
		      ResultSet rs = stmt.executeQuery(sql);
		      int num = 0;
		      while(rs.next()){
//		    	  String sno = rs.getString("sno");
//		    	  String sn = rs.getString("sn");
//		    	  String sd = rs.getString("sd");
//		    	  String si = rs.getString("si");
//		    	  
//		    	  System.out.println("*************************************");
//		    	  System.out.println("sno:   "+sno);
//		    	  System.out.println("sn:   "+sn);
//		    	  System.out.println("sd:   "+sd);
//		    	  System.out.println("si:   "+si);
//		    	  System.out.println("*************************************");
		    	  num++;
		      }
		      
		      rs.close();
		      stmt.close();
		      conn.close();
		      return num;
		      
		      
		}catch(SQLException se){
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return 0;
	}
	

}
