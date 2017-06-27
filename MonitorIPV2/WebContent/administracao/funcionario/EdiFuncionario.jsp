<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="atg" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="mDao" class="ao.co.smpip.utils.MetodosBuscas"/>

<script type="text/javascript" src="validar-js/jquery.validate.min.js "></script>
<script type="text/javascript" src="validar-js/additional-methods.min.js "></script>
<script type="text/javascript" src="validar-js/validando.js "></script>

<div class="row"> 
	 <form id="contactForm" name="contactForm" method="get" action="funcontroller.do" onsubmit="return validacaoData(this);">	
      	   <div class="col-md-6">
      	  	    <div class="widget-title">
      				<h5><i class="fa fa-tasks"></i> Informações Iniciais </h5> 
      			    <div id="agenda-perfil"> 
      			    	 <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Num. Interno : </span>	            			
	            		     <input  name="numInt" type="text"  class="form-control" required="required" value="${f.numInterno }" readonly="readonly"/>
	            		     <input  name="numFK" type="hidden"  class="form-control" id="numEnt" value="${f.id_entidade }" readonly="readonly"/>
	        			 </div>
	        			 
	        			 <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Nome : </span>	            			
	            		    <input name="nome" id="nome"  type="text" class="form-control" required="required" value="${f.nome }" />
	        			 </div>
	        			 <div class="form-group input-group input-group-addon-ajust">
	        			 	 <span class="input-group-addon">Sobrenome : </span>	            			
	            		     <input name="apelido" id="apelido" type="text" class="form-control" required="required" value="${f.snome }" />
	        			 </div>
	        	 <div class="row">
	        	  	  <div class="col-md-6">		 
	        			 <div class="form-group input-group input-group-addon-ajust">
				     		  <span class="input-group-addon">Data de Nascimento :</span>
				     		  <input name="nascido" id="nascido" type="text" class="form-control datepicker" data-date-format="dd/mm/yyyy" required="required" value="<fmt:formatDate value="${f.dt_nascimento.time }" pattern="dd/MM/yyyy"/>" />         		               	 	
			     		</div>
			     	 </div>
			     	 <div class="col-md-6 tamanhoMarcons">	
       					<div class="form-group input-group">
	        			 	 <span class="input-group-addon">Estado Civil : </span>     		   	 
             				 <select class="form-control"  name="estcivil" id="estcivil">
           							 <c:forEach var="atg" items="${estCivil}">
				 							<option value="${atg.est_civil}" <c:if test="${atg.est_civil == f.est_cvl }">selected</c:if> > ${atg.nomeEC} </option>
									</c:forEach>									                
           					 </select>             				
	        			</div>
	        		 </div>
	             </div>			
	        	<div class="form-group input-group input-group-addon-ajust ">
       						<span class="input-group-addon">Genero : </span>				     
				    		 <select class="form-control"  name="sexo"  >
	             				 <option value=""> -- Seleccione -- </option>
	             				 <option value="M" <c:if test="${f.sexo eq 'M' }">selected</c:if>> Masculino </option>
	             				 <option value="F" <c:if test="${f.sexo eq 'F' }">selected</c:if>> Feminino </option>		                   
             				</select>     		 
    		   </div> 		
    		   
    		   <div class="row">
	        	  	  <div class="col-md-6">		 
	        			 <div class="form-group input-group input-group-addon-ajust">
				     		  <span class="input-group-addon">Categoria :</span>
				     		  <select class="form-control"  name="categoria" required="required" >
	             				 <option value="" > -- Seleccione -- </option>
            						<c:forEach var="atg" items="${categoria}">
										<option value="${atg.id_ocupacao}" <c:if test="${atg.id_ocupacao == f.id_ocupacao }">selected</c:if>>${atg.ocupacao}</option>
			 						</c:forEach>		                   
             				</select>	         		               	 	
			     		</div>
			     	 </div>
			     	 <div class="col-md-6 tamanhoMarcons">	
       					<div class="form-group input-group">
	        			 	 <span class="input-group-addon">Profissão : </span>     		   	 
             				 <select  class="form-control" name="profissao" id="profissao" onchange="mensagem()">
									 <option value="" > -- Seleccione -- </option>
									 <c:forEach var="atg" items="${profissao}">
											<option value="${atg.profissao}" <c:if test="${atg.profissao == f.id_profissao }">selected 	</c:if>>${atg.nomeProf}</option>
									</c:forEach>
							</select>             				
	        			</div>
	        		 </div>
	             </div> 	        			
       		   <div class="form-group input-group  input-group-addon-ajust">
     						<span class="input-group-addon">Especialidade:</span> 				     
		    		<select class="form-control"  name="esp" id="especialidade"   >
            			 	 <option  > -- Seleccione -- </option>
           					 <c:forEach var="atg" items="${especialidade}">
						 <option value="${atg.especialidade}" <c:if test="${atg.especialidade == f.fk_especialidade }">selected </c:if> >${atg.nomeEsp}</option>
	 					 </c:forEach>		                   
           				  </select>  
  		   		   </div>
  		   		   <div class="form-group input-group  input-group-addon-ajust">
     						<span class="input-group-addon">Telefone : </span> 				     
		    				<input class="form-control" name="tlf" id="tlf" value="${f.editfone2 }"  required="required" onblur="checkFone()"  />    
  		   		   </div>   
	        		     
	            	
