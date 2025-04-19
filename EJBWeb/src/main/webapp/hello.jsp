<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.souradip.statefulbean.BookStoreRemote" %>
<%@page import="javax.naming.InitialContext" %> 
<%@page import="java.util.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book store application welcome page</title>
</head>
<body>
 <h2>Hello, welcome to our book store application</h2>
 <form action="hello.jsp" method="post">
 Place item into the booking cart:
 <input type="text" size=35 value="" name="Purchased">
 <input type="submit" value="Add to Cart" name="BookAction">
 <input type="submit" value="Remove from Cart" name="BookAction">
 <input type="submit" value="List Items in the Cart" name="BookAction">
 <input type="submit" value="Empty Cart" name="CartAction">
 </form>
 <%
   BookStoreRemote remote=(BookStoreRemote)session.getAttribute("remote");
   if(remote==null){
	   InitialContext ctx=new InitialContext();
	   BookStoreRemote bsCart=(BookStoreRemote)ctx.lookup("java:global/EJBear/EJBBean/BookStore!com.souradip.statefulbean.BookStoreRemote");
	   session.setAttribute("remote",bsCart);
   }
   //Get the input strings from the servlet context path. 
   String book=request.getParameter("Purchased");
   String bookAction=request.getParameter("BookAction");
   //Performing the actions.  
   if(bookAction!=null){
	   if(bookAction.equalsIgnoreCase("Add to Cart")){
		   remote.addBook(book);
		   out.println("<h3>"+ book +" added to the cart </h3>");
		   
	   }else if(bookAction.equalsIgnoreCase("Remove from Cart")){
		   remote.removeBookItem(book);
		   out.println("<h3>"+book+" removed from the cart </h3>");
	   }
	   else if(bookAction.equalsIgnoreCase("List Items in the Cart")){
		   out.println("<h3>List of items in the cart</h3>");
		   out.println("<ol>");
		   List<String> bookList=remote.listBookItems();
		   for(String var:bookList){
			   out.println("<li>");
			   out.println(var);
			   out.println("</li>");
		   }
		   out.println("</li>");
	   }
	   else if(bookAction.equals("Empty Cart")){
		   remote.clearBookCart();
		   out.println("<h3>Cart is empty</h3>");
	   }
   }
 %>
</body>
</html>