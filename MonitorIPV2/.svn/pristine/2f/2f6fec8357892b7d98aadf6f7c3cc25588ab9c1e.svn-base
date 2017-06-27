// -------- Atualizar a partir de Sector ----------------
$(document).ready(function(){
	$('select[name=sector]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'InternamentoController',
			data: 'codigo='+$('select[name=sector]').val()+'&'+'acao='+'sc',		
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=sala] option').remove();
				var pegavalor = dados.split(":");
				document.getElementById("andar").value = pegavalor[0].split("-")[0];
				$('select[name=sala]').append('<option value="0"> Selecione Sala </option>')
				for(var i=0;i<pegavalor.length-1;i++)
				{
					var id_sala  = pegavalor[i].split("-")[1];
					var num_sala = pegavalor[i].split("-")[2];
					var des_sala = pegavalor[i].split("-")[3];
					$('select[name=sala]').append('<option value="'+id_sala+'"> '+num_sala +" - "+ des_sala+'</option>')
				}
			}
				
		});		
	})
});

//-------- Atualizar a partir de Sala ----------------
$(document).ready(function(){
	$('select[name=sala]').on('change',function(){
		$.ajax({
			type: 'GET',
			url : 'InternamentoController',
			data: 'codigo='+$('select[name=sala]').val()+'&'+'acao='+'sl',		
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('select[name=leito] option').remove();
				var pegavalor = dados.split(":");
				$('select[name=leito]').append('<option value=" Selecione Leito </option>')
				for(var i=0;i<pegavalor.length-1;i++)
				{
					var id_leito  = pegavalor[i].split("-")[0];
					var leito     = pegavalor[i].split("-")[1];
					$('select[name=leito]').append('<option value="'+id_leito+'">'+leito +'</option>')
				}
			}
				
		});		
	})
});

function gestante(id_consulta) {
	var form = document.marconsulta;
	var id="";
	var cod="";
	var Radio=null;	
	Radio= form.gestante;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
			id = id_consulta;
			if (Radio[i].value == "Feminino") { 
				cod = Radio[i] = '1';
	        }
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;
			id = id_consulta;
		}
	}	
	if(cod!=""){
		location.href="marConsultacontroller.do?mod=ag&acao=mc&pesquisar=mc&cod="+id+"&gest="+cod;
	}
	else
	{
	sweetAlert("", "Por favor selecione o estado do Paciente", "error");	
	//alert("Selecione o estado do Paciente");
	}
}

function gestantes(id_consulta) {
	var form = document.marconsulta;
	var id="";
	var cod="";
	var Radio=null;	
	Radio= form.gestante;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
			id = id_consulta;			
			if (Radio[i].value == "Feminino") { 
			cod = Radio[i] = '1';
            }			
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;			
			id = id_consulta;
		}
	}	
	if(cod!=""){
		location.href="navegacaoag?mod=ag&pesquisar=re&cod="+id+"&gest="+cod;
	}
	else
	{
	sweetAlert("", "Por favor selecione o estado do Paciente", "error");	
	//alert("Selecione o estado do Paciente");
	}
}

function verGenero() {
	var form = document.marconsulta;	
	var Radio= form.gestante;
	var cod="";	
	var $inputs = $('input:radio');	
    for (var i = 0; i < Radio.length; i++) {
        if (Radio[i].checked) {
            if (Radio[i].value == "Masculino") { 
            	sweetAlert("", "O paciente seleccionado é masculino, por favor verifique o estado", "error");
            	//alert('O paciente seleccionado é masculino, verifique o estado');
    			$inputs.prop('checked',false);
            }else{}
        }
    }
}

function limparH(){
	document.getElementById("historial").value 	= "";
}
function limparQ(){
	document.getElementById("queixas1").value 	= "";
}

function cancel() {	
	 var form = document.getElementById("examesFazerform");
	 var cod="";	 
	 cod = form.fkPac.value;
	 if(cod!=""){
	  if(!confirm("Tem certeza de que pretende cancelar a requisição de exames?"))
		  {
		  
		  }else{
			  location.href="navegacaoag?mod=ag&pesquisar=mc";
		  }
	 }  
	}

//Waite submit 
function wiatAndSubmit(){           
 $.blockUI({ 
          css: { 
            border: 'none', 
            padding: '20px',
            fontSize:'18px',            
            backgroundColor: '#000', 
            '-webkit-border-radius': '3px', 
            '-moz-border-radius': '3px', 
            opacity: .6, 
            color: '#fff',
            'text-align': 'center',
        }, 
        message: '<img src="../img/ajax-loader.gif" /><br> Salvando, Por favor aguarde...'
      });
 setTimeout($.unblockUI, 3000); 
 }

//function gestante(id_consulta) {
//
//	var form = document.marconsulta;
//	var id="";
//	var cod="";
//	var Radio=null;
//	
//	Radio= form.gestante;
//	if(1<Radio.length){
//	for(var i=0;i<Radio.length;i++) {
//		if(Radio[i].checked) {
//			cod = Radio[i].value;
//			id = id_consulta;
//		}
//	}	
//	}
// 	else {
//		if (Radio.checked) {
//			cod = Radio.value;
//			id = id_consulta;
//		}
//
//	}
//	
//	if(cod!=""){
//		location.href="marConsultacontroller.do?mod=ag&acao=mc&pesquisar=mc&cod="+id+"&gest="+cod;
//	}
//	else
//	{
//	alert("Selecione o estado do Paciente");
//	}
//}
//
//function limparH(){
//	document.getElementById("historial").value 	= "";
//}
//function limparQ(){
//	document.getElementById("queixas1").value 	= "";
//}
