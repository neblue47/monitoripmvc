<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>

<div class="row"> 
	 <div class="col-md-6 ">	 	  	  			 	  	 
   			   <form  method="post" action="ExtraController" name="nm_frmDados"> 
   					 <div class="widget-title">
   					  	  <h5><i class="fa fa-tasks"></i> Configurar Tempo de Monitor </h5>
   				 		  <div id="agenda-perfil"> 
   				 		  <div class="row">	   				 		  	   					
   						  	   <div class="col-md-12"> 			  	
									   <div class="form-group input-group">
	        				 				<span class="input-group-addon">Tempo Máxima de Autorefresh:</span>	            			
	            			 				<input type="text" class="form-control" required="required" name="tmp" value="${tmp}"    maxlength="5"  pattern="[0-9]+$"/>
	        						   </div>
									 
							   </div>						  
						  	   
				  			</div>
				 	   </div>	
				 </div>
				 <div class="pull-right">
				 <input name="Id" type="hidden" id="Id" value=""/>				 
				 <button type="submit" class="btn btn-success btn-sm" name="Modificar" value="Alterar" id ="salvar">
					  <span class="fa  fa-pencil" aria-hidden="true"></span> Alterar
				  </button>
				  
				  </div>					
			</form>
			<br><br> 
			 <form  method="post" action="ExtraController" name="nm_frmDados"> 
   					 <div class="widget-title">
   					  	  <h5><i class="fa fa-tasks"></i> Configurar Precisão Maps </h5>
   				 		  <div id="agenda-perfil"> 
   				 		  <div class="row">	   				 		  	   					
   						  	   <div class="col-md-12"> 			  	
									   <div class="form-group input-group">
	        				 				<span class="input-group-addon">Ampliar / Reduzir:</span>	            			
	            			 				<input type="text" class="form-control" required="required" name="tamMap" value="${tamMap}"    maxlength="5"  pattern="[0-9]+$"/>
	        						   </div>
									 
							   </div>						  
						  	   
				  			</div>
				 	   </div>	
				 </div>
				 <div class="pull-right">
				 <input name="Id" type="hidden" id="Id" value=""/>				 
				 <button type="submit" class="btn btn-success btn-sm" name="Modificar" value="Alterar" id ="salvar">
					  <span class="fa  fa-pencil" aria-hidden="true"></span> Alterar
				  </button>
				  
				  </div>					
			</form>
	</div>
<div class="col-md-6"> 
 <div class="row">	   				 		  	   					
   <div class="col-md-12"> 	
		<div id="log">
			<jsp:include page="logSensor.jsp"></jsp:include>	 
		</div> 
		<div class="col-md-12 ">	 	  	  			 	  	 
	   			   <form  method="post" action="ExtraController" name="cf_frmDados"> 
	   					 <div class="widget-title">
	   					  	  <h5><i class="fa fa-tasks"></i> Configurar Valores Normais do Armario </h5>
	   				 		  <div id="agenda-perfil"> 
	   				 		  <div class="row">	   				 		  	   					
	   						  	   <div class="col-md-12"> 			  	
										 								  
										   <div class="form-group input-group">
		        				 				<span class="input-group-addon">Valor Normal do Armario (A):</span>	            			
		            			 				<input type="text" class="form-control" required="required" name="normalPosto" value="${postos.normalPosto}"    maxlength="5"   />
		        						   </div>
		        						   <div class="form-group input-group">
		        				 				<span class="input-group-addon">Valor Mediano do Armario (A):</span>	            			
		            			 				<input type="text" class="form-control" required="required" name="medianPosto" value="${postos.medianPosto}"    maxlength="5"   "/>
		        						   </div>
		        						   
								   </div>						  
					  			</div>
					 	   </div>	
					 </div>
					 <div class="pull-right">
					 <input name="Id" type="hidden" id="Id" value=""/>				 
					 <button type="submit" class="btn btn-success btn-sm" name="Modificar" value="Alterar" id ="salvar">
						  <span class="fa  fa-pencil" aria-hidden="true"></span> Alterar
					  </button>
					  
					  </div>					
				</form>
		</div> 
	</div> 
	</div> 
 </div>  	  	  			 	  	 
</div>

   <c:if test="${ not empty msgOk}">
	<script>
	 swal(" ", "Alteracao feita com sucesso!", "success");

	</script>
	<c:remove var="msgOk" />
	</c:if>

<script >
$(document).ready(function(){
 	 
	setInterval(function(){
		$("#log").load('configuracao/logSensor.jsp')
    }, 10000);
	
}); 
</script>

