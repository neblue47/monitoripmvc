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
			 <c:if test="${not empty armarios}">		
			 	  <div class="widget-title">
								 			  
				  <h5><i class="fa fa-th"></i> Lista de Armarios </h5>
				  <table id="table" data-toggle="table" data-height="468" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Descricao" data-align="left">Descricao Google</th>
								<th data-field="Nome Posto" data-align="left">Nome Posto</th>
								<th data-field="Lampada" data-align="center"># Lampadas</th>
								<th data-field="Editar" data-align="center">Editar</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${armarios}">
							<tr>
								<td>${at.descricao}</td>
								<td>${at.nomPosto}</td>
								<td>${at.qdtLampada}</td>
								
								<td>
								  	
								  	<a href="navegacao?mod=cf&pesquisar=mt&cod=${at.idPosto}">								  	
								  		<i class="glyphicon glyphicon-wrench" title="Novo Utilizador"></i>								  														
								  	</a>								
								</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
			
			
			</div>	
			</c:if>
			<c:if test="${empty armarios}">
					 <div class="widget-title">
					 	  <h5><i class="fa fa-th"></i> Lista de Armários </h5>
						  <div id="agenda-perfil">						
								<p  style="color:#CC0033; text-align:center">Nenhum registo localizado</p>
						  </div>
					</div>
			</c:if>
	  </div>
	  <div class="col-md-5">
		   <form method="get" action="PostosController">
     			 <div class="widget-title pesAdmin">
     			 	  <h5><i class="fa fa-th"></i> Gestão de Armários / Postos </h5>
     			 	  <div id="agenda-perfil">     			 
           				   <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Descrição : </span>	            			
	            			 	<input class="form-control" name="desc" type="text" value="${posto.descricao }" readonly="readonly"/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Designação da Caixa : </span>	            			
	            			 	<input class="form-control" name="nomep" type="text" value="${posto.nomPosto }"/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon"> Província </span>   		   
	             			  <select class="form-control"  name="provincia" id="provincia" required="required" >
				             		  <option value="">-- Seleccione Provincia ---</option>
				             		  <c:forEach items="${provincia }" var="pr" varStatus="loop">
				             		   	<option value="${pr.provincia }" <c:if test="${pr.provincia == posto.fk_provincia}">selected</c:if>> ${pr.nomeProv } </option>
				             		  </c:forEach>            
				             </select>			
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon"> Municipio </span>   		   
	             			  <select class="form-control"  name="municipio" id="municipio" required="required" >
				             		 <option > -- Seleccione -- </option>           
				             </select>			
	        			  </div>
	        			   <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon"> Distrito </span>   		   
	             			  <select class="form-control"  name="distrito" id="distrito" required="required" >
				             		  <option> -- Seleccione -- </option>             
				             </select>			
	        			    </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Nº de Lampadas : </span>	            			
	            			 	<input class="form-control" name="qdtLp" type="text" value="${posto.qdtLampada }"/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Latitude : </span>	            			
	            			 	<span id="lat_c"><input class="form-control" name="lat" id="lat" type="text" value="${posto.latitude }" readonly="readonly"/></span>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Longitude : </span>	            			
	            			 	<span id="lng_c"><input class="form-control" name="lng" id="lng" type="text" value="${posto.longitude }" readonly="readonly"/></span>
	        			  </div>	        				   
     					   	    <input type="hidden" name="fkUsuario" value = "${fkUsuario }">	
     					   	    <input type="hidden" name="idposto"   value = "${posto.idPosto }">			    			   	  				
					  </div>
					  
					  <br/>
				 </div>
				 <div class="pull-right">						
					            <button type="submit" class="btn btn-success btn-sm" name="salvar" value="editar" >
										  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
								</button>
			
					            <button type="button" class="btn btn-danger btn-sm" data-toggle="button" value="Limpar" name ="excluir" onclick="excluir('${posto.idPosto }')">
									 	 	<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Eliminar
							    </button>
							    
							    <button type="button" class="btn btn-default btn-sm"  data-toggle="button" value="cancel" name ="cancel" onclick="confirmCancel()">
									 	 	<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span> Cancelar
							    </button>
							</div>
			</form>
		</div>	
 </div>

<script>
function confirmCancel() {     
	swal({
		title : "",
		text : "Deseja cancelar?",
		type : "warning",
		showCancelButton : true,
		cancelButtonText : "Não",
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "Sim!",
		closeOnConfirm : false			
	}, function() {
		location.href="navegacao?mod=cf&pesquisar=mt";  
	}); 
	}

</script>
 