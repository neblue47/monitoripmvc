package ao.co.smpip.constantes;

public enum TipoDocumento {

BI(1,"Bilhete de Identidade"),  CIS(2,"Cartao de Residente"), PP(3,"Passaporte Nacional");
	
	public int pos;
	public String titulo;
	TipoDocumento(int pos,String titulo){
		this.pos = pos;
		this.titulo = titulo;
	}
}
