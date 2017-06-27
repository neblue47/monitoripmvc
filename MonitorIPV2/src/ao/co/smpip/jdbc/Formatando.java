package ao.co.smpip.jdbc;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Formatando {
	 
		
	public final String dtHora()
	{
		Calendar c = Calendar.getInstance(); 
		//c.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH); 
		Date data = c.getTime(); 
		DateFormat dtHora = DateFormat.getDateTimeInstance(); 
		return (dtHora.format(data));
	}
	public String getHoraAtual() {

		Date data = new Date();

		SimpleDateFormat hformatador = new SimpleDateFormat("HH:mm:ss");

		String sHora = hformatador.format(data);
		return sHora;
	}
	public Calendar data (String dataEmTexto)
	{
		Calendar dataCalendar=null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataCalendar = Calendar.getInstance();
			dataCalendar.setTime(date);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		return dataCalendar;  
	}
	public java.sql.Date data_registo()
	{
		java.sql.Date dt_registo = null;
		Calendar c = Calendar.getInstance(); // Cria um objeto para armazenar a data atual
        c.setTime(new Date()); // pega a data atual do sistema
        int diaAtual = c.get(Calendar.DAY_OF_MONTH); // DIA
        int mesAtual = c.get(Calendar.MONTH)+1; // MES
        int anoAtual = c.get(Calendar.YEAR);  // ANO
        String hoje = anoAtual+"/"+mesAtual+"/"+diaAtual;
        DateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
	    java.util.Date a; 
		try {
			a = (java.util.Date) formate.parse(hoje);
			dt_registo = new java.sql.Date(a.getTime());
			} catch (ParseException e) { }
		return dt_registo;
	}
	
	public String data_Admissao()
	{
		java.sql.Date dt_registo = null;
		Calendar c = Calendar.getInstance(); // Cria um objeto para armazenar a data atual
        c.setTime(new Date()); // pega a data atual do sistema
        int diaAtual = c.get(Calendar.DAY_OF_MONTH); // DIA
        int mesAtual = c.get(Calendar.MONTH); // MES
        int anoAtual = c.get(Calendar.YEAR);  // ANO
        String hoje = diaAtual+"/"+mesAtual+"/"+anoAtual;
         
		return hoje;
	}
	public java.sql.Date dataSql(String data)
	{
		String dia = data.substring(0,2);
		String mes = data.substring(3,5);
		String ano = data.substring(6);
		String dataSql = ano+"/"+mes+"/"+dia;
		java.sql.Date dataf=null;	
		DateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
	    java.util.Date a; 
		try {
			a = (java.util.Date) formate.parse(dataSql);
			dataf = new java.sql.Date(a.getTime());
			} catch (ParseException e) { }
	return dataf;
	}
	public Long fone(String temp)
	{
		//244 924-044-145
		long aux =0;
		try
		{ 
		String cod  = temp.substring(0,3);
		String num1 = temp.substring(4,7);
		String num2 = temp.substring(8,11);
		String num3 = temp.substring(12);
		String fonet= cod+num1+num2+num3;
		aux = Long.parseLong(fonet);
		
		}
		catch(NumberFormatException er){System.out.print(er);}
		return aux;
	}
	
	public Long fone2(String temp)
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
	public String Editfone(int temp)
	{
		//123456789
		String fonetmp = ""+temp;
		String aux ="";
		try
		{
		String cod  = fonetmp.substring(0,3);
		String num1 = fonetmp.substring(3,6);
		String num2 = fonetmp.substring(6);
		
		String fonet= cod+" "+num1+"-"+num2;
		aux = fonet;
		
		}
		catch(NumberFormatException er){System.out.print(er);}
		return aux;
	}
	
	public String checkedH(String a)
	{
		String check="";
		if(a.equals("Masculino"))
		{
			check="checked = 'checked'";
		}
		return check;
	}
	public String checkedM(String a)
	{
		String check="";
		if(a.equals("Feminino"))
		{
			check="checked = 'checked'";
		}
		return check;
	}
	public String checkedEa(int a)
	{
		String check="";
		if(a == 1)
		{
			check="checked = 'checked'";
		}
		//System.out.print("Ativo "+check);
		return check;
	}
	public String checkedEi(int a)
	{
		String check="";
		if(a == 0)
		{
			check="checked = 'checked'";
		}
		//System.out.print("Inativo "+check);
		return check;
	}
	
	public String databd(String data)
	{
		String dia = data.substring(8);
		String mes = data.substring(5,7);
		String ano = data.substring(0,4);
		String datatl = dia+"/"+mes+"/"+ano;
		return datatl;
	}
	public String getHoraAtual1() {
		// TODO Auto-generated method stub
		return null;
	}
		
}



	

