package ao.co.smpip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import ao.co.smpip.entidades.ListaBean;
import ao.co.smpip.entidades.Notificacao;
import ao.co.smpip.entidades.SerialBean;
import ao.co.smpip.entidades.Turnos;
import ao.co.smpip.entidades.Diverso;
import ao.co.smpip.entidades.Equipa;
import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.entidades.Posto;
import ao.co.smpip.entidades.Usuario;
import ao.co.smpip.jdbc.AcessosDAO;
import ao.co.smpip.jdbc.AgendaDAO;
import ao.co.smpip.jdbc.EquipaDAO;
import ao.co.smpip.jdbc.FuncionarioDAO;
import ao.co.smpip.jdbc.MapaDAO;
import ao.co.smpip.jdbc.NotificacaoDAO;
import ao.co.smpip.jdbc.UserDAO;
import ao.co.smpip.security.EncriptaDecriptaRSA;
import ao.co.smpip.serial.SerialConexao;
import ao.co.smpip.serial.SerialMonitor;
import ao.co.smpip.utils.MetodosBuscas;

/**
 * Servlet implementation class NavegController
 */
@WebServlet("/navegacao")
public class NavegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavegController() {
        super();
        
    }
    private EncriptaDecriptaRSA rsa;
    String hash_id = "";
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher saida = null;
		String mod = request.getParameter("mod");
		FuncionarioDAO fdao = new FuncionarioDAO();
		SerialConexao sc = new SerialConexao();
		HttpSession ss = request.getSession(true);
		if(ss!=null){
			try {
				
				 
				 if(mod!=null && mod.equals("ajd"))
					{
					    saida = request.getRequestDispatcher("index.jsp?mod=ajd");
						saida.forward(request, response);
					}
				if(mod!=null && mod.equals("ng"))
				{
//					
//					 if(sc.iniciaSerial()){
//						 
//					 }
//					 else
//					 {
//						 sc.close();
//					 }
					saida = request.getRequestDispatcher("index.jsp?mod=ng");
					saida.forward(request, response);
				}
				if(mod!=null && mod.equals("ad"))
				{
					String tela = request.getParameter("pesquisar");
					if(tela==null){
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=rh");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("rh"))
					{
						
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=rh");
						saida.forward(request, response);
						
					}

					if(tela!=null && tela.equals("u")){
						String hab1 = "disabled='disabled'";
						String hab2 = "disabled='disabled'";
						List <Funcionario> lista = new FuncionarioDAO().getFuncionario();
						String aux = request.getParameter("valorp");
						if(aux!= null )
							lista = new FuncionarioDAO().buscaPorNomeNumero(aux);
						
						request.setAttribute("lista", lista);
						request.setAttribute("hab1", hab1);
						request.setAttribute("hab2", hab2);
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=u");
						
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("ut")){
						String hab1 = "disabled='disabled'";
						String hab2 = "disabled='disabled'";
						String cod = request.getParameter("cod");
						
						if(cod!=null)
							hash_id = rsa.decriptografa(cod);
						System.out.println(hash_id);	
						Funcionario f = new FuncionarioDAO().getUtilizador(hash_id);
						Usuario u = new UserDAO().buscarPorId(cod);
						List <Funcionario> lista = new FuncionarioDAO().getFuncionario();
						request.setAttribute("lista", lista);
						request.setAttribute("nome_c", f.getNome()+" "+f.getSnome());
						if(u.getNivel()!=0)
						{
							request.setAttribute("nomeu", u.getNome());
							request.setAttribute("senha", u.getSenha());
							request.setAttribute("grupou",u.getNivel());
							request.setAttribute("txtid",cod);
							request.setAttribute("hab1", hab1);
							request.setAttribute("hab2", "");
						}
						else {
							request.setAttribute("txtid",0);
							request.setAttribute("hab1", "");
							request.setAttribute("hab2", hab2);
						}
						
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=u");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("eq")){
						List <Funcionario> lista = new FuncionarioDAO().getFuncionarioTecnico();
						List<Equipa> lista_eq = new EquipaDAO().getEquipas();
						request.setAttribute("lista", lista);
						request.setAttribute("lista_eq", lista_eq);
						String acao		  = request.getParameter("acao");
						if(acao!=null && acao.equals("edit")){
							int cod = Integer.parseInt(request.getParameter("cod"));							
							Equipa equipa = new EquipaDAO().getEquipas(cod);
							request.setAttribute("equipa", equipa);
							request.setAttribute("acao", acao);
						}
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=eq");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("ag")){
						List <Funcionario> lista = new FuncionarioDAO().getFuncionario();
						List <Diverso> dsemanas = new MetodosBuscas().buscaDiasSemanasEnum();
						request.setAttribute("lista", lista);
						request.setAttribute("dsemanas", dsemanas);
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=ag");
						saida.forward(request, response);
					}

					if(tela!=null && tela.equals("f")){
						MetodosBuscas func = new MetodosBuscas();
						List <Diverso> lista_esp = func.buscaEspecialidade();
						List <Diverso> lista_prof = func.buscaProfissao() ;
						List <Diverso> lista_est = func.buscaEstadoCivilEnum();
						List <Diverso> lista_ocu = func.buscaCategoriaEnum ();
						
						List <Diverso> lista_tdoc = func.buscaTipoDocEnum ();
						List <Diverso> lista_pais = func.buscaPais();
						List <Diverso> lista_fnc = func.buscaCategoriaEnum ();
						String num = "FUN00" + (1 + new FuncionarioDAO().novaNum());
						request.setAttribute("especialidade", lista_esp);
						request.setAttribute("profissao", lista_prof);
						request.setAttribute("estCivil", lista_est);
						request.setAttribute("lista_ocu", lista_ocu);
						request.setAttribute("pais", lista_pais);
						request.setAttribute("tipodoc", lista_tdoc);
						request.setAttribute("categoria", lista_fnc);
						request.setAttribute("num", num);
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=f");
						saida.forward(request, response);
					}
					
					if(tela!=null && (tela.equals("p")||tela.equals("Pesquisar")) ){
						String aux = request.getParameter("valorp");
					    
					
					     
						
						List <Funcionario> lista =fdao.getFuncionario();
						if(aux!=null)
							lista = fdao.buscaPorNomeNumero(aux);
						
					    request.setAttribute("lista", lista);
						 
					    saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=p");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("arq")){
						String cod = request.getParameter("cod");
						if(cod!=null)
							hash_id = rsa.decriptografa(cod);
					    int id = Integer.parseInt(hash_id);
					    
						request.setAttribute("codEnt", id);
						saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=arq");
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("edit")){
						String num = request.getParameter("valor");
						if(num!=null)
							hash_id = rsa.decriptografa(num);
					    int id = Integer.parseInt(hash_id);
						
						Funcionario lista =fdao.buscaEditFuncionario(id);
					    
					    MetodosBuscas func = new MetodosBuscas();
					    
					    List <Diverso> lista_esp = func.buscaEspecialidade();
						List <Diverso> lista_prof = func.buscaProfissao() ;
						List <Diverso> lista_est = func.buscaEstadoCivilEnum();
						List <Diverso> lista_ocu = func.buscaCategoriaEnum ();
						
						List <Diverso> lista_tdoc = func.buscaTipoDocEnum ();
						List <Diverso> lista_pais = func.buscaPais();
						List <Diverso> lista_fnc = func.buscaCategoriaEnum ();
						 
						request.setAttribute("especialidade", lista_esp);
						request.setAttribute("profissao", lista_prof);
						request.setAttribute("estCivil", lista_est);
						request.setAttribute("lista_ocu", lista_ocu);
						request.setAttribute("pais", lista_pais);
						request.setAttribute("tipodoc", lista_tdoc);
						request.setAttribute("categoria", lista_fnc);
						request.setAttribute("f", lista);
					    saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=edit");
						saida.forward(request, response);
					}
					
				}
				if(mod!=null && mod.equals("ag"))
				{
					String tela = request.getParameter("pesquisar");
					if(tela!=null && tela.equals("pc")){
						 
						request.setAttribute("tmp", new MapaDAO().busacTempoTela());
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=pc");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("ps")){
						List<Posto> armarios = new MapaDAO().buscaPorArmarios();
						request.setAttribute("armarios", armarios);
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=ps");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("ht")){
						MapaDAO m = new MapaDAO();
						List<Posto> logs = m.getLogs_sensor();
						request.setAttribute("logs", logs);
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=ht");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("rq")){
						
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=rq");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("rt")){
						List<Equipa> lista_eq = new EquipaDAO().getEquipas();
						MetodosBuscas mtb = new MetodosBuscas();
						List<Diverso> Meses = mtb.buscaMes();
						 
						request.setAttribute("meses", Meses);
						request.setAttribute("lista_eq", lista_eq);
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=rt");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("rtd")){
						String armario = request.getParameter("armario");
						if(armario!=null){
							List<Posto> listaLogs = new EquipaDAO().getLogsManutencaoDiaria(armario);
							request.setAttribute("listaLogs", listaLogs);
						}
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=rtd");
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("rts")){
						MetodosBuscas mtb = new MetodosBuscas();
						String armario = request.getParameter("armario");
						String mes = request.getParameter("mess");
						String semana = request.getParameter("semana");
						if(armario!=null){
							int mes_id = Integer.parseInt(mes);
							int semana_id = Integer.parseInt(semana);
							System.out.println(mes_id+ " "+semana);
							List<Posto> listaLogs = new EquipaDAO().getLogsManutencaoSemanal(armario, mes_id, semana_id);
							request.setAttribute("listaLogs", listaLogs);
						}
						List<Diverso> Meses = mtb.buscaMes();
						 
						request.setAttribute("meses", Meses);
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=rts");
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("rtm")){
						MetodosBuscas mtb = new MetodosBuscas();
						
						String armario = request.getParameter("armario");
						String mes = request.getParameter("mess");
						String ano = request.getParameter("ano");
						if(armario!=null){
							int mes_id = Integer.parseInt(mes);
							int anoInt = Integer.parseInt(ano);
							System.out.println(mes_id+ " "+ano);
							List<Posto> listaLogs = new EquipaDAO().getLogsManutencaoMensal(armario, mes_id, anoInt);
							request.setAttribute("listaLogs", listaLogs);
						}
						
						List<Diverso> Meses = mtb.buscaMes();
						request.setAttribute("meses", Meses);
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=rtm");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("not")){
						String codNot = request.getParameter("cod");
						if(codNot!=null && !codNot.equals("")){
							int temp = Integer.parseInt(codNot);
							Notificacao nota = new NotificacaoDAO().buscaNotificacoes(temp);
							request.setAttribute("nota", nota);
						}
						List<Notificacao> lsNotas = new NotificacaoDAO().buscaNotificacoes();
						request.setAttribute("lsNotas", lsNotas);
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=not");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("mts")){
						List<Posto> logs_manutencao = new MapaDAO().getLogs_manutencao();
						request.setAttribute("logs_manutencao", logs_manutencao);
						String cod = request.getParameter("cod");
						if(cod!=null){
							int idposto = Integer.parseInt(cod);
							List<Equipa> lista_eq = new EquipaDAO().getEquipas();
							request.setAttribute("lista_eq", lista_eq);
							Posto posto = new MapaDAO().buscaPorPostoNoHistorico(idposto);
							request.setAttribute("posto", posto);
						}
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=mts");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("msg")){
						
						saida = request.getRequestDispatcher("index.jsp?mod=ag&pesquisar=msg");
						saida.forward(request, response);
					}
					if(tela==null){
						saida = request.getRequestDispatcher("index.jsp?mod=ag");
						saida.forward(request, response);
					}
					
				}
				
				if(mod!=null && mod.equals("cf"))
				{
					String tela = request.getParameter("pesquisar");
					if(tela!=null && tela.equals("nc")){
						 
						List<Diverso> provincia = new MetodosBuscas().buscaProvincia (7);
						request.setAttribute("provincia", provincia);
						 
						saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=nc");
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("ns")){
						List<Posto> armarios = new MapaDAO().getSensores();
						request.setAttribute("armarios", armarios);
						String cod = request.getParameter("cod");
						if(cod!=null){
							int idposto = Integer.parseInt(cod);
							Posto posto = new MapaDAO().buscaPorPosto(idposto);
							request.setAttribute("posto", posto);
						}
						saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=ns");
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("mt")){
						List<Posto> armarios = new MapaDAO().buscaPorArmarios();
						List<Diverso> provincia = new MetodosBuscas().buscaProvincia (7);
						request.setAttribute("provincia", provincia);
						request.setAttribute("armarios", armarios);
						String cod = request.getParameter("cod");
						if(cod!=null){
							int idposto = Integer.parseInt(cod);
							Posto posto = new MapaDAO().buscaPorPosto(idposto);
							request.setAttribute("posto", posto);
						}
						saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=mt");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("cm")){
						request.setAttribute("tmp", new MapaDAO().busacTempoTela());
						request.setAttribute("postos", new MapaDAO().buscarValoresArmarios());
						saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=cm");
						saida.forward(request, response);
					}
					
					if(tela!=null && tela.equals("acss")){
						 AcessosDAO dDao = new AcessosDAO();
						 List<Diverso> buscarPerifisTelas = dDao.buscarPerifisTelas();
						 List<Diverso> ListaTelas = dDao.buscarTelas();
						 List<Diverso> ListaModulos = dDao.buscarModulos();
						 request.setAttribute("buscarPerifisTelas", buscarPerifisTelas); 
						 request.setAttribute("ListaTelas", ListaTelas);
						 request.setAttribute("ListaModulos", ListaModulos);
						 String acao = request.getParameter("acao");
						 if(acao!=null && acao.equals("edit")){
							 String codPrf = request.getParameter("perfil");
							 Diverso tmpPerfil = new AcessosDAO().verPerfilPrivilegio(codPrf);
							 request.setAttribute("tmpPerfil", tmpPerfil);
						 }
						 saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=acss");
						 saida.forward(request, response);
					}
					if(tela!=null && tela.equals("actela")){
						String valor = request.getParameter("valorp");
						List<Diverso> ListaDeTela = null;
						if(valor!=null)
							ListaDeTela = new AcessosDAO().buscarTelas(valor);
						else
							ListaDeTela = new AcessosDAO().buscarTelas();
						
						request.setAttribute("ListaDeTela", ListaDeTela);
						saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=actela");
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("acmdl")){
						 
						saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=acmdl");
						saida.forward(request, response);
					}
					if(tela!=null && tela.equals("acssu")){
						List<Usuario> ListaUtilizadores = new UserDAO().buscaTodos () ;
						
						String valorp = request.getParameter("valorp");
						if(valorp!=null)
							ListaUtilizadores = new UserDAO().buscaTodos (valorp);
						else
							ListaUtilizadores = new UserDAO().buscaTodos (); 
						
							List<Diverso> ListaPerfil = new AcessosDAO().buscarListaPerfil();
						String cod = request.getParameter("cod");
						if(cod!=null ){
							Usuario usu = new UserDAO().buscarPorIdUsu(cod);
							request.setAttribute("usuTemp", usu);
						}
						request.setAttribute("listaUtilizador", ListaUtilizadores);
						request.setAttribute("listaPerfil", ListaPerfil);
						saida = request.getRequestDispatcher("index.jsp?mod=cf&pesquisar=acssu");
						saida.forward(request, response);
					}
					if(tela==null){
						saida = request.getRequestDispatcher("index.jsp?mod=cf");
						saida.forward(request, response);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				 saida = request.getRequestDispatcher("index.jsp?mod=ajd");
					saida.forward(request, response);
			}
		}
		else
		{
			/*String url = request.getRequestURL().toString();
	        String queryString = request.getQueryString();
       
	        
			request.getSession().setAttribute("ultimaURL", url);
			request.getSession().setAttribute("queryString", queryString);
			 */
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
