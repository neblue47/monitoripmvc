function sinais() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cps&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
 
	
}
//------------- Metodo Queixa -------------------
function queixas() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cpq&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function diario(){
	location.href="navegacao?mod=ag&pesquisar=rtd";
}
function semanal(){
	location.href="navegacao?mod=ag&pesquisar=rts";
}
function mensal(){
	location.href="navegacao?mod=ag&pesquisar=rtm";
}
function funcionario(){
	location.href="navegacao?mod=ag&pesquisar=rt";
}
//------------------------------- Antecedentes -----------------------
function antecedentes() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cpt&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
//------------------------------- Exames Fisicos -----------------------
function examesFS() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cpef&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
//------------------------------- Hipotese -----------------------
function hipotese() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cph&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

//------------------------------- Diagnosticos -----------------------
function diagnosticos() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cpdg&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

//------------------------------- Exames Clinicos -----------------------
function exames_clinico() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cpecv&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

//------------------------------- TrataMentos RecoMendaçoes -----------------------
function tratamento() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cptrc&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

//------------------------------- Recetuarios -----------------------
function recetuario() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cprc&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

//------------------------------- Historico de Consulta - Justificativo -----------------------
function hist_consulta() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cphj&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
//------------------------------- Internamento -----------------------
function internamento() {

	var form = document.triados;
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
		location.href="navegacaopd?mod=pd&pesquisar=cpint&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
//------------------------- Metodos Singular ---------------------
function sinaisN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cps&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function antecedenteN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpt&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
function examesFSN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpef&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
function hipoteseN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cph&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
function diagnosticoN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpdg&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
function exam_clinicoN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpecv&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function internamentoN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpint&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function tratamentoN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cptrc&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
function receituarioN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cprc&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function hist_consultaN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cphj&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}


function queixasN() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpq&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function cancel() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.decod.value;
			
	if(cod!=""){
		if(confirm("Pretende Cancelar a consulta"));
		location.href="navegacaopd?mod=pd&pesquisar=del&cod="+cod;
	}
	
}

function finalizar() {

	var form = document.triados;
	var conf="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
	conf = form.txtconsul.value;		
	if(cod!=""){
		if(confirm("Pretende Finalizar a consulta")){
			location.href="navegacaopd?mod=pd&pesquisar=fin&cod="+cod+"&conf="+conf;	
		}
		else
			{
			
			}
		
	}
	
}

// ------------------------- Metodos Para Novas Informação -------------------------------- 
function queixasNova() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpn&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}
function hipoteseNova() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cphn&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function antecedenteNova() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cptn&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function examFSNova() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpefn&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function tratamentoNova() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value;
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cptrcn&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function RecetuarioNova() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value; 
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cprcn&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}

function ExameNova() {

	var form = document.triados;
	var msg="";
	var cod="";
	var Radio=null;
	
	cod = form.txtcod.value; 
			
	if(cod!=""){
		location.href="navegacaopd?mod=pd&pesquisar=cpec&cod="+cod;
	}
	else
	{
	alert("Selecione um paciente" + cod);
	location.href="navegacaopd?mod=pd&pesquisar=cp";
	}
}