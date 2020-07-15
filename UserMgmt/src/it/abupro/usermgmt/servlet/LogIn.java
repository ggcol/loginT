package it.abupro.usermgmt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.abupro.usermgmt.entities.Utente;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/logIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailIm = request.getParameter("email");
		String pswIm = request.getParameter("password");
		
		Utente u1 = new Utente();
		boolean check = u1.confronto(emailIm, pswIm);
		short tipologia = u1.tipoUtente(emailIm);
		
		if (check == true) {
			if (tipologia == 3) {
			response.sendRedirect("landing_page_alredy_normal_user.html");
			} else if (tipologia == 2) {
				response.sendRedirect("landing_page_alredy_mod_user.html");
			} else if (tipologia == 1) {
				response.sendRedirect("landing_page_alredy_adm_user.html");
			}
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "email o psw incorrette");
			
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
