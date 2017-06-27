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

import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.entidades.Grupos;
import ao.co.smpip.jdbc.Formatando;
import ao.co.smpip.jdbc.FuncionarioDAO;
import ao.co.smpip.jdbc.GrupoDAO;

/**
 * Servlet implementation class ModController
 */
@WebServlet("/ModController")
public class ModController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		
		int cd = Integer.parseInt(request.getParameter("codigomod"));
		GrupoDAO eDao = new GrupoDAO(); 
		List <Grupos> lt = eDao.buscaTelas(cd);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<lt.size();i++)
			sb.append(lt.get(i).getId_tela()+"-"+lt.get(i).getTela()+":");
		out.write(sb.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GrupoDAO eDao = new GrupoDAO(); 
		Formatando dt = new Formatando();
		String acao = request.getParameter("btpriv");
		String grupo = request.getParameter("grupo");
		String modulo= request.getParameter("modulo");
		String tela  = request.getParameter("tela");
		String [] priv= request.getParameterValues("opcao");
		int fk_priv[] = new  int [priv.length];
		int tam = priv.length;
		if(acao!=null  )
		{
			int fk_grupo = Integer.parseInt(grupo);
			int fk_modulo = Integer.parseInt(modulo);
			int fk_tela = Integer.parseInt(tela);
			for(int i=0;i<tam;i++)
			{
				Grupos grup = new Grupos();
				grup.setFk_grupo(fk_grupo);
				grup.setFk_modulos(fk_modulo);
				grup.setFk_telas(fk_tela);
				grup.setDt_registo(dt.data_registo());
				grup.setFk_funcionalidades(Integer.parseInt(priv[i]));
				System.out.print("\nGrupo: "+grup.getFk_grupo()+ " Modulo: "+grup.getFk_modulos()+" Tela: "+grup.getFk_telas()+" Funcionalidade: "+grup.getFk_funcionalidades()+" Data Registo: "+grup.getDt_registo() );
				eDao.add_funcionalidade(grup);
			}
			RequestDispatcher saida = request.getRequestDispatcher("index.jsp?pesquisar=cg");
			saida.forward(request, response);
		}
		
		
	}

}
