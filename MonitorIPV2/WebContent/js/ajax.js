
$(document).ready(function(){
	$('select[name=nacional]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'PaisController',
			data: 'codigopais='+$('select[name=nacional]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					 
				}
			},
			success: function (dados){
				$('select[name=natural] option').remove();
				var pegados = dados.split(":");
				if(dados=='')
					{
					$('select[name=natural]').append('<option > -- Seleccione -- </option>');
					}
				else{
					$('select[name=natural]').append('<option > -- Seleccione -- </option>');
				for(var i=0;i<pegados.length-1;i++)
				{
					var codprovincia = pegados[i].split("-")[0];
					var nomprovincia = pegados[i].split("-")[1];
					$('select[name=natural]').append('<option value="'+codprovincia+'"> '+nomprovincia+'</option>');
				}
			}
				
			}
		});		
	})
});

$(document).ready(function(){
	$('select[name=categoria]').on('change',function(){
		$.ajax({
			type: 'POST',
			url : 'PaisController',
			data: 'codcategoria='+$('select[name=categoria]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					 
				}
			},
			success: function (dados){
				$('select[name=profissao] option').remove();
				var pegados = dados.split(":");
				if(dados=='')
					{
					$('select[name=profissao]').append('<option > Seleccione Categoria </option>');
					}
				else{
					$('select[name=profissao]').append('<option > -- Seleccione -- </option>');
				for(var i=0;i<pegados.length-1;i++)
				{
					var codprofissao = pegados[i].split("-")[0];
					var nomprofissao = pegados[i].split("-")[1];
					$('select[name=profissao]').append('<option value="'+codprofissao+'"> '+nomprofissao+'</option>');
				}
			}
				
			}
		});		
	})
});


//-------------- Tabela Telas Privilegios --------------------- 
$(document).ready(function(){
	$('select[name=codmodulo]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'PaisController',
			data: 'codmodulo='+$('select[name=codmodulo]').val()+'&'+'Idperfil='+$('input[name=Idperfil]').val(),
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

 

