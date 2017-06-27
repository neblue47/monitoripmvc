package ao.co.smpip.controller;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import ao.co.smpip.jdbc.FuncionarioDAO;
import ao.co.smpip.utils.RelatorioUtil;



@WebServlet("/RelatoriosServlet")
public class RelatoriosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	static String fotos="";
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> parametros = new HashMap<String, Object>();

		String nomeRelat = request.getParameter("nomeArquivo");
		String caixa = request.getParameter("armario");
		if(nomeRelat!=null){
			if (nomeRelat.equalsIgnoreCase("Passe")) {
				Integer aux = Integer.parseInt(request.getParameter("id_entidade"));
				fotos = new FuncionarioDAO().foto(aux);
				parametros.put("id_entidade", aux);					
			}
			
			if(fotos.equals("")||fotos==null){
				fotos = "semfoto.JPG";
			}
			Image logo = new ImageIcon(getServletContext().getRealPath("/WEB-INF/relatorios/logoIP.jpg")).getImage(); 
			parametros.put("RelLogo", logo);
			
			Image foto = new ImageIcon(getServletContext().getRealPath("/WEB-INF/relatorios/"+fotos)).getImage(); 
			parametros.put("RelFotoUser", foto);
		}
		else
		{
			//invoice_logo.png
			nomeRelat = "relatorioEquipa";
			Image logo = new ImageIcon(getServletContext().getRealPath("/ficheiro/inotec.jpg")).getImage(); 
			parametros.put("logoImg", logo);
			parametros.put("caixa", caixa);
		}
		
		
		String arquivoJasper = getServletContext().getRealPath(
				"/WEB-INF/relatorios/" + nomeRelat + ".jasper");

		byte[] bytes = RelatorioUtil.criarRelatorio(arquivoJasper, parametros);

		if (bytes != null && bytes.length > 0) {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		}
	}
}
