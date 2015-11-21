package cl.pruebas.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.prueba.datos.Usuario;
import cl.prueba.ejb.PrimerEJB;

/**
 * Servlet implementation class ServletPrueba1
 */
@WebServlet("/Servlet")
public class ServletPrueba1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PrimerEJB oEjb;
          
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sNombreUsuario = request.getParameter("id");
    	String sPassword = request.getParameter("pass");
    	Usuario usuario= oEjb.login(sNombreUsuario, sPassword);
    	if (usuario!=null) {
	    	request.setAttribute("usuario", usuario.getNombre());
	    	request.getRequestDispatcher("home.jsp").forward(request, response);
    	} else {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	}
    }
}
