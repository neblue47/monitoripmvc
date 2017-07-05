<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row">
 	<div class="col-md-12">	
     <ul >
          <% 
          String mod = request.getParameter("mod");
          String cont = request.getParameter("pesquisar");
       // Telas do Administracao
          if(mod.equals("ad")){
	          if(cont!=null && !cont.equals(""))
	          {  
	        	  if(cont.equals("f") )   {
	     		     %>
	     		     <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ad'}" > 
	     		           <li <c:if test="${md.codTela eq 'f'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>  
	                 <% }
	        	  if (cont.equals("p") || cont.equals("Pesquisar")) { %>
	                <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ad'}" > 
	     		           <li <c:if test="${md.codTela eq 'p'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
	                <% } 
				 if (cont.equals("u")) { %>
	                
		                <c:forEach var="md" items="${AcessoTelas}">
		     		        <c:if test="${md.codCl eq 'ad'}" > 
		     		           <li <c:if test="${md.codTela eq 'u'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
		     		        </c:if>
					    </c:forEach>
	                <% }
				 
				 if (cont.equals("eq")) { %>
		              <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ad'}" > 
	     		           <li <c:if test="${md.codTela eq 'eq'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>	                
	                <% }
				 
		         if (cont.equals("edit")) { %>
	                
		                <li ><a onclick = "window.history.back()" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
		                <li class="ative"><a href="#">Editando<span></span></a></li>
		                
	                <% }
		         if (cont.equals("arq")) { %>
		                <li ><a onclick = "window.history.back()" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
		                <li class="ative"><a href="#">Upload Arquivo<span></span></a></li>
	                <%}
	          }
          }//- Fim Modulo Administracao (telas) 
             
       //   <!-- MODULO SERVIÇO -->  
            
         if(mod.equals("ag")) {
            	 
            	  if(cont!=null && !cont.equals("")){
            		  if(cont.equals("pc")){%>
              		<!-- MENU SERVIÇO -->
                      <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ag'}" > 
	     		           <li <c:if test="${md.codTela eq 'pc'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
              		<% }
            		  
            		  if(cont.equals("ps")){%>
                      <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ag'}" > 
	     		           <li <c:if test="${md.codTela eq 'ps'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>	 
              		 <% }
            		  
            		  if(cont.equals("rq")){%>
                      <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ag'}" > 
	     		           <li <c:if test="${md.codTela eq 'rq'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>	 
              		 <% }
            		  
            		  if(cont.equals("ht")){%>
                      <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ag'}" > 
	     		           <li <c:if test="${md.codTela eq 'ht'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
              		 <% }
            		  
            		  if(cont.equals("rt")||cont.equals("rtd")||cont.equals("rts")||cont.equals("rtm")){%>
                      <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ag'}" > 
	     		           <li <c:if test="${md.codTela eq 'rt' or md.codTela eq 'rtd' or md.codTela eq 'rts' or  md.codTela eq 'rtm' }" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
              		 <% }
            		  
            		  if(cont.equals("not")){%>
                       <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ag'}" > 
	     		           <li <c:if test="${md.codTela eq 'not'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
              		 <% }
            		  
                     if(cont.equals("mts")){%>
                       <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'ag'}" > 
	     		           <li <c:if test="${md.codTela eq 'mts'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
                     <%}
            	  }
                }
         //   <!-- MODULO configuracao -->  
             if(mod.equals("cf")) {
            	 if(cont!=null && !cont.equals("")){
            		 if(cont.equals("nc")){%>
                 	  <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'nc'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
                     
               <%}
                 if(cont.equals("mt")){%>
                     <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'mt'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach> 
                 <%}
                 if(cont.equals("cm")){%>
	              	 <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'cm'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
                <%}
                 
                 if(cont.equals("ns")){%>
             	 	 <c:forEach var="md" items="${AcessoTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'ns'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
					  </c:forEach>
                <%}
                 
                 if(cont.equals("acss")){%>
         	 	 <li ><a href="navegacao?mod=cf" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
             	 <c:forEach var="md" items="${AcessoPrivTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'ns'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
				</c:forEach>           
              <%}
                 if(cont.equals("actela")){%>
         	 	 <li ><a href="navegacao?mod=cf" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
             	 <c:forEach var="md" items="${AcessoPrivTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'actela'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
				</c:forEach>            
              <%}
                 if(cont.equals("acmdl")){%>
         	 	 <li ><a href="navegacao?mod=cf" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
             	 <c:forEach var="md" items="${AcessoPrivTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'acmdl'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
				</c:forEach>     
             	           
              <%}
                 if(cont.equals("acssu")){%>
         	 	 <li ><a href="navegacao?mod=cf" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
             	 <c:forEach var="md" items="${AcessoPrivTelas}">
	     		        <c:if test="${md.codCl eq 'cf'}" > 
	     		           <li <c:if test="${md.codTela eq 'acssu'}" >class="ative"</c:if>><a href="${md.mdlink}?mod=${md.codCl}&pesquisar=${md.codTela}" 	>   ${md.tela}</a></li>
	     		        </c:if>
				</c:forEach>         
              <%}
                 
                
            	 }
            }
             if(mod.equals("ajd")) {%>
            	 <!-- MENU AJUDA -->
	                    <li class="ative"><a href="#">Ajuda</a></li>
	                    
            <% }  %>
          </ul>
      </div>
    </div>