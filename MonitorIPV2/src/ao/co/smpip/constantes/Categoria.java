package ao.co.smpip.constantes;

public enum Categoria {

	
	AD(1,"Admnistrativo"), TC(2,"Tecnico");
	
	public int pos;
	public String titulo;
	Categoria(int pos,String titulo){
		this.pos = pos;
		this.titulo = titulo;
	}
}
