package ao.co.smpip.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.jdbc.Formatando;
import ao.co.smpip.jdbc.FuncionarioDAO;


/**
 * Servlet implementation class FuncionarioController
 */ 
@WebServlet("/funcontroller.do")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando pelo Metodo Post");
		Funcionario f = new Funcionario();
		FuncionarioDAO fDao = new FuncionarioDAO();
		
		String numInt = request.getParameter("numInt");
		String numFK = request.getParameter("numFK");
		String nome = request.getParameter("nome");
		String snome = request.getParameter("apelido");
		String dtaNasc = request.getParameter("nascido");
		String estCvl = request.getParameter("estcivil");
		String genero = request.getParameter("sexo");
		String categoria = request.getParameter("categoria");
		String profissao = request.getParameter("profissao"); 
		String especialidade = request.getParameter("esp");
		String telefone = request.getParameter("tlf");
		String email = request.getParameter("email");
		String tipoD = request.getParameter("tipoD");
		String nssocial = request.getParameter("numssocail");
		String nif = request.getParameter("nif");
		String numDoc = request.getParameter("numDoc");
		if(numDoc==null){
			numDoc = request.getParameter("numB");
		}
		if(numDoc==null ){
			numDoc = request.getParameter("numCd");
		}
		if(numDoc==null ){
			numDoc = request.getParameter("numP");
		}
		
		
		String endereco = request.getParameter("endereco");
		String pais = request.getParameter("nacional");
		String provincia = request.getParameter("natural");
		String dtAdmitido = new Formatando().data_Admissao();
		String salario = request.getParameter("salario");
		System.out.println("Espec "+especialidade);
		System.out.println("funcao "+categoria);
		System.out.println("Provincia "+provincia);
		try
		{
			 
			int id_cat = Integer.parseInt(categoria);
			int id_especld= Integer.parseInt(especialidade);
			int id_prof= Integer.parseInt(profissao);
			long fone = new Formatando().fone2(telefone);
			int id_pais = Integer.parseInt(pais);
			int id_prov = Integer.parseInt(provincia);
			int tpDoc = Integer.parseInt(tipoD);
			double remun= Double.parseDouble(salario);
			Calendar data1= new Formatando().data(dtaNasc); 
			Calendar data2= new Formatando().data(dtAdmitido);
			
			f.setNumInterno(numInt);
			f.setNome(nome);
			f.setSnome(snome);
			f.setDt_nascimento(data1);
			f.setId_estcivil(estCvl);
			f.setSexo(genero);
			f.setId_categoria(id_cat);
			f.setFk_especialidade(id_especld);
			f.setId_profissao(id_prof);
			f.setTelefone(fone);
			f.setEmail(email);
			f.setTipoEnt(tpDoc);
			f.setNumDoc(numDoc);
			f.setEndereco(endereco);
			f.setId_pais(id_pais);
			f.setId_provincia(id_prov);
			f.setDt_admissao(data2);
			f.setSalario(remun);
			f.setS_social(nssocial);
			f.setNif(nif);
			
			int id_enti = Integer.parseInt(numFK);
			f.setId_entidade(id_enti);
			fDao.editFuncionario(f);
			fDao.editNaturalidade(f);
			
		}
		catch(NumberFormatException en){
			System.out.println("Erro de conversao: "+en);
		}
		HttpSession sess = request.getSession();
		sess.setAttribute("nome", f.getNome()+" "+f.getSnome());
		sess.setAttribute("num", f.getNumInterno());
		response.sendRedirect("index.jsp?pesquisar=ms&mod=ad");
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando pelo Metodo Post");
		Funcionario f = new Funcionario();
		FuncionarioDAO fDao = new FuncionarioDAO();
		
		String numInt = request.getParameter("numInt");
		String nome = request.getParameter("nome");
		String snome = request.getParameter("apelido");
		String dtaNasc = request.getParameter("nascido");
		String estCvl = request.getParameter("estcivil");
		String genero = request.getParameter("sexo");
		String categoria = request.getParameter("categoria");
		String profissao = request.getParameter("profissao"); 
		String especialidade = request.getParameter("esp");
		String telefone = request.getParameter("tlf");
		String email = request.getParameter("email");
		String tipoD = request.getParameter("tipoD");
		String nssocial = request.getParameter("numssocail");
		String nif = request.getParameter("nif");
		String numDoc = request.getParameter("numDoc");
		if(numDoc==null){
			numDoc = request.getParameter("numB");
		}
		if(numDoc==null ){
			numDoc = request.getParameter("numCd");
		}
		if(numDoc==null ){
			numDoc = request.getParameter("numP");
		}
		
		
		String endereco = request.getParameter("endereco");
		String pais = request.getParameter("nacional");
		String provincia = request.getParameter("natural");
		String dtAdmitido = new Formatando().data_Admissao();
		String salario = request.getParameter("salario");
		System.out.println("Espec "+especialidade);
		System.out.println("funcao "+categoria);
		System.out.println("Provincia "+provincia);
		try
		{
			 
			int id_cat = Integer.parseInt(categoria);
			int id_especld= Integer.parseInt(especialidade);
			int id_prof= Integer.parseInt(profissao);
			long fone = new Formatando().fone2(telefone);
			int id_pais = Integer.parseInt(pais);
			int id_prov = Integer.parseInt(provincia);
			int tpDoc = Integer.parseInt(tipoD);
			double remun= Double.parseDouble(salario);
			Calendar data1= new Formatando().data(dtaNasc); 
			Calendar data2= new Formatando().data(dtAdmitido);
			
			f.setNumInterno(numInt);
			f.setNome(nome);
			f.setSnome(snome);
			f.setDt_nascimento(data1);
			f.setId_estcivil(estCvl);
			f.setSexo(genero);
			f.setId_categoria(id_cat);
			f.setFk_especialidade(id_especld);
			f.setId_profissao(id_prof);
			f.setTelefone(fone);
			f.setEmail(email);
			f.setTipoEnt(tpDoc);
			f.setNumDoc(numDoc);
			f.setEndereco(endereco);
			f.setId_pais(id_pais);
			f.setId_provincia(id_prov);
			f.setDt_admissao(data2);
			f.setSalario(remun);
			f.setS_social(nssocial);
			f.setNif(nif);
			
			int id_enti = fDao.criar_entidade(f);
			f.setId_entidade(id_enti);
			fDao.novoFuncionario(f);
			fDao.tblNaturalidade(f);
			
		}
		catch(NumberFormatException en){
			System.out.println("Erro de conversao: "+en);
		}
		HttpSession sess = request.getSession();
		sess.setAttribute("nome", f.getNome()+" "+f.getSnome());
		sess.setAttribute("num", f.getNumInterno());
		response.sendRedirect("index.jsp?pesquisar=ms&mod=ad");
	}
			    

}
