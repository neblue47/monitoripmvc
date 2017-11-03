package ao.co.smpip.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.smpip.entidades.Posto;
import ao.co.smpip.jdbc.Formatando;
import ao.co.smpip.jdbc.MapaDAO;

/**
 * Servlet implementation class SensorController
 */
@WebServlet("/SensorController")
public class SensorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SensorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	    try {
	    	String  armario = request.getParameter("armario");
			String  historico = request.getParameter("historico");
			String equipa = request.getParameter("equipa");
			String observ = request.getParameter("obs");
			String dtmanu = request.getParameter("data");
			String dataEv = request.getParameter("dataEv");
			int fk_armario = Integer.parseInt(armario);
			int fk_equipa = Integer.parseInt(equipa);
			int fk_histo = Integer.parseInt(historico);
			Calendar data1= new Formatando().data(dtmanu); 
			Date data = new Formatando().dataSql(dataEv);
			Posto p = new Posto();
			List<Posto> logs = new MapaDAO().buscaLogsToFixNoHistorico(fk_armario, data);
			if(!logs.isEmpty())
			{
				p.setSensor(logs.get(0).getSensor());
				p.setIdPosto(logs.get(0).getIdPosto());
				p.setDataEv(data1);
				p.setFk_entidade(fk_equipa);
				p.setDescricao(observ);
				p.setFk_historico(fk_histo);
				p.setSensor(p.getSensor());
				
				new MapaDAO().manutencao(p);
				new MapaDAO().clear_manutencao(p.getSensor(), data, fk_histo ); 
			}
			
			
			
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("navegacao?mod=ag&pesquisar=mts");		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String sensor = request.getParameter("sensor");
		 String armario = request.getParameter("armario");
		 String modelo = request.getParameter("modelo");
		 String status = request.getParameter("status");
		 
		 try {
			int codArm = Integer.parseInt(armario);
			int state = Integer.parseInt(status);
			Posto novoSensor = new Posto();
			novoSensor.setIdPosto(codArm);
			novoSensor.setNomSensor(sensor);
			novoSensor.setDescricao(modelo);
			novoSensor.setStatus(state);
			new MapaDAO().configuraSensor(novoSensor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 response.sendRedirect("navegacao?mod=cf&pesquisar=ns");
	}

}
