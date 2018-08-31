package ao.co.smpip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.co.smpip.jdbc.MapaDAO;

/**
 * Servlet implementation class ExtraController
 */
@WebServlet("/ExtraController")
public class ExtraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ExtraController() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		String num = request.getParameter("codigoTdoc");
		out.write(num);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String tmp = request.getParameter("tmp");
		String normal = request.getParameter("normalPosto");
		String median = request.getParameter("medianPosto");
		String tamMap = request.getParameter("tamMap");
		HttpSession ss = request.getSession();
		try {
			if(tmp!=null)
			{
				int tempo = Integer.parseInt(tmp);
				new MapaDAO().atualizarTempoTela(tempo);
			}
			if(tamMap!=null)
			{
				int tam = Integer.parseInt(tamMap);
				new MapaDAO().atualizarTamanhoTela(tam);
			}
			if(normal!=null && median !=null)
			{
				double n1 = Double.parseDouble(normal);
				double m2 = Double.parseDouble(median);
				
				new MapaDAO().atualizarValoresArmarios(n1,m2);
			}
			
			ss.setAttribute("msgOk", "msgOk");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("navegacao?mod=cf&pesquisar=cm");
	}
}
;