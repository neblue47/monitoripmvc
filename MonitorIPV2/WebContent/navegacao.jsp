<%@ page language="java" contentType="text/html; charset=UTF-8"     %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<div class="container">
	<div class="menus_destaq">
	   <div class="row">
	    <c:forEach var="md" items="${modulos}">
	    	<div class="col-md-6 menu_central">
	    		<a href="${ md.mdlink}">
	    			<div class="thumbnail">
	    			<div class="caption">			    	
			    		<img src="icons/${ md.imagem_md}" /> ${ md.mod_nome}			    			    
			    	</div>
			    	</div>
			    </a>
		    </div>
	    </c:forEach>
	     <c:if test="${nivelUs == 1 }">
          <div class="col-md-6">
	     <a href="navegacao?mod=ad&pesquisar=rh">
		    <div class="thumbnail">
		    	<div class="caption">
		       		<img src="icons/admintracao-icon.png" />Administração
		        </div>	  	
		 	</div>
		 </a>
	  	</div>
          </c:if>
	    
	  	<div class="col-md-6">
	     <a href="navegacao?mod=ag">
		    <div class="thumbnail">
		    	<div class="caption">
		       		<img src="icons/folder-tools-icon.png" />Serviços
		        </div>	  	
		 	</div>
		 </a>
	  	</div>
	  	<div class="col-md-6">
	     <a href="navegacao?mod=cf">
		    <div class="thumbnail">
		    	<div class="caption">
		       		<img src="icons/Administrative-Tools-icon.png" />Configuração
		        </div>	  	
		 	</div>
		 </a>
	  	</div>
	  	<div class="col-md-6">
	     <a href="navegacao?mod=ajd">
		    <div class="thumbnail">
		    	<div class="caption">
		       		<img src="icons/ajuda-icon.png" />Ajuda
		        </div>	  	
		 	</div>
		 </a>
	  	</div>
	  	</div>	  	
	 </div>
 </div>
