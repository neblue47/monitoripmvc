<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	<script src="tmp/jquery-1.8.2.js"></script>
    <script src="js/form-validation.js"></script>
    <script src="js/addcampos.js"></script>
	<script src="tmp/jquery-ui.js"></script>
    <script src="tmp/jquery.maskedinput-1.3.min.js"></script>
 <div class="row">
		<div class="col-md-8">
		<div class="widget-title">
			<h5><i class="fa fa-th"></i> Gestão de Acessos</h5>
			<form action="navegacao" method="get">	
			<div id="agenda-perfil" >
					<div class="form-group input-group">
				       	<span class="input-group-addon">Pesquisa </span>                    
		                <input type="text" name="valorp"  class="form-control"  placeholder="pesquisar por nome ou numero interno e pressione enter	" required="required"/>			           	 	
			        </div>	
			        <input type="hidden" name="mod" value="cf" />
			        <input type="hidden" name="pesquisar" value="u">			
			</div>
	     </form> 
		</div>	
		  <c:if test="${not empty listaUtilizador}">		
			 	  <div class="widget-title">
								 			  
				  <h5><i class="fa fa-th"></i> Lista de Utilizadores </h5>
				  <table id="table" data-toggle="table" data-height="368" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Nome Completo" data-align="left">Nome Completo</th>
								<th data-field="Utilizador" data-align="left">Utilizador</th>
								<th data-field="Perfil" data-align="left">Perfil</th>
								<th data-field="Associar" data-align="center">Associar</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${listaUtilizador}">
							<tr>
								<td>${at.nomeComp} </td>
								<td>${at.nome}</td>
								<td>${at.perfil}</td> 
								<td>
								  <a href="navegacao?mod=cf&pesquisar=acssu&cod=${at.hash_id}"><i class="glyphicon glyphicon-plus"></i></a>								
								</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>	
			</c:if>
			<c:if test="${empty listaUtilizador}">
				  <c:if test="${aux != 'p'}">
					 <div class="widget-title">
					 	  <h5><i class="fa fa-th"></i> Lista de Utilizadores </h5>
						  <div id="agenda-perfil">						
								<p  style="color:#CC0033; text-align:center">Nenhum registo localizado</p>
						  </div>
					</div>
				</c:if>
			</c:if>
	  </div>
	  <div class="col-md-4">
		   <form method="post" action="usucontroller.do">
     			 <div class="widget-title pesAdmin">
     			 	  <h5><i class="fa fa-th"></i> Privilegios </h5>
     			 	  <div id="agenda-perfil"> 
     			 	  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Nome : </span>	            			
	            		     <input  name="numInt" type="text"  class="form-control" required="required" value="${usuTemp.nome }" readonly="readonly"/>
	      			 </div>
	        			     			 
           				   	        					 
       				  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Perfil : </span> 
	        			 	 <select class="form-control"  name="codmodulo" id="codmodulo" required="required">
           							 <option value=" "> Seleccione </option>
           							 <c:forEach var="atg" items="${listaPerfil}">
				 							<option value="${atg.fk_perfil}" <c:if test="${atg.fk_perfil == usuTemp.fk_perfil}"> selected</c:if>> ${atg.perfil} </option>
									</c:forEach>									                
           					 </select>    		   	             				
	        		  </div>
	        		  
	        		 
	        				 	        				   
     					   <input name="txtid" type="hidden" value="${txtid}"/>
     					    <input name="txtfk" type="hidden" value="${param.cod}"/>					    			   	  				
					  </div>
					  
					  <br/>
				 </div>
				 <div class="pull-right">						
					            <button type="submit" class="btn btn-success btn-sm" name="salvar"   value="Salvar" <c:if test="${ empty usuTemp.fk_perfil or usuTemp.fk_perfil > 0}"> disabled = 'disabled'</c:if>>
										  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
								</button>
					           <button type="submit" class="btn btn-success btn-sm" name="salvar" value="Salvar" <c:if test="${empty usuTemp.fk_perfil or usuTemp.fk_perfil == 0}"> disabled = 'disabled'</c:if>>
										  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Modificar
								</button>
					            <button type="reset" class="btn btn-primary btn-sm" value="Limpar" value="Eliminar" name ="excluir" ${hab2}>
									 	 	<span class="fa fa-eraser" aria-hidden="true"></span> Eliminar
							    </button>
							</div>
			</form>
		</div>	
 </div>
 
<script>

function new_perfil(aux) {
	   window.open("administracao/funcionario/perfil.jsp?cod="+aux, 'Perfil','toolbar=0,scrollbars=1,location=10,directories=0,copyhistory=0,status=0,menubar=0,resizable=1,width=830,height=410,z-lock,screenX=90,screenY=0, Left=300, Top=20')
	   }
</script>

 