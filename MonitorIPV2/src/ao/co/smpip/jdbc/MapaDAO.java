package ao.co.smpip.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.ListaBean;
import ao.co.smpip.entidades.Posto;
import ao.co.smpip.entidades.SerialBean;

public class MapaDAO 
{
	private Connection con = Conexao.getConexao();
	Formatando ft = new Formatando();
	public List<Posto> buscaPorArmarios()
	{
		List<Posto> lp = new ArrayList<Posto>();
		String sql = "SELECT * FROM vwarmarios ";
		try { 
			con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Posto p = new Posto();
				 p.setIdPosto(rs.getInt("id_armario"));
				 p.setLatitude(rs.getDouble("LAT"));
				 p.setLongitude(rs.getDouble("LNG"));
				 p.setDescricao(rs.getString("descricao_google"));
				 p.setNomPosto(rs.getString("nome"));
				 p.setQdtLampada(rs.getInt("QTD_LAMP"));
				 p.setFk_distrito(rs.getInt("FK_distrito"));
				 p.setFk_municipio(rs.getInt("FK_municipio"));
				 p.setFk_provincia(rs.getInt("FK_provincia"));
				 p.setNomDistrito(rs.getString("distrito"));
				 p.setNomMunicipio(rs.getString("municipio"));
				 lp.add(p);
			 }
			 preparador.close();
			 con.close();
		} catch (SQLException e) {	System.out.println(e);}
//		System.out.println("Tamanho: "+lp.size());
		return lp;
	}
	public List<Posto> buscaPorPostos()
	{
		List<Posto> lp = new ArrayList<Posto>();
		String sql = "SELECT * FROM vwarmarioscomlogs   group by nome order by id_historico desc limit 3 ";
		try {
			con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Posto p = new Posto();
				 p.setIdPosto(rs.getInt("id_armario"));
				 p.setLatitude(rs.getDouble("lat"));
				 p.setLongitude(rs.getDouble("LNG"));
				 p.setDescricao(rs.getString("descricao_google"));
				 p.setNomPosto(rs.getString("nome"));
				 p.setQdtLampada(rs.getInt("qtd_lamp"));
				 p.setStream(rs.getDouble("valor_stream"));
				 if(p.getStream() > 1.200)
					 p.setFlag("http://maps.google.com/mapfiles/ms/icons/green.png");
				 else
					 p.setFlag("http://maps.google.com/mapfiles/ms/icons/red.png");
				 lp.add(p);
			 }
			 preparador.close();
			 con.close();
		} catch (SQLException e) {	System.out.println(e);}
//		System.out.println("Tamanho: "+lp.size());
		return lp;
	}
	public List<Posto> buscaPorPostos(String termo)
	{
		List<Posto> lp = new ArrayList<Posto>();
		String sql = "SELECT * FROM TBLPOSTO where descricao Like ? ";
		try {
			con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, termo);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Posto p = new Posto();
				 p.setIdPosto(rs.getInt("ID_POSTO"));
				 p.setLatitude(rs.getDouble("LAT"));
				 p.setLongitude(rs.getDouble("LNG"));
				 p.setDescricao(rs.getString("DESCRICAO"));
				 p.setNomPosto(rs.getString("NOM_POSTO"));
				 p.setQdtLampada(rs.getInt("QTD_LAMPADA"));
				 lp.add(p);
			 }
			 preparador.close();
			 con.close();
		} catch (SQLException e) {	System.out.println(e);}
