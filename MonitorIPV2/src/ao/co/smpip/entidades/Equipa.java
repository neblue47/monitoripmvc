package ao.co.smpip.entidades;

import java.io.Serializable;

public class Equipa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_equipa;
	private int fk_entidade;
	private String nome_equipe;
	
	public int getId_equipa() {
		return id_equipa;
	}
	public void setId_equipa(int id_equipa) {
		this.id_equipa = id_equipa;
	}
	public int getFk_entidade() {
		return fk_entidade;
	}
	public void setFk_entidade(int fk_entidade) {
		this.fk_entidade = fk_entidade;
	}
	public String getNome_equipe() {
		return nome_equipe;
	}
	public void setNome_equipe(String nome) {
		this.nome_equipe = nome;
	}
	
	
	

}
