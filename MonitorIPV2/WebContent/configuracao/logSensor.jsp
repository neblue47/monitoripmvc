<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ao.co.smpip.serial.SerialMonitor"%>
<%@page import="ao.co.smpip.jdbc.MapaDAO"%>
<%@page import="java.util.List"%>
<%@page import="ao.co.smpip.entidades.*"%>
	<%
      MapaDAO mp = new MapaDAO();
      List<Posto> lp = mp.buscaPorPostosOn(); 
       
    %>
 <div class="col-md-12 ">
	<div class="widget-title">
		<h5>
			<i class="fa fa-tasks"></i> Leitura dos Sensores nos Armários
		</h5>
		<div id="agenda-perfil">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group input-group">
						<span class="input-group-addon">Logs nos Armários:</span>
						<table class="dignostico">
							<tbody>
								<%for(Posto p: lp){%>
								<tr>
									<td><%=p.getNomPosto()%> : <%=p.getStream()%> (A)</td>
								</tr>
								<%} %>
							</tbody>
						</table>
					</div>

				</div>

			</div>
		</div>
	</div>

</div>