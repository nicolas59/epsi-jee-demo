package fr.nro.demoservlet.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ecouteur permettant d'afficher le nombre de sessions créé.
 * 
 * 
 * @author nrousseau1
 *
 */
@WebListener
public class SessionDetectionListener implements HttpSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionDetectionListener.class);

    private AtomicInteger sessionCounter = new AtomicInteger(0);

    public void sessionCreated(HttpSessionEvent se) {
        LOGGER.info("Nouvelle session créée");
        LOGGER.info("Nombre de sessions en cours : {}", sessionCounter.incrementAndGet());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCounter.decrementAndGet();
    }

}
