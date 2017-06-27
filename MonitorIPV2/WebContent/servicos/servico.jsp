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
			    <a href="navegacao?mod=ag&pesquisar=pc">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/monitor.png" /> Monitor
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ag&pesquisar=ps">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/Map-Marker-icon.png" /> Armarios / Postos
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ag&pesquisar=ht">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/log.png" /> Historicos
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ag&pesquisar=rtd">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/relatorio.png" /> Relatorios
				    	</div>
			    	</div>
			    </a>
			</div> 
			<div class="col-md-6">
			    <a href="index.jsp?mod=ag&pesquisar=rq">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/icone-paciente.png" /> Equipas
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ag&pesquisar=not">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/notificacao.png" /> Notificações
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=ag&pesquisar=mts">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/Folder_categorize_fix.png" /> Manutenção
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