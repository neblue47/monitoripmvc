<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row">				
			<div class="col-md-9 col-md-offset-3 sub_menu">
              <div id="container">
                <ul>
          		<%
	    
             	    String ative = "class='ative'";
             	    String menu = request.getParameter("mod");
             	    int nivelUs = (int)request.getSession().getAttribute("nivelUs");
             	    String nome_us = "";
                    
		            if(menu.equals("ad") && nivelUs == 1){%>
			          <c:forEach var="md" items="${AcessoMudulos}">
				 			<li><a href="${md.mdlink}?mod=${md.codCl}" <c:if test="${md.codCl eq 'ad'}" >class="ative"</c:if>	> <i class="fa fa-adn"></i> ${md.modulo}</a></li>	
					  </c:forEach>
			          <%} 
		            
		            if(menu.equals("ag")){ %>
		              <c:forEach var="md" items="${AcessoMudulos}">
				 			<li><a href="${md.mdlink}?mod=${md.codCl}" <c:if test="${md.codCl eq 'ag'}" >class="ative"</c:if>	> <i class="fa fa-group"></i> ${md.modulo}</a></li>	
					  </c:forEach>			            
			          <%}
		            if(menu.equals("cf")){ %>
		             <c:forEach var="md" items="${AcessoMudulos}">
				 			<li><a href="${md.mdlink}?mod=${md.codCl}" <c:if test="${md.codCl eq 'cf'}" >class="ative"</c:if>	> <i class="glyphicon glyphicon-cog"></i> ${md.modulo}</a></li>	
					  </c:forEach>
			          <%}
		            if(menu.equals("ajd")) 
			            {%>
			            <c:forEach var="md" items="${AcessoMudulos}">
				 			<li><a href="${md.mdlink}?mod=${md.codCl}" <c:if test="${md.codCl eq 'ajd'}" >class="ative"</c:if>	> <i class="fa fa-question-circle"></i> ${md.modulo}</a></li>	
					   </c:forEach>
			           <%} %>  
		          </ul>   
     		    </div>
          	</div>  
</div>