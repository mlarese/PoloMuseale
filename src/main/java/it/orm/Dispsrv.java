package it.orm;

import jakarta.ejb.EJB;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MuseoSrv
 */
@WebServlet("/dispatch/*")
public class Dispsrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB MuseoEjb mejb;

    public Dispsrv() {
        super();
    }

   
    public void editMuseo(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().append("Eccolo richiesto ")
		.append("editMuseo") ;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		switch(path) {
			case "/edit/musei": editMuseo(request,response);break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
