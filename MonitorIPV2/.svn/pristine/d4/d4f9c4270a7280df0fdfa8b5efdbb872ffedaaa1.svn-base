package ao.co.smpip.controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import ao.co.smpip.jdbc.Conexao;
import ao.co.smpip.jdbc.FuncionarioDAO;
import ao.co.smpip.utils.RelatorioUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;



@WebServlet("/relatorioprint.do")
public class RelatoriosPrints extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		 // Compile jrxml file.
	       JasperReport jasperReport;
		try {
			jasperReport = JasperCompileManager.compileReport(getServletContext().getRealPath("/WEB-INF/relatorios/relatorioEquipa.jrxml"));
			// Parameters for report
			Map<String, Object> parameters = new HashMap<String, Object>();
			Connection dataSource = Conexao.getConexao();

			JasperPrint jasperPrint;
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			File outDir = new File("C:/jasperoutput");
			outDir.mkdirs();
			JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/jasperoutput/relatorioEquipa.pdf");
		} catch (JRException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	 
		

		
	}
}
