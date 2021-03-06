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
			     <input type="button" value="Diário" class="btn btn-primary btn-block " data-toggle="button" onClick="diario();"/>
			     <input type="button" value="Semanal" class="btn btn-primary btn-block btn-active-proc" data-toggle="button" onclick="semanal();" />
			     <input type="button" value="Mensal" class="btn btn-primary btn-block" data-toggle="button" onclick="mensal();">
			     <input type="button" value="Equipa" class="btn btn-primary btn-block" data-toggle="button" onclick="funcionario();">
		    </form>
		</div>
	</div>
	<div class="col-md-8">
		<c:if test="${empty listaLogs }">
	 	<form name="form1" method="get" action="navegacao">
			<div class="col-md-12">
			 	<div class="widget-title">
			 		<h5><i class="fa fa-tasks"></i> Emitir Relatorio - Semanal </h5>
			 		<div id="agenda-perfil">
			 			<div class="form-group input-group input-group-addon-ajust">
			       	 	<span class="input-group-addon">Armario / Posto:</span>                    
	                    <input class="form-control" id="armario" name="armario" required="required">
		           		</div>
			     		 <div class="form-group input-group input-group-addon-ajust">
				     		  <span class="input-group-addon">  Mês: </span>
				     		  <select name="mess" class="form-control" required="required">
				     		    <option value=""> selecione o mes</option>
				     		    <c:forEach var="ds" items="${meses}">
					             	<option value="${ds.id_mes}" <c:if test="${ds.id_mes == data.mes}">selected</c:if>> ${ds.mes} </option>
					             </c:forEach>
				     		  </select>         		               	 	
			     		 </div>
			     		 <div class="form-group input-group input-group-addon-ajust">
				     		  <span class="input-group-addon"> Semana:  </span>
				     		  <select name="semana" class="form-control" required="required">
				     		    <option value=""> selecione a semana</option>
				     		    <option value="1"> semana 1 </option>
				     		    <option value="2"> semana 2</option>
				     		    <option value="3"> semana 3</option>
				     		    <option value="4"> semana 4</option>
				     		  </select>         		               	 	
			     		 </div>
					</div>
				</div>
				<input type="hidden" name="mod" value="ag">
				<input type="hidden" name="pesquisar" value="rts">	
				<div class="pull-right">
					<button type="submit" class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span> Pesquisar
					</button>
				</div>
			</div>			
		</form>
		</c:if>
		
		<c:if test="${not empty listaLogs }">
	 <div class="row">
    		<div class="col-md-12">
    			<div class="widget-title">
				 	  <h5><i class="glyphicon glyphicon-user"></i>  ${listaLogs[0].nomPosto}  </h5>
				 	 <p style="margin-top: 2px; font-size: 16pt; color: #fff;">${fundo} |</p>
				 </div>
    		</div>
    	</div>
	  <div class="widget-title">			 			  
				  <h5><i class="fa fa-th"></i> Históricos de Manutenção</h5>
				  <table id="table" data-toggle="table" data-height="408" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Equipa" data-align="center">Equipa</th>
								<th data-field="Local" data-align="center">Local</th>
								<th data-field="Data" data-align="center">Data </th>
								<th data-field="Hora" data-align="center">Hora </th>
								<th data-field="Observação" data-align="center">Observação</th>
								
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${listaLogs}">
							<tr>
								<td>${at.nomEquipa}</td>
								<td>${at.endereco}</td>
								<td><fmt:formatDate value="${at.dataEv.time}" pattern="dd/MM/yyyy"/> </td>
								<td>${at.horaEvento}</td>
								<td>${at.descricao}</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
				</div>
				<div class="pull-right">
					<a href="navegacao?mod=ag&pesquisar=rts"  class="btn btn-default btn-sm"  >
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Cancelar
					</a>
					<button type="submit" class="btn btn-primary btn-sm" name="relat">
						<span class="glyphicon glyphicon-print" aria-hidden="true"></span> Imprimir
					</button>
				</div>
	 </c:if>
	</div>
</div>
<script >
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