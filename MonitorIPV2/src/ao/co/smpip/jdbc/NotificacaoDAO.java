package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ao.co.smpip.entidades.Notificacao;

public class NotificacaoDAO {

	private Connection con;
	
	public List<Notificacao> buscaNotificacoes() {
		String sql = "Select * from vwnotificacao order by id_notificacao desc";
		List<Notificacao> lsNotas = new ArrayList<Notificacao>();
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Notificacao notas = new Notificacao ();
				notas.setId_notificacao(rs.getInt("id_notificacao"));
				notas.setNome(rs.getString("nome"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_registo"));
				notas.setDataRegisto(data);
				notas.setNotificacao(rs.getString("notificacao"));
				lsNotas.add(notas);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lsNotas;
	}
	
	public Notificacao buscaNotificacoes(int cod) {
		String sql = "Select * from vwnotificacao where id_notificacao = ? order by id_notificacao desc";
		Notificacao notas = new Notificacao ();
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				notas.setId_notificacao(rs.getInt("id_notificacao"));
				notas.setNome(rs.getString("nome"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_registo"));
				notas.setDataRegisto(data);
				notas.setNotificacao(rs.getString("notificacao"));
				 
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notas;
	}
}
