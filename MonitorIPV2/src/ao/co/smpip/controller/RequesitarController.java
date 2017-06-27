package ao.co.smpip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.jdbc.FuncionarioDAO;
import ao.co.smpip.utils.EmailJava;
import ao.co.smpip.utils.SmsJava;

/**
 * Servlet implementation class RequesitarController
 */
@WebServlet("/requesitar.do")
public class RequesitarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequesitarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
		String tofone = request.getParameter("tofone");
		String msg  =  request.getParameter("msg");
		int p1 = tofone.indexOf("<");
		int p2 = tofone.indexOf(">");
		String fone  = tofone.substring((p1+2), (p2-1));
//		System.out.println("P1 : "+(p1+1)+" P2: "+p2);
//		System.out.println(fone);
		
		response.sendRedirect("navegacao?mod=ag&pesquisar=msg");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = "sistemampip@gmail.com";
		String aux = request.getParameter("tomail");
		String subj = request.getParameter("subj");
		String msg  =  request.getParameter("msg");
		String tipo = request.getParameter("tipom");
		Funcionario f = new FuncionarioDAO().getContacto(aux);
		if(tipo!=null && tipo.equals("1")){
			EmailJava email = new EmailJava();
			String to = f.getEmail();
			email.EnviarMail(from, subj, msg, to);
		}
		if(tipo!=null && tipo.equals("2")){
			try {
				String fone = ""+f.getTelefone();
				SmsJava.simpleSMS(fone, msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("navegacao?mod=ag&pesquisar=msg");
	}

}
