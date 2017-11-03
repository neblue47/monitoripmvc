package ao.co.smpip.entidades;

import java.util.Calendar;

public class Posto 
{
	private Integer idPosto;
	private Integer fk_entidade;
	private String nomPosto;
	String nomEquipa;
	private Integer qdtLampada;
	private double latitude;
	private double longitude;
	private String descricao;
	private String endereco;
	private String horaEvento;
	private Calendar dataEv;
	private Integer fk_distrito;
	private Integer fk_municipio;
	private Integer fk_provincia;
	private String nomDistrito;
	private String nomMunicipio;
	private String nomProvincia;
	private String doSerial;
	private double stream;
	private String flag;
	private int status;
	
	private Integer sensor;
	private String nomSensor;
	private String tipo;
	private Integer fk_historico;
	
	public Integer getIdPosto() {
		return idPosto;
	}
	public void setIdPosto(Integer idPosto) {
		this.idPosto = idPosto;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getFk_entidade() {
		return fk_entidade;
	}
	public void setFk_entidade(Integer fk_entidade) {
		this.fk_entidade = fk_entidade;
	}
	public String getNomPosto() {
		return nomPosto;
	}
	public void setNomPosto(String nomPosto) {
		this.nomPosto = nomPosto;
	}
	public Integer getQdtLampada() {
		return qdtLampada;
	}
	public void setQdtLampada(Integer qdtLampada) {
		this.qdtLampada = qdtLampada;
	}
	public Calendar getDataEv() {
		return dataEv;
	}
	public void setDataEv(Calendar dataEv) {
		this.dataEv = dataEv;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(String horaEvento) {
//		int t = horaEvento.length() - 2;
		this.horaEvento = horaEvento;
	}
	public Integer getFk_distrito() {
		return fk_distrito;
	}
	public void setFk_distrito(Integer fk_distrito) {
		this.fk_distrito = fk_distrito;
	}
	public Integer getFk_municipio() {
		return fk_municipio;
	}
	public void setFk_municipio(Integer fk_municipio) {
		this.fk_municipio = fk_municipio;
	}
	public Integer getFk_provincia() {
		return fk_provincia;
	}
	public void setFk_provincia(Integer fk_provincia) {
		this.fk_provincia = fk_provincia;
	}
	public String getNomDistrito() {
		return nomDistrito;
	}
	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}
	public String getNomMunicipio() {
		return nomMunicipio;
	}
	public void setNomMunicipio(String nomMunicipio) {
		this.nomMunicipio = nomMunicipio;
	}
	public String getNomProvincia() {
		return nomProvincia;
	}
	public void setNomProvincia(String nomProvincia) {
		this.nomProvincia = nomProvincia;
	}
	public Integer getSensor() {
		return sensor;
	}
	public void setSensor(Integer sensor) {
		this.sensor = sensor;
	}
	public String getNomSensor() {
		return nomSensor;
	}
	public void setNomSensor(String nomSensor) {
		this.nomSensor = nomSensor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getFk_historico() {
		return fk_historico;
	}
	public void setFk_historico(Integer fk_historico) {
		this.fk_historico = fk_historico;
	}
	public String getDoSerial() {
		return doSerial;
	}
	public void setDoSerial(String doSerial) {
		this.doSerial = doSerial;
	}
	public double getStream() {
		return stream;
	}
	public void setStream(double stream) {
		this.stream = stream;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getNomEquipa() {
		return nomEquipa;
	}
	public void setNomEquipa(String nomEquipa) {
		this.nomEquipa = nomEquipa;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	 
	
	
	
}
