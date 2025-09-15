
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

public class MultiDayPerWeekEvent extends CalendarEvent {
	GregorianCalendar repeatUntil;
	int day[];
	
	public MultiDayPerWeekEvent() {
		// TODO Auto-generated constructor stub
	}

	public MultiDayPerWeekEvent(String description, String location, GregorianCalendar startTime,
			GregorianCalendar endTime, GregorianCalendar repeatUntil, int days[]) {
		super(description, location, startTime, endTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	void scheduleEvent(MeetingCalendar cal) {
	}

}
