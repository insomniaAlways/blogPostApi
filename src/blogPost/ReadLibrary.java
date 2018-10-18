package blogPost;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadLibrary
 */

@WebServlet("/readLibrary")
public class ReadLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DbManagement db = new DbManagement();
	Connection conn = db.getConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadLibrary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		
		
		if(conn == null){
			out.print("connection failed");
		} else {
			
			try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from libraries");
	    	ArrayList libraryList = new ArrayList();
	    	while(rs.next())
	    		{
	        		Library lb= new Library();
	        
	        		lb.setId(rs.getInt(1));
	        		lb.setAddress(rs.getString(2));
	        		lb.setName(rs.getString(3));
	        		lb.setPhone(rs.getString(4));
	        
	        		libraryList.add(lb);
	        		
	 
	        		
	        		out.println(lb.getAddress() +" "+ lb.getName()+ " "+ lb.getPhone());
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
