package ao.co.smpip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.Usuario;
import ao.co.smpip.jdbc.AcessosDAO;
import ao.co.smpip.jdbc.UserDAO;
import ao.co.smpip.serial.SerialConexao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		HttpSession sessaos = request.getSession(false);
		SerialConexao sc = new SerialConexao();
		if(acao!=null&&acao.equals("out")) 
		{
			if(sessaos!=null){
				sessaos.invalidate();
				
			}
			sc.close();
		}
		response.sendRedirect("login.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usu = new Usuario();
		UserDAO uDao = new UserDAO();
		String user = request.getParameter("user");
		String pass = request.getParameter("senha");
		HttpSession sessao = request.getSession();
		usu.setNome(user);
		usu.setSenha(pass);
		if(uDao.existe_usuario(usu))
		{
			Usuario us = uDao.autenticar(usu);
			List<Diverso>AcessoMudulos = new AcessosDAO().AcessoModulosLogin(us.getFK_entidade());
			List<Diverso>AcessoTelas   = new AcessosDAO().AcessoTelasLogin(us.getFK_entidade());
			List<Diverso>AcessoPrivTelas   = new AcessosDAO().AcessoTelasPrivLogin(us.getFK_entidade());
			
			System.out.println("Nome C: "+us.getNomeComp());
			
			sessao.setAttribute("nomeUsa", us.getNomeComp());
			sessao.setAttribute("fkUsuario", us.getId());
			sessao.setAttribute("nivelUs", us.getNivel());
			
			sessao.setAttribute("AcessoMudulos", AcessoMudulos);
			sessao.setAttribute("AcessoTelas", AcessoTelas);
			sessao.setAttribute("AcessoPrivTelas", AcessoPrivTelas);
			sessao.setAttribute("tmp", 60);
			System.out.println("CHEIYss");
			response.sendRedirect("navegacao?mod=ng");
//			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ng");
//			saida.forward(request, response);
		}
		else
		{
			request.setAttribute("mensLogin", "Nome do Utilizador ou Senha Invalida! ");
			RequestDispatcher saida = request.getRequestDispatcher("login.jsp");
			saida.forward(request, response);
		}
	}

}
