$(document).ready(function(){
	$('select[name=tipoD]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'ExtraController',
			data: 'codigoTdoc='+$('select[name=tipoD]').val(),
			statusCode: {
				404: function(){
					alert('Pagina não encontrada');
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
				success: function (dados){
					$("#numDoc").remove();
					if(dados == '1')
						{
						$("#numCd").remove();
						$("#numP").remove();
						$("#valNum").append("<input class='form-control' name='numB' id='numB' type='text'  required='required' placeholder='000000000AA000' maxlength='14' pattern='^00[0-9]{7}[A-Z]{2}[0][0-9]{2}$' title='001234567AZ019'/>");
						}
					if(dados == '2')
					{
						$("#numB").remove();
						$("#numP").remove();
						$("#valNum").append("<input class='form-control' name='numCd' id='numCd' type='text'  required='required' placeholder='000000000' maxlength='9' pattern='^[0-9]{5}$' />");
					}
					if(dados == '3')
					{
						$("#numCd").remove();
						$("#numB").remove();
						$("#valNum").append("<input class='form-control' name='numP' id='numP' type='text'  required='required' placeholder='N000000' maxlength='7' pattern='^[N]{1}[0-9]{6}$'/>");
					}
			}
		})
	})
});

