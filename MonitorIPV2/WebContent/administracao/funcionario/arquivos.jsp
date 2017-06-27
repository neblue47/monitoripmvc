<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
  String id = request.getParameter("cod");
%>
<div class="rowm">
	<div class="col-md-6 col-md-offset-3">
		<form action="UploadFile" method="post" enctype="multipart/form-data">
			<div class="widget-title tratamento-recom">
			 		<h5><i class="fa fa-tasks"></i> Arquivos</h5>	
			 		<div id="agenda-perfil">
					 
						 
							 <div class="form-group">
							 <label>Fotografia </label>
							    <div class="fileupload fileupload-new" data-provides="fileupload">
							        <div class="input-group">
							            <div class="form-control uneditable-input"><i class="icon-file fileupload-exists"></i> 
							                <span class="fileupload-preview"></span>
							            </div>
							            <div class="input-group-btn">							            	
							                <a class="btn btn-primary btn-file btn-search">
							                    <span class="fileupload-new"><i class="glyphicon glyphicon-folder-open"></i> &nbsp;Selecione o ficheiro</span>
							                    <span class="fileupload-exists"><i class="glyphicon glyphicon-edit"></i> &nbsp;Mudar</span>
							                    <input type="file" class="file-input" name="foto" id="foto" accept="image/*"/>
							                </a>
							                <a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload"><i class="glyphicon glyphicon-trash"></i> &nbsp;Remover</a>
							            </div>
							        </div>
							    </div>
							</div>
					     
					    				       
				     
				    
				             
		     	</div>
		     </div>
		             
		     <div class="pull-right">
		     	<input name="id" id="id" type="hidden" value="${codEnt }" /> 
			   	<input type="hidden" name="acao" value="salvar"/>
			   	<button type="submit" class="btn btn-success btn-sm">
				  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
				</button>
				<button type="button" onclick="voltar();" class="btn btn-default btn-sm">
				  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Cancelar
				</button>
			</div>	        	            
		</form>
	</div>
</div>

<script type="text/javascript" src="js/js-table/file-input-upload.js"></script>
<script type="text/javascript">
function voltar(){
	location.href="navegacaoad?&mod=ad&pesquisar=p";
}
</script>
