jQuery(document).ready(function($){

 // hide messages 
 $("#error").hide();
 $("#sent-form-msg").hide();
 
 // on submit...
 $("#contactForm #submit").click(function() {
  $("#error").hide();
  
  //required:
  
  //name e apelido
  var name = $("input#nome").val();
  if(name == ""){
   $("#error").fadeIn().text("Por favor informe seu nome completo.");
   $("input#nome").focus();
   return false;
  }
  
  
  var namef = $("input#apelido").val();
  if(namef == ""){
   $("#error").fadeIn().text("Por favor informe seu nome completo.");
   $("input#apelido").focus();
   return false;
  }
  
  // email
  var email = $("input#email").val();
  if(email == ""){
   $("#error").fadeIn().text("Por favor digite um email valido.");
   $("input#email").focus();
   return false;

   var atpos = email.indexOf("@");
      var dotpos = email.lastIndexOf(".");
      if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
         $("#error").fadeIn().text("Esse email não parece ser valido");
         $("input#email").focus();
         return false;
   }
  }

	  
  // phone
  var phone = $("input#fone").val();
  if(phone == ""){
   $("#error").fadeIn().text("Por favor informe um telefone válido.");
   $("input#fone").focus();
   return false;
  }

  // assunto
  var endereco = $("input#endereco").val();
  if(endereco == ""){
   $("#error").fadeIn().text("Por favor informe o seu endereco.");
   $("input#endereco").focus();
   return false;
  }

  // numero da identificacao, NIF, Num SS e Salario
  var numDoc = $("input#numDoc").val();
  if(numDoc == ""){
   $("#error").fadeIn().text("Por favor informe a numero da identificacao.");
   $("input#numDoc").focus();
   return false;
  }

  // doutor
  var nif = $("input#nif").val();
  if(nif == ""){
   $("#error").fadeIn().text("Por favor informe o Num de Contribuinte.");
   $("input#nif").focus();
   return false;
  }
  
  var numss = $("input#numss").val();
  if(numss == ""){
   $("#error").fadeIn().text("Por favor informe o num de seguranca social.");
   $("input#numss").focus();
   return false;
  }
  var phone = $("input#salario").val();
  if(phone == ""){
   $("#error").fadeIn().text("Por favor informe o salario.");
   $("input#salario").focus();
   return false;
  }

  // data
  var data = $("input#dataIn").val();
  if(data == ""){
   $("#error").fadeIn().text("Por favor informe a data que fez a consulta.");
   $("input#dataIn").focus();
   return false;
  }

  /*// especialidade
  var especialidade = $("option#especialidade").val();
  if(especialidade == ""){
   $("#error").fadeIn().text("Por favor selecione uma opção.");
   $("option#especialidade").focus();
   return false;
  }*/
  
  // comments
  var comments = $("textarea#comments").val();
  if(comments == ""){
   $("#error").fadeIn().text("Por favor escreve uma mensagem.");
   $("input#comments").focus();
   return false;
  }

  // send mail php
  var sendMailUrl = $("#sendMailUrl").val();
  
  //to, from & subject
  var to = $("#to").val();
  var from = $("#from").val();
  var subject = $("#subject").val();
  
  // data string
  var dataString = 'name='+ name
      + '&email=' + email        
      + '&phone=' + phone
      + '&assunto=' + assunto
      + '&especialidade=' + especialidade
      + '&comments=' + comments
      + '&to=' + to
      + '&from=' + from
      + '&subject=' + subject;               
  // ajax
  $.ajax({
   type:"POST",
   url: sendMailUrl,
   data: dataString,
   success: success()
  });
 });  
 
  
 // on success...
  function success(){
   $("#sent-form-msg").fadeIn();
   $("#contactForm").fadeOut();
  }
 
    return false;
    
});

$(function() {
    $("#nascido").datepicker({
        changeMonth: true,
        changeYear: true,
		dateFormat: 'dd/mm/yy',
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
    });
});