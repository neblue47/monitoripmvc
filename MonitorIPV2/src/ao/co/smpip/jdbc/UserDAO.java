package ao.co.smpip.jdbc;

import ao.co.smpip.entidades.Usuario;
import ao.co.smpip.security.EncriptaDecriptaRSA;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO 
{
	private Connection con = Conexao.getConexao();
	private EncriptaDecriptaRSA rsa;
	public void cadastrar (Usuario usu)
	{
		String sql = "INSERT INTO tblutilizador (nome_ut,senha_ut,nivel_ut,FK_entidade) VALUES (?,?,?,?)";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, usu.getNome());
			 preparador.setString(2, usu.getSenha());
			 preparador.setInt   (3, usu.getNivel());
			 preparador.setInt(4, usu.getFK_entidade());
			 preparador.execute();
			 preparador.close();
			 System.out.println("Cadastro de sucesso..."); 
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
	public void alterar (Usuario usu)
	{
		String sql = "UPDATE tblutilizador SET nome_ut=?,senha_ut=?,nivel_ut=? WHERE id_utilizador=?";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, usu.getNome());
			 preparador.setString(2, usu.getSenha());
			 preparador.setInt   (3, usu.getNivel());
			 preparador.setInt   (4, usu.getId());
			 preparador.execute();
			 preparador.close();
			 System.out.println("Alteracao com sucesso..."); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void excluir (Usuario usu)
	{
		String sql = "DELETE FROM tblutilizador  WHERE id_entidade=?";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt   (1, usu.getId());
			 preparador.execute();
			 preparador.close();
			 System.out.println("Excuisao com sucesso..."); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Usuario> buscaTodos ()
	{
		List <Usuario> lista = new ArrayList<Usuario>();
		String sql = "select * from vwutilizadores w left join tblperfil p on w.fk_perfil = p.Id ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 
			 ResultSet rs = preparador.executeQuery();
			 
			 while(rs.next())
			 {
				 Usuario usu = new Usuario();
				 usu.setId(rs.getInt("id_utilizador"));
				 usu.setNome(rs.getString("nome_ut"));
				 usu.setNomeComp(rs.getString("nome")+" "+rs.getString("snome"));
				 usu.setSenha(rs.getString("senha_ut"));
				 usu.setNivel(rs.getInt("nivel_ut"));
				 usu.setPerfil(rs.getString("perfil"));
				 usu.setFk_perfil(rs.getInt("fk_perfil"));
				 usu.setHash_id(rsa.criptografa(toString(rs.getInt("id_utilizador"))));
				 lista.add(usu);
			 }
			 preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Usuario> buscaTodos (String aux)
	{
		List <Usuario> lista = new ArrayList<Usuario>();
		String sql = "select * from vwutilizadores w left join tblperfil p on w.fk_perfil = p.Id  where w.nome_ut Like ? or w.nome LIKE ? ";
		try {
			 PreparedStatement pr = con.prepareStatement(sql);
			 pr.setString(1, "%"+aux+"%");
			 pr.setString(2, "%"+aux+"%");
			 ResultSet rs = pr.executeQuery();
			 
			 while(rs.next())
			 {
				 Usuario usu = new Usuario();
				 usu.setId(rs.getInt("id_utilizador"));
				 usu.setNome(rs.getString("nome_ut"));
				 usu.setNomeComp(rs.getString("nome")+" "+rs.getString("snome"));
				 usu.setSenha(rs.getString("senha_ut"));
				 usu.setNivel(rs.getInt("nivel_ut"));
				 usu.setPerfil(rs.getString("perfil"));
				 usu.setFk_perfil(rs.getInt("fk_perfil"));
				 usu.setHash_id(rsa.criptografa(toString(rs.getInt("id_utilizador"))));
				 lista.add(usu);
			 }
			 pr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public Usuario buscarPorId(String id)
	{
		Usuario usu = new Usuario();
		String codId = EncriptaDecriptaRSA.decriptografa(id);
		String sql = "SELECT * FROM tblutilizador WHERE fk_entidade=?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, codId);
			ResultSet rs = preparador.executeQuery();
			
			if(rs.next())
			{
				
				usu.setId(rs.getInt("fk_entidade"));
				usu.setNome(rs.getString("nome_ut"));
				String decifrada = EncriptaDecriptaRSA.decriptografa(rs.getString("senha_ut"));
				usu.setSenha(decifrada);
				usu.setNivel(rs.getInt("nivel_ut"));
				usu.setFk_perfil(rs.getInt("fk_perfil"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu;
	}
	
	public Usuario buscarPorIdUsu(String id)
	{
		Usuario usu = new Usuario();
		String codId = EncriptaDecriptaRSA.decriptografa(id);
		String sql = "SELECT * FROM tblutilizador WHERE id_utilizador=?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, codId);
			ResultSet rs = preparador.executeQuery();
			
			if(rs.next())
			{
				usu.setId(rs.getInt("fk_entidade"));
				usu.setFK_entidade(rs.getInt("id_utilizador"));
				usu.setNome(rs.getString("nome_ut"));
				String decifrada = EncriptaDecriptaRSA.decriptografa(rs.getString("senha_ut"));
				usu.setSenha(decifrada);
				usu.setNivel(rs.getInt("nivel_ut"));
				usu.setFk_perfil(rs.getInt("fk_perfil"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu;
	}
	public List<Usuario> buscarPorNome(String nome)
	{
		Usuario usu=null;
		String sql = "SELECT * FROM UTILIZADORES WHERE nome LIKE ?";
		List <Usuario> lista = new ArrayList<Usuario>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+nome+"%");
			ResultSet rs = preparador.executeQuery();
			
			while(rs.next())
			{
				usu = new Usuario();
				usu = new Usuario();
				usu.setId(rs.getInt("id_entidade"));
				usu.setNome(rs.getString("nome_ut"));
				usu.setSenha(rs.getString("senha_ut"));
				usu.setNivel(rs.getInt("nivel_ut"));
				lista.add(usu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public Usuario autenticar(Usuario usu)
	{
		Usuario usua = new Usuario();
		String sql = "SELECT * FROM vwutilizadores WHERE nome_ut LIKE ?  ";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			 
			ResultSet rs = preparador.executeQuery();
			if(rs.next())
			{
				
				
				usua.setId(rs.getInt("fk_entidade"));
				usua.setNome(rs.getString("nome_ut"));
				usua.setFK_entidade(rs.getInt("id_utilizador"));
				usua.setNomeComp(rs.getString("nome")+" "+rs.getString("snome"));
				usua.setNivel(rs.getInt("nivel_ut"));
		   }
			preparador.close();
//			System.out.println(usu.getNome());
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return usua;
	}
	public boolean existe_usuario(Usuario usu)
	{
		
		String sql = "SELECT * FROM vwutilizadores WHERE nome_ut LIKE ? ";
		//boolean rest = false;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			 
			ResultSet rs = preparador.executeQuery();
			if(rs.next()){
				String senha =  EncriptaDecriptaRSA.decriptografa(rs.getString("senha_ut")); 
//				System.err.println(senha);
				if(usu.getSenha().equals(senha))
					 return true;
			}
			
			
		} catch (SQLException e) {
 
			e.printStackTrace();
		}
		return false;
	}
	public void salvar(Usuario usu)
	{
		if(usu.getId()!=null && usu.getId()!=0)
		{
			alterar(usu);
		}
		else
		{
			cadastrar(usu);
		}
	}
	
	public String toString(Object ob) {
		// TODO Auto-generated method stub
		return ob.toString();
	}
}
