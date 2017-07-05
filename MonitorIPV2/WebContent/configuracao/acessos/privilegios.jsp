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
								<td>${at.qtd_telas}</td>
								
								<td>
								  	
								  	<a href="navegacao?mod=cf&pesquisar=acss&acao=edit&perfil=${at.fk_perfil}">								  	
								  		<i class="glyphicon glyphicon-pencil" title="editar"></i>								  														
								  	</a>
								  	|
								  	<a href="#" onclick="novo()">								  	
								  		<i class="glyphicon glyphicon-plus" title="novo"></i>								  														
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

      	 <c:if test="${not empty param.acao and param.acao eq 'edit' }">
      	 <form  action="AcessosController" method="get" id="benificiosForm">
       				<div class="widget-title">
       					  <h5><i class="fa fa-th"></i> Editar Perfil </h5>
       					  <div id="agenda-perfil">       					  
		       				<div class="row pesAdmin"> 
		       				  <div class="col-md-12">         
			        	   		 	  <div class="form-group input-group input-group-addon-ajust">
        				 	<span class="input-group-addon"> Perfil : </span>	            			
            			 	<input class="form-control" name="desc" type="text" value="${tmpPerfil.perfil }"  required="required"/>
        			    </div>
	        		 
       					<div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Módulo : </span>     		   	 
             				 <select class="form-control"  name="codmodulo" id="codmodulo" required="required">
           							 
           							 <c:forEach var="atg" items="${ListaModulos}">
				 							<option value="${atg.id_mod}"> ${atg.modulo} </option>
									</c:forEach>									                
           					 </select>             				
	        			</div>    
			        	   		  </div>
			        	   		 </div>
			        	   		</div>

								<div class="scrolltableContainer">
									<div class="scrollingarea">
										<table class="cruises scrolltable" name="tabela" id="testliprv">
											<thead>
												<tr>
													<th class="analise"><div>Telas</div></th>
													<th class="accao"><div>Seleccione</div></th>
												</tr>
											</thead>
											<tbody>
											 
												<c:forEach var="fc" items="${ListaTelas }">
													<tr>
														<td class="analise"><div>${fc.tela}</div></td>
														<td class="accao"><div><input type="checkbox" name="opcao" value="${at.id_tela }" disabled="disabled" />
															</div></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								 					
			 		</div>
				 <div class="pull-right" >
	       			  <input type="hidden" name = "Idperfil" id = "Idperfil" value="${param.perfil }">                 
	                  
					   <button type="submit" class="btn btn-success btn-sm" name="btpriv">
						  		<span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
					   </button>			 
					   
					   <button type="button" data-toggle="button" onClick="cancelar();" class="btn btn-default btn-sm" name="btpriv">
						  		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Cancelar
					   </button>
					   
					   <button type="button" data-toggle="button" onClick="novo();" class="btn btn-default btn-sm" name="btpriv">
						  		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Novo
					   </button>
				</div>
      	 </form>
      	 </c:if>
      	 
      	 <c:if test="${not empty param.acao and param.acao eq 'novo'}">
      	 <form  action="AcessosController" method="post" id="benificiosForm">
       				<div class="widget-title">
       					  <h5><i class="fa fa-th"></i> Criar Perfil </h5>
       					  <div id="agenda-perfil">       					  
		       				<div class="row pesAdmin"> 
		       				  <div class="col-md-12">         
			        	   		 	  <div class="form-group input-group input-group-addon-ajust">
        				 	<span class="input-group-addon"> Perfil : </span>	            			
            			 	<input class="form-control" name="perfil" type="text"   required="required"/>
        			    </div>
	        		 
       					<div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Módulo : </span>     		   	 
             				 <select class="form-control"  name="codmodulo" id="codmodulo" required="required">
           							 <option value=" "> Seleccione </option>
           							 <c:forEach var="atg" items="${ListaModulos}">
				 							<option value="${atg.id_mod}"> ${atg.modulo} </option>
									</c:forEach>									                
           					 </select>             				
	        			</div>    
			        	   		  </div>
			        	   		 </div>
			        	   		</div>

								<div class="scrolltableContainer">
									<div class="scrollingarea">
										<table class="cruises scrolltable" name="tabela" id="testliprv">
											<thead>
												<tr>
													<th class="analise"><div>Telas</div></th>
													<th class="accao"><div>Seleccione</div></th>
												</tr>
											</thead>
											<tbody>
											 
												<c:forEach var="fc" items="${ListaTelas }">
													<tr>
														<td class="analise"><div>${fc.tela}</div></td>
														<td class="accao"><div><input type="checkbox" name="opcao" value="${at.id_tela }" disabled="disabled" />
															</div></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								 					
			 		</div>
				 <div class="pull-right" >
	       			  <input type="hidden" name = "Idperfil" id = "Idperfil" value="0">                 
	                  
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

