package ao.co.smpip.utils;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;
import com.sun.xml.internal.ws.util.UtilException;
import ao.co.smpip.jdbc.Conexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioUtil {

	public static byte[] criarRelatorio(String arquivoJasper, Map<String, Object> parametros) {
		byte[] bytes = null;
		try {
			Connection conn = Conexao.getConexao();
						
			JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(arquivoJasper);
			
			bytes = JasperRunManager.runReportToPdf(relatorioJasper, parametros, conn);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (UtilException e) {
			e.printStackTrace();
		}
		return bytes;
	}
	
	 
	   public void geraPdf(String jrxml, Map<String, Object> parametros, OutputStream saida) {

		        try {
		        	Connection conexao = Conexao.getConexao();
		            // compila jrxml em memoria
		            JasperReport jasper = JasperCompileManager.compileReport(jrxml);

		            // preenche relatorio
		            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conexao);

		            // exporta para pdf
		            JRExporter exporter = new JRPdfExporter();
		            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

		            exporter.exportReport();
		            

		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
}
