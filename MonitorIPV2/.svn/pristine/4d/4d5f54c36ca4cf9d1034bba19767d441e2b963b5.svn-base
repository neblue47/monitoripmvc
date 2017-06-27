package ao.co.smpip.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

//import org.apache.tomcat.util.http.fileupload.FileItem;


import ao.co.smpip.entidades.Funcionario;
import ao.co.smpip.jdbc.FuncionarioDAO;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadFile 
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet  {
	
	Funcionario fun = new Funcionario();
	FuncionarioDAO da = new FuncionarioDAO();
	String msg = "Novos Arquivos Adicionados com sucesso";
	int cont=0;
	String listArquivo [] = {"","Foto do Perfil","Bilhete de Identidade","Registo Criminal","Atestado Medico","Declaracao Militar","Certificado de Habilitacao","Carta de Conducao","Diploma 1","Diploma 2"};
	String saveFile = "C:/Users/NEBLUE47/Documents/monitorws/MonitorIP/WebContent/ficheiro/";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try
		{
			int cod =0;
			boolean ismultipart = ServletFileUpload.isMultipartContent(request);
			if(!ismultipart)
			{
				
			}
			else
			{
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = null;
				try
				{
					items = upload.parseRequest(request);
				}catch(Exception e){out.print("Errror" +e);}
				Iterator itr = items.iterator();
				FileItem itm = (FileItem) items.get(9);
				try
				{
					cod = Integer.parseInt(itm.getString());
					fun.setId_entidade(cod);
				}
				catch(NumberFormatException er){out.print("Errror" +er);} 
				while(itr.hasNext()){
					FileItem item = (FileItem)itr.next();
					if(item.isFormField()){            	
					}
					else
					{
						String itemname = item.getName();
						
						if((itemname==null)|| itemname.equals(""))
						{
							continue;
						}
						String filename = fun.getId_entidade()+FilenameUtils.getName(itemname);
						File f = checkExist(filename);
						item.write(f);
						
						
						cont++; 
						fun.setArquivo(cont);
						fun.setLocalArq(saveFile);
						fun.setNomeArq(filename);
						System.out.println("ID Entidade: "+fun.getId_entidade()+"Nome do Arquivo: "+fun.getNomeArq());
						da.fun_arquivos(fun);
						
					}
				}
				items = null;
				cont=0;
				request.setAttribute("id", cod);
				request.getSession().setAttribute("msg", msg);
				RequestDispatcher saida = request.getRequestDispatcher("index.jsp?mod=ad&pesquisar=mss&valor="+cod);
				saida.forward(request, response);
			} 
				
		}catch(Exception er){out.print("Errror" +er);}
		
		finally {out.close();}
		
		
	}
	private File checkExist(String fileName) {
		File f = new File(saveFile+"/"+fileName);
		
		if(f.exists()){
			StringBuffer sb = new StringBuffer(fileName);
			sb.insert(sb.indexOf("."), "-"+fun.getId_entidade());
			f = new File(saveFile+"/"+sb.toString());
			
		}
		return f;
	}

	

}
