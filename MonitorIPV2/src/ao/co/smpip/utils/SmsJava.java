package ao.co.smpip.utils;
import java.util.ArrayList;
import java.util.List;

import br.com.facilitamovel.bean.Retorno;
import br.com.facilitamovel.bean.SmsMultiplo;
import br.com.facilitamovel.bean.SmsMultiploMessages;
import br.com.facilitamovel.bean.SmsSimples;
import br.com.facilitamovel.service.SendMessage;

public class SmsJava {
	
	/**
	 * Exemplo de um envio Simples de SMS para a Plataforma
	 * @throws Exception
	 */
	public static void simpleSMS(String tofone,String msg) throws Exception {
		// Simple Send
		SmsSimples sms = new SmsSimples();
		sms.setUser("UNITEL");
		sms.setPassword("2516");
		sms.setDestinatario(tofone);
		sms.setMessage(msg);
		Retorno retorno = SendMessage.simpleSend(sms);
		System.out.println("Codigo:" + retorno.getCodigo());
		System.out.println("Descricao:" + retorno.getMensagem());
	}

	
	/**
	 * Exemplo de uma mensagem para multiplos destinatarios
	 * @throws Exception
	 */
	public static void multiple() throws Exception {
		// Multiple Send
		SmsMultiplo sms = new SmsMultiplo();
		sms.setUser("teste");
		sms.setPassword("teste");

		// Multiplos destinatarios
		List<String> nmbs = new ArrayList<String>();
		nmbs.add("5199444555");
		nmbs.add("5199444551");
		nmbs.add("5198961100");
		sms.setDestinatarios(nmbs);

		// Chave Interna do Cliente, nao eh obrigatorio
		List<String> chaveCliente = new ArrayList<String>();
		chaveCliente.add("1");
		chaveCliente.add("2");
		chaveCliente.add("3");
		sms.setChaveClientes(chaveCliente);

		sms.setMessage("teste");
		Retorno retorno = SendMessage.multipleSend(sms);

		System.out.println("Codigo:" + retorno.getCodigo());
		System.out.println("Descricao:" + retorno.getMensagem());
	}

	
	/**
	 * Exemplo de envio de Multiplas Mensagens para Multiplos Destinatarios
	 * @throws Exception
	 */
	public static void multipleMsgs() throws Exception{
		// Multiple Send
		SmsMultiploMessages sms = new SmsMultiploMessages();
		sms.setUser("teste");
		sms.setPassword("teste");

		// Multiplos destinatarios
		List<String> listNmbs = new ArrayList<String>();
		listNmbs.add("5199444555");
		listNmbs.add("5199444551");
		listNmbs.add("5198961100");
		sms.setDestinatarios(listNmbs);

		// Chave Interna do Cliente, nao eh obrigatorio
		List<String> messagesList = new ArrayList<String>();
		messagesList.add("Mensagem 1");
		messagesList.add("Mensagem 2");
		messagesList.add("Mensagem 3");
		sms.setMessages(messagesList);

		// Chave Interna do Cliente, nao eh obrigatorio
		List<String> chaveCliente = new ArrayList<String>();
		chaveCliente.add("1");
		chaveCliente.add("2");
		chaveCliente.add("3");
		sms.setChaveClientes(chaveCliente);

		Retorno retorno = SendMessage.multipleMessagesToMultPhones(sms);
		System.out.println("Codigo:" + retorno.getCodigo());
		System.out.println("Descricao:" + retorno.getMensagem());
	}
}
