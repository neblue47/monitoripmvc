// -------- Atualizar a partir de Semana ----------------
$(document).ready(function(){
	$('select[name=dSemana]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'DataMarController',
			data: 'codSemanas='+$('select[name=dSemana]').val()+'&'+'CodAno='+$('select[name=ano]').val()+'&'+'codMes='+$('select[name=mes]').val(),		
			statusCode: {
				404: function(){
					 
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=dia] option').remove();
				var pegavalor = dados.split(":");
				for(var i=0;i<pegavalor.length-1;i++)
				{
					var codDia = pegavalor[i].split("-")[0];
					var MostraDia = pegavalor[i].split("-")[1];
					$('select[name=dia]').append('<option value="'+codDia+'"> '+MostraDia+'</option>')
				}
			}
				
		});		
	})
});
// -------- Atualizar a partir de Ano ----------------
$(document).ready(function(){
	$('select[name=ano]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'DataMarController',
			data: 'codSemanas='+$('select[name=dSemana]').val()+'&'+'CodAno='+$('select[name=ano]').val()+'&'+'codMes='+$('select[name=mes]').val(),		
			statusCode: {
				404: function(){
					 
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=dia] option').remove();
				var pegavalor = dados.split(":");
				for(var i=0;i<pegavalor.length-1;i++)
				{
					var codDia = pegavalor[i].split("-")[0];
					var MostraDia = pegavalor[i].split("-")[1];
					$('select[name=dia]').append('<option value="'+codDia+'"> '+MostraDia+'</option>')
				}
			}
				
		});		
	})
});
//-------- Atualizar a partir de Mes ----------------
$(document).ready(function(){
	$('select[name=mes]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'DataMarController',
			data: 'codSemanas='+$('select[name=dSemana]').val()+'&'+'CodAno='+$('select[name=ano]').val()+'&'+'codMes='+$('select[name=mes]').val(),		
			statusCode: {
				404: function(){
					 
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=dia] option').remove();
				var pegavalor = dados.split(":");
				for(var i=0;i<pegavalor.length-1;i++)
				{
					var codDia = pegavalor[i].split("-")[0];
					var MostraDia = pegavalor[i].split("-")[1];
					$('select[name=dia]').append('<option value="'+codDia+'"> '+MostraDia+'</option>')
				}
			}
				
		});		
	})
});

//-------- Atualizar profissional ----------------
$(document).ready(function(){
	$('select[name=especialidade]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'Consultacontroller',
			data: 'codespecialidade='+$('select[name=especialidade]').val()+'&'+'dSemana='+$('select[name=dSemana]').val(),		
			statusCode: {
				404: function(){
					
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=profis] option').remove();
				var pegavalor = dados.split(":");
				if(dados=='')
					{
					$('select[name=profis]').append("<option value='' > Nenhuma Profiss </option>");
					}
				else{
					$('select[name=profis]').append("<option value='' > Selecione </option>");
					$('select[name=servico]').append("<option value='' > Selecione </option>");
				for(var i=0;i<pegavalor.length;i++)
				{
					var id_medico = pegavalor[i].split("-")[0];
					var medico = pegavalor[i].split("-")[1];
					if(id_medico!='')
					$('select[name=profis]').append('<option value="'+id_medico+'"> '+medico+'</option>');
				}
				}
			}
				
		});		
	})
});



//-----------Tabela Consulta-------
$(document).ready(function(){  
$('select[name=servico]').on('change',function(){
	$.ajax({
		type: 'GET',
		url : 'Tiposervicocontroller',
		data: 'codigotiposervico='+$('select[name=servico]').val(),
		statusCode: {
			404: function(){
				alert('Pagina nao encontrada');
			},
			500: function(){
				alert('Erro no servidor');
			}
		},
		success: function (dados){
			
			var pegados = dados.split(":");
			if(dados=='')
				{
				
				}
				  
				  
			else{
				$("#tesli tr").remove();	
				$("#tesli thead").append("<tr >"+
						"<th class='marca'><div>Marca</div></th>"+
						"<th class='desc'><div>Descrição</div></th>"+
					    "<th class='preco'><div>Preço</div></th>"+
                       "</tr>");
			for(var i=0;i<pegados.length-1;i++)
			{
				var codtela = pegados[i].split("-")[0];
				var nomtela = pegados[i].split("-")[1];
				var preco = pegados[i].split("-")[2];
			    $("#tesli tbody").append("<tr >"+
                                      "<td class='marca'><div><input type='radio' name='opcao' id='opcao' value='"+codtela+"' /></div></td>"+
                                      "<td class='desc'><div>"+nomtela+"</div></td>"+
                                      "<td class='preco'><div>"+preco+" </div></td>"+
                                     "</tr>");
			}
		   
		}
			
		}
	});		
});
});

//Tabela grupo de exames

$(document).ready(function(){
	$('select[name=grupoexames]').on('change',function(){

		$.ajax({
			type: 'GET',
			url : 'GrupoExamescontroller',
			data: 'codigogrupoexames='+$('select[name=grupoexames]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (informacao){
				var pegainfo = informacao.split(":");
				if(informacao=='')
					{
						$("#tesli tr").remove();
						sweetAlert("", "Nenhum serviço relacionado a esse grupo!", "error");
						//alert('Nenhum serviço relacionado a esse grupo');
					}
					  
					  
				else{
					$("#tesli tr").remove();	
					$("#tesli thead").append("<tr >"+
							"<th class='analise'><div>Servios de Análises</div></th>"+
							"<th class='preco'><div>Preço</div></th>"+
						    "<th class='accao'><div>Acção</div></th>"+
                           "</tr>");
				for(var i=0;i<pegainfo.length-1;i++)
				{
					var nomtela = pegainfo[i].split("-")[1];
					var preco   = pegainfo[i].split("-")[2];
					var codtela = pegainfo[i].split("-")[0];
				    $("#tesli tbody").append("<tr >"+                                             
                                          "<td class='analise'><div>"+nomtela+"</div></td>"+
                                          "<td class='preco'><div>"+preco+" </div></td>"+
                                          "<td class='accao'><div><input type='checkbox' name='codtela' id='accao' value='"+codtela+"' /></div></td>"+
                                         "</tr>");
				}
			   
			}
			}
		});	
	});
});
