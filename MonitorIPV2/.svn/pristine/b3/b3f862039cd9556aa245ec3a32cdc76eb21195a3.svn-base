package ao.co.smpip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Grupos;
import ao.co.smpip.jdbc.GrupoDAO;

@WebServlet("/grcontroller.do")
public class GrupoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GrupoController() {
        super(); 
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GrupoDAO grDao = new GrupoDAO();
		Grupos gr = new Grupos();
		String acao = request.getParameter("acao");
				
		if(acao!= null && acao.equals("edit"))
		{
			try{
				int cod = Integer.parseInt(request.getParameter("cod"));
				RequestDispatcher saida = request.getRequestDispatcher("index.jsp?pesquisar=cg&mod=ad&cod="+cod);
				saida.forward(request, response);
			}catch(NumberFormatException er){}
			
		}
		if(acao!= null && acao.equals("exc"))
		{
			try{
				int cod = Integer.parseInt(request.getParameter("cod"));
				grDao.del_grupo(cod);
				RequestDispatcher saida = request.getRequestDispatcher("index.jsp?pesquisar=cg&mod=ad");
				saida.forward(request, response);
			}catch(NumberFormatException er){}
			
		}
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GrupoDAO grDao = new GrupoDAO();
		Grupos gr = new Grupos();
		String txtgrupo = request.getParameter("txtgrupo");
		String id    = request.getParameter("txtcod");
		String salvar = request.getParameter("salvar");
		System.out.print(id);
		if(id!=null && !id.equals("0"))
		{
			try{
				gr.setId_grupo(Integer.parseInt(id));
				System.out.print(gr.getId_grupo());
			}catch(NumberFormatException er){}
			gr.setNomgrupo(txtgrupo);
			grDao.salvar(gr);
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?pesquisar=cg&mod=ad");
			saida.forward(request, response);
		}
		else{
			gr.setNomgrupo(txtgrupo);
			grDao.salvar(gr);
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?pesquisar=cg&mod=ad");
			saida.forward(request, response);
		}
			
		
		
	} 
		
	

}
