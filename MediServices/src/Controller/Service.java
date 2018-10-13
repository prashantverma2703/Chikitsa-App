package Controller;

import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

import com.sun.jersey.api.core.servlet.WebAppResourceConfig;
import com.sun.jersey.api.representation.Form;

import Dao.Resource;
import model.User;
import util.DbTranscation;

@WebServlet("/Service")
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		ClientConfig clientconfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientconfig);
		
		String req = request.getParameter("req");
		Resource r1 = new Resource();
		
		if(req.equalsIgnoreCase("userform"))
		{
			String name = request.getParameter("name");
			String dob = request.getParameter("dob");
			String gender = request.getParameter("gender");
			String address = request.getParameter("add");
			String contact = request.getParameter("contact");
			String aadhar= request.getParameter("aadhar");
			
			User u = new User(name, dob, gender, address, contact, aadhar);
			
			String name1 = r1.createuser(u);
			/*Form form = new Form();
			form.add(name, name);
			form.add(dob, dob);
			form.add(gender, gender);
			form.add(address, address);
			form.add(contact, contact);*/
			
			URI serviceURI = UriBuilder.fromUri("http://localhost:8081/Mediservices/").build();
			WebTarget webtarget = client.target(serviceURI);
			String s = webtarget.path("rest").path("service").path("create").request().accept(MediaType.APPLICATION_JSON).get().toString();
			System.out.println(s);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			request.setAttribute(name, name1);
			rd.forward(request, response);
			
		}
	}

}
