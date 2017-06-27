package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.entidades.Turnos;


public class AgendaDAO {
	
	private Connection con = Conexao.getConexao();
	
	public List <Funcionario> buscaPorNome (String nome)
	{
		List <Funcionario> lista = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM vwentidadecidadaocomofuncionario WHERE NOME LIKE ?";
		try {
			 con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, nome);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Funcionario fun = new Funcionario();
				 fun.setId_entidade(rs.getInt("ID_ENTIDADE"));
				 fun.setNome(rs.getString("NOME"));
				 fun.setSnome(rs.getString("SNOME"));
				 lista.add(fun);
			 }
			 preparador.close();
			 con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
		public List <Funcionario> buscaFun ()
		{
			List <Funcionario> lista = new ArrayList<Funcionario>();
			String sql = "SELECT * FROM vwentidadecidadaocomofuncionario LIMIT 0,20";
			try {
				con = Conexao.getConexao();
				 PreparedStatement preparador = con.prepareStatement(sql);
				 ResultSet rs = preparador.executeQuery();
				 while(rs.next())
				 {
					 Funcionario fun = new Funcionario();
					 fun.setId_entidade(rs.getInt("ID_ENTIDADE"));
					 fun.setNome(rs.getString("NOME"));
					 fun.setSnome(rs.getString("SNOME"));
					 lista.add(fun);
				 }
				 preparador.close();
				 con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return lista;
	}
	
		public Funcionario buscaFuncionario (int num)
		{
			Funcionario lista = new Funcionario();
			String sql = "SELECT * FROM vwlistadecadastrados WHERE id_entidade = ?";
			try {  
				 con = Conexao.getConexao();
				 PreparedStatement preparador = con.prepareStatement(sql);
				 preparador.setInt(1, num);
				 ResultSet rs = preparador.executeQuery();
				 if(rs.next())
				 {
					 lista.setId_entidade(rs.getInt("id_entidade"));
					 lista.setNome(rs.getString("NOME"));
					 lista.setSnome(rs.getString("SNOME"));
					
				 }
				 preparador.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			System.out.print("Nome: "+lista.getNome());
			return lista;
	}
		
		
		//INSERIR DATA AUTOMM�TICA
		 public java.sql.Date data_registo()
		 {
			 java.sql.Date dt_registo = null;
				Calendar c = Calendar.getInstance(); // Cria um objeto para armazenar a data atual
		        c.setTime(new Date()); // pega a data atual do sistema
		        int diaAtual = c.get(Calendar.DAY_OF_MONTH); // DIA
		        int mesAtual = c.get(Calendar.MONTH)+1; // MES
		        int anoAtual = c.get(Calendar.YEAR);  // ANO
		        String hoje = anoAtual+"/"+mesAtual+"/"+diaAtual;
		        DateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
			    java.util.Date a; 
				try {
					a = (java.util.Date) formate.parse(hoje);
					dt_registo = new java.sql.Date(a.getTime());
					} catch (ParseException e) { }
				return dt_registo;
		 }
		
		 // Inserir dados na tabela Agenda
		public void agendar(Turnos fun)
		{
			
			String sql = "INSERT INTO tblagendadetrabalho(FK_entidade, FK_dia_da_semana, hora_de_inicio, " +
					"hora_do_fin,data)" + " VALUES(?,?,?,?,?)";
			try{
				PreparedStatement agendaHora = con.prepareStatement(sql);
				agendaHora.setInt(1, fun.getFK_entidade());
				agendaHora.setInt(2, fun.getDia_da_semana());
				agendaHora.setString(3, fun.getHora_de_inicio());
				agendaHora.setString(4, fun.getHora_do_fim());
				agendaHora.setDate(5, data_registo());
				agendaHora.execute();
				agendaHora.close();
				System.out.println("Cadastro de Sucesso....");
			}catch(SQLException e){
			e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public List <Turnos> MostrarDiasDaSemana()
		{
			List <Turnos> listaagenda = new ArrayList<Turnos>();
			String sql = "SELECT * FROM TBLDIADASEMANA";
			try{
				PreparedStatement preparador = con.prepareStatement(sql);
				ResultSet ag = preparador.executeQuery();
				while(ag.next())
				 {
				     Turnos fun = new Turnos();
				     fun.setDia_da_semana(ag.getInt("id_dia_da_semana"));
				     fun.setNome_dia_da_semana(ag.getString("dia_da_semana"));
				     listaagenda.add(fun);
				    }
				    preparador.close();
				  } catch (SQLException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
				  }
				  return listaagenda;
				 }
		
		public List<Turnos> funcionarioagendadoMostrar ()
		{
			List <Turnos> listaMostrar = new ArrayList<Turnos>();
			String sql = "SELECT * FROM vwfuncespecializadoeagendado ";
			try {
				 PreparedStatement preparador = con.prepareStatement(sql);
				 ResultSet age = preparador.executeQuery();
				 while(age.next())
				 {
					 Turnos fun = new Turnos();
					 fun.setId_agendatrabalho(age.getInt("id_agendatrabalho"));
					 fun.setFK_entidade(age.getInt("FK_entidade"));
					 fun.setNomeFuncionario(age.getString("nome"));
					 fun.setUltimonome(age.getString("ultimo_nome"));
					 fun.setHora_de_inicio(age.getString("hora_de_inicio"));
					 fun.setNome_dia_da_semana(age.getString("dia_da_semana"));
					 fun.setHora_do_fim(age.getString("hora_do_fin"));
					 fun.setData(age.getDate("data"));
					 listaMostrar.add(fun);
				 }
				 preparador.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return listaMostrar;
		}
		
		public void up_agendamentoModificar(Turnos fun)
		{
			String sql = "UPDATE TBLAGENDADETRABALHO SET FK_dia_da_semana=?, hora_de_inicio=?, hora_do_fin,data=? WHERE id_agendatrabalho=?";
			try {
				PreparedStatement agend = con.prepareStatement(sql);
				
				agend.setString(1, fun.getNomeFuncionario()+" "+fun.getUltimonome());
				agend.setString(2, fun.getNome_dia_da_semana());
				agend.setString(3, fun.getHora_de_inicio());
				agend.setString(4, fun.getHora_do_fim());
				agend.execute();
				agend.close();
				System.out.println("ALTERACAO com sucesso...TBLAGENDA"); 
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		public void delete_funcionarioagendado(int id)
		{
			String sql = "DELETE FROM tblagendadetrabalho  WHERE id_agendatrabalho=?";
			try {
				 PreparedStatement preparador = con.prepareStatement(sql);
				 preparador.setInt   (1, id);
				 preparador.execute();
				 preparador.close();
				 System.out.println("Exclusao com sucesso...TBLAGENDA"); 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public void alt_agenda(Turnos ag)
		{
			String sql = "UPDATE tblagendadetrabalho SET FK_dia_da_semana =?, hora_de_inicio =?, hora_do_fin =? WHERE id_agendatrabalho = ?";
			try {
				PreparedStatement agenda = con.prepareStatement(sql);
				
				agenda.setInt(1, ag.getDia_da_semana());
				agenda.setString(2, ag.getHora_de_inicio());
				agenda.setString(3, ag.getHora_do_fim());
				agenda.setInt(4, ag.getId_agendatrabalho());
				agenda.execute();
				agenda.close();
				System.out.println("Alteracao com sucesso...TBLAGENDA"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void salvarAge(Turnos ag)
		{
			if(ag.getFK_entidade()!=0)
			{
				alt_agenda(ag);
			}
			else
			{
				agendar(ag);
			}
		}
		  
		public Turnos edit_agenda(int ed)
		{
			Turnos fun = new Turnos();
			 
			return fun;
		}
		
		public List<Turnos> buscarFunAgendado (String nome)
		{
			List <Turnos> listaAge = new ArrayList<Turnos>();
			String sql = "SELECT * FROM vwfuncespecializadoeagendado WHERE nome LIKE ?";
			try {
				 PreparedStatement preparador = con.prepareStatement(sql);
				 preparador.setString(1, nome);
				 ResultSet age = preparador.executeQuery();
				 while(age.next())
				 {
					 Turnos fun = new Turnos();
					 fun.setFK_entidade(age.getInt("FK_entidade"));
					 fun.setId_agendatrabalho(age.getInt("id_agendatrabalho"));
					 fun.setNomeFuncionario(age.getString("nome"));
					 fun.setUltimonome(age.getString("ultimo_nome"));
					 fun.setHora_de_inicio(age.getString("hora_de_inicio"));
					 fun.setNome_dia_da_semana(age.getString("dia_da_semana"));
					 fun.setHora_do_fim(age.getString("hora_do_fin"));
					 fun.setData(age.getDate("data"));
					 listaAge.add(fun);
				 }
				 preparador.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return listaAge;
		}
		
		}