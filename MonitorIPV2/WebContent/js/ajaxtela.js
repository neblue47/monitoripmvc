
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
			url : 'AjaxPrivController',
			data: 'codmodulo='+$('select[name=modulo]').val()+'&'+'Idperfil='+$('#Idperfil').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					alert('Erro no servidor');
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
//												
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

