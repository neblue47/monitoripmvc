<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
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
	                     <li class="ative"><a href="navegacao?mod=ad&pesquisar=f">Novo Funcionário<span></span></a></li>
	                     <li><a href="navegacao?mod=ad&pesquisar=p">Listar Funcionário<span></span></a></li>
	                     <li><a href="navegacao?mod=ad&pesquisar=u">Utilizadores<span></span></a></li>
	                     <li ><a href="navegacao?mod=ad&pesquisar=eq">Equipas<span></span></a></li>
	                      
	                 <% }
	        	  if (cont.equals("p") || cont.equals("Pesquisar")) { %>
	                
	                	<li ><a href="navegacao?mod=ad&pesquisar=f">Novo Funcionário<span></span></a></li>
	                	<li class="ative"><a href="navegacao?mod=ad&pesquisar=p">Listar Funcionário<span></span></a></li>
	                	<li><a href="navegacao?mod=ad&pesquisar=u">Utilizadores<span></span></a></li>
	                	<li ><a href="navegacao?mod=ad&pesquisar=eq">Equipas<span></span></a></li>
	              	 
	                <% } 
				 if (cont.equals("u")) { %>
	                
		                <li ><a href="navegacao?mod=ad&pesquisar=f">Novo Funcionário<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=p">Listar Funcionário<span></span></a></li>
		                <li class="ative"><a href="navegacao?mod=ad&pesquisar=u">Utilizadores<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=eq">Equipas<span></span></a></li>
	                 
	                
	                <% }
				 
				 if (cont.equals("eq")) { %>
	                
		                <li ><a href="navegacao?mod=ad&pesquisar=f">Novo Funcionário<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=p">Listar Funcionário<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=u">Utilizadores<span></span></a></li>
		                <li class="ative"><a href="navegacao?mod=ad&pesquisar=eq">Equipas<span></span></a></li>
	                 
	                
	                <% }
				 
		         if (cont.equals("edit")) { %>
	                
		                <li ><a onclick = "window.history.back()" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
		                <li class="ative"><a href="#">Editando<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=p">Listar Funcionário<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=u">Utilizadores<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=eq">Equipas<span></span></a></li>
		                <li ><a href="navegacao?mod=ad&pesquisar=ag">Turnos<span></span></a></li>
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
                      <li class="ative"><a href="navegacao?mod=ag&pesquisar=pc">Monitor<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ps">Armários<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ht">Histórico<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=rt">Relatórios<span></span></a></li>
                  	  <li ><a href="navegacao?mod=ag&pesquisar=not">Notificações<span></span></a></li> 
                  	  <li ><a href="navegacao?mod=ag&pesquisar=rq">Equipas<span></span></a></li> 
                  	  <li ><a href="navegacao?mod=ag&pesquisar=mts">Manutenção<span></span></a></li>
              		<% }
            		  
            		  if(cont.equals("ps")){%>
                      <li ><a href="navegacao?mod=ag&pesquisar=pc">Monitor<span></span></a></li>
                      <li class="ative"><a href="navegacao?mod=ag&pesquisar=ps">Armarios<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ht">Histórico<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=rt">Relatórios<span></span></a></li>
                  	  <li ><a href="navegacao?mod=ag&pesquisar=not">Notificações<span></span></a></li> 
                  	  <li ><a href="navegacao?mod=ag&pesquisar=rq">Equipas<span></span></a></li>
                  	  <li ><a href="navegacao?mod=ag&pesquisar=mts">Manutenção<span></span></a></li>	 
              		 <% }
            		  
            		  if(cont.equals("rq")){%>
                      <li ><a href="navegacao?mod=ag&pesquisar=pc">Monitor<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ps">Armários<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ht">Histórico<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=rt">Relatórios<span></span></a></li>
                  	  <li ><a href="navegacao?mod=ag&pesquisar=not">Notificações<span></span></a></li> 
                  	  <li class="ative"><a href="navegacao?mod=ag&pesquisar=rq">Equipas<span></span></a></li>
                  	  <li ><a href="navegacao?mod=ag&pesquisar=mts">Manutenção<span></span></a></li>	 
              		 <% }
            		  
            		  if(cont.equals("ht")){%>
                      <li ><a href="navegacao?mod=ag&pesquisar=pc">Monitor<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ps">Armários<span></span></a></li>
                      <li class="ative"><a href="navegacao?mod=ag&pesquisar=ht">Historico<span></span></a></li>
                      <li><a href="navegacao?mod=ag&pesquisar=rt">Relatórios<span></span></a></li>
                  	  <li><a href="navegacao?mod=ag&pesquisar=not">Notificações<span></span></a></li> 
                  	  <li><a href="navegacao?mod=ag&pesquisar=rq">Equipas<span></span></a></li>	
                  	  <li ><a href="navegacao?mod=ag&pesquisar=mts">Manutenção<span></span></a></li> 
              		 <% }
            		  
            		  if(cont.equals("rt")||cont.equals("rtd")||cont.equals("rts")||cont.equals("rtm")){%>
                      <li ><a href="navegacao?mod=ag&pesquisar=pc">Monitor<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ps">Armários<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ht">Histórico<span></span></a></li>
                      <li class="ative"><a href="navegacao?mod=ag&pesquisar=rt">Relatorios<span></span></a></li>
                  	  <li><a href="navegacao?mod=ag&pesquisar=not">Notificações<span></span></a></li> 
                  	  <li><a href="navegacao?mod=ag&pesquisar=rq">Equipas<span></span></a></li>	
                  	  <li ><a href="navegacao?mod=ag&pesquisar=mts">Manutenção<span></span></a></li> 
              		 <% }
            		  
            		  if(cont.equals("not")){%>
                      <li ><a href="navegacao?mod=ag&pesquisar=pc">Monitor<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ps">Armários<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ht">Histórico<span></span></a></li>
                      <li><a href="navegacao?mod=ag&pesquisar=rt">Relatórios<span></span></a></li>
                  	  <li class="ative"><a href="navegacao?mod=ag&pesquisar=not">Notificações<span></span></a></li> 
                  	  <li><a href="navegacao?mod=ag&pesquisar=rq">Equipas<span></span></a></li>	 
                  	  <li ><a href="navegacao?mod=ag&pesquisar=mts">Manutenção<span></span></a></li>
              		 <% }
            		  
                     if(cont.equals("mts")){%>
                      <li ><a href="navegacao?mod=ag&pesquisar=pc">Monitor<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ps">Armários<span></span></a></li>
                      <li ><a href="navegacao?mod=ag&pesquisar=ht">Histórico<span></span></a></li>
                      <li><a href="navegacao?mod=ag&pesquisar=rt">Relatórios<span></span></a></li>
                  	  <li ><a href="navegacao?mod=ag&pesquisar=not">Notificações<span></span></a></li> 
                  	  <li><a href="navegacao?mod=ag&pesquisar=rq">Equipas<span></span></a></li>	 
                  	  <li class="ative"><a href="navegacao?mod=ag&pesquisar=mts">Manutenção<span></span></a></li>
                     <%}
            	  }
                }
         //   <!-- MODULO configuracao -->  
             if(mod.equals("cf")) {
            	 if(cont!=null && !cont.equals("")){
            		 if(cont.equals("nc")){%>
                 	 <li class="ative"><a href="navegacao?mod=cf&pesquisar=nc">Novo Armário<span></span></a></li>
                 	 <li ><a href="navegacao?mod=cf&pesquisar=mt">Gerir Armários<span></span></a></li>
                 	 <li ><a href="navegacao?mod=cf&pesquisar=cm">Configurar Monitor<span></span></a></li>
                     <li ><a href="navegacao?mod=cf&pesquisar=ns">Configurar Sensor<span></span></a></li>
                     
               <%}
                 if(cont.equals("mt")){%>
                     <li ><a href="navegacao?mod=cf&pesquisar=nc">Novo Armário<span></span></a></li>
                 	 <li class="ative"><a href="navegacao?mod=cf&pesquisar=mt">Gerir Armários<span></span></a></li>
                 	 <li ><a href="navegacao?mod=cf&pesquisar=cm">Configurar Monitor<span></span></a></li>
                     <li ><a href="navegacao?mod=cf&pesquisar=ns">Configurar Sensor<span></span></a></li>
                      
                 <%}
                 if(cont.equals("cm")){%>
	              	 <li ><a href="navegacao?mod=cf&pesquisar=nc">Novo Armário<span></span></a></li>
	              	 <li ><a href="navegacao?mod=cf&pesquisar=mt">Gerir Armários<span></span></a></li>
	                 <li class="ative"><a href="navegacao?mod=cf&pesquisar=cm">Configurar Monitor<span></span></a></li>
	                 <li ><a href="navegacao?mod=cf&pesquisar=ns">Configurar Sensor<span></span></a></li>
                   
                <%}
                 
                 if(cont.equals("ns")){%>
             	 	 <li ><a href="navegacao?mod=cf&pesquisar=nc">Novo Armário<span></span></a></li>
             	  	 <li ><a href="navegacao?mod=cf&pesquisar=mt">Gerir Armários<span></span></a></li>
                   	 <li ><a href="navegacao?mod=cf&pesquisar=cm">Configurar Monitor<span></span></a></li>
                 	 <li class="ative"><a href="navegacao?mod=cf&pesquisar=ns">Configurar Sensor<span></span></a></li>
                  
                <%}
                 
                 if(cont.equals("acss")){%>
         	 	 <li ><a onclick = "window.history.back()" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
             	 <li class="ative"><a href="navegacao?mod=cf&pesquisar=acss">Privilégios <span></span></a></li>
               	 <li ><a href="navegacao?mod=cf&pesquisar=actela">Telas<span></span></a></li>
             	 <li ><a href="navegacao?mod=cf&pesquisar=acmdl">Módulos<span></span></a></li>              
              <%}
                 if(cont.equals("actela")){%>
         	 	 <li ><a onclick = "window.history.back()" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
             	 <li ><a href="navegacao?mod=cf&pesquisar=acss">Privilégios <span></span></a></li>
               	 <li class="ative"><a href="navegacao?mod=cf&pesquisar=actela">Telas<span></span></a></li>
             	 <li ><a href="navegacao?mod=cf&pesquisar=acmdl">Módulos<span></span></a></li>              
              <%}
                 if(cont.equals("acmdl")){%>
         	 	 <li ><a onclick = "window.history.back()" style="color:#CCC; cursor: pointer;"><i class="fa fa-reply"></i></a></li>
             	 <li ><a href="navegacao?mod=cf&pesquisar=acss">Privilégios <span></span></a></li>
               	 <li ><a href="navegacao?mod=cf&pesquisar=actela">Telas<span></span></a></li>
             	 <li class="ative"><a href="navegacao?mod=cf&pesquisar=acmdl">Módulos<span></span></a></li>              
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