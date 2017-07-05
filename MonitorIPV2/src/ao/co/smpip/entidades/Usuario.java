package ao.co.smpip.entidades;

import java.io.Serializable;

public class Usuario implements Serializable
{
	private Integer id;
	private String nome;
	private String nomeComp;
	private String senha;
	private int fk_perfil;
	private String perfil;
	private String hash_id;
	private int nivel;
	private int FK_entidade;
	private byte [] cifras;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id; 
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getNomeComp() {
		return nomeComp;
	}
	public void setNomeComp(String nomeComp) {
		this.nomeComp = nomeComp;
	}
	public byte[] getCifras() {
		return cifras;
	}
	public void setCifras(byte[] cifras) {
		this.cifras = cifras;
	}
	public int getFK_entidade() {
		return FK_entidade;
	}
	public void setFK_entidade(int fK_entidade) {
		FK_entidade = fK_entidade;
	}
	public int getFk_perfil() {
		return fk_perfil;
	}
	public void setFk_perfil(int fk_perfil) {
		this.fk_perfil = fk_perfil;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getHash_id() {
		return hash_id;
	}
	public void setHash_id(String hash_id) {
		this.hash_id = hash_id;
	}
	
	
	
}
