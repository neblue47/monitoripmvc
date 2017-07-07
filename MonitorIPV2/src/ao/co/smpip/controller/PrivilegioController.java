package ao.co.smpip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Usuario;
import ao.co.smpip.jdbc.AcessosDAO;

/**
 * Servlet implementation class PrivilegioController
 */
@WebServlet("/PrivilegioController")
public class PrivilegioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrivilegioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuId = request.getParameter("txtUt");
	 
			
		try {
			if(usuId!=null && !usuId.equals("")){
				int id_ut = Integer.parseInt(usuId);
 
				new AcessosDAO().EliminarPerfilUtilizador(id_ut);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("navegacao?mod=cf&pesquisar=acssu");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuId = request.getParameter("txtUt");
		String usuPrf = request.getParameter("codperfil");
			
		try {
			if(usuId!=null && usuPrf!=null){
				int id_ut = Integer.parseInt(usuId);
				int id_prf = Integer.parseInt(usuPrf);
				Usuario uso = new Usuario();
				uso.setId(id_ut);
				uso.setFk_perfil(id_prf);
				new AcessosDAO().AssociarPerfilUtilizador(uso);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("navegacao?mod=cf&pesquisar=acssu");
	}
}
