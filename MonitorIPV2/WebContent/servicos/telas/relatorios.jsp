<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="atg" %> 

<div class="row">	
	<div class="col-md-4">
		<div class="widget-title widget-btn">
			<form name="triados">		     
		     	 <div class="pacient-selecionado">
		     	 	<input type="text" name="txtpesq" id="txtpesq" value="Modelo de Relatório" readonly="readonly"/>
		     	 	<input type="hidden" name="txtcod"  id="txtcod" value="18"/>
		     	 </div> 			     
			     <input type="button" value="Diário" class="btn btn-primary btn-block" data-toggle="button" onClick="diario();"/>
			     <input type="button" value="Semanal" class="btn btn-primary btn-block" data-toggle="button" onclick="semanal();" />
			     <input type="button" value="Mensal" class="btn btn-primary btn-block" data-toggle="button" onclick="mensal();">
			     <input type="button" value="Equipa" class="btn btn-primary btn-block btn-active-proc" data-toggle="button" onclick="funcionario();">
		    </form>
		</div>
	</div>
	<div class="col-md-8">
		<form name="form1" method="get" action="navegacao">
			<div class="col-md-12">
			 	<div class="widget-title">
			 		<h5><i class="fa fa-tasks"></i> Emitir Relatorio - Equipa de Manutenção </h5>
			 		<div id="agenda-perfil">
			 			<div class="form-group input-group input-group-addon-ajust">
			       	 	<span class="input-group-addon">Equipa:</span>                    
	                    <select class="form-control" name="equipa" required="required">
                 			<option value=""> selecione equipa </option> 	 
						  	<c:forEach var="at" items="${lista_eq }"> 
						  	<option value="${at.id_equipa}"> ${at.nome_equipe } </option>
						  	</c:forEach>
		                </select> 
		           		</div>
			     		 <div class="form-group input-group input-group-addon-ajust">
				     		  <span class="input-group-addon">  Mês: </span>
				     		  <select name="mess" class="form-control" >
				     		  		<option value="0"> selecione o mes</option>
				     		    <c:forEach var="ds" items="${meses}">
					             	<option value="${ds.id_mes}" <c:if test="${ds.id_mes == data.mes}">selected</c:if>> ${ds.mes} </option>
					             </c:forEach>
				     		  </select>         		               	 	
			     		 </div>
			     		 <div class="form-group input-group input-group-addon-ajust">
				     		  <span class="input-group-addon"> Ano:  </span>
				     		  <input class="form-control" id="ano" name="ano" required="required" pattern="[0-9]+$">        		               	 	
			     		 </div>
					</div>
				</div>
			    <input type="hidden" name="mod" value="ag">
				<input type="hidden" name="pesquisar" value="rt">	
				<div class="pull-right">
					<button type="submit" class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span> Pesquisar
					</button>
				</div>
			</div>			
		</form>
	</div>
</div>
<script>
$('.datepicker-1').datepicker().on('changeDate', function (e) {
    $('.datepicker-1').datepicker('hide')
});
$('.datepicker-2').datepicker().on('changeDate', function (e) {
    $('.datepicker-2').datepicker('hide')
});
</script>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
  	<script type="text/javascript" src="js/autocomple-ui.js"></script>