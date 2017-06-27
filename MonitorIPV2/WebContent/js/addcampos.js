// JavaScript Document

	   function add(type) {
			//Create an input type dynamically.
			var element = document.createElement("input");
			//Assign different attributes to the element.
			element.setAttribute("type", type);
			element.setAttribute("value", type);
			element.setAttribute("name", type);
			var foo = document.getElementById("fooBar");
			//Append the element in	 page (in span).
			foo.appendChild(element);
       }
	
	   function admissao(){
			 
			  var radio = document.interna.admins;
			  var cod="";
			  if(radio.value == '1') {
				 $(".input_in").attr('disabled', false);
				}
			  else
			   {
			  	 $(".input_in").attr('disabled', true);
			   }
		  }
	   
	function outroEmail(valor) { 
			var conteudo = ""; 
			var bt = "";
			if(valor == '+') { 
			  conteudo += "<input style='margin-top:5px;' type='email' class='champ' id='email2' name='email2'  />";
			  bt += "<input type='button' value=' - ' name='submit' onclick='eliminarEmail(this.value);'/>";
			}else { 
				document.getElementById("email2").innerHTML = "";
				return; 
			}
			document.getElementById("email2").innerHTML = conteudo + " " +bt;
			
		} 
		function endereco2(valor) { 
			var conteudo = ""; 
			var bt = "";
			if(valor == '+') { 
			  conteudo += "<input type='text' class='champ' id='endereco2' name='endereco2'  />";
			  bt += "<input type='button' value=' - ' name='submit' onclick='eliminarEnd(this.value);'/>";
			}else { 
				document.getElementById("endereco2").innerHTML = "";
				return; 
			}
			document.getElementById("endereco2").innerHTML = conteudo + " " +bt; 
		} 
		
		function outroPhone(valor) { 
			var conteudo = ""; 
			var bt = "";
			if(valor == '+') { 
			  conteudo += "<input type='button' value=' - ' name='submit' onclick='eliminarPhone(this.value);'/>";
			  bt += "";
			}else { 
				document.getElementById("fone").innerHTML = "";
				return; 
			}
			document.getElementById("fone").innerHTML = conteudo; 
		} 
		function ativarFone(valor) { 
			var conteudo = ""; 
			var bt = "";
			if(valor == '+') { 
			  conteudo += "<input style='margin-top:5px;' type='tel' class='champ1' id='telefone' name='telefone1' maxlength='11'   placeholder='999 999-999' onkeypress='formata_mask(this,'### ###-###'); return Numero(event);'  />";
			  bt += "<input type='button' value=' - ' name='submit' onclick='eliminarPhone(this.value);'/>";
			}else { 
				document.getElementById("fone");
				return; 
			}
			document.getElementById("fone").innerHTML = conteudo + " " +bt; 
		}
		
       
		function validacaoData(contactForm)
		  {
			var now = new Date();
		  	var data2 = document.getElementById("nascido").value; 
		  	var atual = now.getFullYear() - parseInt(data2.split("/")[2].toString());
		  	
		  	if (atual < 18)
	  		{
		  		alert("Somente idade Superior a 17 anos!", "warning");
		  		//window.alert('Erro - Data de Nascimento,\nSomente idade Superior a 17 anos');
	  	      document.contactForm.nascido.focus();
	  	      return false;
	  		}		  	 
		  	
		  }
		function verifuncao(contactForm)
		{
			var valor = document.getElementById("funcao").value;
			if(valor == 1 || valor == 2)
				return true;
			else
				document.contactForm.funcao.focus;
			    return false;
		}
		function checkSenha(form_usuario)
		  {
			var camp1 = document.getElementById("senha");
	    	var camp2 = document.getElementById("senharp");
				  	
		  	
		  	if (camp1.value != camp2.value)
	  		{
	  		  window.alert('Valor da senha devem ser igual...');
	  	      document.form_usuario.senharp.focus();
	  	      return false;
	  		}
		  	
		  }
		
	
		
		function adTelefone()
		{
		  
		  var botao1 = document.getElementById("botao");
		  var botao2 = document.getElementById("btElm");
		  var conteudo = "<input type='button' value=' - ' name='btElm' id='btElm' onclick='adTelefone()'/>";
		  if(botao1.value == "+")
		  {
		    document.contactForm.telefone1.type = "text";
		    botao1.disabled = true;
		    document.getElementById("fone").innerHTML = conteudo;
		    
		  }
		  if(botao2.value == " - ")
		  {
		    document.contactForm.telefone1.type = "hidden";
		    document.contactForm.telefone1.value = "";
		    botao.disabled = false;
		    document.getElementById("fone").innerHTML = "";
		    
		  }

		}
		function adEmail()
		{
		  
		  var botao1 = document.getElementById("btEm");
		  var botao2 = document.getElementById("btElm2");
		  var conteudo = "<input type='button' value=' - ' name='btElm2' id='btElm2' onclick='adEmail()'/>";
		  if(botao1.value == "+")
		  {
		    document.contactForm.email2.type = "email";
		    document.contactForm.email2.value = "";
		    btEm.disabled = true;
		    document.getElementById("btemail2").innerHTML = conteudo;
		    
		  }
		  if(botao2.value == " - ")
		  {
		    document.contactForm.email2.type = "hidden";
		    document.contactForm.email2.value = "";
		    btEm.disabled = false;
		    document.getElementById("btemail2").innerHTML = "";
		    
		  }

		}

function formata_mask(campo_passado,mask)
{
	var campo = campo_passado.value.length;
	var saida = mask.substring(0,1);
	var texto = mask.substring(campo);
	if(texto.substring(0,1) != saida)
		{
		campo_passado.value +=texto.substring(0,1);
		}
}

function Numero(e)
{
	navegador = /msie/i.test(navigator.userAgent);
	if(navegador)
		var tecla = event.keyCode;
	else
		var tecla = e.which;
	if(tecla > 47 && tecla < 58) // numeros de 0 a 9
		return true;
	else
		{
			if(tecla != 8) // backspace 
				return false;
			else
				return true;
		}
}

function naoImplementado(){
	sweetAlert("Oops...", "Não Disponivel ainda!", "error");
}
