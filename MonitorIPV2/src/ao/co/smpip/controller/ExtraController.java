package ao.co.smpip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.co.smpip.jdbc.MapaDAO;

/**
 * Servlet implementation class ExtraController
 */
@WebServlet("/ExtraController")
public class ExtraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ExtraController() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		String num = request.getParameter("codigoTdoc");
		out.write(num);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String tmp = request.getParameter("tmp");
		HttpSession ss = request.getSession();
		try {
			int tempo = Integer.parseInt(tmp);
			new MapaDAO().atualizarTempoTela(tempo);
			
			ss.setAttribute("msgOk", "msgOk");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("navegacao?mod=cf&pesquisar=cm");
	}
}
;