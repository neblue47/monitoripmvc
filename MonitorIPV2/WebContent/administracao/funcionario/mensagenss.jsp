<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1" errorPage=""%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
 >

 atch(NumberFormatException er){}
%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="alert alert-success" id="conFirm">
<%-- 			  <div class="success"><%="" %></div>  --%>
<!-- 		       <div> -->
<!-- 		             <span>Nome Completo: </span> -->
<%-- 		             <span><%= "" %> </span> --%>
<!-- 		       </div> -->
<!-- 		       <div> -->
<!-- 		          <span>Data e Hora do Registo: </span> -->
<%-- 		          <span><%= "" %></span>  --%>
<!-- 		       </div> -->
			</div>
			 <div class="btn-position pull-right">
			 <button type="button" class="btn btn-success btn-sm" onclick="novo();">
				  <span class="fa fa-pencil-square-o" aria-hidden="true"></span> Novo
			  </button>
			  <button type="button" class="btn btn-primary btn-sm" onclick="pesquisar();">
				  <span class="glyphicon glyphicon-search" aria-hidden="true"></span> Pesquisar
			  </button>     
		    </div>
		</div>
	</div>
</div>

<script type="text/javascript">
function pesquisar()
{
	location.href="navegacao?mod=ad&pesquisar=p";
}
function novo()
{
	location.href="navegacao?mod=ad&pesquisar=f";
}
</script>


 