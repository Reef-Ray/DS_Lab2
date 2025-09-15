import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calendar.Meeting;
import calendar.MeetingCalendar;

class CalanderEventTest {
	
	CalendarEvent test;
	CalendarEvent test2;

    @BeforeEach
    void setup() {
    }

    @Test
    void OneTimeTest() {
    	var sTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 13, 30);
		var eTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 14, 30);
    	test = new OneTimeEvent("Lunch Time","Cowan", sTime, eTime);
		assertEquals("Lunch Time", test.getDescription());
		assertEquals("Cowan", test.getLocation());
		assertEquals(sTime, test.getStartTime());
		assertEquals(eTime, test.getEndTime());
		var cal = new MeetingCalendar();
		
		test.scheduleEvent(cal);
		Meeting a = cal.findMeeting(sTime);
		Meeting b = new Meeting("Lunch Time","Cowan", sTime, eTime);
		assertEquals(b, a);
    }
    
	@Test
	void PriorityTest() {
		var sTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 13, 30);
		var eTime = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 14, 30);
    	test = new PriorityEvent("Lunch Time","Cowan", sTime, eTime);
		var sTime2 = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 13, 30);
		var eTime2 = new GregorianCalendar(2025, Calendar.OCTOBER, 2, 14, 00);
		test2 = new PriorityEvent("tourney", "EVO", sTime2, eTime2);
		assertEquals("Lunch Time", test.getDescription());
		assertEquals("Cowan", test.getLocation());
		assertEquals(sTime, test.getStartTime());
		assertEquals(eTime, test.getEndTime());
		var cal = new MeetingCalendar();
		
		test.scheduleEvent(cal);
		test2.scheduleEvent(cal);
		Meeting a = cal.findMeeting(sTime);
		Meeting b = new Meeting("tourney", "EVO", sTime2, eTime2);
		assertEquals(b,a);
	}
	
	@Test
	void Num() {
		test.setDescription("2023");
		test.setLocation("413");
		var sTime = new GregorianCalendar(12, 1, 1);
		test.setStartTime(sTime);
		var eTime = new GregorianCalendar(102910, 1, 65);
		test.setEndTime(eTime);
		assertEquals("2023", test.getDescription());
		assertEquals("413", test.getLocation());
		assertEquals(sTime, test.getStartTime());
		assertEquals(eTime, test.getEndTime());
	}
}
