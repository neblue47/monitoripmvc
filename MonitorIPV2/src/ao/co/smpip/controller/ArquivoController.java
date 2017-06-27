package ao.co.smpip.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.jdbc.FuncionarioDAO;

/**
 * Servlet implementation class DeleteArquivo
 */
@WebServlet("/deletearq.do")
public class ArquivoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArquivoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		if(acao.equals("exec"))
		{
			try
			{
			int id = Integer.parseInt(request.getParameter("arqId"));
			int tip = Integer.parseInt(request.getParameter("tip"));
			Funcionario fn = new Funcionario();
			fn.setId_entidade(id);fn.setArquivo(tip);
			FuncionarioDAO fDao = new FuncionarioDAO();
			
			try{
				File f=new File(fDao.Find_Arq(fn));
				if(f.delete()){
					System.out.print(fDao.Find_Arq(fn));
					response.setContentType("text/javascript");
					response.getWriter().write("function teste() { alert('Ficheiro Eliminado com sucesso.'); }");
				}
				
			}catch(Exception e){}
			fDao.Delete_Arq(fn);
			//JOptionPane.showMessageDialog(null, "Eliminado com sucesso");
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=Arquivo&arqId="+id);
			saida.forward(request, response);
			}
			catch(NumberFormatException er){}
		}
	}

}
