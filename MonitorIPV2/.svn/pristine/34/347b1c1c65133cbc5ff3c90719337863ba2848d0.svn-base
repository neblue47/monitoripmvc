package ao.co.smpip.utils;
import java.sql.Connection;
import java.util.Map;
import com.sun.xml.internal.ws.util.UtilException;
import ao.co.smpip.jdbc.Conexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
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
}