<script >
    $(document).ready(function(){
    	$('select[name=codmodulo]').on('change',function(){
    		$.ajax({
    			type: 'GET',
    			url : 'AjaxPrivController',
    			data: 'codmodulo='+$('select[name=codmodulo]').val()+'&'+'idperfil='+$('input[name=Idperfil]').val(),
    			statusCode: {
    				404: function(){
    					alert('Pagina nao encontrada');
    				},
    				500: function(){
    					alert('Erro no servidor');
    				}
    			},
    			success: function (dados){
    				$("#testliprv tbody tr").remove();
    				//$("#testliprv thead tr").remove();
    				var pegados = dados.split(":");
    				if(dados=='')
    					{
    					
    					}
    				else{
//    												
    					for(var i=0;i<pegados.length-1;i++)
    					{
    						var codtela = pegados[i].split("-")[0];
    						var nomtela = pegados[i].split("-")[1];
    					    $("#testliprv tbody").append("<tr  >"+
    						                            "<td class='analise'> <div>"+nomtela+"</div> </td>"+
    	                                                "<td class='accao'> <div><input type='checkbox' name='opcao' id='opcao' value='"+codtela +"' /></div></td>"+
    	                                                "</tr>");
    					}
    			}
    				
    			}
    		});		
    	});
    });
    </script>
    
<style>
#benificiosForm table.cruises { 
    font-size: 14px;
	font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
	border-collapse: collapse; 
    width: 635px;   
    } 
#benificiosForm table.cruises tbody { 
    top: 2.91em;
    height: 255px; 
    width: 633px; 
    overflow-x: hidden; 
    overflow-y: auto;
    position: absolute;
}
#benificiosForm table.cruises tr:first-child td {
    border-top: none;
}
#benificiosForm table.cruises th {     
	padding: 8px 10px;
	background-color:#f4f4f4;  
	color: #222;
	clear: both;   
	line-height: 24px;
    vertical-align: top; 
    font-variant: none;
    border-top: 0;
    border-bottom: 1px solid #dddddd;
    border-right: 1px solid #dddddd;
    border-left: 1px solid #dddddd;
    }
#benificiosForm table.cruises td { 
  	background-color: #fcfcfc; 
  	overflow: hidden; 
  	padding: 8px 10px;
  	border: 1px solid #dddddd;
}
#benificiosForm table.cruises tr:hover { 
  	background-color:#f4f4f4; 
}
#benificiosForm div.scrolltableContainer { 
    position: relative; 
    width: 643px;    
    background-color: #fcfcfc;
    border-top: 1px solid #dddddd;
}
#benificiosForm div.scrollingarea { 
    height: 285px; 
    overflow: auto; 
}
#benificiosForm table.scrolltable thead tr {
    left: 0px; 
    top: 0;
    position: absolute;  
}
#benificiosForm table.cruises .analise  div { width: 395px; text-align:center; }
 
#benificiosForm table.cruises .accao    div { width: 84px;  text-align:center; }
</style>

 