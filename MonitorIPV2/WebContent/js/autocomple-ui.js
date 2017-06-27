var $s = jQuery.noConflict();
$s('#funcionario').autocomplete({
	minLength: 2,
	source: function(request,response){
		$s.ajax({
			url:'PesquisarController',
			type: 'GET',
			datatype:'html',
			data: {
				'termo_n': request.term
			}
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

$s('#armario').autocomplete({
	minLength: 2,
	source: function(request,response){
		$s.ajax({
			url:'PesquisarController',
			type: 'GET',
			datatype:'html',
			data: {
				'termo_a': request.term
			}
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

$s('#tomail').autocomplete({
	minLength: 2,
	source: function(request,response){
		$s.ajax({
			url:'PesquisarController',
			type: 'GET',
			datatype:'html',
			data: {
				'termo_e': request.term
			}
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

$s('#tofone').autocomplete({
	minLength: 2,
	source: function(request,response){
		$s.ajax({
			url:'PesquisarController',
			type: 'GET',
			datatype:'html',
			data: {
				'termo_t': request.term
			}
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

