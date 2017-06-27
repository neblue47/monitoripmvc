<div class="row">				
			<div class="col-md-9 col-md-offset-3 sub_menu">
              <div id="container">
                <ul>
          		<%
	    
             	    String ative = "class='ative'";
             	    String menu = request.getParameter("mod");
             	    int nivelUs = (int)request.getSession().getAttribute("nivelUs");
             	    String nome_us = "";
              
		            if(menu.equals("ad") && nivelUs == 1){
			          %>
			          <li><a href="navegacao?mod=ag"> <i class="fa fa-group"></i> Serviços</a></li>
			          <li><a href="navegacao?mod=ad" class="ative"> <i class="fa fa-adn"></i> Administração</a></li>
			          <li><a href="navegacao?mod=cf"> <i class="glyphicon glyphicon-cog"></i> Configuração</a></li>
			          <li><a href="navegacao?mod=ajd"> <i class="fa fa-question-circle"></i> Ajuda</a></li>
			          <%} 
		            if(menu.equals("ag")){ %>
			          <li><a href="navegacao?mod=ag" class="ative"> <i class="fa fa-group"></i> Serviços</a></li>
			          <%if( nivelUs == 1) {%>
			          <li><a href="navegacao?mod=ad" > <i class="fa fa-adn"></i> Administração</a></li>
			          <%} %>
			          <li><a href="navegacao?mod=cf"> <i class="glyphicon glyphicon-cog"></i> Configuração</a></li>
			          <li><a href="navegacao?mod=ajd"> <i class="fa fa-question-circle"></i> Ajuda</a></li> 
			            
			          <%}
		            if(menu.equals("cf")){ %>
			          <li><a href="navegacao?mod=ag" > <i class="fa fa-group"></i> Serviços</a></li>
			           <%if( nivelUs == 1) {%>
			          <li><a href="navegacao?mod=ad" > <i class="fa fa-adn"></i> Administração</a></li>
			          <%} %>
			          <li><a href="navegacao?mod=cf" class="ative"> <i class="glyphicon glyphicon-cog"></i> Configuração</a></li>
			          <li><a href="navegacao?mod=ajd"> <i class="fa fa-question-circle"></i> Ajuda</a></li>  
			           
			          <%}
		            if(menu.equals("ajd")) 
			            {%>
		            	<li><a href="navegacao?mod=ag" > <i class="fa fa-group"></i> Serviços</a></li>
			            <%if( nivelUs == 1) {%>
			          	<li><a href="navegacao?mod=ad" > <i class="fa fa-adn"></i> Administração</a></li>
			          	<%} %>
		            	<li><a href="navegacao?mod=cf" > <i class="glyphicon glyphicon-cog"></i> Configuração</a></li>
		                <li><a href="navegacao?mod=ajd" class="ative"> <i class="fa fa-question-circle"></i> Ajuda</a></li>
			           <%} %>  
		          </ul>   
     		    </div>
          	</div>  
</div>