<!-- 	            			labTxt	 -->
	            
	            		    		
   				  </div>
    		</div>
    	</div> <!-- /col-md-6 -->    
        
    	<div class="col-md-6">
    		  <div class="widget-title">
    		  	   <h5><i class="fa fa-tasks"></i> Informações Complementar </h5> 
      			   <div id="agenda-perfil"> 
      			   		<div class="form-group input-group input-group-addon-ajust">
		           				<span class="input-group-addon">Email : </span> 
		           				<input class="form-control" name="email" id="email" type="email"  title="Email incorreto" value="${f.email }"/> 		              
		       			</div>		       
				        <div class="form-group input-group input-group-addon-ajust ">
	        			 	 <span class="input-group-addon">Tipo Identificação : </span>   		   
	             			 <select class="form-control"  name="tipoD" id="tipoD">
             						  <option selected> -- Seleccione -- </option>
            						  <c:forEach var="atg" items="${tipodoc}">
											<option value="${atg.tipo_doc}" <c:if test="${atg.tipo_doc == f.tipoEnt }">selected 	</c:if> >${atg.nomeDoc}</option>
			 						  </c:forEach>										
             				  </select>					
	        			</div>  
      
				       <div class="form-group input-group input-group-addon-ajust">
		            	    <span class="input-group-addon">Nº de Identificação : </span> 
		            		<span id="valNum"><input class="form-control" name="numDoc" id="numDoc" type="text" value="${f.numDoc }"  required="required"/></span>
		      		  </div>
       				
       				   <div class="form-group input-group input-group-addon-ajust ">
	        				<span class="input-group-addon">Endereço : </span>	            			
	            			<input class="form-control"  name="endereco" id="endereco" type="text"  required="required" value="${f.endereco }"/>
	        			</div>
	        			
	        			<div class="form-group input-group input-group-addon-ajust ">
	        				<span class="input-group-addon">Nacionalidade : </span>	            			
	            			<select class="form-control" name="nacional" id="nacional" required="required" >
				             	  <option selected> -- Seleccione -- </option>
				             	  <c:forEach var="atg" items="${pais}">
										<option value="${atg.pais}" <c:if test="${f.id_pais == atg.pais }">selected</c:if> >${atg.nomePais}</option>
							      </c:forEach>							
				             </select>	
	        			</div>
	        			
	        			<div class="form-group input-group input-group-addon-ajust ">
	        				<span class="input-group-addon">Província : </span>	            			
	            			<select class="form-control" name="natural" id="natural" required="required" >
	            				  <c:forEach items="${mDao.buscaProvincia (f.id_pais) }" var="prv">
	            				    <option value="${prv.provincia }" <c:if test="${f.id_provincia == prv.provincia }">selected</c:if>> ${prv.nomeProv } </option>
	            				  </c:forEach>							
				             </select>	
	        			</div>	        			
	        	<div class="row">
	        	<div class="col-md-12 ">	
	        			<div class="form-group input-group input-group-addon-ajust">
	        				 <span class="input-group-addon">Nº Contribuinte : </span>	            			
	            			 <input class="form-control" name="nif" type="text" required="required"  placeholder='0000000000AA0000' maxlength='16' pattern="^10[0-9]{8}[A-Z]{2}[0][0-9]{3}$" title="001234567AZ019" value="${f.nif }" />
	            			  <input class="form-control" name="salario" id="salario" maxlength="16" type="hidden" required="required" pattern="[0-9]+$" value="0"/> 
	        			</div>
	        		  </div>
	        		           		  	        	
	        	     <div class="col-md-12 input-group-addon-ajust ">		
	        			<div class="form-group input-group">
	        				 <span class="input-group-addon">Número de S.Social : </span>	            			
	            			 <input class="form-control"  name="numssocail" id="numss" type="text" required="required" value="${f.s_social }"/>
	        			</div>
	        		</div>
	        		  
	        		 
	        	       
	        	</div> 	   
	        			
	        			       							      
				                  
  				</div>
    		</div>
     
       <div class="pull-right">						
            <button type="submit" class="btn btn-success btn-sm" name="salvar" id="enviar" value="Salvar" >
					  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
			</button>
           
            <button type="button" class="btn btn-primary btn-sm" value="Limpar" onclick="confirmExclusao()">
				 	 	<span class="fa fa-trash-o" aria-hidden="true"></span> Eliminar
		    </button>
		    
		    <button type="button" class="btn btn-danger btn-sm" onclick="cancel_task()" >
				 	 	<span class="fa fa-stop-circle" aria-hidden="true"></span> Cancelar
		    </button>
		</div>
    </div>  
 </form>
       
 </div>   
 <script>
   function confirmExclusao() {     
	   var nomes = $('#nome').val() + " " + $('#apelido').val() ;

	   swal({
			title : "Eliminar ?",
			type : "warning",
			showCancelButton : true,
			cancelButtonText : " Não! ",
			confirmButtonColor : "#DD6B55",
			confirmButtonText : " Sim! ",
			closeOnConfirm : false
		},
		 function(){    
			  var id = $("#numEnt").val();  	
	          location.href="editcontroller.do?acao=exc&id="+id;          
   });

	    
	}
