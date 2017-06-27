<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
 #mapa{height: 500px; width: auto; margin:auto; background-color:#9CF; }
 #quadro{height: 500px; width: auto; margin:auto; background-color:#DCDCDC; padding: 10px}
 .col-md-2{ padding-left: 1px; }
 .col-md-10{ padding-right: 1px; }
</style>
  		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script> 
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDXKO8r13-KZ9eXHnAsxh9qT9v_XfCcu0k&libraries=places"></script>
         <link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.min.css"/>
   
<script src="https://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	var code = "${tmp}";
	setInterval(function(){
		$("#mapa").load('servicos/telas/monitor.jsp')
    }, 30000);
});
</script>
<div class="row">
	<div class="col-md-12">
           <div id="mapa" >       </div>
    </div>
</div>