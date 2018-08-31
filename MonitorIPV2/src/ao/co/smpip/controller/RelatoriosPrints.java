package ao.co.smpip.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ao.co.smpip.utils.RelatorioUtil;



@WebServlet("/relatorioprint.do")
public class RelatoriosPrints extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		 RelatorioUtil gpdf = new RelatorioUtil();
		 Map<String, Object> param = new HashMap<String, Object>();
		 ServletOutputStream saida = response.getOutputStream();
		 // Pacientes Cadastrados
		 if(true)
		 {
			 try
			 {					 
					 param.put("armario", "Caixa Campus UAN");
					 String jrxml = getServletContext().getRealPath("/WEB-INF/relatorios/RelatorioDiario.jrxml");
					 gpdf.geraPdf(jrxml, param, saida);
			 }
			  
			 catch(Exception e){
				 e.printStackTrace();
			 }
		 }

		
	}
}
