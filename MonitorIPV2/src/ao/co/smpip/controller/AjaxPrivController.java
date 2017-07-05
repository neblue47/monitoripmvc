package ao.co.smpip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.Grupos;
import ao.co.smpip.jdbc.AcessosDAO;
import ao.co.smpip.jdbc.GrupoDAO;

/**
 * Servlet implementation class AjaxPrivController
 */
@WebServlet("/AjaxPrivController")
public class AjaxPrivController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxPrivController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		StringBuilder sb = new StringBuilder();
		
		try {
			int codmodulo = Integer.parseInt(request.getParameter("codmodulo"));
			int Idperfil = Integer.parseInt(request.getParameter("idperfil"));
			AcessosDAO acDao = new AcessosDAO(); 
			List <Diverso> lt = acDao.buscarTelasPorPerfil(Idperfil,codmodulo);
			
			for(int i=0;i<lt.size();i++)
				sb.append(lt.get(i).getId_tela()+"-"+lt.get(i).getTela()+":");
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		response.setContentType("text/plain");  
	  	response.setCharacterEncoding("UTF-8"); 
	  	response.getWriter().write(sb.toString()); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
