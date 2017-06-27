<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="atg" %>
<%@page import="ao.co.smpip.jdbc.*"%>

<% 
   	Formatando data= new Formatando();
%>
<div class="container">
<div class="row">
<div class="col-md-6 col-md-offset-3">
	<div class="alert alert-success" id="conFirm">
	  <div class="success">Requisição Enviada Com Sucesso</div> 
      <!--  <div>
             <span>Nome Completo: </span>
             <span></span>
       </div> -->
       <div>
          <span>Data e Hora do Registo: </span>
          <span><%= data.dtHora() %></span> 
       </div>
	</div>
	 <div class="btn-position pull-right">
	 <button type="button" class="btn btn-success btn-sm" onclick="nova();">
		  <span class="fa fa-pencil-square-o" aria-hidden="true"></span> Nova
	  </button>    
    </div>
</div>
</div>
</div>
<script type="text/javascript"> 
function modificar()
{
	location.href="navegacaopd?mod=pd&pesquisar=trm";
}
function nova()
{
	location.href="navegacao?mod=ag&pesquisar=rq";
}
</script>