//		System.out.println("Tamanho: "+lp.size());
		return lp;
	}
	
	public Posto buscaPorPosto(int termo)
	{
		Posto p = new Posto();
		String sql = "SELECT * FROM vwarmarios where id_armario = ? ";
		try {
			con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, termo);
			 ResultSet rs = preparador.executeQuery();
			 if(rs.next())
			 {
				 
				 p.setIdPosto(rs.getInt("id_armario"));
				 p.setLatitude(rs.getDouble("LAT"));
				 p.setLongitude(rs.getDouble("LNG"));
				 p.setDescricao(rs.getString("descricao_google"));
				 p.setNomPosto(rs.getString("nome"));
				 p.setQdtLampada(rs.getInt("QTD_LAMP"));
				 p.setFk_distrito(rs.getInt("FK_distrito"));
				 p.setFk_municipio(rs.getInt("FK_municipio"));
				 p.setFk_provincia(rs.getInt("FK_provincia"));
				 p.setNomDistrito(rs.getString("distrito"));
				 p.setNomMunicipio(rs.getString("municipio"));
				  
			 }
			 preparador.close();
			 con.close();;
		} catch (SQLException e) {	System.out.println(e);}
//		System.out.println("Tamanho: "+lp.size());
		return p;
	}
	
	public Posto buscaPorPostoNoHistorico(int termo)
	{
		Posto p = new Posto();
		String sql = "SELECT * FROM vwlogs_sensores where id_historico = ? ";
		try {
			con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, termo);
			 ResultSet rs = preparador.executeQuery();
			 if(rs.next())
			 {
				 p.setIdPosto(rs.getInt("id_armario"));
				 p.setDescricao(rs.getString("descricao_google"));
				 p.setNomPosto(rs.getString("nome"));	
				 p.setFk_historico(rs.getInt("id_historico"));
				 
			 }
			 preparador.close();
			 con.close();
		} catch (SQLException e) {	System.out.println(e);}
//		System.out.println("Tamanho: "+lp.size());
		return p;
	}
	
	public List<Posto> buscaLogsToFixNoHistorico(int termo,Date data)
	{
		
		List<Posto> lsLogs = new ArrayList<Posto>();
		String sql = "SELECT * FROM vwlogs_sensores where id_armario = ? and data_evento = ?";
		try {
			con = Conexao.getConexao();
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setInt(1, termo);
			 preparador.setDate(2, data);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Posto p = new Posto();
				 p.setIdPosto(rs.getInt("id_armario"));	
				 p.setFk_historico(rs.getInt("id_historico"));
				 p.setSensor(rs.getInt("id_sensor"));
				 lsLogs.add(p);
			 }
			 preparador.close();
			 con.close();
		} catch (SQLException e) {	System.out.println(e);}
