package ao.co.smpip.testejsp;

import java.io.File;

import ao.co.smpip.security.EncriptaDecriptaRSA;


public class testejsp 
{
	public static final String PATH_CHAVE_PRIVADA = "C:/keysss/private.key";
	public static void main(String[] args) {
      //String cha = "43:-84:119:-3:101:-75:-37:-64:-25:-113:41:-86:-92:-123:-72:83:-126:-125:82:-96:69:56:-74:-71:-61:-82:-116:110:-116:26:56:-87:-113:88:-53:-21:-78:-93:122:13:25:43:-100:-97:-42:65:44:-111:-77:-87:-10:-18:118:75:34:-43:59:59:89:12:106:-39:127:-37:-24:29:-114:-42:25:68:-121:-105:3:121:-78:-2:10:-32:47:52:-60:-44:-102:74:-57:44:-52:80:-19:-1:-114:-104:-40:118:105:-71:113:109:-109:49:48:-92:93:-87:117:-90:87:127:-31:28:86:-15:-71:98:73:82:107:38:47:72:106:13:28:-98:118:84:23:121:";   
      //String senha = EncriptaDecriptaRSA.decriptografa(cha);
      String aux = EncriptaDecriptaRSA.criptografa("12");
      System.out.println(aux);
      System.out.println(EncriptaDecriptaRSA.decriptografa(aux));
    }
	
	static Long fone2(String temp)
	{
		//244 924-044-145
		long aux =0;
		try
		{ 
		String cod  = "244";
		String num1 = temp.replace(" ", "");
		String fonet= cod+num1;
		aux = Long.parseLong(fonet);
		
		}
		catch(NumberFormatException er){System.out.print(er);}
		return aux;
	}
	
	
}
