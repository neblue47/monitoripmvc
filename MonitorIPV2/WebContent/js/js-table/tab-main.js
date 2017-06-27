
$(document).ready(function(){
	
	/* For Tratamento*/
	
  $("#receituario").click(function(){
	  $("#fromReceituario").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromSinaisVitais").slideUp("slow");
	  $("#sinais-vitais").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromEvolucao").slideUp("slow");
	  $("#evolucao").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  $("#sinais-vitais").click(function(){
	  $("#fromSinaisVitais").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");
	
	  $("#fromEvolucao").slideUp("slow");
	  $("#evolucao").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	
	  $("#fromReceituario").slideUp("slow");
	  $("#receituario").css("background","#34495e").css("color","#fff").css("opacity","0.7");

  });

  $("#evolucao").click(function(){
	  $("#fromEvolucao").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromSinaisVitais").slideUp("slow");
	  $("#sinais-vitais").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromReceituario").slideUp("slow");
	  $("#receituario").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  /* For Consultorio*/
	
  $("#receituarios").click(function(){
	  $("#fromReceituarios").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromInternamento").slideUp("slow");
	  $("#internamento").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromMedicacao").slideUp("slow");
	  $("#medicacao").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromRecomendacoes").slideUp("slow");
	  $("#recomendacoes").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromSuspensos").slideUp("slow");
	  $("#suspensos").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromExameInt").slideUp("slow");
	  $("#exameInt").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  $("#internamento").click(function(){
	  $("#fromInternamento").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");
	
	  $("#fromReceituarios").slideUp("slow");
	  $("#receituarios").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromMedicacao").slideUp("slow");
	  $("#medicacao").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromRecomendacoes").slideUp("slow");
	  $("#recomendacoes").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromSuspensos").slideUp("slow");
	  $("#suspensos").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromExameInt").slideUp("slow");
	  $("#exameInt").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	
	  });
  
  $("#internamentos").click(function(){
	  $("#fromInternamentos").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");
	
	  $("#fromReceituarios").slideUp("slow");
	  $("#receituarios").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromMedicacao").slideUp("slow");
	  $("#medicacao").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromRecomendacoes").slideUp("slow");
	  $("#recomendacoes").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromSuspensos").slideUp("slow");
	  $("#suspensos").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromExameInt").slideUp("slow");
	  $("#exameInt").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	
	  });

  $("#medicacao").click(function(){
	  $("#fromMedicacao").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromInternamentos").slideUp("slow");
	  $("#internamentos").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromReceituarios").slideUp("slow");
	  $("#receituarios").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromRecomendacoes").slideUp("slow");
	  $("#recomendacoes").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromSuspensos").slideUp("slow");
	  $("#suspensos").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromExameInt").slideUp("slow");
	  $("#exameInt").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  $("#recomendacoes").click(function(){
	  $("#fromRecomendacoes").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromInternamentos").slideUp("slow");
	  $("#internamentos").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromReceituarios").slideUp("slow");
	  $("#receituarios").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromMedicacao").slideUp("slow");
	  $("#medicacao").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromSuspensos").slideUp("slow");
	  $("#suspensos").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromExameInt").slideUp("slow");
	  $("#exameInt").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  $("#suspensos").click(function(){
	  $("#fromSuspensos").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromInternamentos").slideUp("slow");
	  $("#internamentos").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromReceituarios").slideUp("slow");
	  $("#receituarios").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromMedicacao").slideUp("slow");
	  $("#medicacao").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromRecomendacoes").slideUp("slow");
	  $("#recomendacoes").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromExameInt").slideUp("slow");
	  $("#exameInt").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  

	  });
  
  $("#exameInt").click(function(){
	  $("#fromExameInt").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromInternamentos").slideUp("slow");
	  $("#internamentos").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  $("#fromReceituarios").slideUp("slow");
	  $("#receituarios").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromMedicacao").slideUp("slow");
	  $("#medicacao").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromRecomendacoes").slideUp("slow");
	  $("#recomendacoes").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromSuspensos").slideUp("slow");
	  $("#suspensos").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });

  /*For Antecedentes*/
  
  $("#antecedentesPessoais").click(function(){
	  $("#fromAntecedentesPessoais").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromAntecedentesFamiliar").slideUp("slow");
	  $("#antecedentesFamiliar").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  $("#antecedentesFamiliar").click(function(){
	  $("#fromAntecedentesFamiliar").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromAntecedentesPessoais").slideUp("slow");
	  $("#antecedentesPessoais").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  /*For Beneficios*/
  
  $("#consultas").click(function(){
	  $("#fromConsultas").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromExames").slideUp("slow");
	  $("#exames").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromFarmacos").slideUp("slow");
	  $("#farmacos").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  $("#exames").click(function(){
	  $("#fromExames").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromConsultas").slideUp("slow");
	  $("#consultas").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromFarmacos").slideUp("slow");
	  $("#farmacos").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });
  
  $("#farmacos").click(function(){
	  $("#fromFarmacos").slideDown("slow");
	  $(this).css("background","#34495e").css("color","#fff").css("opacity","1");

	  $("#fromExames").slideUp("slow");
	  $("#exames").css("background","#34495e").css("color","#fff").css("opacity","0.7");
	  
	  $("#fromConsultas").slideUp("slow");
	  $("#consultas").css("background","#34495e").css("color","#fff").css("opacity","0.7");

	  });

});