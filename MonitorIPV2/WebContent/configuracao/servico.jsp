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
			    <a href="navegacao?mod=cf&pesquisar=nc">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/maisposto.png" /> Novo Armario
				    	</div>
			    	</div>
			    </a>
			</div>
			<div class="col-md-6">
			    <a href="navegacao?mod=cf&pesquisar=mt">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/Folder_categorize_fix.png" /> Manutenção
				    	</div>
			    	</div>
			    </a>
			</div>	
			<div class="col-md-6">
			    <a href="navegacao?mod=cf&pesquisar=acss">
			    	<div class="thumbnail">
		    			<div class="caption">
				    		<img src="icons/acesso.jpg" /> Acessos
				    	</div>
			    	</div>
			    </a>
			</div>	  	
 		</div>
	</div>
</div>