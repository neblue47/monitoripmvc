package ao.co.smpip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.jdbc.AcessosDAO;
import ao.co.smpip.jdbc.AgendaDAO;

/**
 * Servlet implementation class AcessosController
 */
@WebServlet("/AcessosController")
public class AcessosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcessosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcessosDAO acDAO = new AcessosDAO();
		List<Diverso> acessos =  new ArrayList<Diverso>();
		String perfil = request.getParameter("perfil");
		String modulo = request.getParameter("modulo");
		String [] telas = request.getParameterValues("opcao");
		if(telas!=null && telas.length > 0){
			int fk_perfil = Integer.parseInt(perfil);
			int fk_modulo = Integer.parseInt(modulo);
			for(int i = 0;i < telas.length; i++)
			{
				Diverso dd = new Diverso();
				dd.setFk_perfil(fk_perfil);
				dd.setId_mod(fk_modulo);
				dd.setId_tela(Integer.parseInt(telas[i]));
				acessos.add(dd);
			}
			acDAO.EditarPerifilTelas(acessos);
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
