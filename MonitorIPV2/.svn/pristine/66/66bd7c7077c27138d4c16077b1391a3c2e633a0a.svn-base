// -------- Atualizar a partir de Sector ----------------
$(document).ready(function(){
	$('select[name=sector_in]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'InternamentoController',
			data: 'codigo='+$('select[name=sector_in]').val()+'&'+'acao='+'sc',		
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada'); 
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=sala_in] option').remove();
				var pegavalor = dados.split(":");
				document.getElementById("andar_in").value = pegavalor[0].split("-")[0];
				$('select[name=sala_in]').append('<option value="0"> Selecione Sala </option>')
				for(var i=0;i<pegavalor.length-1;i++)
				{
					var id_sala  = pegavalor[i].split("-")[1];
					var num_sala = pegavalor[i].split("-")[2];
					var des_sala = pegavalor[i].split("-")[3];
					$('select[name=sala_in]').append('<option value="'+id_sala+'"> '+num_sala +" - "+ des_sala+'</option>')
				}
			}
				
		});		
	})
});

//-------- Atualizar a partir de Sala ----------------
$(document).ready(function(){
	$('select[name=sala_in]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'InternamentoController',
			data: 'codigo='+$('select[name=sala_in]').val()+'&'+'acao='+'sl',		
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=leito_in] option').remove();
				var pegavalor = dados.split(":");
				$('select[name=leito_in]').append('<option value=" Selecione Leito </option>')
				for(var i=0;i<pegavalor.length-1;i++)
				{
					var id_leito  = pegavalor[i].split("-")[0];
					var leito     = pegavalor[i].split("-")[1];
					$('select[name=leito_in]').append('<option value="'+id_leito+'">'+leito +'</option>')
				}
			}
				
		});		
	})
});


$(document).ready( function(){
    $('.data_ev').on('click',function(){
//      var coute = $(this).text();
//      sweetAlert($(this).text());
    	$.ajax({
			type: 'POST',
			url : 'AjaxController',
			data: 'data='+$(this).text()+'&'+'cod='+$('input[name=pac_int]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');				
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
//				 $("#table_tmp thead tr").remove(); 
//				$("#table_pls tbody tr").remove(); 
				var pegados = dados.split(";");
				if(dados=='')
					{
					 
					}
				
				else{																											
					document.getElementById("evo_int").value = pegados+"\n";
				}
			}
		});
  });
  });