<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	<script src="tmp/jquery-1.8.2.js"></script>
    <script src="js/form-validation.js"></script>
    <script src="js/addcampos.js"></script>
	<script src="tmp/jquery-ui.js"></script>
    <script src="tmp/jquery.maskedinput-1.3.min.js"></script>
 
 <div class="row">
 	  <div class="col-md-6">
		    		
			 	  <div class="widget-title">			 			  
				  <h5><i class="fa fa-th"></i> Notificantes</h5>
				  <table id="table" data-toggle="table" data-height="468" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Nome Completo" data-align="left">Name Completo</th>
								<th data-field="Data Notificação" data-align="center">Data Notificação</th>
								<th data-field="Acção" data-align="center">Acção</th>
							</tr>
					  </thead>
		  			  <c:forEach var="at" items="${lsNotas}">
		  			  <tbody>
							<tr>
								<td>${at.nome} </td>
								<td><fmt:formatDate value="${at.dataRegisto.time}"	pattern="dd/MM/yyyy" /></td>
								<td>
								  	<a href="navegacao?mod=ag&pesquisar=not&cod=${at.id_notificacao}">								  	
								  		<i class="glyphicon glyphicon-eye-open" title="Adicionar"></i>								  														
								  	</a>									
								</td>
						    </tr>
					</tbody>
					</c:forEach>
				</table>
				</div>			
			</div>	
			
		  <div class="col-md-6">	
		  <div class="widget-title pesAdmin">
     			 	  <h5><i class="fa fa-th"></i> Notificação </h5>
     			 	  <div id="agenda-perfil">     			 
	        				<div class="form-group input-group ">
	        				 	 <span class="input-group-addon"> Notificante : </span>	            			
	            			 	 <input class="form-control" name="nomep" type="text" readonly="readonly" value="${nota.nome}"/>
	        				</div>
	        				<div class="form-group input-group ">
	        				 	 <span class="input-group-addon"> Data Ocorrência : </span>	            			
	            			 	 <input class="form-control" name="data" type="text" value="<fmt:formatDate value="${nota.dataRegisto.time}"	pattern="dd/MM/yyyy" />" readonly="readonly" />
	        				</div>	        				   
           					
           					<div class="form-group input-group">
								<span class="input-group-addon"> Mensagem : </span>
								<textarea class="form-control" name="msg" readonly="readonly">${nota.notificacao}</textarea>  	   	
							</div>			   	  				
					  </div>
				 </div>
				 <div class="pull-right">
					<a   class="btn btn-default btn-sm"  href="navegacao?mod=ag&pesquisar=not">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Limpar
					</a>
					 
				</div>
	  </div>	
 </div>


 