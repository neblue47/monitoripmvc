//------------------------- Atualizar Especialidade na Transferencia-----------------------------//
$(document).ready( function(){
    $('.data_qh ').on('chenge',function(){
      $.ajax({
			type: 'GET',
			url : 'queixahistorcontroller',
			data: 'data='+$(this).text()+'&'+'cod='+$('input[name=txtcod]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');
					
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				 
				var pegados = dados.split(":");
				if(dados=='')
					{
					
					}
				else{
					
					document.getElementById("queixas1").value = pegados[0].split("-")[0];
					document.getElementById("queixas2").value = pegados[0].split("-")[1];
			
			      }
			}
		});
    });
    });
function int_receturio() {

	var form = document.internados;
	var msg="";
	var cod="";
	var Radio=null;
	
	Radio= form.paciente;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;
		}

	}
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcm&cod="+cod;
	}
	else
	{
		sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_exameclinico(){

	var form = document.internados;
	var msg="";
	var cod="";
	var Radio=null;
	
	Radio= form.paciente;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;
		}

	}
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcex&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_sinais(){

	var form = document.internados;
	var msg="";
	var cod="";
	var Radio=null;
	
	Radio= form.paciente;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;
		}

	}
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcsn&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_transferencia(){

	var form = document.internados;
	var msg="";
	var cod="";
	var Radio=null;
	
	Radio= form.paciente;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;
		}

	}
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrctrf&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_tratamento(){

	var form = document.internados;
	var msg="";
	var cod="";
	var Radio=null;
	
	Radio= form.paciente;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;
		}

	}
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrctr&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_altaMedica(){

	var form = document.internados;
	var msg="";
	var cod="";
	var Radio=null;
	
	Radio= form.paciente;
	if(1<Radio.length){
	for(var i=0;i<Radio.length;i++) {
		if(Radio[i].checked) {
			cod = Radio[i].value;
		}
	}	
	}
 	else {
		if (Radio.checked) {
			cod = Radio.value;
		}

	}
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcaltm&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

// -----------------------------------------------------------------------------------------------
// -------------------------------------------------------------------------------------------------
// Metodo Singular 
//------------------------- Atualizar Especialidade na Transferencia-----------------------------//

function int_receturioIn() {

	var form = document.internados;
	var cod  = form.paciente.value;
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcm&cod="+cod;
	}
	else
	{
		sweetAlert("Oops...", "Selecione um paciente!", "error");
	}	
}

function int_exameclinicoIn(){

	var form = document.internados;
	var cod  = form.paciente.value;
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcex&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
	}	
}

function int_sinaisIn(){

	var form = document.internados;
	var cod  = form.paciente.value;
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcsn&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_transferenciaIn(){

	var form = document.internados;
	var cod  = form.paciente.value;
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrctrf&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_tratamentoIn(){

	var form = document.internados;
	var cod  = form.paciente.value;
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrctr&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function int_altaMedicaIn(){

	var form = document.internados;
	var cod  = form.paciente.value;
	
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=intrcaltm&cod="+cod;
	}
	else
	{
	sweetAlert("Oops...", "Selecione um paciente!", "error");
//	location.href="navegacaopd?mod=pd&pesquisar=int";
	}	
}

function finalizarInt() {

		if(confirm("Pretende Finalizar assistencia")){
		location.href="navegacaopd?mod=pd&pesquisar=intm";	
	}
	
}
