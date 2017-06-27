<%@page import="ao.co.smpip.jdbc.MapaDAO"%>
<%@page import="java.util.List"%>
<%@page import="ao.co.smpip.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html >
<html>
    <head>
    <%
      MapaDAO mp = new MapaDAO();
      Posto geoPosto = new Posto();
      String posto = request.getParameter("geomap");
      if(posto!=null && !posto.equals("")){
    	  int codposto = Integer.parseInt(posto);  
    	  geoPosto = mp.buscaPorPosto(codposto);
    	  
      }else
      {
    	  geoPosto = mp.buscaPorPosto(1);
      }
      //List<Posto> lp = mp.buscaPorArmarios(); 
    %>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script> 
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDXKO8r13-KZ9eXHnAsxh9qT9v_XfCcu0k&libraries=places"></script>
        <link rel="stylesheet" href="css/jquery-ui-1.8.18.custom.css"/>
       
        <style>
        #mapa{height: 470px; width: auto; margin:auto; background-color:#9CF; }
        #bloco{
          width: auto;
          margin: 3px auto;
          background: #ccc;
          text-align: center;
        }
        #bloco-lista{
          width: auto;
          height: 470px;
          margin: 3px auto;
          background: #ccc;
          
        }
        #bloco-lista a{
         margin-left: 10px ;
         margin-top: 10px ;
         padding: 10px 0;
         text-decoration: none;
         color: #000000;
        }
        #bloco-lista a:hover {
         
         color: #F00002;
        }
        #bloco input{
            width: 100%;
            height: 30px;
            padding: 5px;
        	border: 0;
        }
</style>
    </head>
    <body>
    <div class="row">
	    <div class="col-md-10">
            <div id="bloco">
<!--               <input type="text" id="armario" placeholder="Digite nome de local a visualizar..." onblur="localizar()"/> -->
              <input type="hidden" id="mapsearch" />
              <div id="mapa" >
		
             </div>
           </div>
       </div>
       <div class="col-md-2">
        <div id="bloco-lista">
           <ul>
           <c:forEach items="${armarios }" var="at">
           	<li><a href="navegacao?mod=ag&pesquisar=ps&geomap=${at.idPosto }"> <i class="fa fa-map-marker" aria-hidden="true"></i> ${at.nomPosto }</a> </li>
           </c:forEach>        	
           </ul>
        </div>
       
       </div>
     </div>
        
    </body>
     <script type="text/javascript">
          var infowindowsArray = [];
          var image ='http://maps.google.com/mapfiles/ms/icons/yellow-dot.png';
          function initialize()
          {
              var cenLatlong   =   new google.maps.LatLng(<%=geoPosto.getLatitude()%>, <%=geoPosto.getLongitude()%>);
              var myOptions   =   {
                                      zoom:15,
                                      center:cenLatlong,
                                      mapTypeId:google.maps.MapTypeId.ROADMAP,
                                      scrollwheel: false,
                                      
                                  };
             map          =   new google.maps.Map(document.getElementById('mapa'),myOptions); 
                        
              
             var myLatlong = new google.maps.LatLng(<%=geoPosto.getLatitude()%>, <%=geoPosto.getLongitude()%>);
             marker_<%=geoPosto.getIdPosto()%> = new google.maps.Marker({
                 map: map,
                 draggable: false,
                 title: '<%=geoPosto.getDescricao() + geoPosto.getNomPosto()%>',
                 icon: image
             });
             marker_<%=geoPosto.getIdPosto()%>.setPosition(myLatlong);
             
             var conteudo = '<div><%=geoPosto.getDescricao()%></div>';
             var infowindow = new google.maps.InfoWindow({
             	content:conteudo
             });
             google.maps.event.addListener(marker_<%=geoPosto.getIdPosto()%>,'click',function(){
             	infowindow.open(map,marker_<%=geoPosto.getIdPosto()%>);
             });
             
          }
          $(document).ready(function () {
        	    initialize();
        	});
        </script>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
  	<script type="text/javascript" src="js/autocomple-ui.js"></script>
</html>
