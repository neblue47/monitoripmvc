package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ao.co.smpip.entidades.Turnos;
import ao.co.smpip.security.EncriptaDecriptaRSA;
import ao.co.smpip.entidades.Funcionario;

public class FuncionarioDAO 
{
	private Connection con;
	private int fk_ocupacao = 2;
	private EncriptaDecriptaRSA rsa;
	public FuncionarioDAO(){
		this.con  = Conexao.getConexao();
	}
   
	public int novaNum()
	{
		String sql = "Select count(*) total from tblentidade";
		int cod=0;
		try {
			con  = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ResultSet rs = ent.executeQuery();
			if(rs.next())
			  cod = rs.getInt("total");	
			
			ent.close();
			return cod;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cod;
	}
	
	public int criar_entidade(Funcionario f)
	{
		int LastID=0;
		String sql = "INSERT INTO TBLENTIDADE (num_interno) VALUE (?)";
		try {
			con  = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setString(1, f.getNumInterno());
			ent.execute();
			ResultSet rs = ent.executeQuery("SELECT LAST_INSERT_ID()");
			if(rs.next()){
				LastID = rs.getInt(1);
			}
			ent.close();
			System.out.println("Cadastro de sucesso...TBLENTIDADE");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return LastID;
	}
	
	
	
	public void tblNaturalidade(Funcionario f){
		String sql = "Insert into tblnaturalidade (fk_entidade,fk_pais,fk_provincia,bairro) values (?,?,?,?)";
		try{
			con  = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, f.getId_entidade());
			ps.setInt(2, f.getId_pais());
			ps.setInt(3,f.getId_provincia());
			ps.setString(4,f.getEndereco());

			ps.execute();
			System.out.println("Cadastro com sucesso...TBLNATURALIDADE");			
		}
		catch(SQLException e){
			System.out.println("Erro: "+e);
		}
	}
	
	public void editNaturalidade (Funcionario f){
		String sql = "Update tblnaturalidade set FK_pais = ?, FK_provincia = ?, bairro = ? where FK_entidade = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, f.getId_pais());
			ps.setInt(2,f.getId_provincia());
			ps.setString(3,f.getEndereco());
			ps.setInt(4, f.getId_entidade());
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novoFuncionario(Funcionario f){
		String sql = "Insert into tblfuncionario values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt	(1, f.getId_entidade());
			ps.setInt	(2, f.getId_profissao());
			ps.setInt	(3,f.getFk_especialidade());
			ps.setInt	(4, f.getTipoEnt());
			ps.setString(5, f.getNome());
			ps.setString(6, f.getSnome());
			ps.setDate	(7, new Date(f.getDt_nascimento().getTimeInMillis()));
			ps.setString(8, f.getSexo());
			ps.setString(9, f.getId_estcivil());
			ps.setLong	(10, f.getTelefone());
			ps.setString(11, f.getEmail());
			ps.setString(12, f.getNumDoc());
			ps.setString(13, f.getS_social());
			ps.setString(14, f.getNif());
			ps.setDate	(15, new Date(f.getDt_admissao().getTimeInMillis()));
			ps.setDouble(16, f.getSalario());
			ps.setInt(17, f.getId_categoria());
			ps.execute();
			ps.close();
			System.out.println("Cadastro com sucesso...TBLFUNCIONARIO");
		}
		catch(SQLException e){
			System.out.println("Erro: "+e);
		}
	}
	
	
	public void editFuncionario(Funcionario f){
		String sql = "Update tblfuncionario set FK_profissao = ?,FK_especialidade= ?,FK_documento = ?, nome = ?,snome= ?,dt_nascimento = ?,sexo = ?, estado_civil = ?, telefone = ?, email = ?, numero_documento = ?, seguranca_social = ?, nif = ?, dt_adminissao = ?, salario = ?, FK_categoria = ? where FK_entidade = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt	(1, f.getId_profissao());
			ps.setInt	(2,f.getFk_especialidade());
			ps.setInt	(3, f.getTipoEnt());
			ps.setString(4, f.getNome());
			ps.setString(5, f.getSnome());
			ps.setDate	(6, new Date(f.getDt_nascimento().getTimeInMillis()));
			ps.setString(7, f.getSexo());
			ps.setString(8, f.getId_estcivil());
			ps.setLong	(9, f.getTelefone());
			ps.setString(10, f.getEmail());
			ps.setString(11, f.getNumDoc());
			ps.setString(12, f.getS_social());
			ps.setString(13, f.getNif());
			ps.setDate	(14, new Date(f.getDt_admissao().getTimeInMillis()));
			ps.setDouble(15, f.getSalario());
			ps.setInt(16, f.getId_categoria());
			ps.setInt	(17, f.getId_entidade());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int fk_naturalidade()
	{
		int fun = 0;
		String sql = "SELECT max(id_naturalidade) valor FROM tblnaturalidade order by id_naturalidade";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery();
			
			if(rs.last())
				fun = rs.getInt("valor");
		}
		catch(Exception e){}
			return fun;
	}
	
	public int fk_contactos()
	{
		int fun = 0;
		String sql = "SELECT max(id_contacto) valor FROM tblcontactos order by id_contacto";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery();
			
			if(rs.next())
				fun = rs.getInt("valor");
		}
		catch(Exception e){}
			return fun;
	}
	
