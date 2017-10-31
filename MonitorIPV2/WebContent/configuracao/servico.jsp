<%@ page language="java" contentType="text/html; charset=UTF-8"     %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container">
	<div class="menus_destaq">
	   <div class="row">    
		    <c:forEach var="md" items="${AcessoConfigTelas}">
				<c:if test="${md.codCl eq 'cf'}" >
		        <div class="col-md-6">
				     <a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}">   
				    	<div class="thumbnail">
			    			<div class="caption">
					    		   <c:if test="${md.codTela eq 'nc'}" ><img src="icons/maisposto.png" /></c:if> 
					    		   <c:if test="${md.codTela eq 'mt'}" ><img src="icons/Folder_categorize_fix.png" /></c:if> 
					    		   <c:if test="${md.codTela eq 'cm'}" ><img src="icons/Folder_categorize_fix.png" /></c:if>
					    		   <c:if test="${md.codTela eq 'ns'}" ><img src="icons/Folder_categorize_fix.png" /></c:if>   
					    		   ${md.tela}
					    	</div>
				    	</div>
				    </a> 
				</div>
			</c:if>
			</c:forEach> 
			<c:if test="${nivelUs == 1 }">
          	<div class="col-md-6">
			     <a href="navegacao?mod=cf&pesquisar=acssu">
				    <div class="thumbnail">
				    	<div class="caption">
				       		<img src="icons/acesso.jpg" />Acessos
				        </div>	  	
				 	</div>
				 </a>
	  		</div>
          </c:if>	
		    
	 		</div>
	</div>
</div>