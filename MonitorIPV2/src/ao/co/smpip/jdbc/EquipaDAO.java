package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ao.co.smpip.entidades.Equipa;
import ao.co.smpip.entidades.Posto;

public class EquipaDAO {

	private Connection con = Conexao.getConexao();
	
	public void NovaEquipa(Equipa equipa)
	{
		String sql = "Insert into tblequipe (nome_equipe) value(?)";
		try{
			PreparedStatement eq = con.prepareStatement(sql);
			eq.setString(1, equipa.getNome_equipe());
			eq.execute();
			eq.close();
			System.out.println("Cadastro de Sucesso....");
		}catch(SQLException e){
		e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void EditarEquipa(Equipa equipa)
	{
		String sql = "Update tblequipe set nome_equipe = ? where id_equipe = ?";
		try{
			PreparedStatement eq = con.prepareStatement(sql);
			eq.setString(1, equipa.getNome_equipe());
			eq.setInt(2, equipa.getId_equipa());
			eq.execute();
			eq.close();
		}catch(SQLException e){
		e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public List<Equipa> getEquipas(){
		ArrayList<Equipa> lEquipas = new ArrayList<>();
		String sql = "Select * from tblequipe";
		try{
			PreparedStatement eq = con.prepareStatement(sql);
			ResultSet rs = eq.executeQuery();
			while(rs.next()){
				Equipa eqs = new Equipa();
				eqs.setId_equipa(rs.getInt("id_equipe"));
				eqs.setNome_equipe(rs.getString("nome_equipe"));
				lEquipas.add(eqs);
			}
			eq.execute();
			eq.close();
		}catch(SQLException e){
			e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		return lEquipas;
	}
	
	
	public List<Posto> getLogsManutencaoDiaria(String aux) {
		String sql = "select * from vwmanutencaoregistos where nome = ? and data = curdate() group by FK_equipe, data";
		List<Posto> lista = new ArrayList<Posto>();
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, aux);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Posto eq = new Posto();
				eq.setNomPosto(rs.getString("nome"));
				eq.setEndereco(rs.getString("distrito")+" -  "+rs.getString("municipio"));
				eq.setHoraEvento(rs.getString("hora"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				eq.setDataEv(data);
				eq.setDescricao(rs.getString("obs"));
				eq.setNomEquipa(rs.getString("nome_equipe"));
				lista.add(eq);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Posto> getLogsManutencaoSemanal(String aux,int mes, int semana) {
		String sql = "";
		if(semana == 1){
			sql = "select * from vwmanutencaoregistos where nome = ? and month(data) = ? and day(data) between 1 and 7 group by FK_equipe";
		}
		if(semana == 2){
			sql = "select * from vwmanutencaoregistos where nome = ? and month(data) = ? and day(data) between 8 and 15 group by FK_equipe";
		}
		if(semana == 3){
			sql = "select * from vwmanutencaoregistos where nome = ? and month(data) = ? and day(data) between 16 and 23 group by FK_equipe";
		}
		if(semana == 4){
			sql = "select * from vwmanutencaoregistos where nome = ? and month(data) = ? and day(data) between 23 and 31 group by FK_equipe";
		}

		List<Posto> lista = new ArrayList<Posto>();
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, aux);
			ps.setInt(2, mes);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Posto eq = new Posto();
				eq.setNomPosto(rs.getString("nome"));
				eq.setEndereco(rs.getString("distrito")+" -  "+rs.getString("municipio"));
				eq.setHoraEvento(rs.getString("hora"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				eq.setDataEv(data);
				eq.setDescricao(rs.getString("obs"));
				eq.setNomEquipa(rs.getString("nome_equipe"));
				lista.add(eq);
				System.out.println(eq.getNomPosto());
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public List<Posto> getLogsManutencaoMensal(String aux,int mes, int ano) {
	  
		String	sql = "select * from vwmanutencaoregistos where nome = ? and month(data) = ? and year(data) = ? group by FK_equipe";
	 

		List<Posto> lista = new ArrayList<Posto>();
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, aux);
			ps.setInt(2, mes);
			ps.setInt(3, ano);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Posto eq = new Posto();
				eq.setNomPosto(rs.getString("nome"));
				eq.setEndereco(rs.getString("distrito")+" -  "+rs.getString("municipio"));
				eq.setHoraEvento(rs.getString("hora"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				eq.setDataEv(data);
				eq.setDescricao(rs.getString("obs"));
				eq.setNomEquipa(rs.getString("nome_equipe"));
				lista.add(eq);
				System.out.println(eq.getNomPosto());
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Equipa getEquipas(int cod){
		Equipa eqs = new Equipa();
		ArrayList<Equipa> lEquipas = new ArrayList<>();
		String sql = "Select * from tblequipe where id_equipe = ?";
		try{
			PreparedStatement eq = con.prepareStatement(sql);
			eq.setInt(1, cod);
			ResultSet rs = eq.executeQuery();
			if(rs.next()){
				eqs.setId_equipa(rs.getInt("id_equipe"));
				eqs.setNome_equipe(rs.getString("nome_equipe"));
				lEquipas.add(eqs);
			}
			eq.execute();
			eq.close();
		}catch(SQLException e){
			e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		return eqs;
	}

}
