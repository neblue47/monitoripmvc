package ao.co.smpip.entidades;

import java.util.Calendar;


public class Funcionario 

{

	private Integer id_entidade;
	private Integer tipoEnt;
	
	private String nome;
	private String snome;
	private Calendar dt_nascimento;
	private String numDoc;
	private String numInterno;
	private String categoria;
	private Double salario;
	private Calendar dt_admissao;
	private String ocupacao;
	private Integer id_contato;
	private long telefone;
	private String email;
	private String endereco;
	private String funcao;
	private String especialidade;
	private String hash_id;
	
	private String editfone;
	private String editfone2;
	
	//tblArquivos
		 private Integer arquivo;
		 private String localArq;
		 private String nomeArq;
	
	//fk_campos
	
	private Integer id_ocupacao;
	private String id_estcivil;
	private Integer id_naturalidade;
	private Integer id_provincia;
	private Integer id_pais;
	private String nomePais;
	private Integer id_profissao;
	private Integer est_cvl;
	private String sexo;
	
	private Integer fk_funcao;
	private Integer fk_especialidade;
	private String s_social;
	private String nif;
	private Integer id_categoria;

	public String getHash_id() {
		return hash_id;
	}
	public void setHash_id(String hash_id) {
		this.hash_id = hash_id;
	}
	
	public String getNomePais() {
		return nomePais;
	}
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
	public Integer getId_entidade() {
		return id_entidade;
	}
	public void setId_entidade(Integer id_entidade) {
		this.id_entidade = id_entidade;
	}
	public Integer getTipoEnt() {
		return tipoEnt;
	}
	public void setTipoEnt(Integer tipoEnt) {
		this.tipoEnt = tipoEnt;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSnome() {
		return snome;
	}
	public void setSnome(String snome) {
		this.snome = snome;
	}
	public Calendar getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(Calendar dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getNumInterno() {
		return numInterno;
	}
	public void setNumInterno(String numInterno) {
		this.numInterno = numInterno;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Calendar getDt_admissao() {
		return dt_admissao;
	}
	public void setDt_admissao(Calendar dt_admissao) {
		this.dt_admissao = dt_admissao;
	}
	public String getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	public Integer getId_contato() {
		return id_contato;
	}
	public void setId_contato(Integer id_contato) {
		this.id_contato = id_contato;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public Integer getId_ocupacao() {
		return id_ocupacao;
	}
	public void setId_ocupacao(Integer id_ocupacao) {
		this.id_ocupacao = id_ocupacao;
	}
	public String getId_estcivil() {
		return id_estcivil;
	}
	public void setId_estcivil(String id_estcivil) {
		this.id_estcivil = id_estcivil;
	}
	public Integer getId_naturalidade() {
		return id_naturalidade;
	}
	public void setId_naturalidade(Integer id_naturalidade) {
		this.id_naturalidade = id_naturalidade;
	}
	public Integer getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(Integer id_provincia) {
		this.id_provincia = id_provincia;
	}
	public Integer getId_pais() {
		return id_pais;
	}
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	public Integer getId_profissao() {
		return id_profissao;
	}
	public void setId_profissao(Integer id_profissao) {
		this.id_profissao = id_profissao;
	}
	public Integer getFk_funcao() {
		return fk_funcao;
	}
	public void setFk_funcao(Integer fk_funcao) {
		this.fk_funcao = fk_funcao;
	}
	public Integer getFk_especialidade() {
		return fk_especialidade;
	}
	public void setFk_especialidade(Integer fk_especialidade) {
		this.fk_especialidade = fk_especialidade;
	}
	public Integer getEst_cvl() {
		return est_cvl;
	}
	public void setEst_cvl(Integer est_cvl) {
		this.est_cvl = est_cvl;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEditfone() {
		return editfone;
	}
	public void setEditfone(long editfone) {
		// 244924044145
		String fonetmp = "" + editfone;
		try {
			String codp = fonetmp.substring(0, 3);
			String num1 = fonetmp.substring(3, 6);
			String num2 = fonetmp.substring(6, 9);
			String num3 = fonetmp.substring(9);
			String fonet = codp + " " + num1 + "-" + num2 + "-" + num3;
			this.editfone = fonet;
		} catch (NumberFormatException er) {
			System.out.print(er);
		}

	}
	
	
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	public Integer getArquivo() {
		return arquivo;
	}
	public void setArquivo(Integer arquivo) {
		this.arquivo = arquivo;
	}
	public String getLocalArq() {
		return localArq;
	}
	public void setLocalArq(String localArq) {
		this.localArq = localArq;
	}
	public String getNomeArq() {
		return nomeArq;
	}
	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}
	 
	public String getS_social() {
		return s_social;
	}
	public void setS_social(String s_social) {
		this.s_social = s_social;
	}
	public String getNif() {
		// TODO Auto-generated method stub
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getEditfone2() {
		return editfone2;
	}
	public void setEditfone2(long editfone2) {
		// 244924044145
				String fonetmp = "" + editfone2;
				try {
					String codp = fonetmp.substring(0, 3);
					String num1 = fonetmp.substring(3, 6);
					String num2 = fonetmp.substring(6, 9);
					String num3 = fonetmp.substring(9);
					String fonet = num1 + " " + num2 + " " + num3;
					this.editfone2 = fonet;
				} catch (NumberFormatException er) {
					System.out.print(er);
				}
	}
	public String toString(Object object){
		return object.toString();
	}
	
	
	
}