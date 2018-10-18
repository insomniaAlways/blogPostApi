package blogPost;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 

@Path("service") 
public class Service {	
	LibraryDao readLibrary = new LibraryDao();
	@GET 
	@Path("/library") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Library> getUsers(){ 
	   return readLibrary.getAllUsers();
	}
}  
	