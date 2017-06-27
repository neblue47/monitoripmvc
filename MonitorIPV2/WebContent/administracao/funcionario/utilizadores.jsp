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
			<h5><i class="fa fa-th"></i> Gestão de Funcionario</h5>
			<form action="navegacao" method="get">	
			<div id="agenda-perfil" >
					<div class="form-group input-group">
				       	<span class="input-group-addon">Pesquisa </span>                    
		                <input type="text" name="valorp"  class="form-control"  placeholder="pesquisar por nome ou numero interno e pressione enter	" required="required"/>			           	 	
			        </div>	
			        <input type="hidden" name="mod" value="ad" />
			        <input type="hidden" name="pesquisar" value="u">			
			</div>
	     </form> 
		</div>	
		  <c:if test="${not empty lista}">		
			 	  <div class="widget-title">
								 			  
				  <h5><i class="fa fa-th"></i> Lista de Funcionarios </h5>
				  <table id="table" data-toggle="table" data-height="368" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Completo" data-align="left">Name Completo</th>
								<th data-field="Categoria" data-align="center">Categoria</th>
								<th data-field="Telefone" data-align="center">Telefone</th>
								 
								<th data-field="Utilizador" data-align="center">Utilizador</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${lista}">
							<tr>
								<td>${at.nome} ${at.snome}</td>
								<td>${at.categoria}</td>
								<td>${at.telefone}</td>
								 
								<td>
								  	<a href="navegacao?mod=ad&pesquisar=ut&cod=${at.hash_id}">								  	
								  		<i class="glyphicon glyphicon-hand-right" title="Novo Utilizador"></i>								  														
								  	</a>								
								</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>	
			</c:if>
			<c:if test="${empty lista}">
				  <c:if test="${aux != 'p'}">
					 <div class="widget-title">
					 	  <h5><i class="fa fa-th"></i> Lista de Funcionarios </h5>
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
	        			 	 <span class="input-group-addon">Funcionario : </span>	            			
	            		     <input  name="numInt" type="text"  class="form-control" required="required" value="${nome_c }" readonly="readonly"/>
	      			 </div>
	        			     			 
           				   	        					 
       				  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Grupo: </span>     		   	 
             				 <select class="form-control" name="grupou" id="grupou" required="required">    
                                  <option value=" " <c:if test="${grupou == '0'}"> selected</c:if>> - Selecione - </option>
                                  <option value="1" <c:if test="${grupou == '1'}"> selected</c:if>> Admin-Sistema  </option>
                                  <option value="2" <c:if test="${grupou == '2'}"> selected</c:if>> Tecnico-Sistema </option>
                              </select>             				
	        		  </div>
	        		 
	        				<div class="form-group input-group ">
	        				 	 <span class="input-group-addon"> ID Usuario : </span>	            			
	            			 	 <input class="form-control" name="nomeu" type="text" value="${nomeu}" required="required"/>
	        				</div>
	        				<div class="form-group input-group ">
	        				 	 <span class="input-group-addon"> Senha : </span>	            			
	            			 	 <input class="form-control" name="senha" type="password" value="${senha}" required="required"/>
	        				</div>	        				   
     					   <input name="txtid" type="hidden" value="${txtid}"/>
     					    <input name="txtfk" type="hidden" value="${param.cod}"/>					    			   	  				
					  </div>
					  
					  <br/>
				 </div>
				 <div class="pull-right">						
					            <button type="submit" class="btn btn-success btn-sm" name="salvar" value="Salvar" ${hab1}>
										  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
								</button>
					           <button type="submit" class="btn btn-success btn-sm" name="salvar" value="Salvar" ${hab2}>
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

 