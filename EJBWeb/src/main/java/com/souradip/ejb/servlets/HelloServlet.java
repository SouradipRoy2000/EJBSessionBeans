package com.souradip.ejb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.souradip.statelessbean.MessageBeanRemote;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HelloServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			//1. InitialContext object for JNDI is created for performing lookup operation.  
			InitialContext context=new InitialContext();
			//2. Lookup operation performed.  
			MessageBeanRemote remote=(MessageBeanRemote)context.lookup("java:global/EJBear/EJBBean/MessageBean!com.souradip.statelessbean.MessageBeanRemote");
			//3. Call the remote method.  
			String str=remote.message("Souradip");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			//4. Printing the message on the screen.  
			out.println(str);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some excepion has occured");
		}
	}

}
