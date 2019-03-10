
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.append("<!doctype html>");
	    writer.append("<html lang=\"fr\">");
	    writer.append("    <head><title>HelloWorldProject - Welcome</title></head>");
	    writer.append("    <body>");
	    if(request.getParameter("name") !=null) {
	        writer.append("        <h1>Bonjour ").append(request.getParameter("name")).append("</h1>");
	    }else {
	        writer.append("        <form method='post'><input type='text' name='name'/><input type='submit'/></form> ");
	    }
	    writer.append("    </body>");
	    writer.append("</html>");
	}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
