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
import ao.co.smpip.jdbc.AgendaDAO;

/**
 * Servlet implementation class AgendaEliminarController
 */
@WebServlet("/agendaeliminarcontroller.do")
public class AgendaEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaEliminarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = request.getParameter("acao");
		
		  AgendaDAO agendaDao = new AgendaDAO();
		  if(acao!= null && acao.equals("exc"))
			{
				try{
					int cod = Integer.parseInt(request.getParameter("cod"));
					 agendaDao.delete_funcionarioagendado(cod);
					 response.sendRedirect("index.jsp?mod=ad&pesquisar=ag&cod="+cod);
//					saida.forward(request, response);
				}catch(NumberFormatException er){}
				
			}
		  if(acao!= null && acao.equals("edit"))
			{
				try{
					int cod = Integer.parseInt(request.getParameter("cod"));
					 Turnos listEdt = agendaDao.edit_agenda(cod);
					 request.getSession().setAttribute("listEdt", listEdt);
					 response.sendRedirect("index.jsp?mod=ad&pesquisar=ag&cod="+cod);
//					saida.forward(request, response);
				}catch(NumberFormatException er){}
				
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AgendaDAO agendaDao = new AgendaDAO();
		 Turnos ag = new Turnos();
		int cod = Integer.parseInt(request.getParameter("cod"));
		int FK_entidade =Integer.parseInt(request.getParameter("FK_entidade"));
		int dia_da_semana = Integer.parseInt(request.getParameter("champ_contact"));
		String hora_de_inicio = request.getParameter("horai");
		String hora_do_fim = request.getParameter("horaf");
		String id    = request.getParameter("");
		String salvarAge = request.getParameter("salvarAgenda");
		System.out.print(id);
		if(id!=null && !id.equals("0"))
		{
			try{
				ag.setFK_entidade(Integer.parseInt(id));
				System.out.print(ag.getFK_entidade());
			}catch(NumberFormatException er){}
			ag.setDia_da_semana(dia_da_semana);
			ag.setHora_de_inicio(hora_de_inicio);
			ag.setHora_do_fim(hora_do_fim);
			agendaDao.salvarAge(ag);
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=ag&cod="+cod);
			saida.forward(request, response);
		}
		else{
			agendaDao.salvarAge(ag);
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=ag&cod="+cod);
			saida.forward(request, response);
		}
	} 
	
	}


