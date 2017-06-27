package ao.co.smpip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.Posto;
import ao.co.smpip.jdbc.MapaDAO;

/**
 * Servlet implementation class PostosController
 */
@WebServlet("/PostosController")
public class PostosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PostosController() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MapaDAO mp = new MapaDAO();
    	Posto p = new Posto();

    	String nome = request.getParameter("nomep");
    	int prov = Integer.parseInt(request.getParameter("provincia"));
    	int muni = Integer.parseInt(request.getParameter("municipio"));
    	int dist = Integer.parseInt(request.getParameter("distrito"));
    	int qdt = Integer.parseInt(request.getParameter("qdtLp"));
    	int idposto =  Integer.parseInt(request.getParameter("idposto"));
    	 
    	p.setNomPosto(nome);
    	p.setQdtLampada(qdt);
    	p.setIdPosto(idposto);
    	p.setFk_distrito(dist);
    	p.setFk_municipio(muni);
    	p.setFk_provincia(prov);
    	mp.editar_armario(p);
    	mp.editar_LocalArmario(p);
    	response.sendRedirect("navegacao?mod=cf&pesquisar=mt");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MapaDAO mp = new MapaDAO();
    	Posto p = new Posto();
    	Diverso d = new Diverso();
    	String acao = request.getParameter("salvar");
    	Double lat = Double.parseDouble(request.getParameter("lat"));
    	Double lng = Double.parseDouble(request.getParameter("lng"));
    	String desc = request.getParameter("desc");
    	String nome = request.getParameter("nomep");
    	int prov = Integer.parseInt(request.getParameter("provincia"));
    	int muni = Integer.parseInt(request.getParameter("municipio"));
    	int dist = Integer.parseInt(request.getParameter("distrito"));
    	int qdt = Integer.parseInt(request.getParameter("qdtLp"));
    	int fkEnt =  Integer.parseInt(request.getParameter("fkUsuario"));
    
    	p.setLatitude(lat);
    	p.setLongitude(lng);
    	p.setDescricao(desc);
    	p.setNomPosto(nome);
    	p.setQdtLampada(qdt);
    	int armario = mp.novo_armario(p);
    	d.setFk_armario(armario);
    	d.setProvincia(prov);
    	d.setDistrito(dist);
    	d.setMunicipio(muni);
    	mp.endereco_armario(d);
    	
    	response.sendRedirect("navegacao?mod=cf&pesquisar=mt");
		//saida.forward(request, response);
	}

}
