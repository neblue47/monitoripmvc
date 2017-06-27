package ao.co.smpip.testejsp;

import java.io.File;

public class FileDemo {
   public static void main(String[] args) {
      
       System.out.println(validarString("ne2Lson"));
   }
   
   static void hideFileOrFolder(File file){ 

	   try{ 
	   Runtime.getRuntime().exec("attrib -a -s -h \""+file.getAbsolutePath().toString()+"\""); 
	   }catch(Exception e){} 

	   } 



	static boolean validarSenha (String senha){
		String valor = senha;
	    boolean valido = false;	
	    // primeiro verificar se o tamanho é maior ou igual a 8 caracteres
	    if(validarTamanho(valor)){
	    	// verificar se a lista de caracter contem pelo menos um Caracter Numerico
	    	if(validarNumero(valor)){
	    		// verificar se a lista de caracter contem pelo menos um Caracter Maiusculo ou Minusculo
	    		if(validarMaiuscula(valor) || validarMinuscula(valor)){
	    			valido = true;	
	    		}
	    	}
	    }
	    return valido;
	}

	  static boolean validarNumero(String texto) {
	    String valor = texto;
	    boolean valido = false;
	
	    for (int i = 0; i < valor.length(); i++) {
	        Character caractere = valor.charAt(i);
	        if (Character.isDigit(caractere)) {
	            valido = true;
	            break;
	        }
	    }
	    
	    return valido  ;
	}
	
	  static boolean validarMinuscula(String texto) {
	    String valor = texto;
	    boolean valido = false;
	
	    for (int i = 0; i < valor.length(); i++) {
	        Character caractere = valor.charAt(i);
	        if (Character.isLowerCase(caractere)) {
	            valido = true;
	            break;
	        }
	    }
	    return valido  ;
	}
	  static boolean validarTamanho(String texto) {
	    String valor = texto;
	    boolean valido = false;
	    if(valor.length() >= 8){
	    	valido = true;
	    }
	    return valido  ;
	}
	  static boolean validarMaiuscula(String texto) {
	    String valor = texto;
	    boolean valido = false;
	
	    for (int i = 0; i < valor.length(); i++) {
	        Character caractere = valor.charAt(i);
	        if (Character.isUpperCase(caractere)) {
	            System.out.println(caractere);
	            valido = true;
	            break;
	        }
	    }
	    return valido  ;
	}
	  
	  static boolean validarString(String texto) {
		    String valor = texto;
		    boolean valido = false;
		
		    for (int i = 0; i < valor.length(); i++) {
		        Character caractere = valor.charAt(i);
		        if (Character.isUpperCase(caractere)) {
		            System.out.println(caractere);
		            valido = true;
		            break;
		        }
		    }
		    return valido  ;
		}
}