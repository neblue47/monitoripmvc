
//// -----------TABELA-------
$(document).ready(function(){
	$('select[name=tela]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'ListFunController',
			data: 'codtela='+$('select[name=tela]').val(),
			statusCode: {
				404: function(){
					//alert('Pagina n�o encontrada');
				},
				500: function(){
					//alert('Erro no servidor');
				}
			},
			success: function (dados){
				
				var pegados = dados.split(":");
				if(dados=='')
					{
					
					}
				else{
					$("#testli tr").remove();
					$("#testli thead").append("<tr >"+
                                              "<th width='15%' scope='col'>Op�oes</th>"+
                                              "<th width='85%' scope='col'>Funcionalidade</th>"+
                                              "</tr>");						
				for(var i=0;i<pegados.length-1;i++)
				{
					var cod = pegados[i].split("-")[0];
					var funcionalidade = pegados[i].split("-")[1];
				    $("#testli tbody").append("<tr  >"+
                                              "<td align='center'><input type='checkbox' name='opcao' id='opcao' value='"+cod+"' /></td>"+
                                              "<td >"+funcionalidade+" </td>"+
                                              "</tr>");
				}
			   
			}
				
			}
		});		
	});
});

 //-------------- Tabela Telas --------------------- 
$(document).ready(function(){
	$('select[name=modulos]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'ModController',
			data: 'codigomod='+$('select[name=modulos]').val()+'&'+'codigogr='+$('select[name=grupopr]').val(),
			statusCode: {
				404: function(){
					//alert('Pagina n�o encontrada');
				},
				500: function(){
					//alert('Erro no servidor');
				}
			},
			success: function (dados){
				
				var pegados = dados.split(":");
				if(dados=='')
					{
					
					
					}
				else{
					$("#testli tbody tr").remove();
										
				for(var i=0;i<pegados.length-1;i++)
				{
					var codtela = pegados[i].split("-")[0];
					var nomtela = pegados[i].split("-")[1];
				    $("#testli tbody").append("<tr  >"+
					                            "<td class='telas'> <div>"+nomtela+"</div> </td>"+
                                                "<td class='opcoes'> <div><input type='checkbox' name='opcao' id='opcao' value='"+codtela +"' /></div></td>"+
                                                "</tr>");
				}
			}
				
			}
		});		
	});
});

//-------------- Tabela Telas Gerir G--------------------- 
$(document).ready(function(){
	$('select[name=modulog]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'GrupGrController',
			data: 'codigomodg='+$('select[name=modulog]').val()+'&'+'codGrupog='+$('select[name=grupog]').val(),
			statusCode: {
				404: function(){
					//alert('Pagina n�o encontrada');
				},
				500: function(){
					//alert('Erro no servidor');
				}
			},
			success: function (dados){
				$("#testli tbody tr").remove();
				$("#testli thead tr").remove();
				var pegados = dados.split(":");
				if(dados=='')
					{
					
					}
				else{
//							$("#testli thead").append("<tr >"+
//											"<th data-field='Grupo' data-align='center'>Grupo</th>"+
//											"<th data-field='Modulo' data-align='center'>Modulo</th>"+
//											"<th data-field='Tela' data-align='center'>Tela</th>"+
//											"<th data-field='Op�oes' data-align='center'>Opcoes</th>"+
//		                          "</tr>");						
				for(var i=0;i<pegados.length-1;i++)
				{
				var grupo = pegados[i].split("-")[0];
				var modulo = pegados[i].split("-")[1];
				var nomtela = pegados[i].split("-")[2];
				var codtela = pegados[i].split("-")[3];
				$("#testli tbody").append("<tr  >"+
				      	"<td data-field='Grupo' data-align='center'>"+grupo +"</td>"+
				      	"<td data-field='Modulo' data-align='center'>"+modulo +"</td>"+
				      	"<td data-field='Tela' data-align='center'>"+nomtela +"</td>"+
				      	"<td data-field='Opcoes' data-align='center'><input type='checkbox' name='opcao'  value='"+codtela+"'/></td>"+
				     "</tr>");
				}
			}
				
			}
		});		
	});
});

