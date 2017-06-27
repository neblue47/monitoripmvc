package ao.co.smpip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.entidades.Posto;
import ao.co.smpip.jdbc.MapaDAO;
import ao.co.smpip.utils.MetodosBuscas;

/**
 * Servlet implementation class PesquisarController
 */
@WebServlet("/PesquisarController")
public class PesquisarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String termo_n = request.getParameter("termo_n");
		String termo_e = request.getParameter("termo_e");
		String termo_t = request.getParameter("termo_t");
		String termo_a = request.getParameter("termo_a");
		List<Funcionario> listap = null;
		StringBuilder p = new StringBuilder();
		if(termo_a!=null){			
			System.out.println(termo_a);
			listap = new MetodosBuscas().buscaArmario(termo_a);
			for (int i = 0; i < listap.size(); i++)
				p.append(listap.get(i).getNome() + "-");	
		}
		if(termo_n!=null){			
			System.out.println(termo_n);
			listap = new MetodosBuscas().buscaNome(termo_n);
			for (int i = 0; i < listap.size(); i++)
				p.append(listap.get(i).getNome() + "-");	
		}
		if(termo_e!=null){			
			System.out.println(termo_e);
			listap = new MetodosBuscas().buscaNome(termo_e);
			for (int i = 0; i < listap.size(); i++)
				p.append(listap.get(i).getNome() + "-");	
		}
		if(termo_t!=null){			
			System.out.println(termo_t);
			listap = new MetodosBuscas().buscaTelefone(termo_t);
			for (int i = 0; i < listap.size(); i++)
				p.append(listap.get(i).getNome() + "-");	
		}
		response.setContentType("text/plain");  
 	  	response.setCharacterEncoding("UTF-8");
		out.write(p.toString());
		System.out.println("pasouuuu");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String termo = request.getParameter("termo");	 
		List<Posto> listap = new MapaDAO().buscaPorPostos(termo);
		StringBuilder p = new StringBuilder();
		if(termo!=null){
			for (int i = 0; i < listap.size(); i++)
				p.append(listap.get(i).getDescricao() + "-");	
		}		
		out.write(p.toString());
	}

}
