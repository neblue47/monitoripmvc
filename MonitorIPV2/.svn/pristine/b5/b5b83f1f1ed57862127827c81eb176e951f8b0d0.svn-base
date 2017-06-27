package ao.co.smpip.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import ao.co.smpip.entidades.Usuario;
import ao.co.smpip.jdbc.UserDAO;
import ao.co.smpip.security.EncriptaDecriptaRSA;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando pelo Metodo Get");
		
		//1 Obter os dados
		UserDAO usuDao = new UserDAO();
		List<Usuario> lista = usuDao.buscaTodos();
		
		String acao = request.getParameter("acao");
		if(acao!=null && acao.equals("exc"))
		{
			String id = request.getParameter("id");
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(id));
			usuDao.excluir(usu);
		}
		if(acao!=null && acao.equals("alt"))
		{
			String id = request.getParameter("id");
			Usuario usu = usuDao.buscarPorId(id); 
			request.setAttribute("usuario", usu);
			RequestDispatcher saida = request.getRequestDispatcher("usuform.jsp");
			saida.forward(request, response);
		}
		if(acao!=null && acao.equals("lis"))
		{
			request.setAttribute("lista", lista);
			
			//3 Encaminhar no JSP
			RequestDispatcher saida = request.getRequestDispatcher("listarusuario.jsp");
			saida.forward(request, response);
			//saida.println(lista);
		}
		if(acao!=null && acao.equals("fu"))
		{
			request.setAttribute("lista", lista);
			
			//3 Encaminhar no JSP
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?p=fu");
			saida.forward(request, response);
			//saida.println(lista);
		}
		if(acao!=null && acao.equals("us"))
		{
			request.setAttribute("lista", lista);
			
			//3 Encaminhar no JSP
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?p=us");
			saida.forward(request, response);
			//saida.println(lista);
		}
		if(acao!=null && acao.equals("ps"))
		{
			request.setAttribute("lista", lista);
			
			//3 Encaminhar no JSP
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?p=ps");
			saida.forward(request, response);
			//saida.println(lista);
		}
		if(acao!=null && acao.equals("cad"))
		{
			
			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setNome("");
			usu.setSenha("");
			usu.setNivel(0);
			request.setAttribute("usuario", usu);
			RequestDispatcher saida = request.getRequestDispatcher("usuarioform.jsp");
			saida.forward(request, response);
		}
		//2 Engavetar os dados
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando pelo Metodo Post");
		String id    = request.getParameter("txtid");
		String nome  = request.getParameter("nomeu");
		String senha = request.getParameter("senha");
		String txtfk = request.getParameter("txtfk");
		int nivel    = Integer.parseInt(request.getParameter("grupou"));
		String hashsenha =  EncriptaDecriptaRSA.criptografa(senha);
		Usuario usu = new Usuario();
		if(id!=null && !id.equals("0"))
		{usu.setId(Integer.parseInt(id));}
		usu.setNome(nome);
		usu.setSenha(hashsenha);
		usu.setNivel(nivel); 
		usu.setFK_entidade(Integer.parseInt(txtfk));
		UserDAO usuDao = new UserDAO();
		usuDao.salvar(usu);
		response.sendRedirect("navegacao?mod=ad&pesquisar=ut&cod="+txtfk);
	}

}
