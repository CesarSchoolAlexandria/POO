package Interfaces;

import java.util.Calendar;
import java.util.Date;

public interface IArrumavel {
	
	default Date dataHoraATUAL() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
		
	}

}
