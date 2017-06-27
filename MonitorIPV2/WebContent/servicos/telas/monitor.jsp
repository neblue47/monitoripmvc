<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ao.co.smpip.serial.SerialMonitor"%>
<%@page import="ao.co.smpip.jdbc.MapaDAO"%>
<%@page import="java.util.List"%>
<%@page import="ao.co.smpip.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%--  <meta http-equiv= "refresh" content="${tmp}" /> --%>
    <%
      MapaDAO mp = new MapaDAO();
      List<Posto> lp = mp.buscaPorPostos(); 

      
    %>
         
        <script type="text/javascript">
          var infowindowsArray = [];
          var green ='http://maps.google.com/mapfiles/ms/icons/green.png';
          var red ='http://maps.google.com/mapfiles/ms/icons/red.png';
          var image = '';
          var animacao = '';
          function initialize()
          {
              var cenLatlong   =   new google.maps.LatLng(<%=lp.get(0).getLatitude()%>, <%=lp.get(0).getLongitude()%>);
              var myOptions   =   {
                                      zoom:12,
                                      center:cenLatlong,
                                      mapTypeId:google.maps.MapTypeId.ROADMAP,
                                      scrollwheel: false,
                                      
                                  };
             map          =   new google.maps.Map(document.getElementById('mapa'),myOptions);             
             <%for(Posto p: lp){%>
             var myLatlong = new google.maps.LatLng(<%=p.getLatitude()%>, <%=p.getLongitude()%>);
             var valor = <%=p.getStream()%>;
//              alert(valor);
            
             if( valor < 0.900)
            	 {
            	 image = 'http://maps.google.com/mapfiles/ms/icons/red.png';
            	 animacao = google.maps.Animation.BOUNCE;
            	 }
             else if( valor < 1.900 && valor > 0.900)
        	 {
        	 image = 'http://maps.google.com/mapfiles/ms/icons/yellow-dot.png';
        	 animacao = animacao;
        	 }
             else
                 {
            	 image = 'http://maps.google.com/mapfiles/ms/icons/green.png';
            	 animacao = animacao;
            	 }
            
             marker_<%=p.getIdPosto()%> = new google.maps.Marker({
                 map: map,
                 draggable: false,
                 animation: animacao,

                 title: '<%=p.getDescricao() + p.getNomPosto()%>',
                 icon: image
             });
             marker_<%=p.getIdPosto()%>.setPosition(myLatlong);
             
             var conteudo = '<div><%=p.getDescricao()%></div>';
             var infowindow = new google.maps.InfoWindow({ 	content: '<div><%=p.getDescricao()%></div>'
             });
             google.maps.event.addListener(marker_<%=p.getIdPosto()%>,'click',function(){
             	infowindow.open(map,marker_<%=p.getIdPosto()%>);
             });
             <%}%>
          }
          $(document).ready(function () {
        	    initialize();
        	});
        </script>
         

	      
<script type="text/javascript">
var $tool = jQuery.noConflict();
$tool.widget.bridge('uitooltip', $tool.ui.tooltip);

$tool(document).ready(function(){
    $tool('[data-toggle="tooltip"]').tooltip({
        placement : 'top'
    });
}); 
</script>
