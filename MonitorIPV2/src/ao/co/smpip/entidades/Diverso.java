package ao.co.smpip.entidades;

public class Diverso {
	
	 private Integer est_civil;
	 private Integer genero;
	 private Integer tipo_doc;
	 private Integer pais;
	 private Integer provincia;
	 private Integer profissao;
	 private Integer especialidade;
	 private Integer funcao; 
	 
	 private Integer fk_armario;
	 private Integer distrito;
	 private Integer municipio;
	
	 private String nomeEsp;
	 private String nomeFun;
	 private String nomeProv;
	 private String nomePais;
	 private String nomeProf;
	 private String nomeAfl;
	 private String nomeDoc;
	 private String nomeEC;
	 //Modulos - Menu
	 private Integer id_mod;
	 private String modulo;
	 private String mdlink;
	 private String codCl;
	 // Telas  - SubMenu
	 private Integer id_tela;
	 private String tela;
	 private String linktela;
	 private String codTela;
	 private String perfil;
	 private Integer fk_perfil;
	 private Integer qtd_telas;
	 
	 private Integer id_mes;
	 private String mes;
	 
	 private Integer id_semana;
	 private String semana;
	 
	 private Integer id_ocupacao;
	 private String ocupacao;
	 public Integer getEst_civil() {
		return est_civil;
	}
	public void setEst_civil(Integer est_civil) {
		this.est_civil = est_civil;
	}
	public Integer getGenero() {
		return genero;
	}
	public void setGenero(Integer genero) {
		this.genero = genero;
	}
	public Integer getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(Integer tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public Integer getPais() {
		return pais;
	}
	public void setPais(Integer pais) {
		this.pais = pais;
	}
	public Integer getProvincia() {
		return provincia;
	}
	public void setProvincia(Integer provincia) {
		this.provincia = provincia;
	}
	public Integer getProfissao() {
		return profissao;
	}
	public void setProfissao(Integer profissao) {
		this.profissao = profissao;
	}
	public Integer getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Integer especialidade) {
		this.especialidade = especialidade;
	}
	public Integer getFuncao() {
		return funcao;
	}
	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}
	public String getNomeEsp() {
		return nomeEsp;
	}
	public void setNomeEsp(String nomeEsp) {
		this.nomeEsp = nomeEsp;
	}
	public String getNomeFun() {
		return nomeFun;
	}
	public void setNomeFun(String nomeFun) {
		this.nomeFun = nomeFun;
	}
	public String getNomeProv() {
		return nomeProv;
	}
	public void setNomeProv(String nomeProv) {
		this.nomeProv = nomeProv;
	}
	public String getNomePais() {
		return nomePais;
	}
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
	public String getNomeProf() {
		return nomeProf;
	}
	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}
	public String getNomeAfl() {
		return nomeAfl;
	}
	public void setNomeAfl(String nomeAfl) {
		this.nomeAfl = nomeAfl;
	}
	public String getNomeDoc() {
		return nomeDoc;
	}
	public void setNomeDoc(String nomeDoc) {
		this.nomeDoc = nomeDoc;
	}
	public String getNomeEC() {
		return nomeEC;
	}
	public void setNomeEC(String nomeEC) {
		this.nomeEC = nomeEC;
	}
	public Integer getId_mes() {
		return id_mes;
	}
	public void setId_mes(Integer id_mes) {
		this.id_mes = id_mes;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public Integer getId_semana() {
		return id_semana;
	}
	public void setId_semana(Integer id_semana) {
		this.id_semana = id_semana;
	}
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}
	public Integer getId_mod() {
		return id_mod;
	}
	public void setId_mod(Integer id_mod) {
		this.id_mod = id_mod;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String mod) {
		this.modulo = mod;
	}
	public String getMdlink() {
		return mdlink;
	}
	public void setMdlink(String mdlink) {
		this.mdlink = mdlink;
	}
	public String getCodCl() {
		return codCl;
	}
	public void setCodCl(String codCl) {
		this.codCl = codCl;
	}
	public Integer getId_tela() {
		return id_tela;
	}
	public void setId_tela(Integer id_tela) {
		this.id_tela = id_tela;
	}
	public String getTela() {
		return tela;
	}
	public void setTela(String tela) {
		this.tela = tela;
	}
	public String getLinktela() {
		return linktela;
	}
	public void setLinktela(String linktela) {
		this.linktela = linktela;
	}
	public String getCodTela() {
		return codTela;
	}
	public void setCodTela(String codTela) {
		this.codTela = codTela;
	}
	public Integer getId_ocupacao() {
		return id_ocupacao;
	}
	public void setId_ocupacao(Integer id_ocupacao) {
		this.id_ocupacao = id_ocupacao;
	}
	public String getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	public Integer getFk_armario() {
		return fk_armario;
	}
	public void setFk_armario(Integer fk_armario) {
		this.fk_armario = fk_armario;
	}
	public Integer getDistrito() {
		return distrito;
	}
	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}
	public Integer getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public Integer getFk_perfil() {
		return fk_perfil;
	}
	public void setFk_perfil(Integer fk_perfil) {
		this.fk_perfil = fk_perfil;
	}
	public Integer getQtd_telas() {
		return qtd_telas;
	}
	public void setQtd_telas(Integer qtd_telas) {
		this.qtd_telas = qtd_telas;
	}
	 
	 
	
	 
}
