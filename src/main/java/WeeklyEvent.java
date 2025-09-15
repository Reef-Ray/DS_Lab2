
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

public class WeeklyEvent extends CalendarEvent {
	GregorianCalendar repeatUntil;
	
	public WeeklyEvent() {
		// TODO Auto-generated constructor stub
	}

	public WeeklyEvent(String description, String location, GregorianCalendar startTime, GregorianCalendar endTime, GregorianCalendar repeatUntil) {
		super(description, location, startTime, endTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	void scheduleEvent(MeetingCalendar cal) {
	}
	

}
