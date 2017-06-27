package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.Funcionario;

public class AcessosDAO {

	private Connection con;
	
	
	public List<Diverso> buscarPerifisTelas ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "SELECT * from vwprivilegios LIMIT 20";
		try {
			 con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Diverso dd = new Diverso();
				 dd.setId_mod(rs.getInt("fk_modulo"));
				 dd.setModulo(rs.getString("modulo"));
				 dd.setLinktela(rs.getString("controller"));
				 dd.setPerfil(rs.getString("perfil"));
				 lista.add(dd);
				 System.out.println(11);
			 }
			 preparador.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void novoPerifilTelas(Diverso dd){
		int LastID=0;
		String sql = "INSERT INTO tblperfil (perfil) value(?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dd.getPerfil());
			ps.execute();
			ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
			if(rs.next()){
				LastID = rs.getInt(1);
				sql = "INSERT INTO tblprivilegio (fk_modulo,fk_tela,fk_perfil) value(?,?,?)";
				ps.setInt(1, dd.getId_mod());
				ps.setInt(2, dd.getId_tela());
				ps.setInt(3, LastID);
				ps.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
