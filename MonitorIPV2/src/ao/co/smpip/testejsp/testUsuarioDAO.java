package ao.co.smpip.testejsp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.facilitamovel.bean.Retorno;
import br.com.facilitamovel.bean.SmsSimples;
import br.com.facilitamovel.service.SendMessage;
import ao.co.smpip.serial.SerialConexao;


public class testUsuarioDAO {

	
	public static void main(String[] args) {
		SmsSimples sms = new SmsSimples();
		sms.setUser("Movicel");
		sms.setPassword("8032");
		sms.setDestinatario("924044145");
		sms.setMessage("Meu teste");
		Retorno retorno;
		try {
			retorno = SendMessage.simpleSend(sms);
			System.out.println("Codigo:" + retorno.getCodigo());
			System.out.println("Descricao:" + retorno.getMensagem());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	static java.sql.Date data_registo()
	{
		java.sql.Date dt_registo = null;
		Calendar c = Calendar.getInstance(); // Cria um objeto para armazenar a data atual
        c.setTime(new Date()); // pega a data atual do sistema
        int diaAtual = c.get(Calendar.DAY_OF_MONTH); // DIA
        int mesAtual = c.get(Calendar.MONTH)+1; // MES
        int anoAtual = c.get(Calendar.YEAR);  // ANO
        String hoje = anoAtual+"/"+mesAtual+"/"+diaAtual;
        DateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
	    java.util.Date a; 
		try {
			a = (java.util.Date) formate.parse(hoje);
			dt_registo = new java.sql.Date(a.getTime());
			} catch (ParseException e) { }
		return dt_registo;
	}
	
}
