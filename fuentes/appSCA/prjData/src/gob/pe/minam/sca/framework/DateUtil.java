/*
 * DateUtil.java
 * 
 * Copyright - Contraloria General de la República, Todos los derechos reservados.
 */

package gob.pe.minam.sca.framework;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;

/**
 * TODO Ingresar definición de la clase DateUtil
 * 
 * @author  raquino - 60321
* @version 1.0.0 - 04/09/2007
 * @see     TODO Ingresar los métodos que se desean ver
 * @since   1.0.0
 */

public class DateUtil {
	
	//protected static Logger logger = Logger.getLogger(DateUtil.class);
	
	public static String fechaActualString()
    {
        Calendar c = Calendar.getInstance();        
       
        int iDia =c.get(Calendar.DATE );
        String d = "0";
        if (iDia < 10)
        {
            d = d+iDia;
        }
        else
        {
            d = Integer.toString(iDia);
        }        
        String dia = d;
        
        int iMes =c.get(Calendar.MONTH ) + 1;
        String m = "0";
        if (iMes < 10)
        {
            m = m+iMes;
        }
        else
        {
            m = Integer.toString(iMes);
        }
        String mes = m;
        String annio = Integer.toString(c.get(Calendar.YEAR));
        String fechaActual = dia+"/"+mes+"/"+annio;
        return fechaActual;        
    }

	public static Date stringToDate(String fecha) 
		throws ParseException
	{
		 Date outFecha = null;   
		 /*
                 if(StringUtils.isNotEmpty(fecha))
		 {		
		 		Locale locale = new Locale("es");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);
				simpleDateFormat.setLenient(false);
				long time = simpleDateFormat.parse(fecha).getTime();
				outFecha = new Date(time);
		 }
                 */
		 return outFecha;
	}
	public static String dateToString(Date d)
	{
		return dateToString(d,1);
	}
	public static String dateToString(Date d, int format)
	{
		if (d == null)
			return "00/00/0000";
	    
		// convert to Calendar
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(d);
	
		return calendarToString(cal, format);
	}
	public static String calendarToString(java.util.Calendar c, int format)
	{
		// Number Formaters
		java.text.DecimalFormat dformat = new java.text.DecimalFormat("00");
		java.text.DecimalFormat yformat = new java.text.DecimalFormat("0000");
	
		StringBuffer sb = new StringBuffer();
	
		sb.append(dformat.format(c.get(java.util.Calendar.DATE)));
		sb.append("/");
		//Remember: in Java, the first month is 0 (January)
		// that is why we must add 1 to the Calender.MONTH result
		sb.append(dformat.format(c.get(java.util.Calendar.MONTH) + 1));
		sb.append("/");
		sb.append(yformat.format(c.get(java.util.Calendar.YEAR)));
	
		if (format == 1)
			{
			//add the time
			sb.append(" ");
	
			sb.append(dformat.format(c.get(java.util.Calendar.HOUR_OF_DAY)));
			sb.append(":");
			sb.append(dformat.format(c.get(java.util.Calendar.MINUTE)));
			sb.append(":");
			sb.append(dformat.format(c.get(java.util.Calendar.SECOND)));
		}
	
		return sb.toString();
	}
	
	/**
	Compares to Dates (in String format "dd/mm/yyyy")
	and returns an int with the possibles values:

	  -3 : DateA menor DateB
	   0 : DateA igual DateB
	  +2 : DateA mayor DateB

	**/	

	public static int compare(String DateA, String DateB)
	{
		//Check if they are equal
		if (DateA.compareTo(DateB) == 0)
			{
			// DateA equals DateB
			return 0;
		}

		//Convert both Strings to Calendar Objects

		// extract the year, month and day
		String sYear = DateA.substring(6, 10);
		String sMonth = DateA.substring(3, 5);
		String sDay = DateA.substring(0, 2);

		int iYear = Integer.parseInt(sYear);
		int iMonth = Integer.parseInt(sMonth);
		int iDay = Integer.parseInt(sDay);

		iMonth--;
		java.util.Calendar calendarA = java.util.Calendar.getInstance();
		calendarA.set(iYear, iMonth, iDay);

		sYear = DateB.substring(6, 10);
		sMonth = DateB.substring(3, 5);
		sDay = DateB.substring(0, 2);

		iYear = Integer.parseInt(sYear);
		iMonth = Integer.parseInt(sMonth);
		iDay = Integer.parseInt(sDay);
		iMonth--;
		java.util.Calendar calendarB = java.util.Calendar.getInstance();
		calendarB.set(iYear, iMonth, iDay);
		/**
		if (logger.isDebugEnabled())
		{
			logger.debug(" calendarA ["+calendarA.getTime()+"] calendarB ["+calendarB.getTime()+"]");
		}
		**/	
		// compare
		boolean result = calendarA.after(calendarB);

		if (result) {
			// DateA is greater than DateB
			return +2;
		} else {
			// DateB is greater than DateA
			return -3;
		}
	}
	/**
	 * 
	 * Este emtodo evalua que una fecha se encuentre dentro de un rango
	 * retorna true si se encuentra en el rango
	 * retorna false si no se encuentra dentro del rango
	 * @param fechaMin
	 * @param fechaMax
	 * @param fechaEva
	 * @return boolean "true" que si se encuentra en el rango.
	 * @return boolean "false" que no se encuentra en el rango.
	 * 
	 * @author  raquino - 60321
	 * @version 1.0.0 - 13/03/2008
	 * @since   1.0.0
	 */
	public static boolean entre(String fechaMin, String fechaMax, String fechaEva, boolean log)
	{	
		/*
                if (logger.isDebugEnabled())
		{
			logger.debug(" valor de fechaMin ["+fechaMin+"]");
			logger.debug(" valor de fechaMax ["+fechaMax+"]");
			logger.debug(" valor de fechaEva ["+fechaEva+"]");			
		}
                */
		
		boolean valor = false;	
		int comparacionFechaMin = compare(fechaMin,fechaEva);	
		int comparacionFechaMax = compare(fechaEva,fechaMax);		
		boolean vComparacionFechaMin = false;
		boolean vComparacionFechaMax = false;
		/*
                if (logger.isDebugEnabled())
		{
			logger.debug(" valor de comparacioFechaMin ["+comparacionFechaMin+"]" );
			logger.debug(" valor de comparacioFechaMax ["+comparacionFechaMax+"]" );			
		}
                */

		if(comparacionFechaMin != 2) // Si 2 la fechaMin es mayor que fechaEva
		{
			vComparacionFechaMin = true;
		}
		
		if(comparacionFechaMax != 2) // Si 2 la fechaEva es mayor que fechaMax
		{
			vComparacionFechaMax = true;
		}
                /*
		if (logger.isDebugEnabled())
		{
			logger.debug(" valor de vComparacionFechaMin ["+vComparacionFechaMin+"]" );
			logger.debug(" valor de vComparacionFechaMax ["+vComparacionFechaMax+"]" );			
		}
		*/
		if(vComparacionFechaMin && vComparacionFechaMax)
		{
			valor = true;
		}
		/*
                if (logger.isDebugEnabled())
		{
			logger.debug(" valor de final ["+valor+"]" );
		}
                */
		return valor;
	}
	
	public static String DateToStringDDMMYYYY(Date fecha)
	{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(fecha);
	}
	
	
}

