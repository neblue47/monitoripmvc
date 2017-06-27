package ao.co.smpip.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class SerialBean implements Serializable {

	private String posto;
	private int id_posto;
	private double stream;
	private String doSerial;
	
	private ArrayList<SerialBean> lista = new ArrayList<SerialBean>();
	
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public int getId_posto() {
		return id_posto;
	}
	public void setId_posto(int id_posto) {
		this.id_posto = id_posto;
	}
	public String getDoSerial() {
		return doSerial;
	}
	public void setDoSerial(String doSerial) {
		this.doSerial = doSerial;
	}
	
	public void adLista(SerialBean item){
		lista.add(item);
	}
	public void setLista(int i,SerialBean item){
		lista.set(i, item);
	}
	public void remLista(int i){
		lista.remove(i);
	}
	public ArrayList<SerialBean> getLista() {
		return lista;
	}
	
	public int tamLista (){
		return lista.size();
	}
	public double getStream() {
		return stream;
	}
	public void setStream(double stream) {
		this.stream = stream;
	}

	
}
