$(document).ready(function(){
		$('#meuform').validate({
			rules:{
				nome:{
					required: true,
					nowhitespace: true,
					minlength: 4
				},
				apelido:{
					required: true,
					nowhitespace: true,
					minlength: 4
				},
				senha:{
					required: true,
					rangelength: [4,10],					 
				},
				senharp:{
					required: true,					 
					equalTo: "#senha"
				},
				email:{
					required: true,
					email: true
				},
				contrato:{
					required: true
				},
				numDoc:{
					 
					verificaBI: true
					},
				tlf:{
					  
					verificaTLF: true,
					maxlength: 15
					}
			},
			messages:{
				nome:{
					required: "Este campo é obrigatorio!",
					minlength: "No minimo 4 caracteres!"
				},
				apelido:{
					required: "Este campo é obrigatorio!",
					minlength: "No minimo 4 caracteres!"
				},
				senha:{
					required: "Este campo é obrigatorio!",
					rangelength: "Deve ter no minimo 4 a 10 caracteres",
					 
				},
				senharp:{
					required: "Este campo é obrigatorio!",
					 
					equalTo: "As senhas são diferentes!"
				},
				email:{
					required: "Este campo é obrigatorio!",
					email: "Informe email valido!"
				},
				contrato:{
					required: "É obrigatorio aceitar o contrato"
				},
				numDoc:{
					required: "Este campo é obrigatorio!"
				},
				tlf:{
					 
				}
			}
		});
	});
// Validando Capitulos CID
$(document).ready(function(){
	$('#capForm').validate({
		rules:{
			cptlcodigo:{
				required: true,
				verificaCAP: true
			}
		},
		messages:{
			cptlcodigo:{
				required: "Este campo é obrigatorio!"
			}			
		}
	});
});

//Validando Senha do Usuario!
//$(document).ready(function(){
//	$('#form_usuario').validate({
//		rules:{
//			nome_us:{
//				required: true,
//				nowhitespace: true,
//				minlength: 4
//			},
//			senha_us:{
//				required: true,
//				rangelength: [8,10]					 
//			},
//			senharp:{
//				required: true,					 
//				equalTo: "#senha"
//			}
//		},
//		messages:{
//			nome_us:{
//				required: "Este campo é obrigatorio!",
//				minlength: "No minimo 4 caracteres!"
//			},
//			senha_us:{
//				required: "Este campo é obrigatorio!",
//				rangelength: "Deve ter no minimo 8 a 10 caracteres",
//				 
//			},
//			senharp:{
//				required: "Este campo é obrigatorio!",
//				equalTo: "As senhas são diferentes!"
//			}			
//		}
//	});
//});

   jQuery.validator.addMethod("nowhitespace", function(value, element) {
	return this.optional(element) || /^\S+$/i.test(value);
	}, "Nada de espaço em branco");
   
   jQuery.validator.addMethod("verificaCAP", function(value, element) {
	   cap = value;
	   var verifica;
		jQuery.ajax({
	        url: 'AjaxController?cap='+cap,
	        async: false
	       }).done(function(data){
	    	   if(data == 0){
	           	   verifica = true; 
	              }
	              if(data != 0){
	           	   verifica = false; 
	              }
	       });
	    return verifica;
		}, "Capitulo ja Cadastrado!");
	
   jQuery.validator.addMethod("verificaCPF", function(value, element) {
		value = value.replace('.','');
		value = value.replace('.','');
		cpf = value.replace('-','');
		while(cpf.length < 11) cpf = "0"+ cpf;
		var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
		var a = [];
		var b = new Number;
		var c = 11;
		for (i=0; i<11; i++){
		    a[i] = cpf.charAt(i);
		    if (i < 9) b += (a[i] * --c);
		}
		if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }
		b = 0;
		c = 11;
		for (y=0; y<10; y++) b += (a[y] * c--);
		if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }
		if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) return false;
		var verifica;
		jQuery.ajax({
	        url: 'AjaxController?cpf='+cpf,
	        async: false
	       }).done(function(data){
	    	   if(data == 0){
	           	   verifica = true; 
	              }
	              if(data != 0){
	           	   verifica = false; 
	              }
	       });
		
		return verifica;
		}, "CPF inválido ou já cadastrado!");
	
	jQuery.validator.addMethod("verificaTLF", function(value, element) {
		value = value.replace(' ','');
		value = value.replace('-','');
		tlf = value.replace('-','');
		
		var expReg = /^00[0-9]{7}[A-Z]{2}[0][0-9]{2}$/;
		if ((tlf.length < 12) || tlf.match(expReg)) return false;
		
		var verifica;
		jQuery.ajax({
	        url: 'AjaxController?tlf='+tlf,
	        async: false
	       }).done(function(data){
	    	   if(data == 0){
	           	   verifica = true; 
	              }
	           if(data != 0){
	           	   verifica = false; 
	              }	              
	       });		
		return verifica;
		}, "Telefone inválido ou já cadastrado!");
	
	jQuery.validator.addMethod("verificaBI", function(value, element) {
		value = value.replace(' ','');
		value = value.replace('-','');
		numDoc = value.replace('-','');
		
		var expReg = /^00[0-9]{7}[A-Z]{2}[0][0-9]{2}$/;
		if ((numDoc.length < 14) || tlf.match(expReg)) return false;
		
		var verifica;
		jQuery.ajax({
	        url: 'AjaxController?tlf='+tlf,
	        async: false
	       }).done(function(data){
	    	   if(data == 0){
	           	   verifica = true; 
	              }
	           if(data != 0){
	           	   verifica = false; 
	              }	              
	       });		
		return verifica;
		}, "Numero inválido ou já cadastrado!");