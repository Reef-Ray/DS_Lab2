
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

public abstract class CalendarEvent {
	String description;
	String location;
	GregorianCalendar startTime;
	GregorianCalendar endTime;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public GregorianCalendar getStartTime() {
		return startTime;
	}

	public void setStartTime(GregorianCalendar startTime) {
		this.startTime = startTime;
	}

	public GregorianCalendar getEndTime() {
		return endTime;
	}

	public void setEndTime(GregorianCalendar endTime) {
		this.endTime = endTime;
	}
	
	public CalendarEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalendarEvent(String description, String location,  GregorianCalendar startTime,  GregorianCalendar endTime) {
		return;
	}

	void scheduleEvent(MeetingCalendar cal) {
	}
	
}
