<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script> 
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script src="tmp/jquery-1.8.2.js"></script>
    <script src="js/form-validation.js"></script>
    <script src="js/addcampos.js"></script>
	<script src="tmp/jquery-ui.js"></script>
    <script src="tmp/jquery.maskedinput-1.3.min.js"></script>
 <div class="row">
		<div class="col-md-7" >			
			 <div class="widget-title">
			 	  <h5><i class="fa fa-th"></i> Google Maps </h5>
				  <div id="agenda-perfil">						
						<div id="map_canvas" style="width:auto;height:400px;margin: auto; margin-bottom: 10px; background: #CCC;">
						</div>
				  </div>
			</div>
	  </div>
	  <div class="col-md-5 ">
		   <form method="post" action="PostosController">
     			 <div class="widget-title pesAdmin ">
     			 	  <h5><i class="fa fa-th"></i> Adicionar Novo Armario / Postos </h5>
     			 	  <div id="agenda-perfil">     			 
           				   <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Descrição : </span>	            			
	            			 	<input class="form-control" name="desc" type="text" id="autocomplete" type="text" value=""/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Designação da Caixa :  </span>	            			
	            			 	<input class="form-control" name="nomep" type="text" value=""/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon"> Província : </span>   		   
	             			  <select class="form-control"  name="provincia" id="provincia" required="required" >
				             		  <option value=""> -- Seleccione -- </option>
				             		  <c:forEach items="${provincia }" var="pr" varStatus="loop">
				             		   	<option value="${pr.provincia }"> ${pr.nomeProv } </option>
				             		  </c:forEach>           
				             </select>			
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon"> Municipio : </span>   		   
	             			  <select class="form-control"  name="municipio" id="municipio" required="required" >
				             		 <option value=""> -- Seleccione -- </option>           
				             </select>			
	        			  </div>
	        			   <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon"> Distrito : </span>   		   
	             			  <select class="form-control"  name="distrito" id="distrito" required="required" >
				             		  <option value=""> -- Seleccione -- </option>           
				             </select>			
	        			    </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Nº de Lampadas :  </span>	            			
	            			 	<input class="form-control" name="qdtLp" type="text" value=""/>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Latitude   </span>	            			
	            			 	<span id="lat_c"><input class="form-control" name="lat" id="lat" type="text" value=""/></span>
	        			  </div>
	        			  <div class="form-group input-group input-group-addon-ajust ">
	        				 	<span class="input-group-addon"> Longitude   </span>	            			
	            			 	<span id="lng_c"><input class="form-control" name="lng" id="lng" type="text" value=""/></span>
	        			  </div>	        				   
     					   	<input type="hidden" name="fkUsuario" value = "${fkUsuario }">				    			   	  				
					  </div>
					  
					  <br/>
				 </div>
				 <div class="pull-right">						
					            <button type="submit" class="btn btn-success btn-sm" name="salvar" value="Salvar" >
										  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
								</button>
			
					            <button type="reset" class="btn btn-primary btn-sm" value="Limpar" value="Limpar" name ="excluir" ${hab2}>
									 	 	<span class="fa fa-eraser" aria-hidden="true"></span> Limpar
							    </button>
							</div>
			</form>
		</div>	
 </div>

<script type="text/javascript">
var map;
var geocoder;
function initialize()
{
    var myLatlong   =   new google.maps.LatLng(-8.823973, 13.236727);
    var myOptions   =   {
                            zoom:16,
                            center:myLatlong,
                            mapTypeId:google.maps.MapTypeId.ROADMAP
                        };
   map          =   new google.maps.Map(document.getElementById('map_canvas'),myOptions);
   geocoder      =   new google.maps.Geocoder();   
}

$(document).ready(function(){
  $("#autocomplete").autocomplete({
      source:function(request,response){
          geocoder.geocode({'address':request.term},function(results){
              response($.map(results,function(item){
                  return {
                     label:item.formatted_address,
                     value:item.formatted_address,
                     latitude:item.geometry.location.lat(),
                     longitude:item.geometry.location.lng(),
                  }
                  
              }))
          })
     },
      select:function(event,ui) {
        var location    =   new google.maps.LatLng(ui.item.latitude,ui.item.longitude);
        marker          =   new google.maps.Marker({
            map:map,
            draggable:true
        })
       var stringvalue     =   'latitude:<input name ="LAT" type="text" value="'+ui.item.latitude+'" >Longitude:<input name ="LNG" type="text" value="'+ui.item.longitude+'">Descricao: <input name ="DSCR" type="text" ><br/>';
        $("#lat").remove();
        $("#lng").remove();
        $("#lat_c").append('<input class="form-control" name="lat" id="lat" type="text" value="'+ui.item.latitude+'"/>');
        $("#lng_c").append('<input class="form-control" name="lng" id="lng" type="text" value="'+ui.item.longitude+'"/>');
        marker.setPosition(location);
        map.setCenter(location);

    }
      
  })

});

$(document).ready(function () {
    initialize();
});
</script>

 