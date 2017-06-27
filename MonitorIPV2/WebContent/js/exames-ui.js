$('#examesp').autocomplete({
	
	minLength: 2,
	source: function(request,response){
		$.ajax({
			url:'ExamesClinInternamento',
			type: 'GET',
			datatype:'html',
			data: 'grupo='+$('select[name=grupo-ex]').val()+'&'+'exame='+request.term,	
			
		}).done(function(data){
			if(data.length >0){
				data = data.split('-');
				response($.each(data,function(key,item){
					return({
						label: item  
					});
				}));
			}
		});
	}
});
