package blogPost;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Path("/service")
@Provider
public class Service implements ContainerResponseFilter  {
	
	@Override
	   public void filter(final ContainerRequestContext requestContext,
	                      final ContainerResponseContext cres) throws IOException {
	      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
	      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
	      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
	   }
	LibraryDao readLibrary = new LibraryDao();
	@GET
	
	@Path("/library") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Library> getUsers(){ 
	   return readLibrary.getAllUsers();
	}
}  