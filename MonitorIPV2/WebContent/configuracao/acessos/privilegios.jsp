<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	<script src="tmp/jquery-1.8.2.js"></script>
    <script src="js/form-validation.js"></script>
    <script src="js/addcampos.js"></script>
	<script src="tmp/jquery-ui.js"></script>
    <script src="tmp/jquery.maskedinput-1.3.min.js"></script>
 <div class="row">
		<div class="col-md-7" >			
			 <c:if test="${not empty buscarPerifisTelas}">		
			 	  <div class="widget-title">
								 			  
				  <h5><i class="fa fa-th"></i> Lista de Privilégios  </h5>
				  <table id="table" data-toggle="table" data-height="475" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Nome Posto" data-align="left">Perfil</th>
								<th data-field="Descricao" data-align="left"> Módulo </th>
								<th data-field="Lampada" data-align="center"> Nº Telas </th>
								<th data-field="Editar" data-align="center">Acção</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${buscarPerifisTelas}">
							<tr>
								<td>${at.perfil}</td>
								<td>${at.modulo}</td>
								<td>#</td>
								
								<td>
								  	
								  	<a href="navegacao?mod=cf&pesquisar=acss&acao=edit&perfil=${at.fk_perfil}">								  	
								  		<i class="glyphicon glyphicon-hand-right" title="config"></i>								  														
								  	</a>								
								</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
			
			
			</div>	
			</c:if>
			<c:if test="${empty buscarPerifisTelas}">
					 <div class="widget-title">
					 	  <h5><i class="fa fa-th"></i> Lista de Privilégios </h5>
						  <div id="agenda-perfil">						
								<p  style="color:#CC0033; text-align:center">Nenhum registo localizado</p>
						  </div>
					</div>
			</c:if>
	  </div>
	  <div class="col-md-5">
		   
      	 <c:if test="${empty param.acao}">
      	 <form  action="EquipaController" method="get">
       				<div class="widget-title">
       					  <h5><i class="fa fa-th"></i> Criar / Editar Perfil </h5>
       					  <div id="agenda-perfil">       					  
		       				<div class="row pesAdmin"> 
		       				  <div class="col-md-12">         
			        	   		 	  <div class="form-group input-group input-group-addon-ajust">
        				 	<span class="input-group-addon"> Perfil : </span>	            			
            			 	<input class="form-control" name="desc" type="text" value="${posto.nomPosto }"  required="required"/>
        			    </div>
	        		 
       					<div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Módulo : </span>     		   	 
             				 <select class="form-control"  name="estcivil" id="estcivil" required="required">
           							 <c:forEach var="atg" items="${estCivil}">
				 							<option value="${atg.est_civil}"> ${atg.nomeEC} </option>
									</c:forEach>									                
           					 </select>             				
	        			</div>    
			        	   		  </div>
			        	   		 </div>
			        	   		</div>
	        	   		 		<table  id="testli2" data-toggle="table" data-height="340" data-pagination="false" data-search="false" data-show-toggle="false" data-show-columns="false" data-show-refresh="false" >     
					                <thead> 
					                    <tr>
					                        <th data-field="Telas" data-align="center">Telas</th>
						            		<th data-field="Seleccione" data-align="center">Seleccione</th>
					                     </tr>
					                </thead>                  
	                  				<tbody>
	                  					<c:forEach var="at" items="${ListaTelas }">   
	                  					<tr>
	                    					<td>${at.tela }  </td>
	                    					<td><input type="checkbox" name="opcao"  value="${at.id_tela }" /></td>                 
	                  					</tr>
	                  					</c:forEach>	                  					                 
	                  				</tbody>	   						
	            			   </table>						
			 		</div>
				 <div class="pull-right" >
	       			  <input type="hidden" name = "fkFun" value="${param.perfil }">                 
	                   <button type="button" data-toggle="button" onClick="novo();" class="btn btn-default btn-sm" name="btpriv">
						  		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Novo
					   </button>
					   <button type="submit" class="btn btn-success btn-sm" name="btpriv">
						  		<span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
					   </button>			 
					   <button type="reset" class="btn btn-primary btn-sm">
					 	 		<span class="fa fa-eraser" aria-hidden="true"></span> Limpar
					  </button>
				</div>
      	 </form>
      	 </c:if>
      	 
      	 <c:if test="${not empty param.acao}">
      	 <form  action="AcessosController" method="get">
       				<div class="widget-title">
       					  <h5><i class="fa fa-th"></i> Criar Perfil </h5>
       					  <div id="agenda-perfil">       					  
		       				<div class="row pesAdmin"> 
		       				  <div class="col-md-12">         
			        	   		 	  <div class="form-group input-group input-group-addon-ajust">
        				 	<span class="input-group-addon"> Perfil : </span>	            			
            			 	<input class="form-control" name="desc" type="text" value="${tmpPerfil.perfil }"  required="required"/>
        			    </div>
	        		 
       					<div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Módulo : </span>     		   	 
             				 <select class="form-control"  name="modulo" id="modulo" required="required">
           							 <c:forEach var="atg" items="${ListaModulos}">
				 							<option value="${atg.id_mod}"> ${atg.modulo} </option>
									</c:forEach>									                
           					 </select>             				
	        			</div>    
			        	   		  </div>
			        	   		 </div>
			        	   		</div>
	        	   		 		<table  id="testli2" data-toggle="table" data-height="340" data-pagination="false" data-search="false" data-show-toggle="false" data-show-columns="false" data-show-refresh="false" >     
					                <thead> 
					                    <tr>
					                        <th data-field="Telas" data-align="center">Telas</th>
						            		<th data-field="Seleccione" data-align="center">Seleccione</th>
					                     </tr>
					                </thead>                  
	                  				<tbody>
	                  					<c:forEach var="at" items="${ListaTelas }">   
	                  					<tr>
	                    					<td>${at.tela }  </td>
	                    					<td><input type="checkbox" name="opcao"  value="${at.id_tela }" /></td>                 
	                  					</tr>
	                  					</c:forEach>	                  					                 
	                  				</tbody>	   						
	            			   </table>						
			 		</div>
				 <div class="pull-right" >
	       			  <input type="hidden" name = "perfil" id = "Idperfil" value="${param.perfil }">                 
	                  
					   <button type="submit" class="btn btn-success btn-sm" name="btpriv">
						  		<span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
					   </button>			 
					   <button type="reset" class="btn btn-primary btn-sm">
					 	 		<span class="fa fa-eraser" aria-hidden="true"></span> Limpar
					  </button>
					   <button type="button" data-toggle="button" onClick="cancelar();" class="btn btn-default btn-sm" name="btpriv">
						  		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Cancelar
					   </button>
				</div>
      	 </form>
      	 </c:if>
      	 
		</div>	
 </div>
<script>
function novo(){
	location.href="navegacao?mod=cf&pesquisar=acss&acao=novo"; 
}
function cancelar(){
	location.href="navegacao?mod=cf&pesquisar=acss"; 
}
</script>

 