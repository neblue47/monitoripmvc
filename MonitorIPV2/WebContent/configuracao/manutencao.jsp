<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!-- 	<script src="tmp/jquery-1.8.2.js"></script> -->
<!--     <script src="js/form-validation.js"></script> -->
<!--     <script src="js/addcampos.js"></script> -->
<!-- 	<script src="tmp/jquery-ui.js"></script> -->
<!--     <script src="tmp/jquery.maskedinput-1.3.min.js"></script> -->
 <div class="row">
		<div class="col-md-7" >			
			 <c:if test="${not empty logs_manutencao}">		
			 	  <div class="widget-title">
								 			  
				  <h5><i class="fa fa-th"></i> Lista de Armarios </h5>
				  <table id="table" data-toggle="table" data-height="468" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Nome do Posto" data-align="left">Descrição do Posto</th>
								<th data-field="Local Ocorrencia" data-align="left">Local Ocorrencia</th>
								<th data-field="Data Evento" data-align="center">Data Evento</th>
								<th data-field="Hora Evento" data-align="center">Hora Evento</th>
								<th data-field="Acçao" data-align="center">Acção</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${logs_manutencao}">
							<tr>
								<td> ${at.nomPosto}</td>
								<td> ${at.endereco}</td>
								<td><fmt:formatDate value="${at.dataEv.time}" pattern="dd/MM/yyyy"/></td>
								<td>${at.horaEvento}</td>
								<td>
								<a href="navegacao?mod=ag&pesquisar=mts&cod=${at.idPosto}&codp=${at.fk_historico}&data=<fmt:formatDate value="${at.dataEv.time}" pattern="dd/MM/yyyy"/>">								  	
								  		<i class="glyphicon glyphicon-wrench" title="fix"></i>								  														
								  	</a>
								</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
			
			
			</div>	
			</c:if>
			<c:if test="${empty logs_manutencao}">
					 <div class="widget-title">
					 	  <h5><i class="fa fa-th"></i> Lista de Armarios </h5>
						  <div id="agenda-perfil">						
								<p  style="color:#CC0033; text-align:center">Nenhum registo localizado</p>
						  </div>
					</div>
			</c:if>
	  </div>
	  <div class="col-md-5">
		   <form method="get" action="SensorController">
     			 <div class="widget-title pesAdmin">
     			 	  <h5><i class="fa fa-th"></i> Manutenção Armario / Posto </h5>
     			 	  <div id="agenda-perfil">     			 
           				   <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Descrição : </span>	            			
	            			 	<input class="form-control" name="desc" type="text" value="${posto.descricao }" readonly="readonly"/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Designação da Caixa : </span>	            			
	            			 	<input class="form-control" name="nomep" type="text" value="${posto.nomPosto }" readonly="readonly"/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon"> Equipa de Manutenção </span>   		   
	             			  <select class="form-control"  name="equipa" id="equipa" required="required" >
				             		   <option value="">-- Seleccione ---</option>
				             		  <c:forEach items="${lista_eq }" var="pr" varStatus="loop">
				             		   	<option value="${pr.id_equipa }" > ${pr.nome_equipe } </option>
				             		  </c:forEach>            
				             </select>			 
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust">
				     		  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i> Data  </span>
				     		  <input name="data"  type="text" class="form-control datepicker-1" data-date-format="dd/mm/yyyy" required="required"  />         		               	 	
			     		  </div>
			     		  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Observacao </span>	            			
	            			 	<textarea rows="" cols="" class="form-control" name="obs"></textarea>
	        			  </div>	        				   
     					   	    <input type="hidden" name="historico" value = "${posto.fk_historico }">	
     					   	    <input type="hidden" name="armario"   value = "${posto.idPosto }">
     					   	    <input type="hidden" name="dataEv"   value = "${param.data }">			    			   	  				
					  </div>
					  
					  <br/>
				 </div>
				 <div class="pull-right">						
					            <button type="submit" class="btn btn-success btn-sm" name="salvar" id="acao" value="editar"  <c:if test="${empty posto }">disabled</c:if>>
										  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
								</button>
								
					            <button type="reset" class="btn btn-primary btn-sm" value="Limpar" value="Limpar" name ="excluir" ${hab2}>
									 	 	<span class="fa fa-eraser" aria-hidden="true"></span> Limpar
							    </button>
							</div>
			</form>
		</div>	
 </div>

<script>
$('.datepicker-1').datepicker().on('changeDate', function (e) {
	carregarBt(),$('.datepicker-1').datepicker('hide')
});


    function carregarBt(){
	  
    	var data = $('.datepicker-1').val();
    	var btacao = document.getElementById('acao') ;
	  

	    var objDate = new Date();
	    objDate.setYear(data.split("/")[2]);
	    objDate.setMonth(data.split("/")[1]  - 1);//- 1 pq em js é de 0 a 11 os meses
	    objDate.setDate(data.split("/")[0]);
	
	    if(objDate.getTime() > new Date().getTime()){
	     // alert("O dia passado é maior que a data atual..");
	      swal("", "O dia passado é maior que a data atual!", "warning")
			btacao.disabled = true;
	    }
	    if(objDate.getTime() <= new Date().getTime()){  
	 
			btacao.disabled = false;
	    }      
	    
	}
	  
</script>
	<script  >
	  
	</script>
 