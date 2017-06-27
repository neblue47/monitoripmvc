package ao.co.smpip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.entidades.Usuario;
import ao.co.smpip.jdbc.Formatando;
import ao.co.smpip.jdbc.FuncionarioDAO;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/editcontroller.do")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FuncionarioDAO funDao = new FuncionarioDAO();
		String acao = request.getParameter("acao");
		if(acao!=null && acao.equals("exc"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			new FuncionarioDAO().exlcuirFuncionario(id);
			request.getSession().setAttribute("excluido", "ok");
			response.sendRedirect("navegacao?mod=ad&pesquisar=p");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando pelo Metodo Post");
	 
				
	}
}
