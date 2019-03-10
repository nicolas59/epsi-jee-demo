package fr.nro.demoservlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Filtre permettant de forcer le format de la reponse.
 * 
 * 
 * @author nrousseau1
 *
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
       final HttpServletResponse resp = (HttpServletResponse)response;
       resp.setContentType("text/html");
       chain.doFilter(request, response);
        
    }

    public void destroy() {}
}
