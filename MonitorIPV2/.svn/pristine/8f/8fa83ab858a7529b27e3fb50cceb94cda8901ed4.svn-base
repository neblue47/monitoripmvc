package ao.co.smpip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.*;
import ao.co.smpip.jdbc.Formatando;
import ao.co.smpip.jdbc.AgendaDAO;
/**
 * Servlet implementation class AgendaVisualizarController
 */
@WebServlet("/agendavisualizarcontroller")
public class AgendaVisualizarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaVisualizarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AgendaDAO age = new AgendaDAO();
		String acao = request.getParameter("acao");
		String cod = request.getParameter("cod");
		if(cod != null && !cod .equals("")){
			System.out.println();
			request.getSession().setAttribute("codP", cod); 
		}
		RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=ag&acao=pesq");
		saida.forward(request, response);
		
		
	
	}
	

}
