$(document).ready( function(){
    $('.datasx ').on('click',function(){
//      var conteudo = $(this).text();
//      alert(conteudo);
      $.ajax({
			type: 'GET',
			url : 'SinaisController',
			data: 'data='+$(this).text()+'&'+'cod='+$('input[name=fkp]').val(),
			statusCode: {
				404: function(){
					alert('Pagina n�o encontrada');
					
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
				$('.inpu_ value').remove();
				var pegados = dados.split(":");
				if(dados=='')
					{
					
					}
				else{
					
					
					document.getElementById("temp").value 	= pegados[0].split("-")[0];
					document.getElementById("tensao").value = pegados[0].split("-")[1];
					document.getElementById("pulso").value 	= pegados[0].split("-")[2];
					document.getElementById("peso").value 	= pegados[0].split("-")[3];
					document.getElementById("resp").value 	= pegados[0].split("-")[4];
					document.getElementById("altura").value = pegados[0].split("-")[5];
					document.getElementById("estado").value = pegados[0].split("-")[6];
					document.getElementById("imc").value 	= pegados[0].split("-")[7];				
			      }
			}
		});
    });
    });

//------------------------- Antecedentes -----------------------------//
$(document).ready( function(){
    $('.data_at ').on('click',function(){
      
      $.ajax({
			type: 'GET',
			url : 'antecedentes',
			data: 'data='+$(this).text()+'&'+'cod='+$('input[name=fkPac]').val(),
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
					
					if(pegados[0].split("-")[0] == 1)	{	document.getElementById("trans_s").checked = true;	}
					if(pegados[0].split("-")[0] == 0)	{	document.getElementById("trans_n").checked = true;	}
					
					if(pegados[0].split("-")[1] == 1)	{	document.getElementById("cardio_s").checked = true;	}
					if(pegados[0].split("-")[1] == 0)	{	document.getElementById("cardio_n").checked = true;	}
					
					if(pegados[0].split("-")[2] == 1)	{	document.getElementById("tuber_s").checked = true;	}
					if(pegados[0].split("-")[2] == 0)	{	document.getElementById("tuber_n").checked = true;	}
					
					if(pegados[0].split("-")[3] == 1)	{	document.getElementById("aciden_s").checked = true;	}
					if(pegados[0].split("-")[3] == 0)	{	document.getElementById("aciden_n").checked = true;	}
					
					if(pegados[0].split("-")[4] == 1)	{	document.getElementById("tabag_s").checked = true;	}
					if(pegados[0].split("-")[4] == 0)	{	document.getElementById("tabag_n").checked = true;	}
					
					if(pegados[0].split("-")[5] == 1)	{	document.getElementById("diabt_s").checked = true;	}
					if(pegados[0].split("-")[5] == 0)	{	document.getElementById("diabt_n").checked = true;	}
					
					if(pegados[0].split("-")[6] == 1)	{	document.getElementById("cirurg_s").checked = true;	}
					if(pegados[0].split("-")[6] == 0)	{	document.getElementById("cirurg_n").checked = true;	}
					
					if(pegados[0].split("-")[7] == 1)	{	document.getElementById("hta_s").checked = true;	}
					if(pegados[0].split("-")[7] == 0)	{	document.getElementById("hta_n").checked = true;	}
					
					if(pegados[0].split("-")[8] == 1)	{	document.getElementById("avc_s").checked = true;	}
					if(pegados[0].split("-")[8] == 0)	{	document.getElementById("avc_n").checked = true;	}
					
					if(pegados[0].split("-")[9] == 1)	{	document.getElementById("oster_s").checked = true;	}
					if(pegados[0].split("-")[9] == 0)	{	document.getElementById("oster_n").checked = true;	}
					
					if(pegados[0].split("-")[10] == 1)	{	document.getElementById("doencas_s").checked = true;}
					if(pegados[0].split("-")[10] == 0)	{	document.getElementById("doencas_n").checked = true;}
					
					if(pegados[0].split("-")[11] == 1)	{	document.getElementById("endoc_s").checked = true;	}
					if(pegados[0].split("-")[11] == 0)	{	document.getElementById("endoc_n").checked = true;	}
					
					if(pegados[0].split("-")[12] == 1)	{	document.getElementById("etil_s").checked = true;	}
					if(pegados[0].split("-")[12] == 0)	{	document.getElementById("etil_n").checked = true;	}
					
					if(pegados[0].split("-")[13] == 1)	{	document.getElementById("alergia_s").checked = true; }
					if(pegados[0].split("-")[13] == 0)	{	document.getElementById("alergia_n").checked = true; }
					
					
					
					if(pegados[0].split("-")[14] == 1)	{	document.getElementById("anemia_s").checked = true;	}
					if(pegados[0].split("-")[14] == 0)	{	document.getElementById("anemia_n").checked = true;	}
					
					if(pegados[0].split("-")[15] == 1)	{	document.getElementById("droga_s").checked = true;	}
					if(pegados[0].split("-")[15] == 0)	{	document.getElementById("droga_n").checked = true;	}
					
					if(pegados[0].split("-")[16] == 1)	{	document.getElementById("viros_s").checked = true;	}
					if(pegados[0].split("-")[16] == 0)	{	document.getElementById("viros_n").checked = true;	}
					
					if(pegados[0].split("-")[17] == 1)	{	document.getElementById("cancro_s").checked = true;	}
					if(pegados[0].split("-")[17] == 0)	{	document.getElementById("cancro_n").checked = true;	}
					
					if(pegados[0].split("-")[18] == 1)	{	document.getElementById("dts_s").checked = true;	}
					if(pegados[0].split("-")[18] == 0)	{	document.getElementById("dts_n").checked = true;	}
					
					document.getElementById("antecedentes").value = pegados[0].split("-")[19];
			
			      }
			}
		});
    });
    });

