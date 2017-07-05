<%@ page language="java" contentType="text/html; charset=UTF-8"     %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<div class="container">
	<div class="menus_destaq">
	   <div class="row">
	    <c:forEach var="md" items="${AcessoMudulos}">
	    	<div class="col-md-6 menu_central">
	    		<a href="${md.mdlink}?mod=${md.codCl}">
	    			<div class="thumbnail">
	    			<div class="caption">			    	
			    			<c:if test="${md.codCl eq 'ad'}" ><img src="icons/admintracao-icon.png" /></c:if>
			    			<c:if test="${md.codCl eq 'ag'}" ><img src="icons/folder-tools-icon.png" /></c:if>
			    			<c:if test="${md.codCl eq 'cf'}" ><img src="icons/Administrative-Tools-icon.png" /></c:if>
			    			<c:if test="${md.codCl eq 'ajd'}"><img src="icons/ajuda-icon.png" /></c:if>
						    ${ md.modulo}			    			    
			    	</div>
			    	</div>
			    </a>
		    </div>
	    </c:forEach>
	  	</div>	  	
	 </div>
 </div>