//		System.out.println("Tamanho: "+lp.size());
		return lsLogs;
	}
	
	public int fk_entidade()
	{
		int fun = 0;
		String sql = "SELECT COUNT(*) ID FROM TBLENTIDADE";
		try {
			con = Conexao.getConexao();
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery();
			if(rs.last())
				fun = rs.getInt("ID");
			con.close();
		}
		catch(Exception e){}
			return fun;
	}
	public void criar_entidade(Posto p)
	{
		String sql = "INSERT INTO TBLENTIDADE (ID_ENTIDADE,TIPO) VALUE (?,?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, p.getFk_entidade() );
			ent.setInt(2, 0 );
			ent.execute();
			ent.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int novo_armario(Posto p)
	{
		int LastID = -1;
		String sql = "INSERT INTO tblarmarios (nome,descricao_google,lat,lng,qtd_lamp) VALUES (?,?,?,?,?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setString(1, p.getNomPosto());
			ent.setString(2, p.getDescricao());
			ent.setDouble(3, p.getLatitude());
			ent.setDouble(4, p.getLongitude());
			ent.setInt   (5, p.getQdtLampada());
			ent.execute();
			ResultSet rs = ent.executeQuery("SELECT LAST_INSERT_ID()");
			if(rs.next()){
				LastID = rs.getInt(1);
			}
			ent.close();
			con.close();
			System.out.println("Cadastro de sucesso...ARMARIO");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LastID;
	}
	
	public void adicionaLogSerial(SerialBean sb){
		String sql = "insert into tblhistoricos (fk_sensor,valor_stream,data_evento,hora_evento) value (?,?,?,?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sb.getId_posto());
			ps.setDouble(2, sb.getStream());
			ps.setDate(3, ft.data_registo());
			ps.setString(4, ft.getHoraAtual());
			ps.execute();
			
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizaLogSerial(int status,int armario){
		String sql = "Update tblarmarios set status = ? where id_armario = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, armario);
			ps.execute();
			
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void endereco_armario(Diverso p)
	{
//		int LastID = -1;
		String sql = "INSERT INTO tblenderecodoarmario (FK_armario,FK_provincia,FK_municipio,FK_distrito) VALUES (?,?,?,?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, p.getFk_armario());
			ent.setInt(2, p.getProvincia());
			ent.setInt(3, p.getMunicipio());
			ent.setInt(4, p.getDistrito());
			ent.execute();
			ent.close();
			con.close();
			System.out.println("Cadastro de sucesso...ENDERECO_ARMARIO");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return LastID;
	}
	
	public void editar_armario(Posto p)
	{
		String sql = "UPDATE tblarmarios SET nome = ?, qtd_lamp = ? WHERE id_armario = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			
			ent.setString(1, p.getNomPosto());
			ent.setInt   (2, p.getQdtLampada());
			ent.setInt(3, p.getIdPosto());
			ent.execute();
			ent.close();
			con.close();
			System.out.println("Editado com sucesso...ARMARIO");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar_LocalArmario(Posto p)
	{
		String sql = "UPDATE tblenderecodoarmario SET FK_provincia = ?, FK_municipio = ? , FK_distrito = ? WHERE fk_armario = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			
			ent.setInt(1, p.getFk_provincia());
			ent.setInt   (2, p.getFk_municipio());
			ent.setInt(3, p.getFk_distrito());
			ent.setInt(4, p.getIdPosto());
			ent.execute();
			ent.close();
			con.close();
			System.out.println("Editado com sucesso...ENDERECO_ARMARIO");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void novo_sensor(Posto p)
	{
//		int LastID = -1;
		String sql = "INSERT INTO tblsensor (fk_armario,tipo,modelo) VALUES (?,?,?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, p.getIdPosto());
			ent.setString(2, p.getTipo());
			ent.setString(3, p.getNomSensor());
			ent.close();
			con.close();
			System.out.println("Cadastro de sucesso...ARMARIO-SENSOR");  
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return LastID;
	}
	public void logs_sensor(Posto p)
	{
		String sql = "INSERT INTO tblhistorico (ID_POSTO,DESCRICAO_POSTO,LAT,LNG,DESCRICAO) VALUES (?,?,?,?,?,?)";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt   (1, p.getFk_entidade());
			ent.setString(2, p.getNomPosto());
			ent.setInt   (3, p.getQdtLampada());
			ent.setDouble(4, p.getLatitude());
			ent.setDouble(5, p.getLongitude());
			ent.setString(6, p.getDescricao());
			ent.execute();
			ent.close();
			con.close();
			System.out.println("Cadastro de sucesso...LOCALZ");  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Posto> getLogs_sensor()
	{
		List<Posto> lp = new ArrayList<Posto>();
		String sql = "SELECT * FROM vwlogs_sensores, vwarmarios "
				   + "where vwlogs_sensores.id_armario = vwarmarios.id_armario ORDER BY id_historico desc,hora_evento DESC LIMIT 100";
				
				
		try {
			con = Conexao.getConexao();
			PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Posto h = new Posto();
				 h.setIdPosto(rs.getInt("id_armario"));
				 h.setDescricao(rs.getString("descricao_google"));
				 h.setNomPosto(rs.getString("nome"));
				 h.setEndereco(rs.getString("municipio")+", "+rs.getString("distrito"));
				 h.setHoraEvento(rs.getString("hora_evento"));
				 Calendar data = Calendar.getInstance();
				 data.setTime(rs.getDate("data_evento"));
				 h.setDataEv(data);
				 lp.add(h);
			 }
			 con.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lp;
	}
	
	public List<Posto> getLogs_manutencao()
	{
		List<Posto> lp = new ArrayList<Posto>();
		String sql = "SELECT * FROM vwlogs_sensores, vwarmarios where vwlogs_sensores.id_armario = vwarmarios.id_armario and id_historico not in (select fk_historico from tblmanutencao) group by id_sensor,data_evento,vwarmarios.id_armario ORDER BY id_historico desc, hora_evento asc LIMIT 0,20";				
		try {
			con = Conexao.getConexao();
			PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Posto h = new Posto();
				 h.setIdPosto(rs.getInt("id_historico"));
				 h.setFk_historico(rs.getInt("id_armario"));
				 h.setDescricao(rs.getString("descricao_google"));
				 h.setNomPosto(rs.getString("nome"));
				 h.setHoraEvento(rs.getString("hora_evento"));
				 h.setEndereco(rs.getString("municipio")+", "+rs.getString("distrito"));
				 Calendar data = Calendar.getInstance();
				 data.setTime(rs.getDate("data_evento"));
				 h.setDataEv(data);
				 lp.add(h);
//				 System.out.println("OK");
			 }
			 con.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lp;
	}
	
	public List<Posto> getSensores()
	{
		List<Posto> lp = new ArrayList<Posto>();
		String sql = "SELECT * FROM vwsensores ";
		try {
			con = Conexao.getConexao();
			PreparedStatement preparador = con.prepareStatement(sql);
			 ResultSet rs = preparador.executeQuery();
			 while(rs.next())
			 {
				 Posto h = new Posto();
				 h.setIdPosto(rs.getInt("id_armario"));
				 h.setNomPosto(rs.getString("nome"));
				 h.setNomSensor(rs.getString("modelo"));
				 h.setTipo(rs.getString("tipo"));
				 h.setSensor(rs.getInt("id_sensor"));
				 lp.add(h);
			 }
con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lp;
	}

	public void manutencao(Posto p) {
		String sql = "INSERT INTO tblmanutencao (FK_armario,FK_equipe,obs,data,hora,fk_historico) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ent = con.prepareStatement(sql);
			ent.setInt(1, p.getIdPosto());
			ent.setInt(2, p.getFk_entidade());
			ent.setString(3, p.getDescricao());
			ent.setDate(4,new Date(p.getDataEv().getTimeInMillis()));
			ent.setString(5,ft.getHoraAtual());
			ent.setInt(6, p.getFk_historico());
			ent.execute();
			ent.close();
			System.out.println("Cadastro com sucesso...ARMARIO-SENSOR-MANUTEN");  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void clear_manutencao(int FK_sensor,Date dataEv,int FK_historico) {
		String sql = "Delete from tblhistoricos where fk_sensor = ? and data_evento = ? and id_historico <> ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ent = con.prepareStatement(sql);
		    ent.setInt(1, FK_sensor);
		    ent.setDate(2, dataEv);
		    ent.setInt(3, FK_historico);
			ent.execute();
			ent.close();
con.close();
			System.out.println("Clear Feito com sucesso...ARMARIO-SENSOR-MANUTEN");  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void configuraSensor (Posto p) {
		//String sql = "Insert into tblsensor(fk_armario,tipo,modelo) value(?,?,?)";
		String sql = "Select * from tblsensor where fk_armario = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getIdPosto());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				atualizarSensor(p);
			else
				novo_sensor(p);
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void novoSensor (Posto p) {
		String sql = "Insert into tblsensor(fk_armario,tipo,modelo) value(?,?,?)";
		 
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getIdPosto());
			ps.setString(2, p.getNomSensor());
			ps.setString(3, p.getDescricao());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void atualizarSensor (Posto p) {
		 
		String sql = "Update tblsensor set tipo = ?,modelo = ? where fk_armario = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNomSensor());
			ps.setString(2, p.getDescricao());
			ps.setInt(3, p.getIdPosto());
			ps.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarTempoTela (int tempo) {
		 
		String sql = "Update tblparametros set tempotela = ? where Id = ?";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tempo);
			ps.setInt(2, 1);
			ps.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int busacTempoTela () {
		 int tempo = 6000;
		String sql = "Select * from tblparametros ";
		try {
			con = Conexao.getConexao();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				tempo = rs.getInt("tempotela");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tempo;
	}
	
	
	
	
}