//------------------------- Queixas e Historial -----------------------------//
$(document).ready( function(){
    $('.data_qh ').on('click',function(){
      
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

//------------------------- Hipoteses-----------------------------//
$(document).ready( function(){
    $('.data_h').on('click',function(){
//      sweetAlert("","OK","warning");
      $.ajax({
			type: 'GET',
			url : 'HipoteseController',
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
				 
				var pegados = dados.split("-");
				if(dados=='')
					{
					
					}
				
				else{
					$(".ls-hipos tbody tr").remove();
 					var cid_cod  = pegados[0];
					var cid_descricao  = pegados[1];
					var obs_descricao  = pegados[2];
					$(".ls-hipos tbody").append("<tr  >"+
								      	        "<td class='name'><div> "+cid_cod+"  </div></td> "+
								      			"<td class='dat'><div>  "+cid_descricao+"    </div></td> "+
								                "</tr>");
					document.getElementById("observacaoCS").value = obs_descricao;
					}							
//				for(var i=0;i<pegados.length-1;i++)
//				{
//				var cid_descricao  = pegados[i].split("-")[0];
//				var obs_descricao  = pegados[i].split("-")[1];
//				$(".ls-hipos tbody").append("<tr  >"+
//							      	        "<td class='name'><div> "+cid_descricao+"  </div></td> "+
//							      			"<td class='dat'><div>  "+obs_descricao+"    </div></td> "+
//							                "</tr>");
//				}
			
			}
		});
    });
    });

//------------------------- Exames Fisicos-----------------------------//
$(document).ready( function(){
    $('.data_ef').on('click',function(){
      
      $.ajax({
			type: 'GET',
			url : 'ExamesFisController',
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
					
					document.getElementById("cabecao").value 	= pegados[0].split("-")[0];
					document.getElementById("abdomem").value 	= pegados[0].split("-")[1];
					document.getElementById("membrosinf").value = pegados[0].split("-")[2];
					document.getElementById("membrosup").value 	= pegados[0].split("-")[3];
					document.getElementById("pescoco").value 	= pegados[0].split("-")[4];
					document.getElementById("urinatio").value 	= pegados[0].split("-")[6];					
					document.getElementById("torax").value 		= pegados[0].split("-")[5];
			
			      }
			}
		});
    });
    });


//-------------------------Tratamento e Recomendaçoes-----------------------------//
$(document).ready( function(){
  $('.data_trc').on('click',function(){
    
    $.ajax({
			type: 'GET',
			url : 'TratamentoController',
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
					
					document.getElementById("tratamento").value 	= pegados[0].split("-")[0];
					document.getElementById("recomendacao").value 	= pegados[0].split("-")[1];
			
			      }
			}
		});
  });
  });

//-------------------------Exames Clinicos-----------------------------//
$(document).ready( function(){
  $('.data_ecv').on('click',function(){
    $.ajax({
			type: 'GET',
			url : 'menoridadecontroller.do',
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
					$(".ls-exames tbody tr").remove();
				document.getElementById("observacaoCSE").value = obs_descricao;								
				for(var i=0;i<pegados.length-1;i++)
				{
				var analise     = pegados[i].split("-")[0];
				var preco  		= pegados[i].split("-")[1];
				var descricao  	= pegados[i].split("-")[2];
				$(".ls-exames tbody").append("<tr  >"+
							      	        "<td class='name'><div> "+analise+"  </div></td> "+
							      			"<td class='dat'><div>  "+preco+"    </div></td> "+
							      			"<td class='name'><div> "+descricao+"   </div></td>  "+
							                "</tr>");
				}
			}
			}
		});
  });
  });

