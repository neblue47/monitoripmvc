<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	<script src="tmp/jquery-1.8.2.js"></script>
    <script src="js/form-validation.js"></script>
    <script src="js/addcampos.js"></script>
	<script src="tmp/jquery-ui.js"></script>
    <script src="tmp/jquery.maskedinput-1.3.min.js"></script>
 <div class="row">
		<div class="col-md-12">	
		  <c:if test="${not empty logs}">		
			 	  <div class="widget-title">
								 			  
				  <h5><i class="fa fa-th"></i> Logs de Actividades dos Sensores </h5>
				  <table id="table" data-toggle="table" data-height="468" data-pagination="true" data-search="true">
					   <thead>
							<tr>
								<th data-field="Nome do Armario" data-align="left">Descrição do Armário</th>
								<th data-field="Descrição Google" data-align="left">Descrição Google</th>
								<th data-field="Local Ocorrencia" data-align="left">Local Ocorrencia</th>
								<th data-field="Data Evento" data-align="center">Data Evento</th>
								<th data-field="Hora Evento" data-align="center">Hora Evento</th>
							</tr>
					  </thead>
		  			  <tbody>
		  			  <c:forEach var="at" items="${logs}">
							<tr>
								<td> ${at.nomPosto}</td>
								<td> ${at.descricao}</td>
								<td> ${at.endereco}</td>
								<td><fmt:formatDate value="${at.dataEv.time}" pattern="dd/MM/yyyy"/></td>
								<td>${at.horaEvento}</td>
						    </tr>
					</c:forEach>
					</tbody>
				</table>
			
			
			</div>	
			</c:if>
			<c:if test="${empty logs}">
				  <c:if test="${aux != 'p'}">
					 <div class="widget-title">
					 	  <h5><i class="fa fa-th"></i> Logs de Actividades dos Sensores </h5>
						  <div id="agenda-perfil">						
								<p  style="color:#CC0033; text-align:center">Nenhum registo localizado</p>
						  </div>
					</div>
				</c:if>
			</c:if>
	  </div>	
 </div>
 


 