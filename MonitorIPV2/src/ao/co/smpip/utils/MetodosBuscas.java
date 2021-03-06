package ao.co.smpip.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ao.co.smpip.constantes.Categoria;
import ao.co.smpip.constantes.DiasSemana;
import ao.co.smpip.constantes.EstCivil;
import ao.co.smpip.constantes.Profissao;
import ao.co.smpip.constantes.TipoDocumento;
import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.jdbc.Conexao;

public class MetodosBuscas 
{
	private Connection con ;
	public MetodosBuscas() {
		this.con = Conexao.getConexao();
	}

	
	
	public List<Diverso> buscaEspecialidade ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLESPECIALIDADE ";
		try {
			 con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setEspecialidade(rs.getInt("id_especialidade"));
				 fun.setNomeEsp(rs.getString("especialidade"));
				 lista.add(fun);
			 }
			 preparador.close();
			 con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;
	}
	// Metodos de Pesquisas (Consultas no BD)
	public List<Diverso> buscaProfissao ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLPROFISSAO ";
		try {
			con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setProfissao(rs.getInt("id_profissao"));
				 fun.setNomeProf(rs.getString("profissao"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaProfissao (int cod)
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLPROFISSAO where categoria = ?";
		try {
			 con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, cod);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setProfissao(rs.getInt("id_profissao"));
				 fun.setNomeProf(rs.getString("profissao"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaProfissaoEnum ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		try {
			 for(Profissao p: Profissao.values())
			 {
				 Diverso fun = new Diverso();
				 fun.setProfissao(p.pos);
				 fun.setNomeProf(p.titulo);
				 lista.add(fun);
			 }
			 
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaDiasSemanasEnum ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		try {
			 for(DiasSemana p: DiasSemana.values())
			 {
				 Diverso fun = new Diverso();
				 fun.setId_semana(p.pos);
				 fun.setSemana(p.titulo);
				 lista.add(fun);
			 }
			 
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return lista;
	}
	public List<Diverso> buscaCategoriaEnum ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		try {
			 for(Categoria c: Categoria.values())
			 {
				 Diverso d = new Diverso();
				 d.setId_ocupacao(c.pos);
				 d.setOcupacao(c.titulo);
				 lista.add(d);
			 }
			 
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaTipoDocEnum ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		try {
			 for(TipoDocumento td: TipoDocumento.values())
			 {
				 Diverso d = new Diverso();
				 d.setTipo_doc(td.pos);
				 d.setNomeDoc(td.titulo);;
				 lista.add(d);
			 }
			 
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaModulos ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLMODULO ORDER BY ID_MODULO ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso md = new Diverso();
				 md.setId_mod(rs.getInt("id_modulo"));
				 md.setModulo(rs.getString("modulo"));
				 md.setMdlink(rs.getString("linkmod"));
				 md.setCodCl(rs.getString("codMod"));
				 lista.add(md);
			 }
			 preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Diverso> buscaModulos (int grupo)
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "select DISTINCT modulo, linkmod,codMod from vwacesso where id_grupo like ? order by id_modulo ";
		try {
			 PreparedStatement pr = con.prepareStatement(sql);
			 pr.setInt(1, grupo);
			 ResultSet rs = pr.executeQuery();
			 while(rs.next())
			 {
				 Diverso md = new Diverso();
				 md.setModulo(rs.getString("modulo"));
				 md.setMdlink(rs.getString("linkmod"));
				 md.setCodCl(rs.getString("codMod"));
				 lista.add(md);
			 }
			 pr.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	public List<Diverso> buscaTCid ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM tbltela WHERE id_tela between 18 and 22";
		try {
			 PreparedStatement pr = con.prepareStatement(sql);
			 ResultSet rs = pr.executeQuery();
			 while(rs.next())
			 {
				 Diverso md = new Diverso();
				 md.setTela(rs.getString("tela"));
				 md.setLinktela(rs.getString("link"));
				 md.setCodTela(rs.getString("codTela"));
				 lista.add(md);
			 }
			 pr.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	public List<Diverso> buscaEstadoCivil ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLESTADOCIVIL ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setEst_civil(rs.getInt("id_estadocivil"));
				 fun.setNomeEC(rs.getString("estado_civil"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaEstadoCivilEnum() {
		List<Diverso> lista = new ArrayList<Diverso>();

		try {

			for (EstCivil e : EstCivil.values()) {
				Diverso fun = new Diverso();
				fun.setEst_civil(e.pos);
				fun.setNomeEC(e.titulo);
				lista.add(fun);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public List<Diverso> buscaTipoDocumento ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLTIPODOCUMENTO ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setTipo_doc(rs.getInt("id_tipo_documento"));
				 fun.setNomeDoc(rs.getString("tipo_documento"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaPais ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM tblpaises ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setPais(rs.getInt("id_pais"));
				 fun.setNomePais(rs.getString("pais"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public List<Diverso> buscaFuncao()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLFUNCAO ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setFuncao(rs.getInt("id_funcao"));
				 fun.setNomeFun(rs.getString("funcao"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaOcupacao()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM tblocupacao ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setId_ocupacao(rs.getInt("id_ocupacao"));
				 fun.setOcupacao(rs.getString("ocupacao"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return lista;
	}
	
		
		
	public List<Diverso> buscaMes ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLMES ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso dm = new Diverso();
				 dm.setId_mes(rs.getInt("id_mes"));
				 dm.setMes(rs.getString("mes"));
				 lista.add(dm);
			 }
			 preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaDSemana ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLDIADASEMANA ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso dm = new Diverso();
				 dm.setId_semana(rs.getInt("id_dia_da_semana"));
				 dm.setSemana(rs.getString("dia_da_semana"));
				 lista.add(dm);
			 }
			 preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaProvincia (int pais)
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM TBLPROVINCIA WHERE FK_PAIS = ?";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, pais);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setProvincia(rs.getInt("id_provincia"));
				 fun.setNomeProv(rs.getString("provincia"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public List<Diverso> buscaDistrito (int pais)
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM tbldistrito WHERE fk_municipio = ?";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, pais);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setProvincia(rs.getInt("id_distrito"));
				 fun.setNomeProv(rs.getString("distrito"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Diverso> buscaMunicipio (int cod)
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * FROM tblmunicipio WHERE fk_provincia = ?";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, cod);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso fun = new Diverso();
				 fun.setMunicipio(rs.getInt("id_municipio"));
				 fun.setNomePais(rs.getString("municipio"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public List<Funcionario> buscaEmail (String ob)
	{
		List <Funcionario> email = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM vwlistadecadastrados WHERE nome LIKE '"+ob+"%' or email LIKE '"+ob+"%'";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Funcionario em = new Funcionario();
				 em.setEmail(rs.getString("email"));
				 email.add(em);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;
	}
	
	public List<Funcionario> buscaTelefone (String ob)
	{
		List <Funcionario> telefone = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM vwlistadecadastrados WHERE telefone LIKE '"+ob+"%' OR NOME LIKE '"+ob+"%'";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Funcionario em = new Funcionario();
				 em.setNome(rs.getString("nome") + " < " + rs.getLong("telefone")+" > ");
				 //em.setTelefone(rs.getLong("telefone"));
				 telefone.add(em);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return telefone;
	}
	
	public List<Funcionario> buscaNome (String ob)
	{
		List <Funcionario> nome = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM vwlistadecadastrados WHERE nome LIKE '"+ob+"%'  or email LIKE '"+ob+"%' ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Funcionario em = new Funcionario();
				 em.setNome(rs.getString("nome"));
				 nome.add(em);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nome;
	}
	
	public List<Funcionario> buscaArmario (String ob)
	{
		List <Funcionario> nome = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM vwarmarios WHERE nome LIKE '"+ob+"%' OR descricao_google LIKE '"+ob+"%' ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Funcionario em = new Funcionario();
				 em.setNome(rs.getString("nome"));
				 nome.add(em);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nome;
	}
}
