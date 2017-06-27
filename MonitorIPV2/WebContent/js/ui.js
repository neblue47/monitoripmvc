$('#save').click(function(){
	$('#dialog').attr('title','Confirmacao').text('Enviado com sucesso').dialog({
		buttons: { 'Sair': function(){
			$(this).dialog('close');
		},'Voltar': function(){ }},draggable:false,resizable:false, modal: true, show: 'fade'
	});
});

//$('#pesqAuto').autocomplete({
//	
//	minLength: 2,
//	source: function(request,response){
//		$.ajax({
//			url:'RecetuarioController',
//			type: 'GET',
//			datatype:'html',
//			data: {
//				'termo': request.term
//			}
//		}).done(function(data){
//			if(data.length >0){
//				data = data.split('-');
//				response($.each(data,function(key,item){
//					return({
//						label: item  
//					});
//				}));
//			}
//		});
//	}
//});

$(document).ready(function() {
	$('#filtrar').DataTable({
		"language" : {
			"sProcessing" : "Processando...",
			"lengthMenu" : "  ",
			"zeroRecords" : "Nenhum registo encontrado",
			"info" : " ",
			"infoEmpty" : " ",
			"infoFiltered" : " ",
			"sSearch" : "Filtrando Por .:",
			"oPaginate" : {
				"sFirst" : "Primeiro",
				"sPrevious" : "Anterior",
				"sNext" : "Seguinte",
				"sLast" : " "
			}
		}
	}

	);
});