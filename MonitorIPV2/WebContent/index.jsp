<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="erros/404.jsp" %>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<c:if test="${not empty nomeUsa }">

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" type="image/png" href="img/icone.pgn" >

<title>.:Monitor de Iluminação Publica:.</title>

 <!-- Bootstrap -->
 <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="css/bootstrap-table.css">
 <link rel="stylesheet" type="text/css" href="css/font-awesome.css">
 <link rel="stylesheet" type="text/css" href="fonts/stylesheet.css">
 <link rel="stylesheet" type="text/css" href="css/datepicker.css">
<!-- /Bootstrap -->

<link rel="stylesheet" type="text/css" href="css/menu-css.css" media="all" />

<!-- Table Script-->
<script src="js/js-table/jquery.min.js" ></script>
<script src="js/js-table/bootstrap.min.js" ></script>
<script src="js/js-table/bootstrap-table.js" ></script>
<!-- <script src="js/js-table/tab-main.js" ></script> -->
<!-- /Table Script-->

<!-- DialogBox personalizado -->
<script src="js/dialogBox/jquery.blockUI.js" ></script>
<script src="js/dialogBox/sweetalert-dev.js" ></script>
<link rel="stylesheet" type="text/css" href="js/dialogBox/sweetalert.css" >
<!-- /DialogBox personalizado -->

<!-- Tabs Script-->
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/tabs/jquery-1.10.2.js"></script>
<script src="js/tabs/jquery-ui.js"></script>
<script src="js/tabs/jquery.cookie.js"></script>
<!-- /Tabs Script-->


<style type="text/css">
	.bs-example{
    	margin: 100px 50px;
    }
</style>

<script src="js/jquery-ui.min.js"></script>
<script src="js/ajax_marc.js"></script>

<script src="js/scripts-js.js"></script>

<script src="js/script.js"></script>

<script src="js/addcampos.js"></script>
<script src="js/jquery-1.11.1.js"></script>

<script src="js/jquery.mask.min.js"></script>
<script src="js/ajax_val.js"></script>
<script src="js/ajax.js"></script>
<script src="js/ajaxtela.js"></script>
<script src="js/ajax_pc.js"></script>   
<script src="js/ajax-transf.js"></script> 

<script type="text/javascript" src="js/bootstrap-datepicker.js "></script>  

</head>

<body class="body">
 <header id="header_top" >
	<div class="row">
		<div class="col-sm-3">								
			<img src="img/logoIP.png" alt="Logo GestHosp" class="img-responsive" border="0"/>
		</div>
		<div class="col-sm-9">
			<div class="bg_white">
				<ul>					
  					<li>
  						<a href="#" onclick="confirmSair()">
  							<i class="fa fa-power-off"></i> Sair
  						</a>
  					</li> 
  					<li>
	  					<i class="fa fa-user"></i> <span>Bem vindo</span><strong> ${nomeUsa} </strong>
  					</li> 								
  				</ul>
  			</div>
		</div>
	</div>

	<div id="nav_menu">
	     <jsp:include page="menu.jsp" />
    </div>
</header>
<div id="main_menu">
 <div class="container"> 
    <jsp:include page="submenus.jsp" />
  </div>
