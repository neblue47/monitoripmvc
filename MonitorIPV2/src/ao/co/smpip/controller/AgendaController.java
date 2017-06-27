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
import ao.co.smpip.jdbc.FuncionarioDAO;
import ao.co.smpip.utils.MetodosBuscas;


/**
 * Servlet implementation class AgendaController
 */
@WebServlet("/agendacontroller.do")
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaController() {
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
		if(acao!=null && acao.equals("ag"))
		{
			
			int ID = Integer.parseInt(request.getParameter("cod"));
			
			Funcionario turno = age.buscaFuncionario(ID);
			List <Funcionario> lista = new FuncionarioDAO().getFuncionario();
			List <Diverso> dsemanas = new MetodosBuscas().buscaDiasSemanasEnum();
			request.setAttribute("lista", lista);
			request.setAttribute("dsemanas", dsemanas);
			request.getSession().setAttribute("tur",turno);
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=ag");
			saida.forward(request, response);
		}
		if(acao!=null && acao.equals("edit"))
		{
			
			int ns = Integer.parseInt(request.getParameter("cod"));
			Turnos funs = age.edit_agenda(ns);
			request.getSession().setAttribute("dados",funs);
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=ag");
			saida.forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando pelo Metodo Post");
		Turnos fun = new Turnos();
		AgendaDAO funDao = new AgendaDAO();
		try
		{
			String acao = request.getParameter("acao");
			int cod = Integer.parseInt(request.getParameter("FK_enti"));     
			fun.setId_agendatrabalho(cod);
			fun.setFK_entidade(cod);
			String hora_de_inicio = request.getParameter("horai");  						
			fun.setHora_de_inicio(hora_de_inicio);
			int dia_da_semana = Integer.parseInt(request.getParameter("d_semana"));    
			fun.setDia_da_semana(dia_da_semana);
			String hora_do_fim = request.getParameter("horaf");                             
			fun.setHora_do_fim(hora_do_fim);
			
			System.out.println("FK_entidade:"+cod+"Hora de Início:"+hora_de_inicio+"Dia da Semana"+dia_da_semana+"Hora do Fim"+hora_do_fim);
			 
			if (acao!=null && acao.equals("ag")){
				funDao.agendar(fun);
				response.sendRedirect("index.jsp?mod=ad&pesquisar=ag");
			}
			if(acao!=null && acao.equals("edit"))
			{
				funDao.alt_agenda(fun);
				response.sendRedirect("navegacao?mod=ad&pesquisar=ag");
				
		     }
		}
		catch(NumberFormatException er){
			
		}
	
		
	}

}
