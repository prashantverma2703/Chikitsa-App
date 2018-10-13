package Dao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.User;

@Path("service")
public class Resource {
	
	Repo r = new Repo();
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public String createuser(User u)
	{
		return r.createUser(u);
	}
	
	
}
