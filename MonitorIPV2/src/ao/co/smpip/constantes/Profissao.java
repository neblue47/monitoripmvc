package ao.co.smpip.constantes;

public enum Profissao {
	
	D(1,"Diverso"),C(2,"Contabilista"),P(3,"Programador"),AN(4,"Analista"),S(5,"Seguranca"),	MT(6,"Motorista"),EL(7,"Electricista"),NA(8,"N�o Aplicavel");
	
	public int pos;
	public String titulo;
	Profissao(int pos,String titulo){
		this.pos = pos;
		this.titulo = titulo;
	}
}