</div>
      <!--#####################################################################################################
                       ESTA PARTE ESTA RESERVADA PARA O CONTEUDO QUE VAI APARECER NA TELA
      -->
  <div class="container">
       <%
          String modcont  = request.getParameter("mod");
          String pes = request.getParameter("pesquisar");
          if(modcont.equals("ad")){// Modulo Administracao
          if(modcont.equals("ad") && pes==null ){
       %>
          <jsp:include page="administracao/moduloAd.jsp" />
       <%  } else if(pes.equals("rh")&& modcont.equals("ad")){  %>
          <jsp:include page="administracao/rhtelas.jsp" /> 
       <%  } else if(pes.equals("f")&& modcont.equals("ad")){  %>
       <jsp:include page="administracao/funcionario/CadFuncionario.jsp" /> 
       <%  }
       else if((pes.equals("p")||pes.equals("Pesquisar"))&& modcont.equals("ad")){  %>
          <jsp:include page="administracao/funcionario/pesquisar.jsp" /> 
       <%  }else if(pes.equals("cg")&& modcont.equals("ad")){  %>
<%--              <jsp:include page="administracao/funcionario/cr_grupo.jsp" /> --%>
         <%  } else if(pes.equals("u")&& modcont.equals("ad")){%>
          <jsp:include page="administracao/funcionario/utilizadores.jsp" />
         <% } else if(pes.equals("ag")&& modcont.equals("ad")){%>
          <jsp:include page="administracao/funcionario/agenda.jsp" />
          <%} else if(pes.equals("eq")&& modcont.equals("ad")){%>
         <jsp:include page="administracao/funcionario/equipas.jsp" />
         <%}else if(pes.equals("ms")&& modcont.equals("ad")){%>
           <jsp:include page="administracao/funcionario/mensagem.jsp" />
          <%}else if(pes.equals("edit")&& modcont.equals("ad")){%>
          <jsp:include page="administracao/funcionario/EdiFuncionario.jsp" />
         <%}else if(pes.equals("mss")&& modcont.equals("ad")){%>
         <jsp:include page="administracao/funcionario/mensagenss.jsp" />
        <%}else if(pes.equals("arq")&& modcont.equals("ad")){%>
        <jsp:include page="administracao/funcionario/arquivos.jsp" />
       <%}else if(pes.equals("msl")&& modcont.equals("ad")){%>
       <jsp:include page="administracao/funcionario/mensagem.jsp" />
      <%}
          } 
           if(modcont.equals("ag")){// Modulo serviço
          	if(modcont.equals("ag") && pes==null ){%>
         	  <jsp:include page="servicos/servico.jsp" />
         	<%}else	if(pes.equals("pc")&& modcont.equals("ag") ){%>
          	<jsp:include page="servicos/telas/showMonitor.jsp" />
          	<%} else if(pes.equals("ms")&& modcont.equals("ag") ){%>
          	<jsp:include page="servicos/telas/mapaDoBD.jsp" />
          	<%} else if(pes.equals("ps")&& modcont.equals("ag") ){%>
          	<jsp:include page="servicos/telas/mapaDoBD.jsp" /> 
          	<%} 
          	 else if(pes.equals("ht")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/historico.jsp" />
           	<%}
          	else if(pes.equals("rt")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/relatorios.jsp" />
           	<%}
          	else if(pes.equals("rtd")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/relatorios-d.jsp" />
           	<%}
          	else if(pes.equals("rts")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/relatorios-s.jsp" />
           	<%}
          	else if(pes.equals("rtm")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/relatorios-m.jsp" />
           	<%}
          	else if(pes.equals("rq")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/requesitando.jsp" />
           	<%}
          	else if(pes.equals("msg")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/mensagem.jsp" />
           	<%}
          	else if(pes.equals("not")&& modcont.equals("ag") ){%>
           	<jsp:include page="servicos/telas/notificaçoes.jsp" />
           	<%}
          	else if(pes.equals("mts")&& modcont.equals("ag") ){%>
   			<jsp:include page="configuracao/manutencao.jsp" />
			<% }
          }
           if(modcont.equals("cf")){// Modulo Configurar
             	if(modcont.equals("cf") && pes==null ){%>
             	    <jsp:include page="configuracao/servico.jsp" />          		
             	<%}
             	else if(pes.equals("nc")&& modcont.equals("cf") ){%>
             	<jsp:include page="configuracao/novoposto.jsp" />
          		<% }
             	else if(pes.equals("mt")&& modcont.equals("cf") ){%>
       			<jsp:include page="configuracao/gerirarmarios.jsp" />
    			<% }
             	else if(pes.equals("ns")&& modcont.equals("cf") ){%>
       			<jsp:include page="configuracao/sensor.jsp" />
    			<% }
             	else if(pes.equals("cm")&& modcont.equals("cf") ){%>
       			<jsp:include page="configuracao/configuracao.jsp" />
    			<% }
           // ######### MENU ACESSOS #############
             	else if(pes.equals("acss")&& modcont.equals("cf") ){%>
       			<jsp:include page="configuracao/acessos/privilegios.jsp" />
    			<% }
             	else if(pes.equals("acmdl")&& modcont.equals("cf") ){%>
       			<jsp:include page="configuracao/acessos/modulos.jsp" />
    			<% }
             	else if(pes.equals("actela")&& modcont.equals("cf") ){%>
       			<jsp:include page="configuracao/acessos/telas.jsp" />
    			<% }
             	
           
           }
		        
		   // NAVEGAÇÃO INICIAL     
			if (modcont.equals("ng")) {	%>	<jsp:include page="navegacao.jsp" />  <%  }
			if (modcont.equals("ajd")) {	%>	<jsp:include page="erros/404.jsp" />  <%  }
           %>
      </div>
      <footer id="footer">
      	<div class="container">
        	<p> 2017 MONITOR-IP.- Versão <span>1.0</span></p>
        </div>
      </footer>
</body>

<script type="text/javascript">
	function calcularIMC()
	{
		var camp1 = document.getElementById("peso");
		var camp2 = document.getElementById("altura");
		var camp3 = document.getElementById("imc");
	
		if(camp1.value != "" && camp2 !="")
		{
			var x = camp1.value/(camp2.value*camp2.value);
			camp3.value = Math.round(x);
		}
		else
			{
			camp3.value = 0.0;
			}
	}
	function checkpeso()
	{
		var camp1 = document.getElementById("temp");	
		if(camp1.value >=10 && camp1.value <= 50)
		{
			return false;
			alert('Erro');
		}
	}
	function voltar() {
	    history.back();
	}
	
	function confirmSair() {     
		swal({
			title : "",
			text : "Deseja sair do Sistema?",
			type : "warning",
			showCancelButton : true,
			cancelButtonText : "Não",
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "Sim!",
			closeOnConfirm : false			
		}, function() {
			location.href="LoginController?acao=out";  
		}); 
		}
	
	
	
</script>
</html>


 </c:if>
 <c:if test="${empty nomeUsa}">
     <jsp:forward page="login.jsp"></jsp:forward>
 </c:if>
<!-- else -->
<!-- { -->
<!-- 	RequestDispatcher saida = request.getRequestDispatcher("login.jsp"); -->
<!-- 	saida.forward(request, response); -->
<!-- } -->
<!-- %> -->
 