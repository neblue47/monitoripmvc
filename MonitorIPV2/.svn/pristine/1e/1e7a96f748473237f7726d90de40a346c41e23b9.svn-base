package ao.co.smpip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Equipa;
import ao.co.smpip.jdbc.EquipaDAO;

/**
 * Servlet implementation class EquipaController
 */
@WebServlet("/EquipaController")
public class EquipaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Equipa equipa = new Equipa();
		String acao		  = request.getParameter("acao");
		String nomeEquipa = request.getParameter("nomeEquipa");
		
		if(acao == null || acao.equals("")){
			equipa.setNome_equipe(nomeEquipa);
			new EquipaDAO().NovaEquipa(equipa);
		}
		if(acao != null && acao.equals("edit")){
			int id_equipa = Integer.parseInt(request.getParameter("idEquipa"));
			equipa.setId_equipa(id_equipa);
			equipa.setNome_equipe(nomeEquipa);
			new EquipaDAO().EditarEquipa(equipa);
		}
		response.sendRedirect("navegacao?mod=ad&pesquisar=eq");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
