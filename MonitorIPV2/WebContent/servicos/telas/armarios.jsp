<%@page import="ao.co.smpip.jdbc.MapaDAO"%>
<%@page import="java.util.List"%>
<%@page import="ao.co.smpip.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <%
      MapaDAO mp = new MapaDAO();
      List<Posto> lp = mp.buscaPorPostos(); 
    %>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script> 
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDXKO8r13-KZ9eXHnAsxh9qT9v_XfCcu0k&libraries=places"></script>
        <link rel="stylesheet" href="css/jquery-ui-1.8.18.custom.css"/>
        <script type="text/javascript">
         
          
          var infowindowsArray = [];
          var image ='img/red-marker.png';
          function initialize()
          {
              var cenLatlong   =   new google.maps.LatLng(<%=lp.get(0).getLatitude()%>, <%=lp.get(0).getLongitude()%>);
              var myOptions   =   {
                                      zoom:13,
                                      center:cenLatlong,
                                      mapTypeId:google.maps.MapTypeId.ROADMAP,
                                      scrollwheel: false,
                                      
                                  };
             map          =   new google.maps.Map(document.getElementById('mapa'),myOptions);             
             <%for(Posto p: lp){%>
             var myLatlong = new google.maps.LatLng(<%=p.getLatitude()%>, <%=p.getLongitude()%>);
             marker_<%=p.getIdPosto()%> = new google.maps.Marker({
                 map: map,
                 draggable: false,
                 title: '<%=p.getDescricao() + p.getNomPosto()%>',
                 icon: image
             });
             marker_<%=p.getIdPosto()%>.setPosition(myLatlong);
             
             var conteudo = '<div><%=p.getDescricao()%></div>';
             var infowindow = new google.maps.InfoWindow({
             	content:conteudo
             });
             google.maps.event.addListener(marker_<%=p.getIdPosto()%>,'click',function(){
             	infowindow.open(map,marker_<%=p.getIdPosto()%>);
             });
             <%}%>
          }
        
          $(document).ready(function () {
        	    initialize();
        	    var marker = new google.maps.Marker({
             	    map: map,
             	   draggable:false
                });
        	          var searchbox = new google.maps.places.SearchBox(document.getElementById('mapsearch')); 
        	          google.maps.event.addListener(searchbox, 'places_changed', function(){
        	    	  var places = searchbox.getPlaces();
        	    	  var bounds = new google.maps.LatLngBounds();
        	    	  var i,place;
        	    	  for(i=0;place=places[i];i++){
        	    		  console.log(place.geometry.location);
        	    		  bounds.extend(place.geometry.location);
        	    		  marker.setPosition(place.geometry.location);
        	    		  marker.setIcon('img/red-marker.png');
        	    	  }
        	    	  map.fitBounds(bounds);
        	    	  map.setZoom(15);
        	       });
        	});
        </script>
        <style>
        #mapa{height: 500px; width: 1345px; margin:auto; background-color:#9CF; }
        #bloco{
          width: 1345px;
          margin: 3px auto;
          background: #ccc;
          text-align: center;
        }
        #bloco input{
        width: 1330px;
        height: 20px;
        padding: 5px;
        
        }
</style>
    </head>
    <body  >
        <div id="bloco">
        <input type="text" id="mapsearch" placeholder="Digite nome de local a visualizar..."/>
        <div id="mapa" >
		
        </div>
        </div>
        
    </body>
</html>
