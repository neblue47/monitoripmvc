<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="atg" %> 
       <form id="form_set" method="post" action="usucontroller.do">
       <fieldset >
       <legend> Privilegios </legend>
       <div id="div_contact">
             <span class="texte"><label>Nome do Funcionario </label></span> 
             <span id="champ_contact"><input class="champ" name="nome" type="text" readonly="readonly" value="${nome}"/></span>
       </div>
       <div id="div_contact">
             <span class="texte"><label>Grupo de Utilizador </label></span> 
             <span id="champ_contact">
                              <select class="champ1" name="grupou" id="grupou">
                                  
                                  <option value="0" <c:if test="${grupou == '0'}"> selected</c:if>> - Selecione - </option>
                                  <option value="1" <c:if test="${grupou == '1'}"> selected</c:if>> Admin-Sistema  </option>
                                  <option value="2" <c:if test="${grupou == '2'}"> selected</c:if>> Tecnico-Sistema </option>
                              </select></span>
       </div>
       <div id="div_contact">
             <span class="texte"><label>Nome do Usuario </label></span> 
             <span id="champ_contact"><input class="champ" name="nomeu" type="text" value="${nomeu}" autocomplete="off" /></span>
       </div>
       <div id="div_contact">
             <span class="texte"><label>Palavra Chave </label></span> 
             <span id="champ_contact"><input class="champ" name="senha" type="password" value="${senha}" autocomplete="off"/></span>
       </div>       
       </fieldset>
       <input name="senha" type="hidden" value="${txtid}"/>
       <div id="div_contact_button">
						<span class="botao"> <input type="submit" value="Guardar" ${hab1}> </span>
                        <span class="botao"> <input type="submit" value="Modificar" ${hab2}> </span>
                        <span class="botao"> <input type="button" value="Eliminar" ${hab2} > </span>                 
		</div>
       </form>
       
       <fieldset>
			<legend> Lista de Funcionarios </legend>

			<div class="scrollableContainer">
				<div class="scrollingArea">
					<table class="cruises scrollable">
						<thead>
							<tr>
								<th class="name"><div>Nome Completo</div></th>
								<th class="data"><div>Categoria</div></th>
								<th class="fone"><div>Telefone</div></th>
								<th class="email"><div>E-mail</div></th>
								<th class="address"><div>Endere�o</div></th>
								<th class="actions"><div>Ac��o</div></th>
							</tr>
						</thead>

						<c:forEach var="at" items="${lista}">
							<tbody>
								<tr>
									<td class="name"><div>${at.nome} ${at.snome}</div></td>
									<td class="data"><div>${at.categoria}</div></td>
									<td class="fone"><div>${at.telefone}</div></td>
									<td class="email"><div>${at.email}</div></td>
									<td class="address"><div>${at.endereco}</div></td>
									<td class="action">
									    <div>
											<a href="navegacao?mod=ad&pesquisar=ut&cod=${at.id_entidade}">
											  <span><img src="img/novo (2).gif" width="18" height="16"/></span>
											</a>
										</div>
									</td>
									<td class="action"><div>
											<a href="#" onclick="new_perfil(${at.id_entidade})"><span><img
													src="img/usuarios.jpg" width="18" height="16"
													title="Ver Perfil" /></span><span></span></a>
										</div></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</fieldset>
      
      
