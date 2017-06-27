<%@ page language="java" contentType="text/html; charset=UTF-8"     %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">
	<div class="menus_destaq">
	   <div class="row">    
		    <c:forEach var="md" items="${telas}">
			    <div class="col-md-6 menu_central">
				    <a href="${ md.linktela}">
					    <div class="thumbnail">
							<div class="caption">
						    	<img src="icons/${ md.imagens_tela}" /> ${ md.tela}
						    </div>
					    </div>
				    </a>
				</div>
		    </c:forEach>
		    <div class="col-md-6">
			    <a href="navegacao?mod=ad&pesquisar=f">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/cadastfunciona.png" /> Novo Funcionario
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ad&pesquisar=p">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/consulta-icon.png" /> Pesquisar Funcionario
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ad&pesquisar=u">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/icone-paciente.png" /> Utilizadores
				    	</div>
			    	</div>
			    </a>
			</div>
			 
			<div class="col-md-6">
			    <a href="navegacao?mod=ad&pesquisar=eq">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/servico.png" /> Equipas Manutenção
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ng">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/voltar.png" /> Voltar
				    	</div>
			    	</div>
			    </a>
			</div> 		  	
 		</div>
 		
	</div>
</div>