<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ao.co.smpip.serial.SerialMonitor"%>
<%@page import="ao.co.smpip.jdbc.MapaDAO"%>
<%@page import="java.util.List"%>
<%@page import="ao.co.smpip.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
        
    
 <style>
 	#mapa{height: 500px; width: auto; margin:auto; background-color:#9CF; }
 	#quadro{height: 500px; width: auto; margin:auto; background-color:#DCDCDC; padding: 10px}
 	.col-md-2{
 		padding-left: 1px;
 	}
	 .col-md-10{
	 padding-right: 1px;
	 }
</style>

	       <div class="row">
	          <div class="col-md-12">
                 <div id="mapa" >
                    
			     </div>
             </div>

          </div>
 
 
 
<script>
       $(document).ready(function(){
			$('#mapa').load('refresh2.jsp');
			refresh();
	   });
       function refresh(){
			setTimeout(function(){
				$('#mapa').fadeOut('slow').load('tela/refresh2.jsp').fadeIn('slow');
				refresh();
			},20000);
			}
			 
</script>
