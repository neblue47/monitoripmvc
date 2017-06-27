package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ao.co.smpip.entidades.Arquivos;

public class ArquivoDAO
{
	private Connection con = Conexao.getConexao();
	public void fun_arquivos(Arquivos arq)
	{
		String sql = "INSERT INTO TBLARQUIVODOFUNCIONARIO (fk_entidade,fk_arquivo,caminho,nome_ficheiro) VALUES (?,?,?,?)";
		try {
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, arq.getFk_entidade());
			ent.setInt(2, arq.getArquivo());
			ent.setString(3, arq.getLocalArq());
			ent.setString(4, arq.getNomeArq());
			ent.execute();
			ent.close();
			System.out.println("Cadastro de sucesso...TBLARQUIVOS"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Arquivos buscaPorId (String num)
	{
		Arquivos arq = null;
		String sql = "SELECT * FROM TBLARQUIVODOFUNCIONARIO WHERE fk_entidade LIKE ? ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, num);
			 ResultSet rs = preparador.executeQuery();
			 if(rs.next())
			 {
				 
			 }
			 preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arq;
	}
	
	public void Eliminar (String num)
	{
		String sql = "DELETE FROM TBLARQUIVODOFUNCIONARIO WHERE fk_entidade LIKE ? ";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, num);
			 ResultSet rs = preparador.executeQuery();
			 if(rs.next())
			 {
				 
			 }
			 preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