// --------------------------------- Sinais do Internamento ----------------- -------------
$(document).ready( function(){
    $('.data_si').on('click',function(){
//      var coute = $(this).text();
//      sweetAlert($(this).text());
    	$.ajax({
			type: 'POST',
			url : 'SinaisController',
			data: 'data='+$(this).text()+'&'+'cod='+$('input[name=pac_int]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');				
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
//				 $("#table_tmp thead tr").remove(); 
				$("#table_tmp tbody tr").remove(); 
				var pegados = dados.split(";");
				if(dados=='')
					{
					$("#table_tmp tbody tr").remove(); 
					}
				
				else{
//					$("#table_tmp thead").append("<tr>"+
//												  "<th data-field='Temperatura' data-align='center'>Temperatura</th>"+
//												  "<th data-field='Horas' data-align='center'>Horas</th>"+
//												"</tr>");																												
					for(var i=0;i<pegados.length-1;i++)
					{
						var temp1 = new String(pegados[i].split("-")[0]);
						var temp2 = new String(pegados[i].split("-")[1]);
						$("#table_tmp tbody").append("<tr >"+
													 "<td data-field='Temperatura' data-align='center'>"+temp1+" </td> "+
													 "<td data-field='Horas' data-align='center'>"+temp2+" </td> "+
													 "</tr>");
					}
				}
			}
		});
  });
  });

$(document).ready( function(){
    $('.data_rsp').on('click',function(){
//      var coute = $(this).text();
//      sweetAlert($(this).text());
    	$.ajax({
			type: 'POST',
			url : 'SinaisController',
			data: 'data='+$(this).text()+'&'+'codRsp='+$('input[name=pac_int]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');				
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
//				 $("#table_tmp thead tr").remove(); 
				$("#table_rsp tbody tr").remove(); 
				var pegados = dados.split(";");
				if(dados=='')
					{
					$("#table_tmp tbody tr").remove(); 
					}
				
				else{
//					$("#table_tmp thead").append("<tr>"+
//												  "<th data-field='Temperatura' data-align='center'>Temperatura</th>"+
//												  "<th data-field='Horas' data-align='center'>Horas</th>"+
//												"</tr>");																												
					for(var i=0;i<pegados.length-1;i++)
					{
						var temp1 = new String(pegados[i].split("-")[0]);
						var temp2 = new String(pegados[i].split("-")[1]);
						$("#table_rsp tbody").append("<tr >"+
													 "<td data-field='Temperatura' data-align='center'>"+temp1+" </td> "+
													 "<td data-field='Horas' data-align='center'>"+temp2+" </td> "+
													 "</tr>");
					}
				}
			}
		});
  });
  });

$(document).ready( function(){
    $('.data_tns').on('click',function(){
//      var coute = $(this).text();
//      sweetAlert($(this).text());
    	$.ajax({
			type: 'POST',
			url : 'SinaisController',
			data: 'data='+$(this).text()+'&'+'codTns='+$('input[name=pac_int]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');				
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
//				 $("#table_tmp thead tr").remove(); 
				$("#table_tns tbody tr").remove(); 
				var pegados = dados.split(";");
				if(dados=='')
					{
					$("#table_tns tbody tr").remove(); 
					}
				
				else{
//					$("#table_tmp thead").append("<tr>"+
//												  "<th data-field='Temperatura' data-align='center'>Temperatura</th>"+
//												  "<th data-field='Horas' data-align='center'>Horas</th>"+
//												"</tr>");																												
					for(var i=0;i<pegados.length-1;i++)
					{
						var temp1 = new String(pegados[i].split("-")[0]);
						var temp2 = new String(pegados[i].split("-")[1]);
						$("#table_tns tbody").append("<tr >"+
													 "<td data-field='Temperatura' data-align='center'>"+temp1+" </td> "+
													 "<td data-field='Horas' data-align='center'>"+temp2+" </td> "+
													 "</tr>");
					}
				}
			}
		});
  });
  });

$(document).ready( function(){
    $('.data_pls').on('click',function(){
//      var coute = $(this).text();
//      sweetAlert($(this).text());
    	$.ajax({
			type: 'POST',
			url : 'SinaisController',
			data: 'data='+$(this).text()+'&'+'codPls='+$('input[name=pac_int]').val(),
			statusCode: {
				404: function(){
					alert('Pagina nao encontrada');				
				},
				500: function(){
					alert('Erro no servidor');
				}
			},
			success: function (dados){
//				 $("#table_tmp thead tr").remove(); 
				$("#table_pls tbody tr").remove(); 
				var pegados = dados.split(";");
				if(dados=='')
					{
					$("#table_pls tbody tr").remove(); 
					}
				
				else{
//					$("#table_tmp thead").append("<tr>"+
//												  "<th data-field='Temperatura' data-align='center'>Temperatura</th>"+
//												  "<th data-field='Horas' data-align='center'>Horas</th>"+
//												"</tr>");																												
					for(var i=0;i<pegados.length-1;i++)
					{
						var temp1 = new String(pegados[i].split("-")[0]);
						var temp2 = new String(pegados[i].split("-")[1]);
						$("#table_pls tbody").append("<tr >"+
													 "<td data-field='Temperatura' data-align='center'>"+temp1+" </td> "+
													 "<td data-field='Horas' data-align='center'>"+temp2+" </td> "+
													 "</tr>");
					}
				}
			}
		});
  });
  });