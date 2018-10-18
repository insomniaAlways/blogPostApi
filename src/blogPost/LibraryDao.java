package blogPost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


  
public class LibraryDao {
		
	DbManagement db = new DbManagement();
	Connection conn = db.getConnection();
	
	public List<Library> getAllUsers(){ 
	      
		ArrayList libraryList = new ArrayList();
	      try { 
	    	  Statement st = conn.createStatement();
				
				ResultSet rs = st.executeQuery("Select * from libraries");
		    	
		    	while(rs.next())
		    		{
		        		Library lb= new Library();
		        
		        		lb.setId(rs.getInt(1));
		        		lb.setAddress(rs.getString(2));
		        		lb.setName(rs.getString(3));
		        		lb.setPhone(rs.getString(4));
		        
		        		libraryList.add(lb);
		        		
		 
		        		
		        		//out.println(lb.getAddress() +" "+ lb.getName()+ " "+ lb.getPhone()+"<br>");
					}
	      } catch (Exception e) { 
	         e.printStackTrace(); 
	     
	   } 
	      return libraryList; 

	   }    
	   
}
