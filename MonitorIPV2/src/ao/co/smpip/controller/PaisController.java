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
import ao.co.smpip.jdbc.AcessosDAO;
import ao.co.smpip.utils.MetodosBuscas;

/**
 * Servlet implementation class controller
 */
@WebServlet("/PaisController")
public class PaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PaisController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		String pais = request.getParameter("codigopais");
		String prov = request.getParameter("codigoprovincia");
		String munc = request.getParameter("codigomunicipio");
		
		StringBuilder sb = new StringBuilder();
		MetodosBuscas eDao = new MetodosBuscas();
		try {
			if(pais!=null && !pais.equals("")){
				int cd = Integer.parseInt(pais); 
				List <Diverso> lp = eDao.buscaProvincia(cd);
				for(int i=0;i<lp.size();i++)
					sb.append(lp.get(i).getProvincia()+"-"+lp.get(i).getNomeProv()+":");
			}
			if(prov!=null && !prov.equals("")){
				System.out.println(prov);
				int cd = Integer.parseInt(prov);
				List <Diverso> lp = eDao.buscaMunicipio(cd);
				for(int i=0;i<lp.size();i++)
					sb.append(lp.get(i).getMunicipio()+"-"+lp.get(i).getNomePais()+":");
			}
			
			if(munc!=null && !munc.equals("")){
				System.out.println(munc);
				int cd = Integer.parseInt(munc);
				List <Diverso> lp = eDao.buscaDistrito(cd);
				for(int i=0;i<lp.size();i++)
					sb.append(lp.get(i).getProvincia()+"*"+lp.get(i).getNomeProv()+":");
			}
			
			else{
				System.out.println(0000000);
				int codmodulo = Integer.parseInt(request.getParameter("codmodulo"));
				int Idperfil = Integer.parseInt(request.getParameter("Idperfil"));
				AcessosDAO acDao = new AcessosDAO(); 
				List <Diverso> lt = acDao.buscarTelasPorPerfil(Idperfil,codmodulo);
				 
				for(int i=0;i<lt.size();i++)
					sb.append(lt.get(i).getId_tela()+"-"+lt.get(i).getTela()+":");
			}
			
			response.setContentType("text/plain");  
		  	response.setCharacterEncoding("UTF-8"); 
			out.write(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		try {
			int cd = Integer.parseInt(request.getParameter("codcategoria"));
			MetodosBuscas eDao = new MetodosBuscas(); 
			List <Diverso> lp = eDao.buscaProfissao(cd);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<lp.size();i++)
				sb.append(lp.get(i).getProfissao()+"-"+lp.get(i).getNomeProf()+":");
			    out.write(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
