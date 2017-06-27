<%@page import="ao.co.smpip.jdbc.FuncionarioDAO"%>
<%@page import="ao.co.smpip.jdbc.Formatando"%>
<%@page import="ao.co.smpip.entidades.Funcionario"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../../css/estilo.css"  />
<title>..:Perfil do Funcionario:..</title>

</head>


<body>
<%
   Formatando dt = new Formatando();
   int id = Integer.parseInt(request.getParameter("cod"));
   Funcionario fn = new Funcionario();
   FuncionarioDAO fDao = new FuncionarioDAO();
   fn = fDao.buscaEditFuncionario(id);
   String foto = "none.png";
   try{
	   //int num = Integer.parseInt(id);
	   //foto = fDao.foto(num);
	   if(foto.equals(""))
		   foto ="semfoto.JPG";
   }catch(NumberFormatException er){}
   
%>


<div id="conteudo">
<table width="100%" border="0" align="center" class="acervotab">
  <tr>
    <td width="22%" rowspan="8"><img src="../../ficheiro/<%=foto %>" width="auto" height="195" alt="img_perfil" style="height: 226px; width: 180px; "/></td>
    <td colspan="5" style="background-color:#999">NOME COMPLETO</td>
    </tr>
  <tr>
    <td colspan="5"><%= fn.getNome()+" "+fn.getSnome() %></td>
    </tr>
  <tr>
    <td colspan="5"style="background-color:#999">NASCIDO</td>
    </tr>
  <tr>
    <td colspan="5"><%= fn.getDt_nascimento().getTime() %> </td>
    </tr>
  <tr>
    <td colspan="5"style="background-color:#999">GENERO</td>
    </tr>
  <tr>
    <td colspan="5">Masculino</td>
    </tr>
  <tr>
    <td colspan="5"style="background-color:#999">ESTADO CIVIL</td>
    </tr>
  <tr>
    <td colspan="5"><%= fn.getSexo() %></td>
    </tr>
  <tr>
    <td colspan="6"style="background-color:#999">INFORMAÇÕES DEMOGRÁFICA</td>
  </tr>
  <tr>
    <td>Telefone</td>
    <td colspan="3"><%= fn.getEditfone() %></td>
    <td width="8%">Email</td>
    <td width="24%"><%= fn.getEmail() %></td>
  </tr>
  <tr>
    <td>Endereço</td>
    <td colspan="5"><%= fn.getEndereco()%></td>
  </tr>
  <tr>
    <td colspan="6"style="background-color:#999">INFORMAÇÕES PROFISSIONAIS</td>
  </tr>
  <tr>
    <td>Profissão</td>
    <td colspan="3"><%= fn.getId_provincia() %></td>
    <td>Função </td>
    <td><%= fn.getNumInterno() %></td>
  </tr>
  <tr>
    <td height="23">Nº Segurança Social</td>
    <td width="12%"><%= fn.getNumDoc() %></td>
    <td width="15%">Nº Contribuinte: </td>
    <td width="19%"><%= fn.getNumDoc() %></td>
    <td>Salário</td>
    <td> <%= fn.getSalario() %></td>
  </tr>
</table>
</div>
</body>
</html>