package ao.co.smpip.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ao.co.smpip.entidades.*;

public class GrupoDAO 
{
	private Connection con = Conexao.getConexao();
	
	public List<Grupos> buscaModulo ()
	{
		List <Grupos> lista = new ArrayList<Grupos>();
		String sql = "SELECT * FROM TBLMODULO ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Grupos md = new Grupos();
				 md.setId_modulo(rs.getInt("id_modulo"));
				 md.setModulo(rs.getString("modulo"));
				 lista.add(md);
			 }
			 preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public List<Grupos> buscaTelas (int md)
	{
		List <Grupos> lista = new ArrayList<Grupos>();
		String sql = "SELECT * FROM TBLTELA WHERE FK_MODULO = ?";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, md);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Grupos fun = new Grupos();
				 fun.setId_tela(rs.getInt("id_tela"));
				 fun.setTela(rs.getString("tela"));
				 lista.add(fun);
			 }
			 preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public List<Grupos> buscaGrupos ()
	{
		List <Grupos> lista = new ArrayList<Grupos>();
		String sql = "SELECT * FROM TBLGRUPO ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Grupos gr = new Grupos();
				 gr.setId_grupo(rs.getInt("id_grupo"));
				 gr.setNomgrupo(rs.getString("grupo"));
				 lista.add(gr);
			 }
			 preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public String buscaGrupo(int cod)
	{
		String lista = "";
		String sql = "SELECT * FROM TBLGRUPO WHERE ID_GRUPO =?";
		try {
			 PreparedStatement ent = con.prepareStatement(sql);
			 ent.setInt(1, cod);
			 ResultSet rs = ent.executeQuery();
			 if(rs.next())
				 lista = rs.getString("grupo");
			 ent.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Grupos> buscaFuncionalidade(int tela)
	{
		List <Grupos> lista = new ArrayList<Grupos>();
		String sql = "SELECT * FROM TBLLISTARFUNCIONALIDADE WHERE FK_TELA =?";
		try {
			 PreparedStatement ent = con.prepareStatement(sql);
			 ent.setInt(1, tela);
			 ResultSet rs = ent.executeQuery();
			 while(rs.next()){
				 Grupos gr = new Grupos();
				 gr.setId_funcionalidade(rs.getInt("id_funcionalidade"));
				 gr.setFk_tela(rs.getInt("fk_tela"));
				 gr.setCodigo_ext(rs.getString("codigo_externo"));
				 gr.setFuncionalidade(rs.getString("funcionalidade"));
				 gr.setDescricao(rs.getString("descricao"));
				 lista.add(gr);
			 }
				
			 ent.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public void add_grupo(Grupos gr)
	{
		String sql = "INSERT INTO TBLGRUPO (grupo) VALUES (?)";
		try {
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setString(1, gr.getNomgrupo());
			ent.execute();
			ent.close();
			System.out.println("Cadastro de sucesso...TBLGRUPO"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void add_funcionalidade(Grupos gr)
	{
		String sql = "INSERT INTO TBLPREVILEGIOATRIBUIDO (fk_funcionalidade,fk_grupo,fk_funcionario,data,fk_tela,fk_modulo) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, gr.getFk_funcionalidades());
			ent.setInt(2, gr.getFk_grupo());
			ent.setInt(3, 1);
			ent.setDate(4, gr.getDt_registo());
			ent.setInt(5, gr.getFk_telas());
			ent.setInt(6, gr.getFk_modulos());
			ent.execute();
			ent.close();
			System.out.println("Cadastro de sucesso...TBLPREVILEGIOATRIBUIDO"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void del_grupo(int cod)
	{
		String sql = "DELETE FROM TBLGRUPO WHERE ID_GRUPO = ?";
		try {
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, cod);
			ent.execute();
			ent.close();
			System.out.println("Cadastro de sucesso...TBLGRUPO"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void alt_grupo(Grupos gr)
	{
		String sql = "UPDATE TBLGRUPO SET GRUPO = ? WHERE ID_GRUPO = ?";
		try {
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setString(1, gr.getNomgrupo());
			ent.setInt(2, gr.getId_grupo());
			ent.execute();
			ent.close();
			System.out.println("Alteracao com sucesso...TBLGRUPO"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Grupos gr)
	{
		if(gr.getId_grupo()!=null )
		{
			alt_grupo(gr);
		}
		else
		{
			add_grupo(gr);
		}
	}
}
