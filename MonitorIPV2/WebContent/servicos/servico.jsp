<%@ page language="java" contentType="text/html; charset=UTF-8"     %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">
	<div class="menus_destaq">
	   <div class="row"> 
	   <c:forEach var="md" items="${AcessoTelas}">
				<c:if test="${md.codCl eq 'ag'}" >
		        <div class="col-md-6">
				     <a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}">   
				    	<div class="thumbnail">
			    			<div class="caption">
					    		   <c:if test="${md.codTela eq 'pc'}" ><img src="icons/monitor.png" /></c:if> 
					    		   <c:if test="${md.codTela eq 'ps'}" ><img src="icons/Map-Marker-icon.png" /></c:if> 
					    		   <c:if test="${md.codTela eq 'ht'}" ><img src="icons/log.png" /></c:if>  
					    		   <c:if test="${md.codTela eq 'rtd' or md.codTela eq 'rt'}" ><img src="icons/relatorio.png" /></c:if>
					    		   <c:if test="${md.codTela eq 'rq'}" ><img src="icons/consulta-icon.png" /></c:if> 
					    		   <c:if test="${md.codTela eq 'not'}" ><img src="icons/notificacao.png" /></c:if>  
					    		   <c:if test="${md.codTela eq 'mts'}" ><img src="icons/Folder_categorize_fix.png" /></c:if> 
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