</script>    
   <script type="text/javascript">
   


   $(function() {
       $(".datepicker").datepicker({
           changeMonth: true,
           changeYear: true,
   		   dateFormat: 'dd/mm/yy',
           dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
           dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
           dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','SÃ¡b','Dom'],
           monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
           monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
       });
   });
   
   function mensagem(){
	   var prof = document.getElementById("profissao");
	   var numOrd = document.getElementById("numOrd");
	   var espec = document.getElementById("especialidade");
	   if(prof.value == '6'){
		   numOrd.disabled = false;
		   espec.disabled = false;
	   }else{
		   numOrd.disabled = true;
		   espec.disabled = true;
	   }
   }

   function cancel_task(){

	   swal({
			title : "Cancelar ?",
			type : "warning",
			showCancelButton : true,
			cancelButtonText : " Não! ",
			confirmButtonColor : "#DD6B55",
			confirmButtonText : " Sim! ",
			closeOnConfirm : false
		},
		 function(){    
           location.href="navegacao?mod=ad&pesquisar=p";          
    });
		   
	   }
   
  
   function checkFone(){
		var fone = $("#tlf").val();
		if(!fone){
			sweetAlert("", "Não Disponivel ainda!", "warning");
			$("#tlf").focus();
		}
		fone = fone.replace(" ","");
		fone = fone.replace(" ","");
		if(fone.length != 9){
			sweetAlert("", "Numero de telefone invalido!", "warning");
			$("#tlf").focus();
		}
		var num1 = fone.charAt(0)
		var num2 = fone.charAt(1);
		if(num1 != 9){
			sweetAlert("", "Numero de telefone invalido!", "warning");
			$("#tlf").focus();
		}
		if(num2 != 1 && num2 != 2 && num2 != 3 && num2 != 4 && num2 != 9){
			sweetAlert("", "Numero de telefone invalido!", "warning");
			$("#tlf").focus();
		}
		
	}
	
</script>    	   