<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <script>
  $(function() {
    var icons = {
      header: "ui-icon-circle-arrow-e",
      activeHeader: "ui-icon-circle-arrow-s"
    };
    $( "#accordion" ).accordion({
      icons: icons
    });
    $( "#toggle" ).button().click(function() {
      if ( $( "#accordion" ).accordion( "option", "icons" ) ) {
        $( "#accordion" ).accordion( "option", "icons", null );
      } else {
        $( "#accordion" ).accordion( "option", "icons", icons );
      }
    });
  });
  </script>
<div class="row" >
<div class="col-md-10 col-md-offset-1" >
<div class="widget-proc " style="margin: 10px auto;">
   <div class="procediment">
   		<div id="accordion" class="procediment-tab-menu">
		     <ul class="nav nav-tabs nav-justified">
			    	<li id="receituarios">e-Mensagem</li>                   
			 </ul>
		</div>
 <div class="procediment-content">     
   <!-- Email novo - 1 Tab  -->
    	<div id="fromReceituarios">
   			<form name="form1" method="post" action="requesitar.do" class="tamanhoReqExa"> 
   			<div class="form-group input-group">
		       	 	<span class="input-group-addon">De:</span>                    
                    <input class="form-control" name="from" value="sistemaMPIP" readonly="readonly" />
	           	</div>
   			<div class="form-group input-group">
	        			 	 <span class="input-group-addon">Tipo Mensagem : </span>   		   
	             			 <select class="form-control"  name="tipom" required="required" >
	             				 <option value=""> -- Seleccione -- </option>
	             				 <option value="1"> e-Mensagem </option>
	             				 <option value="2"> gsm-Mensagem </option>		                   
             				</select>							
	        			</div>
      					             
				<div class="form-group input-group">
				    <span class="input-group-addon">Para:</span>                    
		            <input class="form-control" name="tomail"  id="tomail" />
			   </div>
			    <div class="form-group input-group">
		       	 	<span class="input-group-addon">Assunto:</span>                    
                    <input class="form-control" name="subj">
	           	</div>
	           			<div class="form-group input-group">
						<span class="input-group-addon">Mensagem:</span>
						<textarea class="form-control" name="msg"></textarea>  	   	
					</div>
	           <div class="pull-right">
			<button type="submit" class="btn btn-success btn-sm" name="commit">
				<span class="glyphicon glyphicon-send" aria-hidden="true"></span> Enviar
			</button>
		</div>
	</form>

   </div>
   
   
    <!-- SMS - 2 Tab  -->
   
   
   
</div>    
</div>
</div> 
</div>
</div>

	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
  	<script type="text/javascript" src="js/autocomple-ui.js"></script>
  
  	