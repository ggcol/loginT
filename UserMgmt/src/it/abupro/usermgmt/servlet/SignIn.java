package it.abupro.usermgmt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.abupro.usermgmt.entities.Utente;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Utente u1 = new Utente();
		u1.setNome(request.getParameter("nome"));
		u1.setCognome(request.getParameter("cognome"));
		u1.setEmail(request.getParameter("email"));
		u1.setSesso(request.getParameter("sesso"));
		u1.setPassword(request.getParameter("password"));
		u1.setTipologia("usr");
		u1.creaNuovo(u1);
		
		response.sendRedirect("landing_page_new_user.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
