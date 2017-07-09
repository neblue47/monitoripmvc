<%@ page language="java" contentType="text/html; charset=UTF-8"     %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">
	<div class="menus_destaq">
	   <div class="row"> 
	           
		     
		    <c:forEach var="md" items="${AcessoTelas}">
				<c:if test="${md.codCl eq 'ad'}" >
		        <div class="col-md-6">
				     <a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}">   
				    	<div class="thumbnail">
			    			<div class="caption">
					    		   <c:if test="${md.codTela eq 'f'}" ><img src="icons/cadastfunciona.png" /></c:if> 
					    		   <c:if test="${md.codTela eq 'p'}" ><img src="icons/consulta-icon.png" /></c:if> 
					    		   <c:if test="${md.codTela eq 'u'}" ><img src="icons/icone-paciente.png" /></c:if>  
					    		   <c:if test="${md.codTela eq 'eq'}" ><img src="icons/servico.png" /></c:if> 
					    		   ${md.tela}
					    	</div>
				    	</div>
				    </a> 
				</div>
			</c:if>
			</c:forEach> 
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