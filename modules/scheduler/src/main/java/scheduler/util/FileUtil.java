package scheduler.util;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FileUtil {
	

	
	public static void deletFile() throws PortalException{
		 List<DLFileEntry> DLFiles = new ArrayList<>();
		DLFiles = DLFileEntryLocalServiceUtil.getFileEntries(0, DLFileEntryLocalServiceUtil.getFileEntriesCount());
	
		for(DLFileEntry dlfile : DLFiles) {
			
			long folderId =  dlfile.getFolderId();
			if(folderId==37837) {
		Date date = dlfile.getCreateDate();
		Date crrdate = new Date();
		long diffInSec = crrdate.getTime()- date.getTime();
		if(diffInSec/1000>=10 && diffInSec/1000<=1000) {
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(dlfile.getFileEntryId());
			 System.out.println("File deleted");
		}
		long diff = getDateDifference(date, crrdate, TimeUnit.DAYS );
//		 if(diff>=90) {
//			 
//	        	DLFileEntryLocalServiceUtil.deleteDLFileEntry(dlfile.getFileEntryId());
//				 System.out.println("File deleted");
//	        	
//	        }
		
		}}
		
	}


	  public static long getDateDifference(Date currentDate, Date givenDate, TimeUnit timeUnit) {
	        // Convert both dates to Calendar objects
	        Calendar currentCalendar = Calendar.getInstance();
	        currentCalendar.setTime(currentDate);

	        Calendar givenCalendar = Calendar.getInstance();
	        givenCalendar.setTime(givenDate);

	        // Clear the time components in both calendars
	        currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
	        currentCalendar.set(Calendar.MINUTE, 0);
	        currentCalendar.set(Calendar.SECOND, 0);
	        currentCalendar.set(Calendar.MILLISECOND, 0);

	        givenCalendar.set(Calendar.HOUR_OF_DAY, 0);
	        givenCalendar.set(Calendar.MINUTE, 0);
	        givenCalendar.set(Calendar.SECOND, 0);
	        givenCalendar.set(Calendar.MILLISECOND, 0);

	        // Calculate the difference in milliseconds
	        long differenceInMillis = givenCalendar.getTimeInMillis() - currentCalendar.getTimeInMillis();

	        // Convert the difference to the desired time unit
	        long difference = timeUnit.convert(differenceInMillis, TimeUnit.MILLISECONDS);

	        return difference;
	    }

	 

}
