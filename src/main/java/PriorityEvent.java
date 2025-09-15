
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

public class PriorityEvent extends CalendarEvent {

	public PriorityEvent() {
		// TODO Auto-generated constructor stub
	}

	public PriorityEvent(String description, String location, GregorianCalendar startTime, GregorianCalendar endTime) {
		super(description, location, startTime, endTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	void scheduleEvent(MeetingCalendar cal) {
	}

}
