package ao.co.smpip.constantes;

public enum DiasSemana {

	D(1,"Domingo"),SF1(2,"Segunda-Feira"),TF(3,"Terça-Feira"),QF1(4,"Quarta-Feira"),QF2(5,"Quinta-Feira"),	SF2(6,"Sexta-Feira"),SB(7,"Sábado");
	
	public int pos;
	public String titulo;
	DiasSemana(int pos,String titulo){
		this.pos = pos;
		this.titulo = titulo;
	}
}
