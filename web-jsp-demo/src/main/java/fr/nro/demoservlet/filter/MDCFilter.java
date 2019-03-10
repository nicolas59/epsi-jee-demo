package fr.nro.demoservlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Filtre permettant d'ajouter un marqueur aux logs
 * 
 * 
 * @author nrousseau1
 *
 */
@WebFilter("/*")
public class MDCFilter implements Filter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MDCFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            MDC.put("sessionId", req.getSession()
                .getId());
            LOGGER.debug("MDC Session initialisé");
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }

    }

    public void destroy() {

    }

}
