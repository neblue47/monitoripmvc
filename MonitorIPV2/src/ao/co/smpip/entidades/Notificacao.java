package ao.co.smpip.entidades;

import java.util.Calendar;

public class Notificacao extends Usuario{

	private int id_notificacao;
	private int FK_publico;
	private int FK_enderecoArmario;
	private String notificacao;
	private Calendar dataRegisto;
	public int getId_notificacao() {
		return id_notificacao;
	}
	public void setId_notificacao(int id_notificacao) {
		this.id_notificacao = id_notificacao;
	}
	public int getFK_publico() {
		return FK_publico;
	}
	public void setFK_publico(int fK_publico) {
		FK_publico = fK_publico;
	}
	public int getFK_enderecoArmario() {
		return FK_enderecoArmario;
	}
	public void setFK_enderecoArmario(int fK_enderecoArmario) {
		FK_enderecoArmario = fK_enderecoArmario;
	}
	public String getNotificacao() {
		return notificacao;
	}
	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}
	public Calendar getDataRegisto() {
		return dataRegisto;
	}
	public void setDataRegisto(Calendar dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
	
	
}
