package co.sigp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tareas")
public class TareaServlet extends HttpServlet {
    private static final String TAREAS = "sigpTareas";

    @SuppressWarnings("unchecked")
    private List<String> obtenerTareas(HttpSession session) {
        List<String> tareas = (List<String>) session.getAttribute(TAREAS);
        if (tareas == null) {
            tareas = new ArrayList<>();
            session.setAttribute(TAREAS, tareas);
        }
        return tareas;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("metodoUsado", "GET");
        request.setAttribute("tareas", obtenerTareas(request.getSession()));
        request.getRequestDispatcher("/WEB-INF/tareas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombreTarea");
        String prioridad = request.getParameter("prioridad");

        if (nombre != null && !nombre.trim().isEmpty()) {
            String tarea = nombre.trim() + " — Prioridad: "
                    + (prioridad == null || prioridad.isBlank() ? "Media" : prioridad);
            obtenerTareas(request.getSession()).add(tarea);
            request.getSession().setAttribute("mensaje", "Tarea registrada correctamente.");
        } else {
            request.getSession().setAttribute("mensaje", "Escribe el nombre de la tarea.");
        }
        response.sendRedirect(request.getContextPath() + "/tareas");
    }
}
