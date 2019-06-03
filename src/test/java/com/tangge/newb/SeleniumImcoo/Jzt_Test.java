package com.tangge.newb.SeleniumImcoo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Jzt_Test {
public static void main(String[] args) {
	Calendar Cld = Calendar.getInstance();
	int YY = Cld.get(Calendar.YEAR) ;
	int MM = Cld.get(Calendar.MONTH)+1;
	int DD = Cld.get(Calendar.DATE);
	int HH = Cld.get(Calendar.HOUR_OF_DAY);
	int mm = Cld.get(Calendar.MINUTE);
	int SS = Cld.get(Calendar.SECOND);
	System.out.println(YY + "/" + MM + "/" + DD + "-" + HH + ":" + mm + ":" + SS);

	//func2
	Calendar cal = Calendar.getInstance(); 
	Date date = cal.getTime();
	//  2016/05/05-01:01:34:364
	System.out.println(new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date));
}
	
}
