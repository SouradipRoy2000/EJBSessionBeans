package com.souradip.ejb.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.souradip.statefulbean.BookStoreRemote;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> findBookList;
	
    public BookServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getContextPath();
		System.out.println("Name of the servlet end point is:"+path);
		 try {
			InitialContext context=new InitialContext();
			BookStoreRemote remote=(BookStoreRemote)context.lookup("java:global/EJBear/EJBBean/BookStore!com.souradip.statefulbean.BookStoreRemote");
			findBookList=remote.listBookItems();
			if(path.equals("/addBook")) {
				String bookName=request.getParameter("bookName");
				remote.addBook(bookName);
				PrintWriter out=response.getWriter();
				response.setContentType("text/html");
				out.println("Book has been added successfully");
				RequestDispatcher rd=request.getRequestDispatcher("hello.jsp");
				rd.forward(request, response);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		doGet(request, response);
	}

}
