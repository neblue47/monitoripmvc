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
      List<Posto> lp = mp.buscaPorPostosOn(); 
      Parametros pmt = mp.buscarValoresArmarios();

      
    %>
    
        <script type="text/javascript">
          var infowindowsArray = [];
          var green ='http://maps.google.com/mapfiles/ms/icons/green.png';
          var red ='http://maps.google.com/mapfiles/ms/icons/red.png';
          var image = '';
          var animacao = '';
          function initialize()
          {
              var lat = <%=lp.get(0).getLatitude()%>;
              var lon = <%=lp.get(0).getLongitude()%>;
              var cenLatlong   =   new google.maps.LatLng(lat, lon);
              var myOptions   =   {
                                      zoom:11,
                                      center:cenLatlong,
                                      mapTypeId:google.maps.MapTypeId.ROADMAP,
                                      scrollwheel: false,
                                  };
             map =  new google.maps.Map(document.getElementById('mapa'),myOptions); 
        	             
             <%for(Posto p: lp){%>
             var myLatlong = new google.maps.LatLng(<%=p.getLatitude()%>, <%=p.getLongitude()%>);
             var valor = <%=p.getStream()%>;
             if( Number( valor) <= Number (<%=pmt.getFalhasPosto()%>))
            	 {
            	 image = 'http://maps.google.com/mapfiles/ms/icons/red.png';
            	 animacao = google.maps.Animation.BOUNCE;
            	 lat = <%=p.getLatitude()%>;
                 lon = <%=p.getLongitude()%>;
            	 }
             else if(Number( valor) <= Number (<%=pmt.getMedianPosto()%>) && valor > Number (<%=pmt.getFalhasPosto()%>))
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

                 title: '<%=p.getDescricao() + p.getNomPosto()%>' ,
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
