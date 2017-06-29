package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.security.EncriptaDecriptaRSA;

public class AcessosDAO {

	private Connection con;
	private EncriptaDecriptaRSA rsa;
	
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
				 dd.setFk_perfil(rs.getInt("fk_perfil"));
				 lista.add(dd);
				  
			 }
			  
			 preparador.close();
			 con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Diverso verPerfilPrivilegio(String codPrf){
		
		String sql = "SELECT * FROM vwprivilegios WHERE fk_perfil = ?";
		Diverso perfil = new Diverso();
		try {
			//String aux = rsa.decriptografa(codPrf);
			int cod = Integer.parseInt(codPrf);
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				perfil.setFk_perfil(rs.getInt("fk_perfil"));
				perfil.setPerfil(rs.getString("perfil"));
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return perfil;
	}
	public List<Diverso> buscarTelas ()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "Select * from tbltela order by tela asc limit 12";
		try {
			 
			 con = Conexao.getConexao();
			 PreparedStatement pr = con.prepareStatement(sql);
			 ResultSet rs = pr.executeQuery();
			 while(rs.next())
			 {
				 Diverso md = new Diverso();
				 md.setId_tela(rs.getInt("Id"));
				 md.setTela(rs.getString("tela"));
				 md.setCodTela(rs.getString("cod_tela"));
				 lista.add(md);
			 }
			 pr.close();
			 con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Diverso> buscarModulos()
	{
		List <Diverso> lista = new ArrayList<Diverso>();
		String sql = "Select * from tblmodulo order by 2  asc  ";
		try {
			 
			 con = Conexao.getConexao();
			 PreparedStatement pr = con.prepareStatement(sql);
			 ResultSet rs = pr.executeQuery();
			 while(rs.next())
			 {
				 Diverso md = new Diverso();
				 md.setId_mod(rs.getInt("id"));
				 md.setModulo(rs.getString("modulo"));
				 md.setMdlink(rs.getString("controller"));
				 md.setCodCl(rs.getString("modcod"));
				 lista.add(md);
			 }
			 pr.close();
			 con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	public void novoPerifilTelas(List <Diverso> acessos){
		/*int LastID=0;
		String sql = "INSERT INTO tblperfil (perfil) value(?)";
		try {
			if(con.isClosed())
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
		}*/
	}
	
	public void EditarPerifilTelas(List <Diverso> acessos){
		 
		   String sql = "DELETE FROM tblprivilegio WHERE fk_perfil = ?";
		try {
			if(!acessos.isEmpty()){
				int fk_perfil = acessos.get(0).getFk_perfil();
				con = Conexao.getConexao();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, fk_perfil);
				ps.execute();
				 
				 for(Diverso dd: acessos){
					 sql = "INSERT INTO tblprivilegio (fk_modulo,fk_tela,fk_perfil) value(?,?,?)";
					    ps = con.prepareStatement(sql);
					    ps.setInt(1, dd.getId_mod());
						ps.setInt(2, dd.getId_tela());
						ps.setInt(3, dd.getFk_perfil());
						ps.execute();
				 }
					
				ps.close();
				con.close();
			}
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
