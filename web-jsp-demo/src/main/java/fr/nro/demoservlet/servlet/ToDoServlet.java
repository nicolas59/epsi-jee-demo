package fr.nro.demoservlet.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.nro.demoservlet.bean.ToDoBean;
import fr.nro.demoservlet.bean.ToDoBean.Status;

/**
 * Exemple trés simplifé d'un affichage de la liste des <i>ToDo</i>.
 * 
 * 
 * @author nrousseau1
 *
 */
@WebServlet("/todo")
public class ToDoServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -2476410260687452867L;

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ToDoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Acces servlet TODO");
        final List<ToDoBean> todos = Arrays.asList(new ToDoBean(1L, "Preparer les cours", Status.EN_COURS),
                new ToDoBean(2L, "Terminer les tutos", Status.EN_COURS));
        req.setAttribute("todos", todos);
        req.getRequestDispatcher("/WEB-INF/views/todo.jsp")
            .include(req, resp);

    }

}
