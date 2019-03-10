<%@page import="java.util.Random"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.StreamSupport"%>
<%@page import="java.util.Collections"%>
<% 
 Integer count = session.getAttribute("count") == null ? 0: (Integer)session.getAttribute("count");
 response.addHeader("page", "hello.jsp");
 session.setAttribute("val1", "1"); 
 session.setAttribute("count", ++count);
 
 
 %>
<html>
<body>
	<h1>Bonjour <%=request.getParameter("name") %></h1>
	
	<p><% out.print("Permet d'écrire dans la page JSP ! "); %></p>
	<p>Identifiant de session : <%= session.getId() %></p>
	<p>Nombre d'objets en session : <%=Collections.list(session.getAttributeNames()).size() %>
	<p>Nombre d'acces : <%=session.getAttribute("count") %>
	<% pageContext.getOut().print("<p/>Acces au writer par le <i>pageContext</i></p>");%>
	<%!
	int sum(int... nombres){
	   return Arrays.stream(nombres).sum(); 
	}
	%>
	<p> Somme  : <span><%=sum(1,2,3,4,5,6,7,8,9,10) %></span>

	<%
	if(session.getAttribute("nb") == null){
	     session.setAttribute("nb", new Random(1000).ints(1, 100)
	             .findFirst().getAsInt());
	 }

	String message = null;
	String valChoisie = request.getParameter("nombreChoisi");
	if(valChoisie!=null && valChoisie.matches("\\d+")){
		Integer numChoisi = Integer.parseInt(valChoisie);
		Integer numSelection = (Integer)session.getAttribute("nb");
		if(numChoisi == numSelection){
		    message = "trouvé";
		}else if( numChoisi > numSelection){
		    message = "trop grand";
		}else{
		    message = "trop petit";
		}
	}
	%>
	<form>
		<p><%= message%></p>
		<input type="text" name="nombreChoisi"/>
		<input type="submit">
	</form>
	
	
</body>
</html>