	public List <Funcionario> buscaPorNomeNumero(String nome)
	{
		List <Funcionario> lista = new ArrayList<Funcionario>();
		//Funcionario fun = null;
		int cat =0;
		String sql = "SELECT * FROM vwlistadecadastrados WHERE nome LIKE ? or snome LIKE ? or num_interno = ? ORDER BY (NOME)";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, nome+"%");
			 preparador.setString(2, nome);
			 preparador.setString(3, nome);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 { 
				 Funcionario f = new Funcionario();
				 f.setId_entidade(rs.getInt("id_entidade"));
				 f.setHash_id(rsa.criptografa(toString(rs.getInt("id_entidade"))));
				 f.setNome(rs.getString("nome"));
				 f.setSnome(rs.getString("snome"));
				 cat = rs.getInt("fk_categoria");
				 if(cat==1){					 
					 f.setCategoria("Administrativo");
				 }
				 if(cat==2){					 
					 f.setCategoria("Tecnico");
				 }
				 f.setTelefone(rs.getLong("telefone"));
				 f.setEditfone(rs.getLong("telefone"));
				 f.setEditfone(rs.getLong("telefone"));
				 f.setEmail(rs.getString("email"));
				 f.setEndereco(rs.getString("endereco"));
				 Calendar data = Calendar.getInstance();
				 data.setTime(rs.getDate("dt_nascimento"));
				 f.setDt_nascimento(data);
				 lista.add(f);
			 }
			 preparador.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return lista;
	}
	
	public Funcionario buscaEditFuncionario(int num)
	{
		Funcionario f = new Funcionario();
		//Funcionario fun = null;
		String sql = "SELECT * FROM vwlistadecadastrados WHERE id_entidade = ?";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, num);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 { 
				 
				 f.setId_entidade(rs.getInt("id_entidade"));
				 f.setHash_id(rsa.criptografa(toString(rs.getInt("id_entidade"))));
				 f.setNumInterno(rs.getString("num_interno"));
				 f.setNome(rs.getString("nome"));
				 f.setSnome(rs.getString("snome"));
                 f.setCategoria(rs.getString("FK_categoria"));
                 f.setId_ocupacao(rs.getInt("fk_categoria"));
				 f.setEditfone(rs.getLong("telefone"));
				 f.setEditfone2(rs.getLong("telefone"));
				 f.setEmail(rs.getString("email"));
				 f.setEst_cvl(rs.getInt("estado_civil"));
				 f.setSexo(rs.getString("sexo"));
				 f.setEndereco(rs.getString("endereco"));
				 f.setSalario(rs.getDouble("salario"));
 
				 f.setId_pais(rs.getInt("FK_pais"));
				 f.setId_provincia(rs.getInt("fk_provincia"));
				 f.setTipoEnt(rs.getInt("FK_documento"));
				 f.setNumDoc(rs.getString("numero_documento"));
				 f.setId_profissao(rs.getInt("fk_profissao"));
				 f.setFk_especialidade(rs.getInt("FK_especialidade"));
				 f.setS_social(rs.getString("seguranca_social"));
				 f.setNif(rs.getString("nif"));
				 f.setSalario(rs.getDouble("salario"));
				 f.setEditfone(rs.getLong("telefone"));
				 f.setId_pais(rs.getInt("FK_pais"));
				 f.setId_provincia(rs.getInt("FK_provincia"));

				 Calendar data = Calendar.getInstance();
				 data.setTime(rs.getDate("dt_nascimento"));
				 f.setDt_nascimento(data);
				 Calendar data1 = Calendar.getInstance();
				 data1.setTime(rs.getDate("dt_adminissao"));
				 f.setDt_admissao(data1);
				 
			 }
			 preparador.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Funcionario> getFuncionario()
	{
		List <Funcionario> lista = new ArrayList<Funcionario>();
		int cat =0;
		String sql = "select * from vwlistadecadastrados order by nome";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Funcionario f = new Funcionario();
				 f.setId_entidade(rs.getInt("id_entidade"));
				 f.setHash_id(rsa.criptografa(toString(rs.getInt("id_entidade"))));
				 f.setNome(rs.getString("nome"));
				 f.setSnome(rs.getString("snome"));
				 cat = rs.getInt("fk_categoria");
				 if(cat==1){					 
					 f.setCategoria("Administrativo");
				 }
				 if(cat==2){					 
					 f.setCategoria("Tecnico");
				 }
				 f.setTelefone(rs.getLong("telefone"));
				 f.setEditfone(rs.getLong("telefone"));
				 f.setEmail(rs.getString("email"));
				 f.setEndereco(rs.getString("endereco"));		
				 lista.add(f);
			 }
			 preparador.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Funcionario> getFuncionarioTecnico()
	{
		List <Funcionario> lista = new ArrayList<Funcionario>();
		String sql = "select * from vwlistadecadastrados where fk_categoria = 2 order by nome";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Funcionario f = new Funcionario();
				 f.setId_entidade(rs.getInt("id_entidade"));
				 f.setHash_id(rsa.criptografa(toString(rs.getInt("id_entidade"))));
				 f.setNome(rs.getString("nome"));
				 f.setSnome(rs.getString("snome"));		
				 lista.add(f);
			 }
			 preparador.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return lista;
	}
	
	public Funcionario getUtilizador(String cod)
	{
		Funcionario f = null;
		//Funcionario fun = null;
		String sql = "select * from vwlistadecadastrados where id_entidade = ? order by nome";
		try {
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, cod);
			 ResultSet rs = preparador.executeQuery();
			 if(rs.next())
			 {
				 f = new Funcionario();
				 f.setId_entidade(rs.getInt("id_entidade"));
				 f.setHash_id(rsa.criptografa(toString(rs.getInt("id_entidade"))));
				 f.setNome(rs.getString("nome"));
				 f.setSnome(rs.getString("snome"));
			 }
			 preparador.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return f;
	}
	
	public void fun_arquivos(Funcionario fun)
	{
		String sql = "INSERT INTO TBLARQUIVODOFUNCIONARIO (fk_entidade,fk_arquivo,caminho,nome_ficheiro) VALUES (?,?,?,?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, fun.getId_entidade());
			ent.setInt(2, fun.getArquivo());
			ent.setString(3, fun.getLocalArq());
			ent.setString(4, fun.getNomeArq());
			ent.execute();
			ent.close();
			System.out.println("Cadastro de sucesso...TBLARQUIVOS"); 
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException ef){
				System.out.println("Erro finalizar: "+ef);
			}
		}
	}
	public void Turno(Turnos fun)
	{
		
		String sql = "Insert into tblturno (turno,inicio_turno,fim_turno,fk_funcionario,dia_semana)";
		try{
			PreparedStatement agendaHora = con.prepareStatement(sql);
			agendaHora.setString(1, fun.getTurno());
			agendaHora.setString(2, fun.getHora_de_inicio());
			agendaHora.setString(3, fun.getHora_do_fim());
			agendaHora.setInt	(4, fun.getFK_entidade());
			agendaHora.setInt   (5, fun.getDia_da_semana());
			agendaHora.execute();
			agendaHora.close();
			System.out.println("Cadastro de Sucesso....Turnos");
		}catch(SQLException e){
		e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void Delete_Arq(Funcionario fun)
	{
		String sql = "DELETE FROM TBLARQUIVODOFUNCIONARIO WHERE fk_entidade=? AND fk_arquivo=?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, fun.getId_entidade());
			ent.setInt(2, fun.getArquivo());
			ent.execute();
			ent.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException ef){
				System.out.println("Erro finalizar: "+ef);
			}
		}
	}
	public String Find_Arq(Funcionario fun)
	{
		String sql = "SELECT CAMINHO,NOME_FICHEIRO FROM TBLARQUIVODOFUNCIONARIO WHERE fk_entidade=? AND fk_arquivo=?";
		String ficheiro="";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, fun.getId_entidade());
			ent.setInt(2, fun.getArquivo());
			ResultSet rs = ent.executeQuery();
			if(rs.next())
				ficheiro = rs.getString("caminho")+rs.getString("nome_ficheiro");
			ent.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException ef){
				System.out.println("Erro finalizar: "+ef);
			}
		}
		return ficheiro;
	}
	public String foto(int id)
	{
		String sql = "SELECT NOME_FICHEIRO FROM TBLARQUIVODOFUNCIONARIO WHERE fk_entidade = ? ";
		String ficheiro=null;
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1,id);
			ResultSet rs = ent.executeQuery();
			if(rs.next())
			{
			   ficheiro = rs.getString("nome_ficheiro");
			}
			ent.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(SQLException ef){
				System.out.println("Erro finalizar: "+ef);
			}
		}
//		System.out.print(ficheiro);
		return ficheiro;
	}
	
	public Funcionario getContacto(String aux){
		String sql = "SELECT * FROM vwlistadecadastrados where nome = ?";
		Funcionario f = new Funcionario();
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, aux);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				f.setTelefone(rs.getLong("telefone"));
				f.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public void exlcuirFuncionario(int cod){
		String sql = "Delete from tblnaturalidade where FK_entidade = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ps.execute();
			ps.execute("Delete from tblfuncionario where FK_entidade = "+cod);
			ps.execute("Delete from tblutilizador where FK_entidade = "+cod);
			ps.execute("Delete from tblentidade where id_entidade = "+cod);
			ps.close();
			con.close();
			System.out.println("Excluido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected String toString(Object object){
		return object.toString();
	}
}
