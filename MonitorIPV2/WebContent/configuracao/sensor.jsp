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
								 			  
				  <h5><i class="fa fa-th"></i> Lista de Armarios Configurados </h5>
				  <table id="table" data-toggle="table" data-height="468" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Nome Posto" data-align="left">Armario</th>
								<th data-field="Descricao" data-align="left"> Sensor </th>
								<th data-field="Lampada" data-align="center"> Modelo </th>
								<th data-field="Editar" data-align="center">Config</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${armarios}">
							<tr>
								<td>${at.nomPosto}</td>
								<td>${at.nomSensor}</td>
								<td>${at.tipo}</td>
								
								<td>
								  	
								  	<a href="navegacao?mod=cf&pesquisar=ns&cod=${at.idPosto}">								  	
								  		<i class="glyphicon glyphicon-wrench" title="config"></i>								  														
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
					 	  <h5><i class="fa fa-th"></i> Lista de Armarios Configurados </h5>
						  <div id="agenda-perfil">						
								<p  style="color:#CC0033; text-align:center">Nenhum registo localizado</p>
						  </div>
					</div>
			</c:if>
	  </div>
	  <div class="col-md-5">
		   <form method="post" action="SensorController">
     			 <div class="widget-title  ">
     			 	  <h5><i class="fa fa-th"></i> Configurar Sensor </h5>
     			 	  <div id="agenda-perfil">     			 
           				   <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Armário : </span>	            			
	            			 	<input class="form-control" name="desc" type="text" value="${posto.nomPosto }" readonly="readonly"/>
	        			  </div>
	        			  
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Nº de Lampadas : </span>	            			
	            			 	<input class="form-control" name="qdtLp" type="text" value="${posto.qdtLampada }" readonly="readonly"/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Designação Sensor : </span>	            			
	            			 	<input class="form-control" name="sensor" type="text"  required="required"/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Modelo : </span>	            			
	            			 	<span id="lat_c"><input class="form-control" name="modelo"   type="text" required="required"/></span>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust">
			    		 	    <span class="input-group-addon"> Status Sensor : </span>
								<select class="form-control"  name="status" required="required" >
				 						<option   > Seleccione... </option>
				 						<option value="0" <c:if test="${posto.status == 0 }">selected</c:if> > Offline </option>
				 						<option value="1" <c:if test="${posto.status == 1 }">selected</c:if> > Online </option>
             					</select>
             				</div>			          	    	        				   
     					   	    <input type="hidden" name="fkUsuario" value = "${fkUsuario }">	
     					   	    <input type="hidden" name="armario"   value = "${posto.idPosto }">			    			   	  				
					  </div>
					  
					  <br/>
				 </div>
				 <div class="pull-right">						
					            <button type="submit" class="btn btn-success btn-sm" name="salvar" value="salvar" >
										  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
								</button>
			
					            <button type="reset" class="btn btn-primary btn-sm" value="Limpar" value="Limpar" name ="excluir" ${hab2}>
									 	 	<span class="fa fa-eraser" aria-hidden="true"></span> Limpar
							    </button>
							</div>
			</form>
		</div>	
 </div>


 