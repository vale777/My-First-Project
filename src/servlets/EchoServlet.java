package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EchoServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	@Override
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      // Set the response message's MIME type
	      response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Echo Servlet</title></head>");
	         out.println("<body><h2>You have enter</h2>");
	 
	         // Retrieve the value of the query parameter "username" (from text field)
	         String username = request.getParameter("username");
	         // Get null if the parameter is missing from query string.
	         // Get empty string or string of white spaces if user did not fill in
	         if (username == null
	               || (username = username.trim()).length() == 0) {
	            out.println("<p>Name: MISSING</p>");
	         } else {
	            out.println("<p>Name: " + username + "</p>");
	         }
	 
	         // Retrieve the value of the query parameter "password" (from password field)
	         String password = request.getParameter("password");
	         if (password == null
	               || (password = password.trim()).length() == 0) {
	            out.println("<p>Password: MISSING</p>");
	         } else {
	            out.println("<p>Password: " + password + "</p>");
	         }
	 
	         // Retrieve the value of the query parameter "server adress" (from server adress field)
	         String adress = request.getParameter("adress");
	         if (adress == null
	               || (adress = adress.trim()).length() == 0) {
	            out.println("<p>Server Adress: MISSING</p>");
	         } else {
	            out.println("<p>Server Adress: " + adress + "</p>");
	         }
	 
	         // Get all the names of request parameters
	         Enumeration names = request.getParameterNames();
	         out.println("<p>Request Parameter Names are: ");
	         if (names.hasMoreElements()) {
	            out.print(names.nextElement());
	         }
	         do {
	            out.print(", " + names.nextElement().toString());
	         } while (names.hasMoreElements());
	         out.println(".</p>");
	 
	         // Hyperlink "BACK" to input page
	         out.println("<a href='Login.html'>BACK</a>");
	 
	         out.println("</body></html>");
	      } finally {
	         out.close();  // Always close the output writer
	      }
	   }
	 
	   // Redirect POST request to GET request.
	   @Override
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	               throws IOException, ServletException {
	      doGet(request, response);
	   }
}
