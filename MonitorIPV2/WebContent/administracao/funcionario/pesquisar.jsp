<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	<script src="tmp/jquery-1.8.2.js"></script>
    <script src="js/form-validation.js"></script>
    <script src="js/addcampos.js"></script>
	<script src="tmp/jquery-ui.js"></script>
    <script src="tmp/jquery.maskedinput-1.3.min.js"></script>
 <div class="row">
 	  
		<div class="col-md-12">	

		  <div class="widget-title">
			<h5><i class="fa fa-th"></i> Gestão de Funcionario</h5>
			<form action="navegacao" method="get">	
			<div id="agenda-perfil" >
			<div class="form-group input-group">
				       	<span class="input-group-addon">Pesquisa </span>                    
		                <input type="text" name="valorp"  class="form-control"  placeholder="pesquisar por nome ou numero interno e pressione enter	" required="required"/>			           	 	
			        </div>	
			        <input type="hidden" name="mod" value="ad" />
			        <input type="hidden" name="pesquisar" value="p">			
			</div>
	     </form> 
		</div>	
			 	  <div class="widget-title">			 			  
				  <h5><i class="fa fa-th"></i> Lista dos Funcionarios </h5>
				  <table id="table" data-toggle="table" data-height="380" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Completo" data-align="left">Name Completo</th>
								<th data-field="Telefone" data-align="center">Telefone</th>
								<th data-field="E-mail" data-align="center">E-mail</th>
								<th data-field="Endereço" data-align="left">Endereço</th>
								<th data-field="Acção" data-align="center" data-width="15%">Acção</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${lista}">
							<tr>
								<td>${at.nome} ${at.snome}</td>
								<td>${at.editfone}</td>
								<td>${at.email}</td>
								<td>${at.endereco}</td>
								<td>
								  	<a href="navegacao?mod=ad&pesquisar=arq&cod=${at.hash_id}">								  	
								  		<i class="glyphicon glyphicon-paperclip" title="Adicionar"></i>								  														
								  	</a>
									 &nbsp;&nbsp;	&nbsp;&nbsp;
									<a 	href="navegacao?mod=ad&pesquisar=edit&valor=${at.hash_id}">										
										<i class="glyphicon glyphicon-edit" title="Modificar"></i>
									</a>
									  
									
								</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>	
	  </div>	
 </div>
  <c:if test="${not empty excluido}">
	<script>
	swal({
		  title: "Eliminado!",
		  text: "Dados Eliminados com sucesso.",
		  showConfirmButton: true
		});

	</script>
	<c:remove var="excluido" />
</c:if>

 