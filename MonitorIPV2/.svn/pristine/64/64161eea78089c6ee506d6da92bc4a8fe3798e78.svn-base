<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="row">
<form id="contactForm" method="get" action="agendavisualizarcontroller">
      <div class="col-md-6">  
       	    <div class="widget-title">
       	    	 <h5><i class="fa fa-tasks"></i> Lista de Funcionarios</h5>   
      			    
				 <table id="table" data-toggle="table" data-height="468" data-pagination="true" data-search="true">
				 		<thead>
                        <tr>
                             <th data-field="Funcionário" data-align="left">Nome do Funcionário</th>
                             <th data-field="Categoria" data-align="center"> Categoria </th>
                             <th data-field="Agenda" data-align="center">Agenda</th>
                         </tr>
                         </thead>
                         <tbody>
                       	 <c:forEach var="at" items="${lista}" >
							<tr>
								<td>${at.nome} ${at.snome}</td>
								<td>${at.categoria}</td>
								<td>
								  	<a href="agendacontroller.do?mod=ad&acao=ag&pesquisar=ag&cod=${at.id_entidade}">								  	
								  		<i class="glyphicon glyphicon-user" title="Agendar"></i>								  														
								  	</a>								
								</td>
						    </tr>
							</c:forEach>
                        </tbody>
               </table>
         </div>
      </div>
</form>
<div class="col-md-6">
        
   <form name="contactForm" method="post" action="agendacontroller.do">
        <div class="widget-title">
             <h5><i class="fa fa-th"></i> Definir Turno de Funcionário </h5>  
       		 <div id="agenda-perfil">
       		 	  <div class="form-group input-group input-group-addon-ajust2">
	        			<span class="input-group-addon"> Nome do Funcionário : </span>	            			
	            		<input  class="form-control"  name="nomeu" type="text" value="${tur.nome} ${tur.snome}"  readonly="readonly"/>
	        	  </div>    	  
	        	  <div class="row">
	        	  	<div class="col-md-6">
  				   	  <div class="form-group input-group input-group-addon-ajust1">
					   <span class="input-group-addon"> Turno : </span>	            			
	            	   <select   name="turnos" class="form-control">
	             				<option value=""> Seleccione </option>
	             				<option value="Manha"> Manha </option>
	             				<option value="Tarde"> Tarde </option>
	            		</select>
	        	      </div>
	        	   </div>
	        	   <div class="col-md-6">
         	 	     <div class="form-group input-group input-group-addon-ajust1">
					   <span class="input-group-addon"> Dia : </span>	            			
	            	   <select   name="d_semana" class="form-control">
	            	   <option value=""> Seleccione </option>
	            	   <c:forEach var="at" items="${dsemanas }">
	            	   <option value="${at.id_semana}"> ${at.semana} </option>
	            	   </c:forEach>
	            		</select>
	        	      </div>
	        	   </div>
	        	</div>
	        	 <div class="row">
	        	  	<div class="col-md-6">
  				   		<div class="form-group input-group input-group-addon-ajust2">
	        				<span class="input-group-addon"> Hora de Início : </span>	            			
	            			<input name="horai" type="time"   value="" class="form-control" required="required"/>
	        	  		</div>
	        	   </div>
	        	   <div class="col-md-6">
         	 	    <div class="form-group input-group">
	        			<span class="input-group-addon"> Hora do Fim : </span>	            			
	            		<input name="horaf" type="time" id ="input_hora"  value="" class="form-control" required="required"/>
	        	   </div>
	        	   </div>
	        	</div>
	        	    
	        	     
     		  </div>
     	</div>
     	<input name="FK_enti" type="hidden" value="${tur.id_entidade}"/>		
		<input name="acao" type="hidden" value="acao"/>
		<div class="pull-right">
			<button type="submit" class="btn btn-success btn-sm" name="salvar">
					  <span class="glyphicon glyphicon-save" aria-hidden="true"></span> Salvar
			</button>			 
			<button type="reset" class="btn btn-primary btn-sm">
				 	 <span class="fa fa-eraser" aria-hidden="true"></span> Limpar
			</button>   
		</div>	 
    </form>
	<br/>
	<br/>
	 <form  method="get" action="agendavisualizarcontroller">
    		<div class="widget-title">
     			 <h5><i class="fa fa-th"></i> Funcionarios </h5>
        	         <table id="table" data-toggle="table" data-height="230" data-pagination="true" data-search="true">
        	         	<thead>
                        	<tr>
                        		<th data-field="Nome do Funcionário" data-align="center">Nome do Funcionário</th>
                        		<th data-field="Equipa" data-align="center">Equipa</th>
                        		<th data-field="Turnos" data-align="center">Turno</th>
                        		<th data-field="Acção" data-align="center">Acção</th>
                        	</tr>
                        </thead>
                        <tbody>
	                        <tr>
		                            <td>Nelson Diwidi</td>
		                            <td>Equipa 1</td>
		                            <td>Manha</td>
		                            <td ><a href="agendacontroller.do?mod=ad&acao=edit&pesquisar=ag&cod=2"><i style="color: #337ab7; font-size: 16px;" class="fa fa-edit "></i></a>
		                            &nbsp;	
			                       <a href="agendaeliminarcontroller.do?acao=exc&cod=2"><i style="color: #ba122b; font-size: 16px;" class="fa fa-trash-o"></i></a>
			                       </td>
	                        </tr>
                      </tbody>    
                    </table>
        			 
        	 
        </div>
      </form>
 
  </div>       
 </div>            	   