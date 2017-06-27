$(document).ready(function(){
	$('select[name=pais]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'Provinciacontroller',
			data: 'codigopais='+$('select[name=pais]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=provincia] option').remove();
				var pegados = dados.split(":");
				if(dados=='')
					{
					$('select[name=provincia]').append('<option > Nenhuma Provincia </option>');
					}
				else{
					$('select[name=provincia]').append('<option > Selecione  </option>');
					for(var i=0;i<pegados.length-1;i++)
				{
					var codprovincia = pegados[i].split("-")[0];
					var nomprovincia = pegados[i].split("-")[1];
					$('select[name=provincia]').append('<option value="'+codprovincia+'"> '+nomprovincia+'</option>');
				}
			}
				
			}
		});		
	})
});
$(document).ready(function(){
	$('select[name=provincia]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'PaisController',
			data: 'codigoprovincia='+$('select[name=provincia]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=municipio] option').remove();
				var pegados = dados.split(":");
				if(dados=='')
					{
					$('select[name=municipio]').append('<option > Nenhum municipio </option>')
					}
				else{
					$('select[name=municipio]').append('<option > Selecione  </option>');
				for(var i=0;i<pegados.length-1;i++)
				{
					var codprovincia = pegados[i].split("-")[0];
					var nomprovincia = pegados[i].split("-")[1];
					$('select[name=municipio]').append('<option value="'+codprovincia+'"> '+nomprovincia+'</option>')
				}
			}
				
			}
		});		
	})
});


$(document).ready(function(){
	$('select[name=municipio]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'PaisController',
			data: 'codigomunicipio='+$('select[name=municipio]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					 
				}
			},
			success: function (dados){
				$('select[name=distrito] option').remove();
				var pegados = dados.split(":");
				if(dados=='')
					{
					$('select[name=distrito]').append('<option > Nenhum Distrito </option>')
					}
				else{
					$('select[name=distrito]').append('<option > -- Seleccione --  </option>');
				for(var i=0;i<pegados.length-1;i++)
				{
					var codprovincia = pegados[i].split("*")[0];
					var nomprovincia = pegados[i].split("*")[1];
					$('select[name=distrito]').append('<option value="'+codprovincia+'"> '+nomprovincia+'</option>')
				}
			}
				
			}
		});		
	})
});

